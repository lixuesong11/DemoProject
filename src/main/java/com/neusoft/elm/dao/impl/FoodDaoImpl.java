package com.neusoft.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.elm.dao.FoodDao;
import com.neusoft.elm.po.Food;
import com.neusoft.elm.util.DBUtil;

public class FoodDaoImpl implements FoodDao {
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public List<Food> getFoodBusinessById(Integer businessId) {
		List<Food>list=new ArrayList<Food>();
		String sql="select * from food where businessId =?";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, businessId);
			rs=pst.executeQuery();
			while(rs.next()) {
				    Food food = new Food();
	                food.setFoodId(rs.getInt("foodId"));
	                food.setFoodName(rs.getString("foodName"));

	                food.setFoodExplain(rs.getString("foodExplain"));
	                food.setFoodImg(rs.getString("foodImg"));
	                food.setFoodPrice(rs.getDouble("foodPrice"));
	                food.setBusinessId(rs.getInt("businessId"));
	                food.setRemarks(rs.getString("remarks"));
	                list.add(food);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pst);
			DBUtil.close();
		}
		return list;
	}

}
