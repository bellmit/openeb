package com.gsccs.b2c.plat.site.service;

import java.util.List;

import com.gsccs.eb.api.domain.site.Link;

public interface LinkService {

	public String add(Link link);

	public void update(Link link);

	public void del(String id);

	public Link findById(String id);

	public List<Link> find(Link link, String orderstr, int page, int pagesize);

	public List<Link> findAll(Link link, String order);

	public int count(Link link);
}
