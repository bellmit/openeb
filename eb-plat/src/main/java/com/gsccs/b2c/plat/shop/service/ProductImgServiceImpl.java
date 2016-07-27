package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.shop.dao.ProductImgTMapper;
import com.gsccs.b2c.plat.shop.model.GoodsT;
import com.gsccs.b2c.plat.shop.model.ProductImgT;

@Service
public class ProductImgServiceImpl implements ProductImgService{

	@Autowired
	private ProductImgTMapper pImgMapper;
	
	@Override
	public List<ProductImgT> getImgByPid(Long siteid, Long pid) {
		return pImgMapper.selectByPid(siteid, pid);
	}

	@Override
	public Long[] addListImg(Long sid, List<ProductImgT> pitList) {
		if (null != pitList && pitList.size() > 0) {
			Long[] ids = new Long[pitList.size()];
			int i = 0;
			for (ProductImgT pt : pitList) {
				pImgMapper.insert(sid, pt);
				ids[i] = pt.getId();
				i++;
			}
			return ids;
		}
		return null;
	}

}
