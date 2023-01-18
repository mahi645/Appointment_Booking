package com.axis.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.UserDetails;
@Repository
public interface UserRepository extends JpaRepository<UserDetails,Long> {
	public UserDetails findByUsername(String username);
	//UserDetails findUserDetailsByUsername(String username);
	public UserDetails findByUsernameAndPassword(String username,String password);
}
