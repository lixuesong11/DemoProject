package com.neusoft.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.util.DBUtil;

public class BusinessDaoImpl implements BusinessDao {

	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public List<Business> ListBusinessByOrderTypeId(Integer orederTypeId) {
		List<Business> list=new ArrayList<Business>();
		String sql="select * from business where orderTypeId=?";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, orederTypeId);
			rs=pst.executeQuery();
			while(rs.next()) {
				Business business=new Business();
				business.setBusinessId(rs.getInt("businessId"));
				business.setBusinessName(rs.getString("businessName"));
				business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));
				list.add(business);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pst);
			DBUtil.close();
		}
		return list;
	}
	@Override
	public Business getBusinessById(Integer businessId) {
		String sql = "select * from business where businessId =?";
		Business business=null;
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, businessId);
			rs=pst.executeQuery();
			while(rs.next()) {
				business=new Business();
				business.setBusinessId(rs.getInt("businessId"));
				business.setBusinessName(rs.getString("businessName"));
				business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pst);
			DBUtil.close();
		}	
		return business;
	}

}
