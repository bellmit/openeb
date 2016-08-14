package com.gsccs.b2c.plat.site.service;

import java.util.List;

import com.gsccs.eb.api.domain.site.Advert;
import com.gsccs.eb.api.domain.site.AdvertSpace;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface AdvertService {

	public void saveAdvert(Advert advert);

	public Advert getAdvert(Long id);

	public void delAdvert(Long id);

	public List<Advert> find(Advert param, String order, int currPage,
			int pageSize);

	public int count(Advert advert);
	
	public void saveAdvertSpace(AdvertSpace param);

	public AdvertSpace getAdvertSpace(Long id);
	
	public List<AdvertSpace> find(AdvertSpace param, String order, int currPage,
			int pageSize);

}
