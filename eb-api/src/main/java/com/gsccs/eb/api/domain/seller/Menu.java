package com.gsccs.eb.api.domain.seller;

import java.util.List;

import com.gsccs.eb.api.domain.base.Domain;

/**
 */
public class Menu extends Domain {

	private Long id; // 编号
	private String name; // 资源名称
	private ResourceType type = ResourceType.menu; // 资源类型
	private String url; // 资源路径
	private String permission; // 权限字符串
	private Long parentId; // 父编号
	private String parentIds; // 父编号列表
	private String state;
	private String remark;
	private String icon;

	private List<Menu> subs;

	public static enum ResourceType {
		menu("菜单"), button("按钮");

		private final String info;

		private ResourceType(String info) {
			this.info = info;
		}

		public String getInfo() {
			return info;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isRootNode() {
		return parentId == 0;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String makeSelfAsParentIds() {
		return getParentIds() + getId() + "/";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Menu resource = (Menu) o;

		if (id != null ? !id.equals(resource.id) : resource.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	public List<Menu> getSubs() {
		return subs;
	}

	public void setSubs(List<Menu> subs) {
		this.subs = subs;
	}

}
