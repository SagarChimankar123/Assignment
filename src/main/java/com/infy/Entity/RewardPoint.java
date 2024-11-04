package com.infy.Entity;

import java.time.Month;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="RewardPoint")
public class RewardPoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rewareId;
	private Integer custId;
	private Integer month;
	private Integer year;
	private Integer point;
	
	public Integer getRewareId() {
		return rewareId;
	}
	public void setRewareId(Integer rewareId) {
		this.rewareId = rewareId;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	
	public RewardPoint(Integer rewareId, Integer custId, Integer month, Integer year, Integer point) {
		super();
		this.rewareId = rewareId;
		this.custId = custId;
		this.month = month;
		this.year = year;
		this.point = point;
	}
	
	
	public RewardPoint() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RewardPoint [rewareId=" + rewareId + ", custId=" + custId + ", month=" + month + ", year=" + year
				+ ", point=" + point + "]";
	}
	
		
}
