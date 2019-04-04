/**
 * 
 */
package com.binbol.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
 
/**
 * @author Vincent
 *
 */
@Component
public class ComonProperties {
	
	
	@Value("${security.oauth2-endpoint}")
	private String oauthEndpoint;
	
	@Value("${security.jwt.client-id}")
	private String clientId;
	
	@Value("${security.jwt.client-secret}")
	private String clientSecret;

	public String getOauthEndpoint() {
		return oauthEndpoint;
	}

	public void setOauthEndpoint(String oauthEndpoint) {
		this.oauthEndpoint = oauthEndpoint;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
}