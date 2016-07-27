package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.plat.shop.dao.CategoryMapper;
import com.gsccs.b2c.plat.shop.dao.StoreCateMapper;
import com.gsccs.b2c.plat.shop.model.CategoryExample;
import com.gsccs.b2c.plat.shop.model.CategoryExample.Criteria;
import com.gsccs.b2c.plat.shop.model.CategoryT;
import com.gsccs.b2c.plat.shop.model.StoreCate;
import com.gsccs.b2c.plat.shop.model.StoreCateExample;
import com.gsccs.b2c.plat.utils.SqlUtil;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private StoreCateMapper storeCateMapper;

	@Override
	public void down(CategoryT category) {

	}

	@Override
	public void up(CategoryT category) {

	}

	@Override
	public List<CategoryT> find(CategoryT category, String order, int currPage,
			int pageSize) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(category, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return categoryMapper.selectPageByExample(example);
	}

	public List<CategoryT> findRootCates() {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParidEqualTo(0l);
		return categoryMapper.selectByExample(example);
	}

	@Override
	public boolean hasChildren(Long parId) {
		CategoryExample example = new CategoryExample();
		Criteria c = example.createCriteria();
		c.andParidEqualTo(parId);
		List<CategoryT> cList = categoryMapper.selectByExample(example);
		if (cList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public CategoryT findById(Long id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<CategoryT> findByPar(Long parid) {
		if (null == parid) {
			return findRootCates();
		} else {
			CategoryT t = new CategoryT();
			t.setParid(parid);
			CategoryExample example = new CategoryExample();
			Criteria criteria = example.createCriteria();
			proSearchParam(t, criteria);
			return categoryMapper.selectByExample(example);
		}
	}

	@Override
	public List<CategoryT> findByPar(Long parid, String state) {
		CategoryT t = new CategoryT();
		t.setParid(parid);
		t.setState(state);
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(t, criteria);
		return categoryMapper.selectByExample(example);
	}

	public List<CategoryT> findCatesByParId(Long storeid, Long parid) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		CategoryT param = new CategoryT();
		param.setParid(parid);
		proSearchParam(param, criteria);
		return categoryMapper.selectByExample(example);
	}

	public List<CategoryT> findCatesBySiteId(Long storeid) {
		return findCatesBySiteId(storeid, null);
	}

	public List<CategoryT> findCatesBySiteId(Long storeid, Long parid) {
		StoreCateExample e1 = new StoreCateExample();
		StoreCateExample.Criteria c1 = e1.createCriteria();
		c1.andSiteIdEqualTo(storeid);
		StoreCate storeCate = storeCateMapper.selectByPrimaryKey(storeid);
		if (null != storeCate && StringUtils.isNotEmpty(storeCate.getCateids())) {
			CategoryExample example = new CategoryExample();
			Criteria criteria = example.createCriteria();
			CategoryT param = new CategoryT();
			param.setParid(parid);
			proSearchParam(param, criteria);
			criteria.andSQL(" id in (" + storeCate.getCateids() + ")");
			return categoryMapper.selectByExample(example);
		}
		return null;
	}

	@Override
	public void update(CategoryT category) {
		categoryMapper.updateByPrimaryKey(category);
	}

	@Override
	public Long insert(CategoryT category) {
		if (null != category) {
			if (null == category.getParid()) {
				category.setParid(0l);
			}
			String parids = this.findParPro(category.getParid());
			category.setParids(parids);
			categoryMapper.insert(category);
			return category.getId();
		}
		return null;
	}

	@Override
	public void del(Long id) {
		categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delPar(Long parId) {
		CategoryT t = new CategoryT();
		t.setParid(parId);
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(t, criteria);
		categoryMapper.deleteByExample(example);
	}

	public List<CategoryT> findAll() {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		// proSearchParam(t, criteria);
		return categoryMapper.selectByExample(example);
	}

	@Override
	public JSONArray findAll(String state) {
		List<CategoryT> categoryList = findAll();
		return java2JsonArray(categoryList);
	}

	private JSONArray java2JsonArray(List<CategoryT> categoryList) {
		JSONArray array = new JSONArray();
		for (CategoryT tg : categoryList) {
			JSONObject object = new JSONObject();
			object.put("id", tg.getId().toString());
			object.put("parentId", tg.getParid().toString());
			object.put("text", tg.getTitle());
			object.put("iconCls", "icon-file");
			object.put("typeid", tg.getTypeId());
			object.put("typename", tg.getTypename());

			if (hasChildren(tg.getId())) {
				object.put("state", "closed");
			}
			array.add(object);
		}

		return array;
	}

	@Override
	public int count(CategoryT category) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(category, criteria);
		return categoryMapper.countByExample(example);
	}

	@Override
	public String findParPro(Long id) {
		String parids = id.toString();
		CategoryT ct = this.findById(id);
		if (null != ct) {
			if (!ct.getParid().equals("0")) {
				findParPro(ct.getParid());
			} else {
				parids += "0/" + ct.getParid();
			}
		}
		return parids;
	}

	@Override
	public StoreCate findStoreCateIds(Long siteid) {
		return storeCateMapper.selectByPrimaryKey(siteid);
	}

	@Override
	public void addStoreCate(Long siteid, String cateids) {
		StoreCate storeCate = storeCateMapper.selectByPrimaryKey(siteid);
		if (null == storeCate) {
			StoreCate storeCate_ = new StoreCate();
			storeCate_.setSiteId(siteid);
			storeCate_.setCateids(cateids);
			storeCateMapper.insert(storeCate_);
		} else {
			storeCate.setCateids(cateids);
			storeCateMapper.updateByPrimaryKey(storeCate);
		}
	}

	@Override
	public JSONArray findByStore(Long storeid) {
		List<CategoryT> cateList = findCatesBySiteId(storeid);
		if (null != cateList) {
			return java2JsonArray(cateList);
			// (JSONArray) JSON.toJSON(cateList);
		}
		return null;
	}

	@Override
	public JSONArray findByStore(Long storeid, Long parid) {
		List<CategoryT> nodes = findCatesByParId(storeid, parid);
		// findCatesBySiteId(storeid, parid);
		if (null != nodes) {
			return (JSONArray) JSON.toJSON(nodes);
		}
		return null;
	}

	public JSONArray findBySite(Long siteid) {
		List<CategoryT> roots = findAll();
		if (null != roots) {
			JSONArray rootArray = (JSONArray) JSON.toJSON(roots);
			return treeList(rootArray, 0l);
		}
		return null;
	}

	public JSONArray treeList(JSONArray nodeList, Long parentId) {
		JSONArray nodearray = new JSONArray();
		for (Object object : nodeList) {
			JSONObject json = (JSONObject) JSON.toJSON(object);
			long menuId = json.getLong("id");
			long pid = json.getLong("parid");
			if (parentId == pid) {
				JSONArray subitems = treeList(nodeList, menuId);
				json.put("items", subitems);
				nodearray.add(json);
			}
		}
		return nodearray;
	}

	/**
	 * 处理查询条件
	 * 
	 * @param info
	 * @param criteria
	 */
	public void proSearchParam(CategoryT c, Criteria criteria) {
		if (c != null) {
			if (c.getId() != null) {
				criteria.andIdEqualTo(c.getId());
			}
			c.setTitle(SqlUtil.replace(c.getTitle()));
			if (c.getTitle() != null && c.getTitle().trim().length() > 0) {
				criteria.andTitleLike("%" + c.getTitle().trim() + "%");
			}

			if (null != c.getParid()) {
				criteria.andParidEqualTo(c.getParid());
			}
		}
	}

}
