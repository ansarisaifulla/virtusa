package io.javabrains.springSecurity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mysql.cj.protocol.AuthenticationProvider;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	private CustomSuccessHandler successhandler;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().
//		http.
		authorizeRequests().
		antMatchers("/home").permitAll().
		antMatchers("/admin").hasAuthority("ADMIN_ROLE").
		antMatchers("/student").hasAuthority("STUDENT_ROLE").
//		antMatchers("/home").hasAnyAuthority("ROLE_STUDENT","ROLE_ADMIN").
//		antMatchers("/registeruser").permitAll().
		anyRequest().
		authenticated().
		and().
		formLogin().
		loginPage("/login").usernameParameter("email").permitAll().successHandler(successhandler).
//		permitAll().
		and().
		logout().invalidateHttpSession(true).
		clearAuthentication(true).
		logoutRequestMatcher(new AntPathRequestMatcher("/logout")).
//		logoutSuccessUrl("/home").
		permitAll();
	}
	
	
//	@Bean
//	public AuthenticationProvider authProvider()
//	{
//		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		return (AuthenticationProvider) provider;
//	}
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		// TODO Auto-generated method stub
//		
//		List<UserDetails> list=new ArrayList<>();
//		list.add(User.withDefaultPasswordEncoder().username("saif").password("1234").roles("USER").build());
//		return new InMemoryUserDetailsManager(list);
//	}
	
	

}
