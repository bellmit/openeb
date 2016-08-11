package com.gsccs.b2c.plat.site.service;

import java.util.ArrayList;
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

			if (null != chanelT.getShopid()) {
				criteria.andShopidEqualTo(chanelT.getShopid());
			}else{
				criteria.andShopidEqualTo(0l);
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

	public List<Channel> searchAllChannel() throws Exception {
		List<Channel> listAllObject = find(null);
		List<Channel> listAllChannel = new ArrayList<Channel>();
		for (Channel row : listAllObject) {
			if (0 == row.getParid()) {
				listAllChannel.add(row);
				fomateChannel(listAllObject, row);
			}
		}
		return listAllChannel;
	}

	private void fomateChannel(List<Channel> tmp, Channel dept) {
		for (Channel row : tmp) {
			
			if (row.getParid()==0 || row.getParid()==null){
				continue;
			}
			
			System.out.println(row.getParid()  +" | "+dept.getId());
			System.out.println(row.getParid() == dept.getId());
			if (row.getParid().equals(dept.getId())) {
				List<Channel> list = dept.getSubChannel();
				if (list == null) {
					list = new ArrayList<Channel>();
				}
				list.add(row);
				dept.setSubChannel(list);
				fomateChannel(tmp, row);
			}
		}
	}

	private List<Channel> data() {
		List<Channel> allChannel = new ArrayList<Channel>();
		Channel channel = new Channel();
		channel.setId(1l);
		channel.setTitle("1_");
		channel.setParid(0l);
		allChannel.add(channel);

		channel = new Channel();
		channel.setId(2l);
		channel.setTitle("1_1_");
		channel.setParid(1l);
		allChannel.add(channel);

		channel = new Channel();
		channel.setId(3l);
		channel.setTitle("1_1_1_");
		channel.setParid(2l);
		allChannel.add(channel);

		channel = new Channel();
		channel.setId(30l);
		channel.setTitle("1_2_");
		channel.setParid(1l);
		allChannel.add(channel);

		channel = new Channel();
		channel.setId(4l);
		channel.setTitle("2_");
		channel.setParid(0l);
		allChannel.add(channel);

		channel = new Channel();
		channel.setId(5l);
		channel.setTitle("2_2_");
		channel.setParid(4l);
		allChannel.add(channel);

		return allChannel;
	}

	public static void main(String[] args) {
		ChannelServiceImpl channelService = new ChannelServiceImpl();
		try {
			List<Channel> channels = channelService.searchAllChannel();
			for (Channel c : channels) {
				System.out.println(c.getTitle());
				System.out.println("   " + c.getSubChannel().size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Channel> findChannelTree(Long shopid) {
		Channel param = new Channel();
		param.setShopid(shopid);
		List<Channel> listAllDb = find(param);
		System.out.println("listAllDb size:"+listAllDb.size());
		List<Channel> listAllTree = new ArrayList<Channel>();
		for (Channel row : listAllDb) {
			if (0 == row.getParid()) {
				listAllTree.add(row);
				fomateChannel(listAllDb, row);
			}
			int size = null==row.getSubChannel()?0:row.getSubChannel().size();
			System.out.println(row.getTitle()+" "+size);
		}
		return listAllTree;
	}

}
