package com.nit.order.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ODER_TB")
public class Order {
@Id
private String  CustomerName;

private Date orderDate;
private String  Shippingadder;
@OneToMany(targetEntity =OrderItem.class ,cascade = CascadeType.ALL )
@JoinColumn(name="cp_hp",referencedColumnName ="CustomerName" )
private List<OrderItem> orderItem;
private double Total;

}
