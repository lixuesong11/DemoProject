package com.neusoft.elm.dao;

import java.util.List;

import com.neusoft.elm.po.Food;

public interface FoodDao {

	List<Food> getFoodBusinessById(Integer businessId);

}
