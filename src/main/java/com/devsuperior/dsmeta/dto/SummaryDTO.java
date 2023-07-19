package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SummaryProjection;

public class SummaryDTO {

	private String sellerName;
	private Double total;
	
	public SummaryDTO(Double total, String sellerName) {
		this.total = total;
		this.sellerName = sellerName;
	}
	
	public SummaryDTO(SummaryProjection projection) {
		sellerName = projection.getName();
		total = projection.getTotal();
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	
	
}
