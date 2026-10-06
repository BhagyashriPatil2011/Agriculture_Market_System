package com.example.AgricultureMarketSystem.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AgricultureMarketSystem.domain.Crop;
import com.example.AgricultureMarketSystem.repository.CropRepository;



@Service
public class CropService {
	
	@Autowired
   private CropRepository repo;
	
	public List<Crop> listAll() {
       return repo.findAll();
   }
    
   public void save(Crop std) {
       repo.save(std);
   }
    
   public Crop get(int id) {
       return repo.findById(id).get();
   }
    
   public void delete(int id) {
       repo.deleteById(id);
   }

}