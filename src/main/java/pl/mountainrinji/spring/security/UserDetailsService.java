package pl.mountainrinji.spring.security;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("userDetailsService")
public class UserDetailsService
		implements org.springframework.security.core.userdetails.UserDetailsService {

	
	public class ROLE_PH_USA implements GrantedAuthority {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public String getAuthority() {
			// TODO Auto-generated method stub
			return "ROLE_PH_USA";
		}
			
	}
	
	public class ROLE_SP_DTQ implements GrantedAuthority {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public String getAuthority() {
			// TODO Auto-generated method stub
			return "ROLE_SP_DTQ";
		}
			
	}
	
	public class ROLE_SP_FYZ implements GrantedAuthority {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public String getAuthority() {
			// TODO Auto-generated method stub
			return "ROLE_SP_FYZ";
		}
			
	}
	
	public class ROLE_SP_FRA implements GrantedAuthority {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public String getAuthority() {
			// TODO Auto-generated method stub
			return "ROLE_SP_FRA";
		}
			
	}
	
	public class ROLE_SP_KRM implements GrantedAuthority {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public String getAuthority() {
			// TODO Auto-generated method stub
			return "ROLE_SP_KRM";
		}
			
	}
	
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		final String username = arg0;
		return new UserDetails() {
			
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}
			
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			public String getUsername() {
				// TODO Auto-generated method stub
				return username;
			}
			
			public String getPassword() {
				// TODO Auto-generated method stub
				return "test";
			}
			
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
				if (username.equals("usa")) {
					roles.add(new ROLE_PH_USA());
				} else if (username.equals("fyz")) {
					roles.add(new ROLE_SP_FYZ());
				} else if (username.equals("fra")) {
					roles.add(new ROLE_SP_FRA());
				} else if (username.equals("krm")) {
					roles.add(new ROLE_SP_KRM());
				}else {
					roles.add(new ROLE_SP_DTQ());
				}
				return roles;
			}
		};
	}

}
