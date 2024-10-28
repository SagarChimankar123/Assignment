package com.infy.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infy.Entity.CustomerTransection;

@Repository
public interface CustomerTransectionRepo extends JpaRepository<CustomerTransection, Integer> {
	
	@Query("SELECT t FROM CustomerTransection t WHERE t.tranDate >= :startDate")
	List<CustomerTransection> getLastThreeMonthData(@Param("startDate") LocalDate startDate);
	
}
