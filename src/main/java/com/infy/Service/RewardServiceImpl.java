package com.infy.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Entity.CustomerTransaction;
import com.infy.Entity.RewardPoint;
import com.infy.Repository.CustomerTransactionRepo;
import com.infy.Repository.rewardPointRepo;
import com.infy.exception.IdNotFound;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RewardServiceImpl implements RewardPointService {
	
	@Autowired
	CustomerTransactionRepo custTransection;
	
	@Autowired
	rewardPointRepo rewardPoint;
	
	@Override
	public String addData(Integer id) {
		log.info("addData method called from RewardServiceImpl class");
		
		//RewardPoint reward=new RewardPoint();
		
		List<CustomerTransaction> findByCustId = custTransection.findByCustId(id);
		if(findByCustId.isEmpty()) {
			throw new IdNotFound("id not found"); 
		}
		for(CustomerTransaction customer:findByCustId) {
			RewardPoint reward=new RewardPoint();
			reward.setCustId(customer.getCustId());
			reward.setMonth(customer.getTranDate().getMonthValue());
			reward.setYear(customer.getTranDate().getYear());
			reward.setPoint(calculatePoint(customer.getTranAmount()));
			
			rewardPoint.save(reward);
			
			reward=null;
			
		}

		return "save Data";
	}
	
//	@Override
//	public String addData(Integer id) {
//		RewardPoint reward=new RewardPoint();
//		Optional<CustomerTransection> findById = custTransection.findById(id);
//		
//		
//		
//		
//		return "save Data";
//	}

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

	
	@Override
	public LinkedHashMap<String, Integer> getmonthlyrewardPoint(Integer id) {
		List<RewardPoint> findByCustId = rewardPoint.findByCustId(id);
		LinkedHashMap<String,Integer> hashmap=new LinkedHashMap();
		
		Integer totalpoint=0;
		
		for(RewardPoint reward:findByCustId) {
			totalpoint=totalpoint+reward.getPoint();
			hashmap.put(getMonth(reward.getMonth()),reward.getPoint() );
		}
		System.out.println(findByCustId);
		hashmap.put("Total_reward_point", totalpoint);
		return hashmap;
	}
	
//	Integer calculateTotalPoint(Integer point) {
//		Integer totalpoint=0;
//		
//	}
	
	public static String getMonth(int id) {
        String month;
        switch (id) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                month = "Invalid month";
                break;
        }
        return month;
    }

}
