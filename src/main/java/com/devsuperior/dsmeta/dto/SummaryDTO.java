package com.devsuperior.dsmeta.dto;

public class SummaryDTO {

	private String sellerName;
	private Double total;

	public SummaryDTO(Double total, String sellerName) {
		this.sellerName = sellerName;
		this.total = total;
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
