package com.infy.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="CustomerTransection")
public class CustomerTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	private Integer tranId;
	private Integer custId;
	
	@Min(value=50,message = "transection amount should be grater than 50")
	private Integer tranAmount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate tranDate;
	
	
	public Integer getTranId() {
		return tranId;
	}
	public void setTranId(Integer tranId) {
		this.tranId = tranId;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Integer getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(Integer tranAmount) {
		this.tranAmount = tranAmount;
	}
	public LocalDate getTranDate() {
		return tranDate;
	}
	public void setTranDate(LocalDate tranDate) {
		this.tranDate = tranDate;
	}
	public CustomerTransaction(Integer tranId, Integer custId, Integer tranAmount, LocalDate tranDate) {
		super();
		this.tranId = tranId;
		this.custId = custId;
		this.tranAmount = tranAmount;
		this.tranDate = tranDate;
	}
	
	
	
	public CustomerTransaction() {
		
	}
	
	@Override
	public String toString() {
		return "CustomerTransection [tranId=" + tranId + ", custId=" + custId + ", tranAmount=" + tranAmount
				+ ", tranDate=" + tranDate + "]";
	}
	
	
	
	
}
