package pl.mountainrinji.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import pl.mountainrinji.spring.security.RestAccessDeniedHandler;
import pl.mountainrinji.spring.security.RestAuthenticationFailureHandler;
import pl.mountainrinji.spring.security.RestAuthenticationSuccessHandler;
import pl.mountainrinji.spring.security.RestUnauthorizedEntryPoint;
import pl.mountainrinji.spring.security.UserDetailsService;

@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = {"pl.mountainrinji"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

// public static final String REMEMBER_ME_KEY = "rememberme_key";
//
 @Autowired
 private RestUnauthorizedEntryPoint restAuthenticationEntryPoint;
// 
@Autowired
private UserDetailsService userDetailsService;
// 
 @Autowired
 private RestAccessDeniedHandler restAccessDeniedHandler;
// 
 @Autowired
 private RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;
// 
 @Autowired
 private RestAuthenticationFailureHandler restAuthenticationFailureHandler;
//
// // Autowire other required beans 
//
   @Autowired
 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
  auth.userDetailsService(userDetailsService);
 }
//
// @Override
// public void configure(WebSecurity web) throws Exception {
//  web.ignoring().antMatchers("/login.html");
// }
	
	public class Role implements GrantedAuthority {

	public String getAuthority() {
		// TODO Auto-generated method stub
		return "USER";
	}
		
	}
	
	/*@Override
	@Bean
		public org.springframework.security.core.userdetails.UserDetailsService userDetailsServiceBean() throws Exception {
		List<UserDetails> users = new ArrayList<UserDetails>();
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new Role());
	    users.add(new User("test", "test", roles)) ;
	    return new InMemoryUserDetailsManager(users);
		}*/

	
	@Override
	 public void configure(WebSecurity web) throws Exception {
	  web.ignoring().antMatchers("/content/index.html", "/rest/**");
	 }
 @Override
 protected void configure(HttpSecurity http) throws Exception {
//	 http
//		.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin()
//			.and()
//		.httpBasic();
	 
	 http.authorizeRequests()
	 ///.*foo\.htm\?parameter=value1.*
	 	.regexMatchers(".*SP-DTQ.*").access("hasRole('SP_DTQ')")
	 	.regexMatchers(".*PH-USA.*").access("hasRole('PH_USA')")
	 	.regexMatchers(".*SP-FYZ.*").access("hasRole('SP_FYZ')")
	 	.regexMatchers(".*SP-FRA.*").access("hasRole('SP_FRA')")
	 	.and()
	 	.formLogin()
	 	.and()
	 	.httpBasic();
 }
}