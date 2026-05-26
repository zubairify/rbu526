package com.rbu.vo;

import java.time.LocalDate;

import com.rbu.entity.Order;

public class OrderVO {
	private int ordNo;
	private LocalDate ordDate;
	private double amount;
	
	private CustomerVO customer;
	private ProductVO item;
	
	// Getters & Setters
	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	public LocalDate getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(LocalDate ordDate) {
		this.ordDate = ordDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public CustomerVO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}
	public ProductVO getItem() {
		return item;
	}
	public void setItem(ProductVO item) {
		this.item = item;
	}
	
	public static final OrderVO transform(Order order) {
		OrderVO vo = new OrderVO();
		vo.setOrdNo(order.getOrdNo());
		vo.setOrdDate(order.getOrdDate());
		vo.setAmount(order.getAmount());
		return vo;
	}
}



