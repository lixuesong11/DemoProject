package com.neusoft.elm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.neusoft.elm.dao.UserDao;
import com.neusoft.elm.po.User;
import com.neusoft.elm.util.DBUtil;

public class UserDaoImpl implements UserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public User getUserById(String userId) {
		String sql = "select * from user";
		User user = new User();
		try {
			conn = DBUtil.getConnection();
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("userId");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				Integer userSex = rs.getInt("userSex");
				user.setUserId(id);
				user.setUserName(userName);
				user.setPassword(password);
				user.setUserSex(userSex);
				
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps);
			DBUtil.close();
		}

		return user;
	}

	@Override
	public User getUserByIdBypassword(String userId, String password) {
		String sql="select * from user where userId =? and password=?";
		User user=null;
		try {
			conn = DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getString("userId"));
				user.setPassword(rs.getString("password"));
				user.setUserName(rs.getString("userName"));
				user.setUserSex(rs.getInt("userSex"));
				user.setUserImg(rs.getString("userImg"));
				user.setDelTag(rs.getInt("delTag"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ps);
			DBUtil.close();
		}
		return user;
	}

}
