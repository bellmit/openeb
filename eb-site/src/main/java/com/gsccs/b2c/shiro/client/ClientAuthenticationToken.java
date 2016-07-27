package com.gsccs.b2c.shiro.client;

import org.apache.shiro.authc.AuthenticationToken;


public interface ClientAuthenticationToken extends AuthenticationToken {

	String getSite();
}
