package com.accenture.lkm.service;

import java.util.List;
import java.util.Map;

import com.accenture.lkm.businessbean.PizzaOrderBean;

public interface PizzaService {
	
	List<PizzaOrderBean> getOrderDetails(Double fromBill,Double toBill);
	PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean);
	Map<Integer, String> findAllPizzaDetails();

}
