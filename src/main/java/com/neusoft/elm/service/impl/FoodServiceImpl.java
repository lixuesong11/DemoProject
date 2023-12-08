package com.neusoft.elm.service.impl;

import java.util.List;

import com.neusoft.elm.dao.FoodDao;
import com.neusoft.elm.dao.impl.FoodDaoImpl;
import com.neusoft.elm.po.Food;
import com.neusoft.elm.service.FoodService;

public class FoodServiceImpl implements FoodService {

	FoodDao dao=new FoodDaoImpl();
	@Override
	public List<Food> getFoodBusinessById(Integer businessId) {
		
		return dao.getFoodBusinessById(businessId);
	}

}
