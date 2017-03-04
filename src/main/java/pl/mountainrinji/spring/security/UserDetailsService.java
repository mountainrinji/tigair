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

	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
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
				return "test";
			}
			
			public String getPassword() {
				// TODO Auto-generated method stub
				return "test";
			}
			
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return new ArrayList<GrantedAuthority>();
			}
		};
	}

}
