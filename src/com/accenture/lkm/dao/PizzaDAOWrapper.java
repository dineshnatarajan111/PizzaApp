package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.businessbean.PizzaBean;
import com.accenture.lkm.businessbean.PizzaOrderBean;
import com.accenture.lkm.entity.PizzaEntity;
import com.accenture.lkm.entity.PizzaOrderEntity;

@Repository
public class PizzaDAOWrapper {

	@Autowired
	private PizzaDAO pizzaDAO;
	
	@Autowired
	private PizzaOrderDAO pizzaOrderDAO;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<PizzaBean> findAllPizzaDetails(){
		List<PizzaEntity> pizzaEntities = pizzaDAO.findPizzaDetails();
		List<PizzaBean> pizzaBeans=new ArrayList<PizzaBean>();
		pizzaEntities.forEach(pizzaEntity->{
			PizzaBean pizzaBean=new PizzaBean();
			BeanUtils.copyProperties(pizzaEntity, pizzaBean);
			pizzaBeans.add(pizzaBean);
		});
		return pizzaBeans;
	}
	
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) {
		PizzaOrderEntity pizzaOrderEntity=new PizzaOrderEntity();
		BeanUtils.copyProperties(pizzaOrderBean, pizzaOrderEntity);
		pizzaOrderEntity = pizzaOrderDAO.save(pizzaOrderEntity);
		BeanUtils.copyProperties(pizzaOrderEntity, pizzaOrderBean);
		return pizzaOrderBean;
	}
	
	public Double getPizzaPrice(Integer pizzaId) {
		/*
		Query query = entityManager.createQuery("SELECT E.price FROM PizzaEntity E WHERE E.pizzaId = :pizzaId");
		query.setParameter("pizzaId", pizzaId);
		return (Double)query.getSingleResult();
		*/
		PizzaEntity pizzaEntity=entityManager.find(PizzaEntity.class, pizzaId);
		return pizzaEntity.getPrice();
		
	}
	public List<PizzaOrderBean> getOrderDetails(Double fromBill,Double toBill){
		Query query = entityManager.createQuery("SELECT E FROM PizzaOrderEntity E WHERE E.bill BETWEEN :fromBill and :toBill");
		query.setParameter("fromBill", fromBill);
		query.setParameter("toBill", toBill);
		List<PizzaOrderEntity> pizzaOrderEntities=query.getResultList();
		List<PizzaOrderBean> pizzaOrderBeans=new ArrayList<PizzaOrderBean>();
		pizzaOrderEntities.forEach(pizzaOrderEntity->{
			PizzaOrderBean pizzaOrderBean=new PizzaOrderBean();
			BeanUtils.copyProperties(pizzaOrderEntity, pizzaOrderBean);
			pizzaOrderBeans.add(pizzaOrderBean);
		});
		return pizzaOrderBeans;
	}
	
}
