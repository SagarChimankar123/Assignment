package com.infy.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Entity.CustomerTransection;
import com.infy.Repository.CustomerTransectionRepo;
import com.infy.exception.IdNotFound;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerTransectionImpl implements CustomerTran {
	
	@Autowired
	CustomerTransectionRepo custTransRepo;

	@Override
	public String upsertTransection(CustomerTransection custTran) {
		log.info("upsertTransection method called from CustomerTransectionImpl class");
		
		CustomerTransection cust=custTran;
		if(cust.getTranId()==null) {
			custTransRepo.save(custTran);
			return "Save Transection";
		}
		
		
		
		custTransRepo.save(custTran);
		return "Update Transection";
	}

	@Override
	public CustomerTransection getDatabyId(Integer TranId) {
		log.info("getDatabyId method called from CustomerTransectionImpl class");
		
		Optional<CustomerTransection> trans = custTransRepo.findById(TranId);
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
	public List<CustomerTransection> getLastRecord() {
		log.info("getLastRecord method called from CustomerTransectionImpl class");
		
		
		LocalDateTime threeMonthAgo = LocalDateTime.now().minusMonths(3);
		LocalDate date=threeMonthAgo.toLocalDate();
		List<CustomerTransection> lastThreeMonthData = custTransRepo.getLastThreeMonthData(date);
		return lastThreeMonthData;
	}
	

	
	
	
}
