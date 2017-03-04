package pl.mountainrinji.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationSuccessHandler 
extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//todo

		SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, new User(1L, "test", "test"));
	}

	public class User {
		
		
		
		public User(Long id, String firstName, String familyName) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.familyName = familyName;
		}
		private Long id;
		private String firstName;
		private String familyName;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getFamilyName() {
			return familyName;
		}
		public void setFamilyName(String familyName) {
			this.familyName = familyName;
		}
		
		
	}
}
