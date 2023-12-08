package com.neusoft.elm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.elm.po.Food;
import com.neusoft.elm.service.FoodService;
import com.neusoft.elm.service.impl.FoodServiceImpl;

public class FoodController {
	
	FoodService service =new  FoodServiceImpl();
	public Object getFoodBusinessById(HttpServletRequest request) {
		//��ȡǰ̨����
		Integer businessId=Integer.parseInt(request.getParameter("businessId"));
		System.out.println(businessId);
		//���ú�̨��ȡ����
		List<Food> food=service.getFoodBusinessById(businessId);
		return food;
	}
}
