package com.axis.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.Admin1;
@Repository
public interface AdminRepository extends JpaRepository<Admin1,Long> {
	public Admin1 findByUsername(String username);
	//UserDetails findUserDetailsByUsername(String username);
	public Admin1 findByUsernameAndPassword(String username,String password);
}
