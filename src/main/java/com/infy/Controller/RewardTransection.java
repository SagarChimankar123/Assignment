package com.infy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Entity.RewardPoint;
import com.infy.Service.RewardServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/point")
public class RewardTransection {
	
	
	@Autowired
	RewardServiceImpl rewardService;
	
	@Tag(name="save data in rewardPoint table using id")
	@PostMapping("/calculatePoint/{id}")
	public ResponseEntity<String> addData(@PathVariable ("id") Integer custId ){
		log.info("AddData API call from RewardTransection");
		
		String massage = rewardService.addData(custId);
		return new ResponseEntity<>(massage,HttpStatus.OK);
	}
	

}
