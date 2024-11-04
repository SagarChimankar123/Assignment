package com.infy.Service;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

@Service
public interface RewardPointService {
	
	//add data in RewardPoint table with calculate point 
	public String addData(Integer id);
	
	public LinkedHashMap<String,Integer> getmonthlyrewardPoint(Integer id);
	
	
}
