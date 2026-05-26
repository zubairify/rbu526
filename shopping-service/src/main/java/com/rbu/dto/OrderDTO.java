package com.rbu.dto;

public class OrderDTO {
	private int cid;
	private int[] pcodes;

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int[] getPcodes() {
		return pcodes;
	}
	public void setPcodes(int[] pcodes) {
		this.pcodes = pcodes;
	}
}
