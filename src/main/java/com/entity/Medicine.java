package com.entity;
import java.sql.Date;

public class Medicine {
			
	int item_id;
	String item_name;
	String batch_number;
	Date exp_date;
	int quantity;
	String supp_name;
	Date last_updated;
	
	
	public Medicine(int item_id, String item_name, String batch_number, Date exp_date, int quantity, String supp_name,
			Date last_updated) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.batch_number = batch_number;
		this.exp_date = exp_date;
		this.quantity = quantity;
		this.supp_name = supp_name;
		this.last_updated = last_updated;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getBatch_number() {
		return batch_number;
	}
	public void setBatch_number(String batch_number) {
		this.batch_number = batch_number;
	}
	public Date getExp_date() {
		return exp_date;
	}
	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSupp_name() {
		return supp_name;
	}
	public void setSupp_name(String supp_name) {
		this.supp_name = supp_name;
	}
	public Date getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}
	
	
	
}
