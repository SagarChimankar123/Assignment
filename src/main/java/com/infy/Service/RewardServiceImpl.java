package com.infy.Service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Entity.CustomerTransection;
import com.infy.Entity.RewardPoint;
import com.infy.Repository.CustomerTransectionRepo;
import com.infy.Repository.rewardPointRepo;
import com.infy.exception.IdNotFound;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RewardServiceImpl implements RewardPointService {
	
	@Autowired
	CustomerTransectionRepo custTransection;
	
	@Autowired
	rewardPointRepo rewardPoint;
	
	@Override
	public String addData(Integer id) {
		log.info("addData method called from RewardServiceImpl class");
		
		RewardPoint reward=new RewardPoint();
		
		Optional<CustomerTransection> findById = custTransection.findById(id);
		if(findById.isEmpty()) {
			throw new IdNotFound("id not found"); 
		}
		CustomerTransection customer=findById.get();
		System.out.println(customer);
		
		
		reward.setCustId(id);
		reward.setPoint(calculatePoint(customer.getTranAmount()));
		reward.setMonth(customer.getTranDate().getMonthValue());
		reward.setYear(customer.getTranDate().getYear());
		
		
		rewardPoint.save(reward);
		return "save Data";
	}

	public Integer calculatePoint(Integer amount) {
		log.info("calculatePoint method called from RewardServiceImpl class");
		
		Integer point=0;
		if(amount>100) {
			point=point+(amount-100)*2;
			point=point+50;
		}else if(amount>50) {
			point=point+(amount-50);
		}
		return point;
	}

}
