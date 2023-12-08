package com.neusoft.elm.service;

import java.util.List;

import com.neusoft.elm.po.Business;

public interface BusinessService {
	List<Business> ListBusinessByOrderTypeId(Integer orederTypeId);

	Business getBusinessById(Integer businessId);
}
