package com.rbu.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id @GeneratedValue
	@Column(name = "ord_no")
	private int ordNo;
	@Column(name = "ord_date")
	private LocalDate ordDate;
	private double amount;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cid")
	private Customer cust;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "item_order", joinColumns = {@JoinColumn(name="ord_no")}, 
		inverseJoinColumns = {@JoinColumn(name="code")})
	private List<Product> items = new ArrayList<Product>();

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

	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public List<Product> getItems() {
		return items;
	}
	public void setItems(List<Product> items) {
		this.items = items;
	}
}
