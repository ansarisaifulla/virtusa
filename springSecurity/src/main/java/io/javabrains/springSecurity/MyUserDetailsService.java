package io.javabrains.springSecurity;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;


@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		user u=repo.findByUsername(username);
		if(u==null)
		{
			throw new UsernameNotFoundException("user 404");
		}
		return new MyUserDetails(u);
	}
	public void saveUser(user u,String option) {
		// TODO Auto-generated method stub  Set<role> roles
		repo.save(new user(u.getUsername(),
				u.getPassword(),
				u.getName(),
				u.getCpassword(),
				u.getMobile(),
				Arrays.asList(new role(option))));
//		repo.sav
		
	}
	public boolean isUserAlreadyPresent(user u) {
		 boolean isUserAlreadyExists = false;
		 user existingUser = repo.findByUsername(u.getUsername());
		 // If user is found in database, then then user already exists.
		 if(existingUser != null){
		 isUserAlreadyExists = true; 
		 }
		 return isUserAlreadyExists;
		}
	public user findUser(String id)
	{
		return repo.findByUsername(id);
	}

}
