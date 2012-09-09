package com.google.gwt.sample.stockwatcher.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
//note that RemoteService is an interface, not a class, cannot extend an interface, only a class
public interface LoginService extends RemoteService {
	
	public LoginInfo login(String requestUri);
}
