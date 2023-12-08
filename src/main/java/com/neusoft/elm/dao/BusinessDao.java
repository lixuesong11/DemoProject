package com.neusoft.elm.dao;

import java.util.List;

import com.neusoft.elm.po.Business;

public interface BusinessDao {

	List<Business> ListBusinessByOrderTypeId(Integer orederTypeId);

	Business getBusinessById(Integer businessId);

}
