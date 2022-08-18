package com.accenture.lkm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.businessbean.PizzaBean;
import com.accenture.lkm.businessbean.PizzaOrderBean;
import com.accenture.lkm.dao.PizzaDAOWrapper;

@Service
public class PizzaServiceImpl implements PizzaService{
	
	@Autowired
	private PizzaDAOWrapper dao;

	@Override
	public List<PizzaOrderBean> getOrderDetails(Double fromBill, Double toBill) {
		List<PizzaOrderBean> orderBeans = dao.getOrderDetails(fromBill, toBill);
		if(orderBeans.isEmpty())
			throw new RuntimeException("No Order found in given bill range");
		return orderBeans;
	}

	@Override
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) {
		Double pizzaPrice=dao.getPizzaPrice(pizzaOrderBean.getPizzaId());
		pizzaOrderBean.setBill(pizzaOrderBean.getNumberOfPiecesOrdered()*pizzaPrice);
		return dao.addPizzaOrderDetails(pizzaOrderBean);
	}

	@Override
	public Map<Integer, String> findAllPizzaDetails() {
		List<PizzaBean> pizzaBeans = dao.findAllPizzaDetails();
		Map<Integer, String> map=new HashMap<Integer, String>();
		pizzaBeans.forEach(pizzaBean->map.put(pizzaBean.getPizzaId(), pizzaBean.getPizzaName()));
		return map;
	}

}
