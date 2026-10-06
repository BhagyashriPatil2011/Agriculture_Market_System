package com.example.AgricultureMarketSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.AgricultureMarketSystem.domain.Crop;
import com.example.AgricultureMarketSystem.domain.Merchant;



@Repository
@Transactional
public interface CropRepository extends JpaRepository<Crop, Integer> {

	@Query(value= "select * from crop WHERE merchant_id = :id", nativeQuery = true)
	public List<Crop> getByUser(@Param("id")int id);
	
	@Query(value= "select * from crop WHERE crop_name= :crop_name", nativeQuery = true)
	public List<Crop> getByCrop(@Param("crop_name")String crop_name);
	
  
	
}