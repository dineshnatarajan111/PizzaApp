package com.accenture.lkm.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.businessbean.PizzaOrderBean;
import com.accenture.lkm.service.PizzaService;

@Controller
public class PizzaOrderController {

	@Autowired
	private PizzaService pizzaService;
	
	@RequestMapping(value = "loadSavePizza.html",method = RequestMethod.GET)
	public ModelAndView loadSavePizza() {
		return new ModelAndView("PizzaOrder", "pizzaOrderBean", new PizzaOrderBean());
	}
	
	@RequestMapping(value = "addPizzaOrderDetails.html",method = RequestMethod.POST)
	public ModelAndView addPizzaOrderDetails(@Valid @ModelAttribute("pizzaOrderBean")PizzaOrderBean pizzaOrderBean,BindingResult bindingResult){
		ModelAndView modelAndView=new ModelAndView();
		if(bindingResult.hasErrors()) {
			modelAndView.setViewName("PizzaOrder");
		}else {
			pizzaOrderBean = pizzaService.addPizzaOrderDetails(pizzaOrderBean);
			modelAndView.setViewName("PizzaOrderSuccess");
			modelAndView.addObject("message","Hi, "+pizzaOrderBean.getCustomerName()+" your order is placed. Bill Amount is : "+pizzaOrderBean.getBill());
		}
		return modelAndView;
		
	}
	
	@ModelAttribute("pizzaNameAndPrice")
	public Map<Integer,String> populatePizzaNames(){
		return pizzaService.findAllPizzaDetails();
	}
}
