package com.gsccs.b2c.api.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.gsccs.b2c.plat.Constants;
import com.gsccs.b2c.plat.common.model.Config;
import com.gsccs.b2c.plat.common.service.ConfigService;
import com.gsccs.b2c.plat.shop.model.StoreTemplet;
import com.gsccs.b2c.plat.shop.model.Templet;
import com.gsccs.b2c.plat.shop.service.StoreTempletService;
import com.gsccs.b2c.plat.shop.service.TempletService;
import com.gsccs.b2c.plat.utils.FileUtil;
import com.gsccs.eb.api.utils.FileTreeGrid;


public class TempletServiceAPI implements TempletServiceI{

	@Resource
	private TempletService templetService;
	//配置服务
	@Resource
	private ConfigService configService;
	
	@Resource
	private StoreTempletService storeTempletService;
	
	/**
	 * 根据店铺Id查询该店铺使用的模板
	 */
	@Override
	public List<FileTreeGrid> getTempleByStoreId(Long storeId){
		StoreTemplet storeTemplet = new StoreTemplet();
		storeTemplet.setStoreid(storeId);
		List<StoreTemplet> stList = storeTempletService.find(storeTemplet, "");
		List<FileTreeGrid> ftgList = new ArrayList<FileTreeGrid>();
		if(stList.size() > 0){
			long templetId = stList.get(0).getTempletid();
			ftgList = getTemplet(templetId);
			return ftgList;
		}else {
			return null;
		}
		
	}
	
	/**
	 * 根据模板Id查询模板文件
	 */
	@Override
	public List<com.gsccs.eb.api.utils.FileTreeGrid> getTemplet(long templetId) {
		
		
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
}
