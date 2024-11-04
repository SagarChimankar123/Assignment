package com.infy.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infy.Entity.CustomerTransaction;

@Repository
public interface CustomerTransactionRepo extends JpaRepository<CustomerTransaction, Integer> {
	
	@Query("SELECT t FROM CustomerTransaction t WHERE t.tranDate >= :startDate")
	List<CustomerTransaction> getLastThreeMonthData(@Param("startDate") LocalDate startDate);
	
	public List<CustomerTransaction> findByCustId(Integer custId);
}
