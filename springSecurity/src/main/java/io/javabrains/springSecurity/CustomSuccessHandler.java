package io.javabrains.springSecurity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String targetUrl=determineTragetUrl(authentication);
		if(response.isCommitted())
		{
			return;
		}
		RedirectStrategy redirect=new DefaultRedirectStrategy();
		redirect.sendRedirect(request, response, targetUrl);
	}
	
	protected String determineTragetUrl(Authentication authentication)
	{
		String url="/login?error=true";
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		List<String> roles=new ArrayList<String>();
		for(GrantedAuthority a:authorities)
		{
			roles.add(a.getAuthority());
		}
		if(roles.contains("ADMIN_ROLE"))
		{
			url="/admin";
		}
		else if(roles.contains("STUDENT_ROLE"))
		{
			url="/student";
		}
		return url;
	}

}
