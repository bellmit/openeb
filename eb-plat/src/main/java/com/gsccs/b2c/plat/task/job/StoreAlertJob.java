package com.gsccs.b2c.plat.task.job;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.gsccs.b2c.plat.seller.model.Store;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.b2c.plat.shop.service.ProductService;
import com.gsccs.b2c.plat.utils.SpringUtils;

/**
 * 商品自动下架任务
 * @author x.d zhang
 *
 */
public class StoreAlertJob extends QuartzJobBean{

	protected static final Logger log=Logger.getLogger(StoreAlertJob.class);  
    
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		 log.info("-----自动下架任务执行-----"); 
		 StoreService storeService =  SpringUtils.getBean("storeService");
		 ProductService goodsService =  SpringUtils.getBean("goodsService");
		 List<Store> storeList = storeService.find(null, null);
		 if (null != storeList){
			 for(int i=0;i<storeList.size();i++){
				 Store storeT = storeList.get(i);
				 try{
					 goodsService.productUnsale(storeT.getId());
				 }catch(Exception e){
					 log.info("自动下架任务执行出错。");  
				 }
			 }
		 }
	}

}
