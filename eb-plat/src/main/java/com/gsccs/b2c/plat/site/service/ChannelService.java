package com.gsccs.b2c.plat.site.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.eb.api.domain.site.Channel;

public interface ChannelService {

	public void insert(Channel sclassT);

	public void update(Channel sclassT);

	public void delChannel(Long id);

	public Channel findById(Long id);

	public List<Channel> find(Channel sclassT, String orderstr, int page,
			int pagesize);

	public List<Channel> find(Channel sclassT);

	public List<Channel> findSubChannel(Long parid);

	public int count(Channel sclassT);

	public List<Channel> findByParids(String string);

	public JSONArray findChannelTree();
}
