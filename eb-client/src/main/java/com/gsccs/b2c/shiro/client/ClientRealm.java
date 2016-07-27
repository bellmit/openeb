package com.gsccs.b2c.shiro.client;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.gsccs.b2c.api.domain.PermissionContext;
import com.gsccs.b2c.api.service.PermissionServiceI;

/**
 * <p>
 * User: x.d zhang
 * <p>
 * Date: 15-3-13
 * <p>
 * Version: 1.0
 */
public class ClientRealm extends AuthorizingRealm {
	
	private PermissionServiceI permissionAPI;
	
	private String appKey;

	
	public PermissionServiceI getPermissionAPI() {
		return permissionAPI;
	}

	public void setPermissionAPI(PermissionServiceI permissionAPI) {
		this.permissionAPI = permissionAPI;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		PermissionContext context = permissionAPI.getPermissions(appKey,
				username);
		authorizationInfo.setRoles(context.getRoles());
		authorizationInfo.setStringPermissions(context.getPermissions());
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// 永远不会被调用
		throw new UnsupportedOperationException("永远不会被调用");
	}
}
