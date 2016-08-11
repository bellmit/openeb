package com.gsccs.b2c.plat.auth.service;

import java.util.List;

import com.gsccs.b2c.plat.auth.model.DictGroup;
import com.gsccs.b2c.plat.auth.model.DictItem;

/**
 * <p>
 * User: x.d zhang
 * <p>
 * Date: 14-1-28
 * <p>
 * Version: 1.0
 */
public interface DictService {

	public void saveDictGroup(DictGroup dictGroupT);

	public void deleteDictGroup(String id);

	public DictGroup getGroupById(String id);

	public DictGroup getGroupByCode(String code);

	public DictGroup getGroupByTitle(String title);

	public List<DictItem> getDictItems(String groupcode);

	public List<DictGroup> findGroupList(DictGroup param, int page, int pagesize);

	public List<DictGroup> findGroupList(DictGroup param);

	public Integer countDictGroup(DictGroup param);

	public void saveDictItem(DictItem dictItemT);

	public void deleteDictItem(String id);

	public DictItem getDictById(String id);

	public List<DictItem> findDictlist(String ids);

	public List<DictItem> findItemList(DictItem param, int page, int pagesize);

	public List<DictItem> findItemList(DictItem param);

	public List<DictItem> findGroupAndItemList(DictItem param);

	public Integer countDictItem(DictItem param);

	public List<DictItem> getDictItemsByCode(String code, DictItem dictItem);
}
