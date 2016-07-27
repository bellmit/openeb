package com.gsccs.eb.api.domain.site;

import java.io.Serializable;
import java.util.List;

import com.gsccs.b2c.api.domain.Domain;

public class Banner extends Domain  {

	private static final long serialVersionUID = 132158652580522323L;

	private Integer id;

	private String maingraph;

	private String maingraphline;

	private String subgraph1;

	private String subgraph2;

	private String subgraphline1;

	private String subgraphline2;
	
	private String longBanner;
	
	private List<LongBanner> longBanners;

	/**
	 * 长条幅
	 */
	public static class LongBanner implements Serializable{
		private static final long serialVersionUID = -2026650163184577574L;
		private String banner;
		private String bannerLine;
		
		public String getBanner() {
			return banner;
		}
		public void setBanner(String banner) {
			this.banner = banner;
		}
		public String getBannerLine() {
			return bannerLine;
		}
		public void setBannerLine(String bannerLine) {
			this.bannerLine = bannerLine;
		}
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaingraph() {
		return maingraph;
	}

	public void setMaingraph(String maingraph) {
		this.maingraph = maingraph;
	}

	public String getMaingraphline() {
		return maingraphline;
	}

	public void setMaingraphline(String maingraphline) {
		this.maingraphline = maingraphline;
	}

	public String getSubgraph1() {
		return subgraph1;
	}

	public void setSubgraph1(String subgraph1) {
		this.subgraph1 = subgraph1;
	}

	public String getSubgraph2() {
		return subgraph2;
	}

	public void setSubgraph2(String subgraph2) {
		this.subgraph2 = subgraph2;
	}

	public String getSubgraphline1() {
		return subgraphline1;
	}

	public void setSubgraphline1(String subgraphline1) {
		this.subgraphline1 = subgraphline1;
	}

	public String getSubgraphline2() {
		return subgraphline2;
	}

	public void setSubgraphline2(String subgraphline2) {
		this.subgraphline2 = subgraphline2;
	}

	public List<LongBanner> getLongBanners() {
		return longBanners;
	}

	public void setLongBanners(List<LongBanner> longBanners) {
		this.longBanners = longBanners;
	}

	public String getLongBanner() {
		return longBanner;
	}

	public void setLongBanner(String longBanner) {
		this.longBanner = longBanner;
	}
}
