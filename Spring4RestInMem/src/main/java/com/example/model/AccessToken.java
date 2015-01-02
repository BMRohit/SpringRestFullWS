/**
 * 
 */
package com.example.model;

import java.util.Date;

/**
 * @author rohithbm
 * 
 */
public class AccessToken {

	private String accessToken;
	private Date issuedDate;
	private Date expiresOn;
	private long expiresIn;
	private String tokenType;
	private String userName;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getExpiresOn() {
		return expiresOn;
	}

	public void setExpiresOn(Date expiresOn) {
		this.expiresOn = expiresOn;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "AccessToken [accessToken=" + accessToken + ", issuedDate="
				+ issuedDate + ", expiresOn=" + expiresOn + ", expiresIn="
				+ expiresIn + ", tokenType=" + tokenType + ", userName="
				+ userName + "]";
	}
}
