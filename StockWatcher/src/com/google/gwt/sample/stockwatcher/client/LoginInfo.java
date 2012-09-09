package com.google.gwt.sample.stockwatcher.client;

import java.io.Serializable;

public class LoginInfo implements Serializable {

	/**
	 * auto generated 
	 */
	private static final long serialVersionUID = 321021730114714718L;

	private boolean loggedIn = false;
	private String loginUrl;
	private String logoutUrl;
	private String emailAddress;
	private String nickname;
	
	public boolean isLoggedIn(){
		return loggedIn;
	}
	
	public void setLoggedIn(boolean loggedIn){
		this.loggedIn = loggedIn;
	}
	
	public String getLoginUrl(){
		return loginUrl;
	}
	
	public void setLoginUrl(String loginUrl){
		this.loginUrl = loginUrl;
	}
	
	public void setLogoutUrl(String logoutUrl){
		this.logoutUrl = logoutUrl;
	}
	
	public String getLogoutUrl(){
		return logoutUrl;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
