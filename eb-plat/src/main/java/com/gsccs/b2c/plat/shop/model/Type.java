package com.gsccs.b2c.plat.shop.model;

import java.util.List;

/**
 * 类型
 * 
 * @author x.d zhang
 * 
 */
public class Type {

	private Long id;
	private String title;
	private String alias;
	private String isPhysical;
	private String useBrand;
	private String useProps;
	private String useParams;
	private String useMinfo;
	private String useFloatstore;
	private String state;
	private Integer ordernum;

	// 类型对应属性列表
	private List<Property> props;
	// 类型规格对应关系
	private List<Specific> specs;
	// 详细参数
	private List<TypeParam> params;
	// 购物必填信息
	private List<RequirInfo> minfos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias == null ? null : alias.trim();
	}

	public String getIsPhysical() {
		return isPhysical;
	}

	public void setIsPhysical(String isPhysical) {
		this.isPhysical = isPhysical == null ? null : isPhysical.trim();
	}

	public String getUseBrand() {
		return useBrand;
	}

	public void setUseBrand(String useBrand) {
		this.useBrand = useBrand == null ? null : useBrand.trim();
	}

	public String getUseProps() {
		return useProps;
	}

	public void setUseProps(String useProps) {
		this.useProps = useProps == null ? null : useProps.trim();
	}

	public String getUseParams() {
		return useParams;
	}

	public void setUseParams(String useParams) {
		this.useParams = useParams == null ? null : useParams.trim();
	}

	public String getUseMinfo() {
		return useMinfo;
	}

	public void setUseMinfo(String useMinfo) {
		this.useMinfo = useMinfo == null ? null : useMinfo.trim();
	}

	public String getUseFloatstore() {
		return useFloatstore;
	}

	public void setUseFloatstore(String useFloatstore) {
		this.useFloatstore = useFloatstore == null ? null : useFloatstore
				.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public List<Property> getProps() {
		return props;
	}

	public void setProps(List<Property> props) {
		this.props = props;
	}

	public List<Specific> getSpecs() {
		return specs;
	}

	public void setSpecs(List<Specific> specs) {
		this.specs = specs;
	}

	public List<TypeParam> getParams() {
		return params;
	}

	public void setParams(List<TypeParam> params) {
		this.params = params;
	}

	public List<RequirInfo> getMinfos() {
		return minfos;
	}

	public void setMinfos(List<RequirInfo> minfos) {
		this.minfos = minfos;
	}

}