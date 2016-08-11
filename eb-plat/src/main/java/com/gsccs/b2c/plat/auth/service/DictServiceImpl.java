package com.gsccs.b2c.plat.auth.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.auth.dao.DictGroupMapper;
import com.gsccs.b2c.plat.auth.dao.DictItemMapper;
import com.gsccs.b2c.plat.auth.model.DictGroup;
import com.gsccs.b2c.plat.auth.model.DictGroupExample;
import com.gsccs.b2c.plat.auth.model.DictItem;
import com.gsccs.b2c.plat.auth.model.DictItemExample;

@Service
public class DictServiceImpl implements DictService {

	@Autowired
	private DictGroupMapper dictGroupMapper;
	@Autowired
	private DictItemMapper dictItemMapper;

	@Override
	public void createDictGroup(DictGroup groupT) {
		if (null != groupT) {
			String code = groupT.getCode();
			DictGroup t = getGroupByCode(code);
			if (null != t) { // 已存在

			} else {
				groupT.setId(UUID.randomUUID().toString());
				dictGroupMapper.insert(groupT);
			}
		}
	}

	@Override
	public void updateDictGroup(DictGroup groupT) {
		if (null != groupT) {
			dictGroupMapper.updateByPrimaryKey(groupT);
		}
	}

	@Override
	public void deleteDictGroup(String groupid) {
		dictGroupMapper.deleteByPrimaryKey(groupid);

	}

	@Override
	public DictGroup getGroupById(String id) {
		return dictGroupMapper.selectByPrimaryKey(id);
	}

	@Override
	public DictGroup getGroupByTitle(String title) {

		return dictGroupMapper.selectByTitle(title);
	}

	@Override
	public DictGroup getGroupByCode(String code) {
		DictGroupExample example = new DictGroupExample();
		DictGroupExample.Criteria c = example.createCriteria();
		c.andCodeEqualTo(code);
		List<DictGroup> list = dictGroupMapper.selectByExample(example);
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<DictGroup> findGroupList(DictGroup param, int page, int pagesize) {
		DictGroupExample example = new DictGroupExample();
		DictGroupExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictGroupMapper.selectByExample(example);
	}

	@Override
	public void createDictItem(DictItem dictItem) {
		if (null != dictItem) {
			dictItem.setId(UUID.randomUUID().toString());
			dictItemMapper.insert(dictItem);
		}
	}

	@Override
	public void updateDictItem(DictItem dictItem) {
		dictItemMapper.updateByPrimaryKey(dictItem);
	}

	@Override
	public void deleteDictItem(String id) {
		dictItemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public DictItem getDictById(String id) {
		return dictItemMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DictItem> findItemList(DictItem param, int page, int pagesize) {
		DictItemExample example = new DictItemExample();
		DictItemExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictItemMapper.selectByExample(example);
	}

	public void proSearchParam(DictGroup dictGroupT,
			DictGroupExample.Criteria criteria) {
		if (null != dictGroupT) {
			if (StringUtils.isNotEmpty(dictGroupT.getCode())) {
				criteria.andCodeEqualTo(dictGroupT.getCode());
			}

			if (StringUtils.isNotEmpty(dictGroupT.getStatus())) {
				criteria.andStatusEqualTo(dictGroupT.getStatus());
			}
		}
	}

	public void proSearchParam(DictItem dictItemT,
			DictItemExample.Criteria criteria) {
		if (null != dictItemT) {
			if (StringUtils.isNotEmpty(dictItemT.getCode())) {
				criteria.andCodeEqualTo(dictItemT.getCode());
			}
			if (StringUtils.isNotEmpty(dictItemT.getGroupid())) {
				criteria.andGroupidEqualTo(dictItemT.getGroupid());
			}
		}
	}

	@Override
	public Integer countDictGroup(DictGroup param) {
		DictGroupExample example = new DictGroupExample();
		DictGroupExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictGroupMapper.countByExample(example);
	}

	@Override
	public Integer countDictItem(DictItem param) {
		DictItemExample example = new DictItemExample();
		DictItemExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictItemMapper.countByExample(example);
	}

	@Override
	public List<DictItem> getDictItems(String code) {
		DictGroupExample example = new DictGroupExample();
		DictGroupExample.Criteria c = example.createCriteria();
		c.andCodeEqualTo(code);
		List<DictGroup> list = dictGroupMapper.selectByExample(example);
		if (null != list && list.size() > 0) {
			DictItemExample example2 = new DictItemExample();
			DictItemExample.Criteria c2 = example2.createCriteria();
			c2.andGroupidEqualTo(list.get(0).getId());
			return dictItemMapper.selectByExample(example2);
		}
		return null;
	}

	@Override
	public List<DictGroup> findGroupList(DictGroup param) {
		DictGroupExample example = new DictGroupExample();
		DictGroupExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictGroupMapper.selectByExample(example);
	}

	@Override
	public List<DictItem> findItemList(DictItem param) {
		DictItemExample example = new DictItemExample();
		DictItemExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictItemMapper.selectByExample(example);
	}

	@Override
	public List<DictItem> findGroupAndItemList(DictItem param) {
		DictItemExample example = new DictItemExample();
		DictItemExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictItemMapper.selectGroupAndItemList(example);
	}

	@Override
	public List<DictItem> findDictlist(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			String[] idArray = ids.split(",");
			if (null != idArray && idArray.length > 0) {
				List<String> idlist = Arrays.asList(idArray);
				for (String id : idlist) {
					if (StringUtils.isEmpty(id)) {
						idlist.remove(id);
					}
				}
				if (null != idlist && idlist.size() > 0) {
					DictItemExample example = new DictItemExample();
					DictItemExample.Criteria c = example.createCriteria();
					c.andIdIn(idlist);
					return dictItemMapper.selectByExample(example);
				}
			}
		}
		return null;
	}

	@Override
	public List<DictItem> getDictItemsByCode(String code, DictItem dictItem) {
		DictGroup dictGroup = dictGroupMapper.selectByCode(code);
		dictItem.setGroupid(dictGroup.getId());
		return findItemList(dictItem);
	}
}
