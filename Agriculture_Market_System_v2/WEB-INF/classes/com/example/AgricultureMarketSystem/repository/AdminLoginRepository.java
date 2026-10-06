package com.example.AgricultureMarketSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AgricultureMarketSystem.domain.AdminLogin;


@Repository
public interface AdminLoginRepository extends JpaRepository<AdminLogin, Long>{
	AdminLogin findByUsernameAndPassword(String username, String password);
 
}