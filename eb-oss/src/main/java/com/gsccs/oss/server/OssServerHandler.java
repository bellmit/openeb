package com.gsccs.oss.server;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.FileUpload;
import io.netty.handler.codec.http.multipart.HttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.util.CharsetUtil;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.coobird.thumbnailator.Thumbnails;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.oss.util.FileUtils;

/**
 * 
 * @author x.d zhang
 */
public class OssServerHandler extends
		SimpleChannelInboundHandler<FullHttpRequest> {

	private HttpPostRequestDecoder decoder;

	private static final HttpDataFactory factory = new DefaultHttpDataFactory(
			true);

	private boolean readingChunks;

	// 缩略图大小

	@Override
	protected void channelRead0(ChannelHandlerContext ctx,
			FullHttpRequest request) throws Exception {
		// URI uri = new URI(request.getUri());
		// String uriStr = uri.getPath();

		if (request.getMethod() == HttpMethod.POST) {
			uploadFile(ctx, request);
		} else {
			sendError(ctx, HttpResponseStatus.METHOD_NOT_ALLOWED);
		}

	}

	/**
	 * 上传文件
	 * 
	 * @param ctx
	 * @param request
	 */
	private void uploadFile(ChannelHandlerContext ctx, FullHttpRequest request) {
		try {
			decoder = new HttpPostRequestDecoder(factory, request);
		} catch (HttpPostRequestDecoder.ErrorDataDecoderException e1) {
			e1.printStackTrace();
			sendError(ctx, HttpResponseStatus.BAD_REQUEST, "解码文件失败");
			return;
		}
		readingChunks = HttpHeaders.isTransferEncodingChunked(request);
		if (decoder != null) {
			if (request instanceof HttpContent) {
				HttpContent chunk = (HttpContent) request;
				try {
					decoder.offer(chunk);
				} catch (HttpPostRequestDecoder.ErrorDataDecoderException e1) {
					e1.printStackTrace();
					sendError(ctx, HttpResponseStatus.BAD_REQUEST,
							"解码文件失败");
					return;
				}
				readHttpDataChunkByChunk(ctx);
				if (chunk instanceof LastHttpContent) {
					readingChunks = false;
					reset();
				}
			} else {
				sendError(ctx, HttpResponseStatus.BAD_REQUEST,
						"Not a http request");
			}
		} else {
			sendError(ctx, HttpResponseStatus.BAD_REQUEST,
					"解码文件失败");
		}

	}

	private void sendResponse(ChannelHandlerContext ctx, String responseString,
			String contentType, HttpResponseStatus status) {
		FullHttpResponse response = new DefaultFullHttpResponse(
				HttpVersion.HTTP_1_1, status, Unpooled.copiedBuffer(
						responseString, CharsetUtil.UTF_8));
		response.headers().set(CONTENT_TYPE, contentType);
		response.headers().add("Access-Control-Allow-Origin", "*");
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

	private void responseMsg(JSONObject json, ChannelHandlerContext ctx) {
		String contentType = "application/json; charset=UTF-8";
		HttpResponseStatus status = HttpResponseStatus.OK;
		sendResponse(ctx, json.toString(), contentType, status);
	}

	
	private void reset() {
		decoder.destroy();
		decoder = null;
	}

	/**
	 * 
	 * 解析http报文
	 */
	private void readHttpDataChunkByChunk(ChannelHandlerContext ctx) {
		// 多个数据块上传
		if (decoder.isMultipart()) {
			List<InterfaceHttpData> datas = decoder.getBodyHttpDatas();

			if (null != datas && datas.size() > 0) {
				Map<String, Object> map = writeHttpData(datas);
				JSONObject json = saveFileOnDisk(map);
				//System.out.println("json:"+json.toJSONString());
				responseMsg(json, ctx);
				datas.clear();
			}

		} else {
			sendError(ctx, HttpResponseStatus.BAD_REQUEST,
					"Not a multipart request");
		}
	}

	private Map<String, Object> writeHttpData(List<InterfaceHttpData> datas) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (InterfaceHttpData data : datas) {
			if (data != null) {
				if (data.getHttpDataType() == InterfaceHttpData.HttpDataType.Attribute) {
					Attribute attribute = (Attribute) data;
					if (attribute.isCompleted()) {
						try {
							if (attribute.getName().equals("fileid")) {
								map.put(attribute.getName(),
										attribute.getValue());
							}
							if (attribute.getName().equals("schema")) {
								map.put(attribute.getName(),
										attribute.getValue());
							}
							if (attribute.getName().equals("path")) {
								map.put(attribute.getName(),
										attribute.getValue());
							}
							if (attribute.getName().equals("content")) {
								map.put(attribute.getName(), attribute.get());
							}

							if (attribute.getName().equals("extension")) {
								map.put(attribute.getName(),
										attribute.getValue());
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				// data.release();
			}
		}
		return map;
	}

	private JSONObject saveFileOnDisk(Map<String, Object> map) {
		JSONObject responseJson = new JSONObject();
		try {
			if (null == map) {
				responseJson.put("code", "1001");
				responseJson.put("msg", "参数不完整.");
				return responseJson;
			}
			String fileid = (String) map.get("fileid");
			String schema = (String) map.get("schema");
			String path = (String) map.get("path");
			String extension = (String) map.get("extension");
			byte[] data = (byte[]) map.get("content");

			if (null == schema || schema.trim().isEmpty()) {
				responseJson.put("code", "1001");
				responseJson.put("msg", "参数不完整。站点ID为空");
				return responseJson;
			}

			if (null == path || path.trim().isEmpty()) {
				responseJson.put("code", "1001");
				responseJson.put("msg", "参数不完整。path为空");
				return responseJson;
			}

			if (null == data) {
				responseJson.put("code", "1001");
				responseJson.put("msg", "参数不完整。文件内容为空");
				return responseJson;
			}

			if (null == extension || extension.trim().length() <= 0) {
				extension = ".jpg";
			}

			if (null==fileid || fileid.trim().length()<=0){
				fileid = getUniqueId();
			}
			
			/*String foldpath = OssConfig.BASE_PATH + File.separator + schema
					+ File.separator + path + File.separator;*/
			SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
			String fileurl = df.format(new Date());
			String foldpath = OssConfig.BASE_PATH + File.separator + schema
					+ File.separator + fileurl + File.separator;

			File fold = new File(foldpath);
			if (!fold.exists()) {
				fold.mkdirs();
			}

			String filePath = foldpath + fileid + extension;
			FileUtils.getFileFromBytes(data, filePath);
			responseJson.put("code", "1000");
			responseJson.put("id", fileid);
			responseJson.put("path", fileurl);

		} catch (JSONException e) {
			Logger.getLogger(OssServerHandler.class.getName()).log(
					Level.SEVERE, "保存文件出错", e);
		}
		return responseJson;
	}

	/**
	 * 生成文件ID
	 * 
	 * @return
	 */
	private String getUniqueId() {
		//UUID uniqueId = UUID.randomUUID();
		//return uniqueId.toString();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return df.format(new Date());
	}

	/**
	 * 保存文件到磁盘
	 * 
	 * @param fileUpload
	 *            文件对象
	 * @return 已保存文件名
	 */
	private JSONObject saveFileToDisk(FileUpload fileUpload) {

		JSONObject responseJson = new JSONObject();

		// 文件保存全路径
		String filePath = null;
		String upoadedFileName = fileUpload.getFilename();
		// 文件扩展名
		String extension = "";
		int i = upoadedFileName.lastIndexOf('.');
		if (i > 0) {
			extension = upoadedFileName.substring(i);
		}

		String uniqueBaseName = getUniqueId();
		String fileName = uniqueBaseName + extension;

		try {
			filePath = OssConfig.BASE_PATH + fileName;
			fileUpload.renameTo(new File(filePath)); // enable to move into
														// another
			responseJson.put("file", fileName);
			if (isImageExtension(extension)) {
				String thumbname = createThumbnail(filePath, uniqueBaseName,
						extension);
				responseJson.put("thumb", thumbname);
			}
		} catch (IOException ex) {
			responseJson = null;
		} catch (JSONException ex) {
			Logger.getLogger(OssServerHandler.class.getName()).log(
					Level.SEVERE, null, ex);
			responseJson = null;
		}

		return responseJson;
	}

	/**
	 * 创建图片缩略图
	 * 
	 * @param fileFullPath
	 *            图片资源全路径
	 * @param fileNameBase
	 *            文件名
	 * @param fileExtension
	 *            文件扩展名
	 */
	private String createThumbnail(String fileFullPath, String fileNameBase,
			String extension) {
		String thumbImgName = fileNameBase + "_thumb" + extension; // thumbnail
		String thumbImageFullPath = OssConfig.BASE_PATH + thumbImgName; // all
																		// are
		try {
			Thumbnails.of(new File(fileFullPath)).size(100, 100)
					.toFile(new File(thumbImageFullPath));
		} catch (IOException ex) {
			Logger.getLogger(OssServerHandler.class.getName()).log(
					Level.SEVERE, null, ex);
			thumbImgName = "";
		}
		return thumbImgName;
	}

	private static boolean isImageExtension(String extension) {
		boolean isImageFile = false;
		String extensionInLowerCase = extension.toLowerCase();

		isImageFile |= extensionInLowerCase.equals(".jpg");
		isImageFile |= extensionInLowerCase.equals(".png");
		isImageFile |= extensionInLowerCase.equals(".jpeg");
		isImageFile |= extensionInLowerCase.equals(".gif");

		return isImageFile;

	}

	private void sendError(ChannelHandlerContext ctx,
			HttpResponseStatus status, String msg) {
		FullHttpResponse response = new DefaultFullHttpResponse(
				HttpVersion.HTTP_1_1, status, Unpooled.copiedBuffer(msg,
						CharsetUtil.UTF_8));
		response.headers().set(CONTENT_TYPE, "text/plain; charset=UTF-8");
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

	private void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
		sendError(ctx, status, "Failure: " + status.toString() + "\r\n");
	}

	private static BufferedImage resizeImage(BufferedImage originalImage,
			int type) {

		BufferedImage resizedImage = new BufferedImage(
				OssConfig.THUMB_MAX_WIDTH, OssConfig.THUMB_MAX_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, OssConfig.THUMB_MAX_WIDTH,
				OssConfig.THUMB_MAX_HEIGHT, null);
		g.dispose();

		return resizedImage;
	}

}
