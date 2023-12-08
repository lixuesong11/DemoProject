package com.neusoft.elm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.elm.po.Business;
import com.neusoft.elm.service.BusinessService;
import com.neusoft.elm.service.impl.BusinessServiceImpl;

public class BusinessController {
	BusinessService service=new BusinessServiceImpl();
	public Object ListBusinessByOrderTypeId(HttpServletRequest request) {
		//��ȡǰ̨����
		Integer orederTypeId=Integer.parseInt(request.getParameter("orederTypeId"));
		
		//���ú�̨��ȡ����
		List<Business> list=service.ListBusinessByOrderTypeId(orederTypeId);
		return list;
	}
	public Object getBusinessById(HttpServletRequest request) {
		//��ȡǰ̨����
		Integer businessId=Integer.parseInt(request.getParameter("businessId"));
		Business business=service.getBusinessById(businessId);
		return business;
	}
	
}
