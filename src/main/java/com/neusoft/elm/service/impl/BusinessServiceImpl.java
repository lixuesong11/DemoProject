package com.neusoft.elm.service.impl;

import java.util.List;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.dao.impl.BusinessDaoImpl;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {

	BusinessDao dao =new BusinessDaoImpl();
	@Override
	public List<Business> ListBusinessByOrderTypeId(Integer orederTypeId) {
		List<Business> list=dao.ListBusinessByOrderTypeId(orederTypeId);
		return list;
	}
	@Override
	public Business getBusinessById(Integer businessId) {
		Business business=dao.getBusinessById(businessId);
		return business;
	}

}
