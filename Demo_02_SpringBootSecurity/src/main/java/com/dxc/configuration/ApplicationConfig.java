package com.dxc.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class ApplicationConfig extends WebSecurityConfigurerAdapter {

	//@Bean
	//@Override
	//protected UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		//List<UserDetails> users = new ArrayList<>();
		//users.add(User.withDefaultPasswordEncoder().username("karthik").roles("USER").build());
		//return super.userDetailsService();
	//}

//	@Autowired
//	 private UserDetailsService userDetailsService;
//	@Bean
//	public AuthenticationProvider authProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//		
//	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable()
		           .authorizeRequests().antMatchers("/login").permitAll();
//		           .and()
//		           .formLogin().loginPage("/login").permitAll()
//		           .and()
//		           .logout().invalidateHttpSession(true)
//		           .clearAuthentication(true)
//		           .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		           .logoutSuccessUrl("/logout-success").permitAll();
		super.configure(http);
	}
	
	
}
