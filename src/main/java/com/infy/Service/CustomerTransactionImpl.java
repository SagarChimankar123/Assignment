package com.infy.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Entity.CustomerTransaction;
import com.infy.Repository.CustomerTransactionRepo;
import com.infy.exception.IdNotFound;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerTransactionImpl implements CustomerTran {
	
	@Autowired
	CustomerTransactionRepo custTransRepo;

	@Override
	public String upsertTransection(CustomerTransaction custTran) {
		log.info("upsertTransection method called from CustomerTransectionImpl class");
		
		CustomerTransaction cust=custTran;
		if(cust.getTranId()==null) {
			custTransRepo.save(custTran);
			return "Save Transection";
		}
		
		
		
		custTransRepo.save(custTran);
		return "Update Transection";
	}

	@Override
	public CustomerTransaction getDatabyId(Integer TranId) {
		log.info("getDatabyId method called from CustomerTransectionImpl class");
		
		Optional<CustomerTransaction> trans = custTransRepo.findById(TranId);
		if(trans.isEmpty()) {
			throw new IdNotFound();
		}
		return trans.get();
	}

	@Override
	public String deleteTransection(Integer tranid) {
		log.info("deleteTransection method called from CustomerTransectionImpl class");
		
		
		if(custTransRepo.existsById(tranid)) {
			custTransRepo.deleteById(tranid);
			return "Delete Sucessfully";
		}else {
			throw new IdNotFound();
		}
		
		
	}

	@Override
	public List<CustomerTransaction> getLastRecord() {
		log.info("getLastRecord method called from CustomerTransectionImpl class");
		
		
		LocalDateTime threeMonthAgo = LocalDateTime.now().minusMonths(3);
		LocalDate date=threeMonthAgo.toLocalDate();
		List<CustomerTransaction> lastThreeMonthData = custTransRepo.getLastThreeMonthData(date);
		return lastThreeMonthData;
	}
	

	
	
	
}
