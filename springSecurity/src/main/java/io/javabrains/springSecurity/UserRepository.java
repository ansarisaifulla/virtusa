package io.javabrains.springSecurity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<user, Long>{
	user findByUsername(String username);

//	void save(user u, List<role> asList);

}
