package com.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.dao.AuthDao;

public class UserLoginService implements UserDetailsService {

	@Autowired
	private AuthDao authdao;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		System.out.println(username);
		try {
			com.bean.User domainUser = authdao.findByUsername(username);
			System.out.println("\n\n\n\n");			
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			boolean isAdmin = false;
			
			if ("ROLE_ADMIN".equals(domainUser.getUserrole())) {				
				isAdmin=true;
			} 
			

			return new User(domainUser.getUsername(), domainUser.getPassword()
					.toLowerCase(), enabled, accountNonExpired,
					credentialsNonExpired, accountNonLocked,
					getAuthorities(isAdmin));

		} catch (Exception e) {
		 e.printStackTrace();
		 throw new RuntimeException();
		}

	}

	private List<GrantedAuthority> getAuthorities(boolean isAdmin) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
		authList.add(new GrantedAuthorityImpl("ROLE_USER"));
		if (isAdmin) {
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		}
		return authList;
	}

	public AuthDao getAuthdao() {
		return authdao;
	}

	public void setAuthdao(AuthDao authdao) {
		this.authdao = authdao;
	}
	
	

}
