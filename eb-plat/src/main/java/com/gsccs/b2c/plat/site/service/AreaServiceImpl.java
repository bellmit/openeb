package com.gsccs.b2c.plat.site.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.site.dao.AreaMapper;
import com.gsccs.b2c.plat.site.model.AreaExample;
import com.gsccs.b2c.plat.site.model.AreaT;

/**
 * 
 */
@Service
public class AreaServiceImpl implements AreaService {

	@Resource
	private AreaMapper areaMapper;
	
	@Override
	public List<AreaT> getByParId(Integer parid){
		return areaMapper.getByParId(parid);
	}

	@Override
	public List<AreaT> find(AreaT area, String order, int currPage, int pageSize) {
		AreaExample example = new AreaExample();
		AreaExample.Criteria c = example.createCriteria();
		List<Integer> pids = new ArrayList<Integer>();
		
		pids.add(0);
		pids.add(area.getId());
		c.andParentidIn(pids);
		/*Area area_ = areaMapper.selectByPrimaryKey(area.getId());
		if (null != area_){
			if (area_.getLevel()!=1){
				getsubs(area_.getId());
			}
		}*/
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return areaMapper.selectPageByExample(example);
	}
	
	public List<AreaT> getsubs(Integer pid){
		AreaExample example = new AreaExample();
		AreaExample.Criteria c = example.createCriteria();
		c.andParentidEqualTo(pid);
		return areaMapper.selectByExample(example);
	}

	@Override
	public int count(AreaT area) {
		AreaExample example = new AreaExample();
		AreaExample.Criteria c = example.createCriteria();
		proSearchParam(area,c);
		return areaMapper.countByExample(example);
	}
	
	public void proSearchParam(AreaT area, AreaExample.Criteria criteria) {
		if (null != area){
			if (null == area.getParentid()){
				criteria.andParentidEqualTo(0);
			}else{
				criteria.andParentidEqualTo(area.getParentid());
			}
		}
	}

}
