package com.neusoft.elm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.elm.po.Business;
import com.neusoft.elm.service.BusinessService;
import com.neusoft.elm.service.impl.BusinessServiceImpl;

public class BusinessController {
	BusinessService service=new BusinessServiceImpl();
	public Object ListBusinessByOrderTypeId(HttpServletRequest request) {
		//获取前台参数
		Integer orederTypeId=Integer.parseInt(request.getParameter("orederTypeId"));
		
		//调用后台获取数据
		List<Business> list=service.ListBusinessByOrderTypeId(orederTypeId);
		return list;
	}
	public Object getBusinessById(HttpServletRequest request) {
		//获取前台参数
		Integer businessId=Integer.parseInt(request.getParameter("businessId"));
		Business business=service.getBusinessById(businessId);
		return business;
	}
	
}
