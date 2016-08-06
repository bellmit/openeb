package com.gsccs.b2c.plat.site.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.b2c.plat.Constants;
import com.gsccs.b2c.plat.bass.Datagrid;
import com.gsccs.b2c.plat.bass.FileTreeGrid;
import com.gsccs.b2c.plat.bass.JsonMsg;
import com.gsccs.b2c.plat.common.model.Config;
import com.gsccs.b2c.plat.common.service.ConfigService;
import com.gsccs.b2c.plat.site.model.Templet;
import com.gsccs.b2c.plat.site.service.TempletService;
import com.gsccs.b2c.plat.utils.FileUtil;
import com.gsccs.b2c.plat.utils.ZipTools;


/**
 * 模板管理
 * @创建人：x.j  niu 
 * @类名称：TempletController
 * @创建时间：2015年4月9日 上午9:02:49
 */

@Controller
@RequestMapping("/templet")
public class TempletController {
	
	@Resource
	private TempletService templetService;
	//配置服务
	@Resource
	private ConfigService configService;

	/**
	 * 跳转到模板列表页面
	 * @param templet
	 * @param map
	 * @param response
	 * @return
	 */
	@RequestMapping("/templetList")
	public String templetList(Templet templet,ModelMap map, HttpServletResponse response){
		return "templet/templet_list";
	}
	
	
	/**
	 * 获取模板列表信息
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @param map
	 * @param templet
	 * @param request
	 * @return
	 */
	//@RequiresPermissions("templet:view")
	@RequestMapping(value = "/datagrid")
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " orderNum  ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Templet templet, HttpServletRequest request) {

		int count = templetService.count(templet);
		List<Templet> templetList = templetService.find(templet, order, currPage, pageSize);
		
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(templetList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}
	
	/**
	 * 跳转到添加页面
	 * */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		return "templet/templet_add";
	}

	/**
	 * 添加模板
	 */
	@RequestMapping(value="/templetAdd")
	@ResponseBody
	public JsonMsg templetAdd(Templet templet,ModelMap map,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile,
			@RequestParam(value = "imgfile", required = false) MultipartFile imgfile,
			HttpServletRequest request,HttpServletResponse response,
			RedirectAttributes redirectAttributes) throws Exception{
		
		JsonMsg jsonMsg = new JsonMsg();
		
		//获取模板存放目录
		String code =Constants.tempathPathCode.toString();
		Config config = configService.findByCode(code);
		String templetPath = config.getConfigvalue();
	
		
		/**模板预览图上传**/
		
		if (imgfile != null && imgfile.getSize() > 0) {
			// 生成目标文件
			String ext = FileUtil.getExt(
					imgfile.getOriginalFilename()).toLowerCase();
			if (!".jpg".equals(ext) && !".jpeg".equals(ext)
					&& !".gif".equals(ext) && !".png".equals(ext)) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("模版预览图片只能上传jpg,jpeg,gif,png格式的图片!");
			}
			//预览图Id与模版Id相同
			File targetFile = new File(templetPath + File.separator + templet.getId() + ext);
			File folder = new File(templetPath + File.separator);
			if (!folder.exists()) {
				folder.mkdir();
			}
			if (!targetFile.exists()) {
				targetFile.createNewFile();
			}
			// 复制到目标文件
			FileUtil.copy(imgfile, targetFile);
			// 生成模版预览图访问地址
			templet.setImg(File.separator + templet.getId() + File.separator + templet.getId()+ ext);
		}
		
		
		/**** 模板文件上传******/
		//生成模板文件目录
		if(uploadFile != null && uploadFile.getSize() > 0){
			
			// 生成目标文件
			String ext = 
			FileUtil.getExt(uploadFile.getOriginalFilename()).toLowerCase();
			if (!".zip".equals(ext)) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("请上传格式为zip的压缩文件!");
			}else{
				
				templetService.insert(templet);
				//templetPaht:  F://plat//templet
				File targetFile = new File(templetPath + File.separator +templet.getId()+ ext);
				File folder = new File(templetPath + File.separator );
				
				if (!folder.exists()) {
					folder.mkdirs();
				}
				if (!targetFile.exists()) {
					targetFile.createNewFile();
				}
				// 复制到目标文件
				FileUtil.copy(uploadFile, targetFile);
				
				// 解压 将文件解压到  tempath/templet/templetId   F:\plat\templet\1007\
				ZipTools.unZip(templetPath + File.separator + templet.getId() + ext, templetPath + File.separator + templet.getId() + File.separator);
				
				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("模板上传成功！");
			}
		}else{
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("请上传格式为zip的模板文件!");
		}
		
		return jsonMsg;
	}
	/**
	 * 打开文件树页面
	 * @param templetId
	 * @param map
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/fileList")
	public String fileList(String  templetId,ModelMap map, HttpServletResponse response,Model model){
		model.addAttribute("templetId", templetId);
		return "templet/file_list";
	}
	
	/**
	 * 获取文件树
	 * @param templetId
	 * @param map
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/fileTreegrid")
	@ResponseBody
	public List<FileTreeGrid> showfile(long  templetId,ModelMap map, HttpServletResponse response){
		
		
		List<FileTreeGrid> fList = new ArrayList<FileTreeGrid>() ;
		
		//获取模板存放目录
		String code =Constants.tempathPathCode.toString();
		Config config = configService.findByCode(code);
		String templetPath = config.getConfigvalue();
		List<FileTreeGrid> ftGrids = null;
		//判断数据库中是否有该条记录
		Templet templet = templetService.findById(templetId);
		if(templet !=null){
			ftGrids = getAllFolder(String.valueOf(templetId), templetPath,fList);
			//添加根节点 （模板Id就是根节点）
			FileTreeGrid fTreeGrid = new FileTreeGrid();
			fTreeGrid.setId(String.valueOf(templetId));
			fTreeGrid.setText(String.valueOf(templetId));
			fTreeGrid.setParentId("1");
			fTreeGrid.setIconCls("icon-file");
			ftGrids.add(fTreeGrid);
		}
		return ftGrids;
	}
	
	
	/**
	 * 根据文件名和path获取该目录下的所有文件夹，并添加到list中
	 * @param fileName
	 * @param path
	 * @return
	 */
	public List<FileTreeGrid> getAllFolder(String fileName,String path,List<FileTreeGrid> fList){
		
		if (FileUtil.hasSonFolder(path + File.separator + fileName)) {
			try {
				List<File> sonFolders = templetFolderSon(fileName, path);
				for (File sonFolder : sonFolders) {
					FileTreeGrid ftgFolder = new FileTreeGrid();
					ftgFolder.setId(sonFolder.getName());
					ftgFolder.setText(sonFolder.getName());
					ftgFolder.setParentId(fileName);
					ftgFolder.setIconCls("icon-file");
					fList.add(ftgFolder);
					
					//读取文件夹下面的所有文件 ,并添加到list中
					List<File> sonFiles = FileUtil.getFiles(path + File.separator +fileName + File.separator + sonFolder.getName());
					for (File sonFiler : sonFiles) {
						FileTreeGrid ftgFile = new FileTreeGrid();
						ftgFile.setId(sonFiler.getName());
						ftgFile.setText(sonFiler.getName());
						ftgFile.setParentId(sonFolder.getName());
						fList.add(ftgFile);
					}
					getAllFolder(sonFolder.getName(),path + File.separator +fileName,fList);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return fList;
	}
	
	
	/**
	 * 查询子文件夹
	 * 
	 * @param map
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public List<File> templetFolderSon(String pid, String templetPath) throws UnsupportedEncodingException {
		if (pid != null && pid.trim().length() > 0) {
			pid = URLDecoder.decode(pid, "utf-8");
			List<File> sonFiles = FileUtil.getFolders(templetPath + File.separator + pid);
			return sonFiles;
		}
		return null;
	}
	
	/**
	 * 跳转到文件编辑页面
	 * @param templet
	 * @param map
	 * @param response
	 * @return
	 */
	@RequestMapping("/fileEdit")
	public String fileEdit(String fileName,ModelMap map, HttpServletResponse response){
		System.out.println("fileName=="+fileName);
		return "templet/file_edit";
	}
	
	/**
	 * 文件编辑
	 * @param templet
	 * @param map
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/fileEditSave", method = RequestMethod.GET)
	public String fileEditSave(String fileName,ModelMap map, HttpServletResponse response){
		return "templet/file_edit";
	}
	

}
