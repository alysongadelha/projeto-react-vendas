package com.devsuperior.dsvendass.dto;

import java.io.Serializable;

import com.devsuperior.dsvendass.entities.Seller;

public class SellerDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long Id;
	private String name;
	
	public SellerDTO() {
		
	}

	public SellerDTO(Long id, String name) {
		this.Id = id;
		this.name = name;
	}

	public SellerDTO(Seller entity) {
		Id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
