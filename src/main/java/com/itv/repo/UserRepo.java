package com.itv.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.itv.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	UserDetails findByUsername(String username);

}
