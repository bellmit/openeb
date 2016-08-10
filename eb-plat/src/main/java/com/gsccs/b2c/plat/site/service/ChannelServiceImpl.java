package com.gsccs.b2c.plat.site.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.plat.site.dao.ChannelMapper;
import com.gsccs.b2c.plat.site.model.ChannelExample;
import com.gsccs.eb.api.domain.site.Channel;

/**
 * 信息分类业务
 * 
 * @author x.d zhang
 * 
 */
@Service(value = "channelService")
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChannelMapper channelMapper;

	/**
	 * 根据id查询
	 */
	@Override
	public Channel findById(Long id) {
		return channelMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insert(Channel chanelT) {
		if (null != chanelT) {
			channelMapper.insert(chanelT);
		}
	}

	/**
	 * 更新栏目信息
	 */
	@Override
	public void update(Channel chanelT) {
		channelMapper.updateByPrimaryKeyWithBLOBs(chanelT);
	}

	@Override
	public int count(Channel chanelT) {
		ChannelExample example = new ChannelExample();
		ChannelExample.Criteria criteria = example.createCriteria();
		proSearchParam(chanelT, criteria);
		return channelMapper.countByExample(example);
	}

	@Override
	public List<Channel> find(Channel chanelT, String orderstr, int page,
			int pagesize) {
		ChannelExample example = new ChannelExample();
		ChannelExample.Criteria criteria = example.createCriteria();
		proSearchParam(chanelT, criteria);
		return channelMapper.selectByExample(example);
	}

	@Override
	public List<Channel> find(Channel chanelT) {
		ChannelExample example = new ChannelExample();
		ChannelExample.Criteria criteria = example.createCriteria();
		proSearchParam(chanelT, criteria);
		return channelMapper.selectByExample(example);
	}

	@Override
	public void delChannel(Long id) {
		channelMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Channel> findSubChannel(Long parid) {
		if (null != parid) {
			Channel chanelT = new Channel();
			chanelT.setParid(parid);
			ChannelExample example = new ChannelExample();
			ChannelExample.Criteria criteria = example.createCriteria();
			proSearchParam(chanelT, criteria);
			return channelMapper.selectByExample(example);
		}
		return null;
	}

	public void proSearchParam(Channel chanelT, ChannelExample.Criteria criteria) {
		if (null != chanelT) {
			if (StringUtils.isNotEmpty(chanelT.getTitle())) {
				criteria.andTitleLike("%" + chanelT.getTitle() + "%");
			}
			if (null != chanelT.getParid()) {
				criteria.andParidEqualTo(chanelT.getParid());
			}
			if (null != chanelT.getParids()) {
				criteria.andParidsLike("%" + chanelT.getParids() + "%");
			}
		}
	}

	@Override
	public List<Channel> findByParids(String parids) {
		if (null != parids) {
			Channel chanelT = new Channel();
			chanelT.setParids(parids);
			ChannelExample example = new ChannelExample();
			ChannelExample.Criteria criteria = example.createCriteria();
			proSearchParam(chanelT, criteria);
			return channelMapper.selectByExample(example);
		}
		return null;
	}

	@Override
	public JSONArray findChannelTree() {
		List<Channel> roots = find(null);
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
			json.put("text", json.get("title"));
			if (parentId == pid) {
				JSONArray subitems = treeList(nodeList, menuId);
				json.put("children", subitems);
				nodearray.add(json);
			}
		}
		return nodearray;
	}
}
