
package com.binbol.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.binbol.dto.UserAccountDto;
import com.binbol.services.UserAccountService;
import com.binbol.services.cache.TokenCache;
import com.binbol.util.JwtUtilService;

public class JwtAuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	JwtUtilService jwtUtilService;

	@Autowired
	private TokenCache tokenCache;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader(JwtUtilService.TOKEN_HEADER);
		List<GrantedAuthority> role_name = new ArrayList<>();
		UserDetails userDetail;
		if ((authToken != null && !authToken.isEmpty())) {
			if (tokenCache.get(authToken) != null && jwtUtilService.validateTokenLogin(authToken)) {
				if (jwtUtilService.validateTokenLogin(authToken)) {
					String username = jwtUtilService.getUsernameFromToken(authToken);
					UserAccountDto user = userAccountService.getUserByUsername(username);
					if (user != null) {
						boolean enabled = true;
						boolean accountNonExpired = true;
						boolean credentialsNonExpired = true;
						boolean accountNonLocked = true;
						userDetail = new User(username, user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, role_name);
						UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
						authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
						SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}
			}
		}

		chain.doFilter(request, response);
	}
}