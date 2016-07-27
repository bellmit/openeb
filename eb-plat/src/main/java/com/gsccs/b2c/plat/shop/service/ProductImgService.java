package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import com.gsccs.b2c.plat.shop.model.ProductImgT;


/**
 *商品图片接口
 * @author niu x j
 *
 */
public interface ProductImgService {
	
	public List<ProductImgT> getImgByPid(Long siteid,Long pid);
	
	public Long[] addListImg(Long sid , List<ProductImgT> pitList);

}
