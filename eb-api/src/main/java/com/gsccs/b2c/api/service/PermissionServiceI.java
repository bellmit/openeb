package com.gsccs.b2c.api.service;

import com.gsccs.b2c.api.domain.PermissionContext;

/**
 * <p>User: x.d zhang
 * <p>Date: 14-3-13
 * <p>Version: 1.0
 */
public interface PermissionServiceI {

  /*  public Session getSession(String appKey, Serializable sessionId);
    Serializable createSession(Session session);
    public void updateSession(String appKey, Session session);
    public void deleteSession(String appKey, Session session);
    public PermissionContext getPermissions(String appKey, String username);*/
    
	public String getSession(String appKey, String sessionId);
	public String createSession(String appKey, String sessionId,String session);
	public void updateSession(String appKey, String id,String session);
	public void deleteSession(String appKey, String id);
	public PermissionContext getPermissions(String appKey, String username);
	
}
