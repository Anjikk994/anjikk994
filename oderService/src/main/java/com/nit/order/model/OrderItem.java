package com.nit.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name="ODERIteam_TB")
public class OrderItem {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer Productcode;
public Integer getProductcode() {
	return Productcode;
}
public void setProductcode(Integer productcode) {
	Productcode = productcode;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
@Column(name = "Productname")
private String productname;
@Column(name = "Quantity")
private int Quantity;

}
