package com.neusoft.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.elm.dao.CartDao;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.po.Cart;
import com.neusoft.elm.po.Food;
import com.neusoft.elm.util.DBUtil;

public class CartDaoImpl implements CartDao {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	// 向购物车中添加一条数据
	@Override
	public int saveCart(Cart cart) {
		String sql = "insert into cart values(null,?,?,?,1)";
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cart.getFoodId());
			pst.setInt(2, cart.getBusinessId());
			pst.setString(3, cart.getUserId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst);
			DBUtil.close();
		}

		return result;
	}

	// 更新购物车商品数量
	@Override
	public int updateCart(Cart cart) {
		int result = 0;
		String sql = "update cart set quantity=? where foodId=? and businessId=? and userId=?";
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cart.getQuantity());
			pst.setInt(2, cart.getFoodId());
			pst.setInt(3, cart.getBusinessId());
			pst.setString(4, cart.getUserId());
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst);
			DBUtil.close();
		}
		return result;
	}

	@Override
	public int removeCart(Cart cart) {
		String sql = "delete from cart where foodId=? and businessId=? and userId=?";
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cart.getFoodId());
			pst.setInt(2, cart.getBusinessId());
			pst.setString(3, cart.getUserId());
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst);
			DBUtil.close();
		}
		return result;
	}

	@Override
	public Object listCart(Cart cart) {
		List<Cart> list =new ArrayList<Cart>();
		String sql = "select \r\n" + "   c.*,\r\n" + "	 f.foodId ffoodId,\r\n" + "	 f.foodName ffoodName,\r\n"
				+ "	 f.foodExplain ffoodImg,\r\n" + "	 f.foodImg ffoodImg,\r\n" + "	 f.foodPrice ffoodPrice,\r\n"
				+ "	 f.businessId fbusinessId,\r\n" + "	 f.remarks fremarks,\r\n" + "	 b.businessId bbusinessId,\r\n"
				+ "	 b.businessName bbusinessName,\r\n" + "	 b.businessAddress bbusinessAddress,\r\n"
				+ "	 b.businessExplain bbusinessExplain,\r\n" + "	 b.businessImg bbusinessImg,\r\n"
				+ "	 b.orderTypeId borderTypeId,\r\n" + "	 b.starPrice bstarPrice,\r\n"
				+ "	 b.deliveryPrice bdeliveryPrice,\r\n" + "	 b.remarks bremarks \r\n"
				+ "from (cart c left join food f on c.foodId = f.foodId) \r\n"
				+ "left join business b on c.businessId = b.businessId \r\n" + "where c.userId = ? and c.businessId = ?"
				+ "";
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, cart.getUserId());
			pst.setInt(2, cart.getBusinessId());
			rs = pst.executeQuery();
			while (rs.next()) {
				Cart c = new Cart();
				c.setCartId(rs.getInt("cartId"));
				c.setFoodId(rs.getInt("foodId"));
				c.setBusinessId(rs.getInt("businessId"));
				c.setUserId(rs.getString("userId"));
				c.setQuantity(rs.getInt("quantity"));
				Food f = new Food();
				f.setFoodId(rs.getInt("ffoodId"));
				f.setFoodName(rs.getString("ffoodName"));
				f.setFoodImg(rs.getString("ffoodImg"));
				f.setFoodPrice(rs.getDouble("ffoodPrice"));
				f.setBusinessId(rs.getInt("fbusinessId"));
				f.setRemarks(rs.getString("fremarks"));
				
				c.setFood(f);
                Business b = new Business();
                b.setBusinessId(rs.getInt("bbusinessId"));
                b.setBusinessName(rs.getString("bbusinessName"));
                b.setBusinessAddress(rs.getString("bbusinessAddress"));
                b.setBusinessExplain(rs.getString("bbusinessExplain"));
                b.setBusinessImg(rs.getString("bbusinessImg"));
                b.setOrderTypeId(rs.getInt("borderTypeId"));
                b.setStarPrice(rs.getDouble("bstarPrice"));
                b.setDeliveryPrice(rs.getDouble("bdeliveryPrice"));
                c.setBusiness(b);
                
                list.add(c);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pst);
			DBUtil.close();
		}
		return list;
	}

}
