package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.businessbean.BillRangeBean;
import com.accenture.lkm.businessbean.PizzaOrderBean;
import com.accenture.lkm.service.PizzaService;

@Controller
public class ReportController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@RequestMapping(value = "loadDateRangeReportPage.html",method = RequestMethod.GET)
	public ModelAndView loadDateRangeReportPage() {
		return new ModelAndView("OrderReport","billRangeBean",new BillRangeBean());
	}
	
	@RequestMapping(value = "getOrderDetails.html",method = RequestMethod.POST)
	public ModelAndView getOrderDetails(@ModelAttribute("billRangeBean")BillRangeBean billRangeBean){
		ModelAndView modelAndView=new ModelAndView();
		List<PizzaOrderBean> pizzaOrderBeans = pizzaService.getOrderDetails(billRangeBean.getFromPrice(), billRangeBean.getToPrice());
		modelAndView.addObject("pizzaOrderBeans",pizzaOrderBeans);
		modelAndView.setViewName("OrderReport");
		return modelAndView;
	}
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}

}
