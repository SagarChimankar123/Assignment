package com.infy.Service;

import org.springframework.stereotype.Service;

import com.infy.Controller.RewardTransection;

@Service
public interface RewardPointService {
	
	//add data in RewardPoint table with calculate point 
	public String addData(Integer id);
	
	
}
