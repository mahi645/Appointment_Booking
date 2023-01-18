package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

}
