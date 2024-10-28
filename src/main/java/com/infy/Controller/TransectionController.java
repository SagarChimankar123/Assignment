package com.infy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Entity.CustomerTransection;
import com.infy.Service.CustomerTransectionImpl;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/transection")
public class TransectionController {
	
	@Autowired
	CustomerTransectionImpl custTran;
	
	
	@Tag(name="add data in CustomerTransection")
	@PostMapping(value="/add" , 
			consumes = {"application/json","application/xml"},
			produces = {"application/xml","application/json"})
	public ResponseEntity<String> addTransection(@RequestBody CustomerTransection custTransection){
		log.info("addTransection API call from TransectionController class");
		
		String massage = custTran.upsertTransection(custTransection);
		return new ResponseEntity<>(massage,HttpStatus.OK);
	}
	
	@Tag(name="get data by id in CustomerTransection")
	@GetMapping("/get/{id}")
	public ResponseEntity<CustomerTransection> getTransection(@PathVariable("id") Integer tranId) {
		log.info("getTransection API call from TransectionController class");
		
		CustomerTransection tran = custTran.getDatabyId(tranId);
		return new ResponseEntity<>(tran,HttpStatus.OK);
	}
	
	@Tag(name="delete data using id in CustomerTransection")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTransection(@PathVariable("id") Integer tranId) {
		log.info("deleteTransection API call from TransectionController class");
		
		String massage = custTran.deleteTransection(tranId);
		return new ResponseEntity<>(massage,HttpStatus.OK);
	}
	
	@Tag(name="update data in CustomerTransection")
	@PutMapping("/update")
	public ResponseEntity<String> UpdateTransection(@RequestBody CustomerTransection tran) {
		log.info("UpdateTransection API call from TransectionController class");
		
		String addTransection = custTran.upsertTransection(tran);
		return new ResponseEntity<>(addTransection,HttpStatus.OK);
	}
	
	@Tag(name="Last three months transection from current date")
	@GetMapping("/lastRecord")
	public ResponseEntity<List<CustomerTransection>> gatLastRecord() {
		log.info("gatLastRecord API call from TransectionController class");
		
		List<CustomerTransection> lastRecord = custTran.getLastRecord();
		return new ResponseEntity<>(lastRecord,HttpStatus.OK);
	}
	
	
}
