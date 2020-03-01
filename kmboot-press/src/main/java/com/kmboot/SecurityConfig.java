package com.kmboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kmboot.system.security.AuthenticationEntryPointImpl;
import com.kmboot.system.security.LogoutSuccessHandlerImpl;

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	AuthenticationEntryPointImpl unauthorizedHandler;
	@Autowired
	LogoutSuccessHandlerImpl logoutSuccessHandler;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				//
				.csrf().disable()
				// exception handler
				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				// use session
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS).and().authorizeRequests()
				// login
				.antMatchers("/login/**", "/captchaImage", "/websocket/**").anonymous()
				//
				.antMatchers(HttpMethod.GET, "/**/*.ico", "/*.html", "/**/*.html", "/**/*.css", "/**/*.js").permitAll()
				//
				.antMatchers("/swagger-ui.html").anonymous().antMatchers("/swagger-resources/**").anonymous()
				.antMatchers("/*/api-docs").anonymous()
				// h2 database
				.antMatchers("/h2-console/**").anonymous()
				// front
				.antMatchers("/blog/**").permitAll().anyRequest().authenticated().and().headers().frameOptions()
				.disable();
		httpSecurity.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}
