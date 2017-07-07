package com.spring.login;
import java.util.List;
import com.spring.login.domain.Community;
import com.spring.login.domain.Country;
import com.spring.login.domain.User;
public interface UserService {
	public void add(User login);
	public List<Country> getAllCountries();
	public List<Community> getAllCommunities(); 
}
