package com.gsccs.b2c.shiro.client;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.gsccs.b2c.api.domain.Account;
import com.gsccs.b2c.api.domain.PermissionContext;
import com.gsccs.b2c.api.service.PermissionServiceI;
import com.gsccs.b2c.api.service.SellerServiceI;
import com.gsccs.eb.api.exception.ApiException;

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
	
	private SellerServiceI sellerAPI;

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
	
	

	public SellerServiceI getSellerAPI() {
		return sellerAPI;
	}

	public void setSellerAPI(SellerServiceI sellerAPI) {
		this.sellerAPI = sellerAPI;
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
		String username = (String) token.getPrincipal();
		SimpleAuthenticationInfo authenticationInfo = null;

		Account user=null ;
		try {
			user = sellerAPI.getSeller(username);
			if (user == null) {
				throw new UnknownAccountException();// 没找到帐号
			}

			if (Boolean.TRUE.equals(user.getLocked())) {
				throw new LockedAccountException(); // 帐号锁定
			}
			user.setSalt(user.getAccount()+user.getSalt());
			
			authenticationInfo = new SimpleAuthenticationInfo(
					user.getAccount(), // 用户名
					user.getPassword(), // 密码
					ByteSource.Util.bytes(user.getSalt()),// salt=username+salt
					getName() // realm name
			);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return authenticationInfo;
	}
}
