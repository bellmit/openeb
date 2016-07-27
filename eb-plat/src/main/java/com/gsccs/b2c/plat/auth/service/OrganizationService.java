package com.gsccs.b2c.plat.auth.service;

import java.util.List;

import com.gsccs.b2c.plat.auth.model.Organization;

/**
 * <p>
 * User: x.d zhang
 * <p>
 * Date: 14-1-28
 * <p>
 * Version: 1.0
 */
public interface OrganizationService {

	public Organization createOrganization(Organization organization);

	public Organization updateOrganization(Organization organization);

	public void deleteOrganization(Long organizationId);

	Organization findOne(Long organizationId);

	List<Organization> findAll();
	
	List<Organization> find(Organization param);

	Object findAllWithExclude(Organization excludeOraganization);

	void move(Organization source, Organization target);

	public String getOrgTreeToJson();

}
