package com.devsuperior.dsvendass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendass.dto.SaleDTO;
import com.devsuperior.dsvendass.dto.SaleSuccessDTO;
import com.devsuperior.dsvendass.dto.SaleSumDTO;
import com.devsuperior.dsvendass.entities.Sale;
import com.devsuperior.dsvendass.repositories.SaleRespository;
import com.devsuperior.dsvendass.repositories.SellerRespository;

@Service
public class SaleService {

	@Autowired
	private SaleRespository repository;
	
	@Autowired
	private SellerRespository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}	
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
		
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
		
	}
		
}
