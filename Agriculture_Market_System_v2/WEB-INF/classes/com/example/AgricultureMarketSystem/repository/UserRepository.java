package com.example.AgricultureMarketSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AgricultureMarketSystem.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


	@Query(value= "select * from user WHERE user_type='Merchant'", nativeQuery = true)
	public List<User> findMerchant();
	
	@Query(value= "select * from user WHERE user_type='Farmer'", nativeQuery = true)
	public List<User> findFarmers();
	
	
}