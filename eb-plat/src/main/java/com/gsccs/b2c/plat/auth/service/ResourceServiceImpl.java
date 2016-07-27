package com.gsccs.b2c.plat.auth.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gsccs.b2c.plat.auth.dao.ResourceMapper;
import com.gsccs.b2c.plat.auth.model.Resource;
import com.gsccs.b2c.plat.auth.model.ResourceExample;
import com.gsccs.b2c.plat.auth.model.ResourceExample.Criteria;


@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public Resource createResource(Resource resource) {
		resourceMapper.insert(resource);
		return resourceMapper.selectByPrimaryKey(resource.getId());
	}

	@Override
	public Resource updateResource(Resource resource) {
		resourceMapper.updateByPrimaryKey(resource);
		return resourceMapper.selectByPrimaryKey(resource.getId());
	}

	@Override
	public void deleteResource(Long resourceId) {
		resourceMapper.deleteByPrimaryKey(resourceId);
	}

	@Override
	public Resource findOne(Long resourceId) {
		return resourceMapper.selectByPrimaryKey(resourceId);
	}

	@Override
	public List<Resource> findAll(Resource param) {
		ResourceExample rexample = new ResourceExample();
		Criteria c = rexample.createCriteria();
		/*if (null != param){
			if (null != param.getParentId()){
				c.andParentIdEqualTo(param.getParentId());
			}
		}*/
		return resourceMapper.selectByExample(rexample);
	}
	
	

	@Override
	public Set<String> findPermissions(Set<Long> resourceIds) {
		Set<String> permissions = new HashSet<String>();
		for (Long resourceId : resourceIds) {
			Resource resource = findOne(resourceId);
			if (resource != null
					&& !StringUtils.isEmpty(resource.getPermission())) {
				permissions.add(resource.getPermission());
			}
		}
		return permissions;
	}

	@Override
	public List<Resource> findMenus(Set<String> permissions) {
		List<Resource> allResources = findAll(null);
		List<Resource> menus = new ArrayList<Resource>();
		for (Resource resource : allResources) {
			if (resource.isRootNode()) {
				continue;
			}
			if (resource.getType() != Resource.ResourceType.menu) {
				continue;
			}
			if (!hasPermission(permissions, resource)) {
				continue;
			}
			menus.add(resource);
		}
		return menus;
	}

	private boolean hasPermission(Set<String> permissions, Resource resource) {
		if (StringUtils.isEmpty(resource.getPermission())) {
			return true;
		}
		for (String permission : permissions) {
			WildcardPermission p1 = new WildcardPermission(permission);
			WildcardPermission p2 = new WildcardPermission(
					resource.getPermission());
			if (p1.implies(p2) || p2.implies(p1)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Resource> findMenus(Set<String> permissions, Resource param) {
		List<Resource> allResources = findAll(param);
		List<Resource> menus = new ArrayList<Resource>();
		//menus = findMenus(permissions,allResources,param);
		System.out.println("allResources:"+allResources.size());
		for (Resource resource : allResources) {
			if (resource.isRootNode()) {
				continue;
			}
			if (resource.getType() != Resource.ResourceType.menu) {
				continue;
			}
			if (!hasPermission(permissions, resource)) {
				continue;
			}
			//Resource tempParam = new Resource();
			//tempParam.setParentId(resource.getParentId());
			resource.setSubs(findMenus(permissions,allResources,resource));
			menus.add(resource);
		}
		
		//JSONArray jsonarray = (JSONArray) JSON.toJSON(menus);
		//System.out.println(jsonarray);
		
		return menus;
	}
	
	
	public List<Resource> findMenus(Set<String> permissions,List<Resource> allResources,Resource param) {
		if (null==allResources || allResources.size()<=0){
			return null;
		}
		List<Resource> menus = new ArrayList<Resource>();
		for (Resource resource : allResources) {
			
			if (resource.isRootNode()) {
				continue;
			}
			if (resource.getType() != Resource.ResourceType.menu) {
				continue;
			}
			if (!hasPermission(permissions, resource)) {
				continue;
			}
			
			
			if(null !=resource.getParentId()
					&& resource.getParentId().equals(param.getId())){
				/*List<Resource> submenus = findMenus(permissions,allResources,resource);
				if (null != submenus){
					resource.setSubs(submenus);
				}*/
				menus.add(resource);
			}
		}
		return menus;
	}
}
