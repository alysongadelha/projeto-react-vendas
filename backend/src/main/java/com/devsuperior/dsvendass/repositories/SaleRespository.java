package com.devsuperior.dsvendass.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendass.dto.SaleSuccessDTO;
import com.devsuperior.dsvendass.dto.SaleSumDTO;
import com.devsuperior.dsvendass.entities.Sale;

public interface SaleRespository extends JpaRepository <Sale, Long> {
	
	@Query("SELECT new com.devsuperior.dsvendass.dto.SaleSumDTO(obj.seller, SUM(obj.amount))  "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.devsuperior.dsvendass.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))  "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

} 
