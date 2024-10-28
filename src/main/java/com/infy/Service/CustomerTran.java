package com.infy.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.infy.Entity.CustomerTransection;

@Service
public interface CustomerTran {
	
	//used to update and save Transection(pass tran_id pass mince update not pass save) 
	public String upsertTransection(CustomerTransection custTran);
	
	//Get Transection by tran_id
	public CustomerTransection getDatabyId(Integer TranId);
	
	//Delete Transection by tran_id
	public String deleteTransection(Integer tranid);
	
	//get last three month transection
	public List<CustomerTransection> getLastRecord();
}