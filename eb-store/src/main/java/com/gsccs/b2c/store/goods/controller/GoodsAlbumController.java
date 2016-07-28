package com.gsccs.b2c.store.goods.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.oss.client.ObjectMetadata;
import com.gsccs.b2c.oss.client.OssClient;
import com.gsccs.b2c.store.base.JsonMsg;

@Controller
public class GoodsAlbumController {
	// 宝贝图片上传
	@RequestMapping("/uploadify")
	@ResponseBody
	public JsonMsg uploadify(HttpServletRequest request, HttpServletResponse response) {

		DiskFileItemFactory diskFileItemFactory_ = new DiskFileItemFactory();
		ServletFileUpload fUpload = new ServletFileUpload(diskFileItemFactory_);
		String filePath = "";
		try {
			List<FileItem> list_ = (List<FileItem>) fUpload.parseRequest(request);
			for(FileItem item : list_) {
				if(item.getName() != null) {
					OssClient client = new OssClient("101.227.249.205", 7070);
					byte[] content = item.get();
		
					ObjectMetadata.ExtensionType exten = ObjectMetadata.ExtensionType.jpg;
					ObjectMetadata metadata = new ObjectMetadata();
					metadata.setDomain("http://img.titles.top/1001/");
					metadata.setSite("1001");
					metadata.setPath("index");
					metadata.setType(exten);
					metadata.setContent(content);
		
					JSONObject obj = client.putObject(metadata);
					filePath = obj.get("url").toString();
				}
			}
		} catch (FileUploadException e2) {
			e2.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JsonMsg msg = new JsonMsg();
		msg.setSuccess(true);
		msg.setMsg("上传成功!");
		msg.setData(filePath);
		return msg;
	}

	// 宝贝详细介绍内容上传
	@RequestMapping("/descriptionUpload")
	@ResponseBody
	public Map<String, Object> fileUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {  
		DiskFileItemFactory diskFileItemFactory_ = new DiskFileItemFactory();
		ServletFileUpload fUpload = new ServletFileUpload(diskFileItemFactory_);
		String filePath = "";
		try {
			List<FileItem> list_ = (List<FileItem>) fUpload.parseRequest(request);
			for(FileItem item : list_) {
				if(item.getName() != null) {
					OssClient client = new OssClient("101.227.249.205", 7070);
					byte[] content = item.get();
		
					ObjectMetadata.ExtensionType exten = ObjectMetadata.ExtensionType.jpg;
					ObjectMetadata metadata = new ObjectMetadata();
					metadata.setDomain("http://img.titles.top/1001/");
					metadata.setSite("1001");
					metadata.setPath("index");
					metadata.setType(exten);
					metadata.setContent(content);
		
					JSONObject obj = client.putObject(metadata);
					filePath = obj.get("url").toString();
				}
			}
		} catch (FileUploadException e2) {
			e2.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("error", 0);
		msg.put("url", filePath);
		return msg;  
    } 
	
	private Map<String, Object> getError(String message) {  
        Map<String, Object> msg = new HashMap<String, Object>();  
        msg.put("error", 1);  
        msg.put("message", message);  
        return msg;  
    } 

}
