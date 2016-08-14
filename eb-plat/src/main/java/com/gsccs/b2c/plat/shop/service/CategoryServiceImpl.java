package com.gsccs.b2c.plat.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.plat.shop.dao.CategoryMapper;
import com.gsccs.b2c.plat.shop.model.CategoryExample;
import com.gsccs.b2c.plat.shop.model.CategoryExample.Criteria;
import com.gsccs.b2c.plat.utils.SqlUtil;
import com.gsccs.eb.api.domain.goods.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> find(Category category, String order, int currPage,
			int pageSize) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(category, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return categoryMapper.selectPageByExample(example);
	}

	public List<Category> findRootCates() {
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
		List<Category> cList = categoryMapper.selectByExample(example);
		if (cList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Category findById(Long id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Category> queryCateList(Long shopid, Long parid) {
		if (null == parid) {
			return findRootCates();
		} else {
			Category t = new Category();
			t.setParid(parid);
			t.setShopId(shopid);
			CategoryExample example = new CategoryExample();
			Criteria criteria = example.createCriteria();
			proSearchParam(t, criteria);
			return categoryMapper.selectByExample(example);
		}
	}
	
	@Override
	public List<Category> findCateList(String ids) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andSql(" id in ("+ids+")");
		return categoryMapper.selectByExample(example);
	}

	@Override
	public List<Category> findByPar(Long parid, String state) {
		Category t = new Category();
		t.setParid(parid);
		t.setState(state);
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(t, criteria);
		return categoryMapper.selectByExample(example);
	}

	public List<Category> findCatesByParId(Long storeid, Long parid) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		Category param = new Category();
		param.setParid(parid);
		proSearchParam(param, criteria);
		return categoryMapper.selectByExample(example);
	}

	public List<Category> findCatesBySiteId(Long storeid) {
		return findCatesBySiteId(storeid, null);
	}

	public List<Category> findCatesBySiteId(Long storeid, Long parid) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		Category param = new Category();
		param.setParid(parid);
		proSearchParam(param, criteria);
		return categoryMapper.selectByExample(example);
	}

	@Override
	public void update(Category category) {
		categoryMapper.updateByPrimaryKey(category);
	}

	@Override
	public Long insert(Category category) {
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
		Category t = new Category();
		t.setParid(parId);
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(t, criteria);
		categoryMapper.deleteByExample(example);
	}

	public List<Category> findAll(Long shopid) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		// proSearchParam(t, criteria);
		return categoryMapper.selectByExample(example);
	}

	@Override
	public JSONArray findAll(String state) {
		List<Category> categoryList = findAll(0l);
		return java2JsonArray(categoryList);
	}

	private JSONArray java2JsonArray(List<Category> categoryList) {
		JSONArray array = new JSONArray();
		for (Category tg : categoryList) {
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
	public int count(Category category) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(category, criteria);
		return categoryMapper.countByExample(example);
	}

	@Override
	public String findParPro(Long id) {
		String parids = id.toString();
		Category ct = this.findById(id);
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
	public JSONArray findByStore(Long storeid) {
		List<Category> cateList = findCatesBySiteId(storeid);
		if (null != cateList) {
			return java2JsonArray(cateList);
			// (JSONArray) JSON.toJSON(cateList);
		}
		return null;
	}

	@Override
	public JSONArray findByStore(Long storeid, Long parid) {
		List<Category> nodes = findCatesByParId(storeid, parid);
		// findCatesBySiteId(storeid, parid);
		if (null != nodes) {
			return (JSONArray) JSON.toJSON(nodes);
		}
		return null;
	}

	public JSONArray findBySite(Long shopid) {
		List<Category> roots = findAll(shopid);
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
	public void proSearchParam(Category c, Criteria criteria) {
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
			
			if (null != c.getShopId()) {
				criteria.andShopidEqualTo(c.getShopId());
			}
		}
	}

	@Override
	public List<Category> findCategoryTree(Long shopid) {
		shopid = shopid==null?0:shopid;
		List<Category> listAllDb = findAll(shopid);
		List<Category> listAllTree = new ArrayList<Category>();
		for (Category row : listAllDb) {
			if (0 == row.getParid()) {
				listAllTree.add(row);
				fomateChannel(listAllDb, row);
			}
			// int size =
			// null==row.getSubCategory()?0:row.getSubCategory().size();
		}
		return listAllTree;
	}

	private void fomateChannel(List<Category> tmp, Category node) {
		for (Category row : tmp) {

			if (row.getParid() == 0 || row.getParid() == null) {
				continue;
			}
			if (row.getParid().equals(node.getId())) {
				List<Category> list = node.getSubCategory();
				if (list == null) {
					list = new ArrayList<Category>();
				}
				list.add(row);
				node.setSubCategory(list);
				fomateChannel(tmp, row);
			}
		}
	}

	

}
