package com.devsuperior.dsvendass.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendass.dto.SellerDTO;
import com.devsuperior.dsvendass.entities.Seller;
import com.devsuperior.dsvendass.repositories.SellerRespository;

@Service
public class SellerService {

	@Autowired
	private SellerRespository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
	
	
	
}
