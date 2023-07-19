package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.ReportDTO;
import com.devsuperior.dsmeta.dto.SummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.devsuperior.dsmeta.dto.ReportDTO(obj.id, obj.date, SUM(obj.amount), obj.seller.name) " +
			"FROM Sale obj " +
			"WHERE obj.date BETWEEN :startDate AND :endDate " +
			"AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%')) " +
			"GROUP BY obj.id, obj.seller.name " +
			"ORDER BY obj.id"
			)
	Page<ReportDTO> report(LocalDate startDate, LocalDate endDate, String name, Pageable pageable);
	
	 @Query("SELECT new com.devsuperior.dsmeta.dto.SummaryDTO(SUM (obj.amount), obj.seller.name) " +
	            "FROM Sale obj " +
	            "WHERE obj.date BETWEEN :initialDate AND :finalDate " +
	            "GROUP BY obj.seller.name " +
	            "ORDER BY obj.seller.name "
	    )
		List<SummaryDTO> summary(LocalDate initialDate, LocalDate finalDate);
}
