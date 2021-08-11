package com.coeding.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.catalina.User;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.vo.UserVO;

@Component("userDao")
public class UserDAO implements DAO<UserVO> {

	private DataSource ds;

//	public UserVO checkLogin(String email, String passwd) {
//		Connection conn = null;
//		PreparedStatement ptmt = null;
//		ResultSet rs = null;
//		UserVO userVO = null;
//		try {
//			String sql = "select * from tbl_user where email=? and passwd=?";
//			conn = ds.getConnection();
//			ptmt.setString(1, email);
//			ptmt.setString(2, passwd);
//			rs = ptmt.executeQuery();
//
//			if (rs.next()) {
//				userVO = new UserVO();
//				userVO.setName(rs.getString("name"));
//				userVO.setEmail(email);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			{
//				try {
//					if (rs != null)
//						rs.close();
//					if (ptmt != null)
//						ptmt.close();
//					if (conn != null)
//						conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//
//		return userVO;
//
//	}

	@Override
	public void update(UserVO vo) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		try {
			String sql = "update tbl_user set name=? , email=?, passwd=? where uid=?";
			conn = ds.getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, vo.getName());
			ptmt.setString(2, vo.getEmail());
			ptmt.setString(3, vo.getPasswd());
			ptmt.setInt(4, vo.getUid());
			ptmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (ptmt != null)
					ptmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(UserVO vo) {

		Connection conn = null;
		PreparedStatement ptmt = null;
		try {
			String sql = "delete from tbl_user where uid=?";
			conn = ds.getConnection();
			ptmt = conn.prepareStatement(sql + vo.getUid());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (ptmt != null)
					ptmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void insert(UserVO vo) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		try {
			String sql = "insert into tbl_user (name,email,passwd) values (?,?,?)";
			conn = ds.getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, vo.getName());
			ptmt.setString(2, vo.getEmail());
			ptmt.setString(3, vo.getPasswd());
			ptmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public UserVO selectOne(UserVO vo) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tbl_user where email=?";
			conn = ds.getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, vo.getEmail());
			rs = ptmt.executeQuery();
			UserVO vo1 = new UserVO();
			while (rs.next()) {
				vo1.setUid(rs.getInt("uid"));
				vo1.setName(rs.getString("name"));
				vo1.setEmail(rs.getString("email"));
				vo1.setPasswd(rs.getString("passwd"));
			}
			System.out.println("dao" + vo1.getName());
			return vo1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<UserVO> selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tbl_user";
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<UserVO> list = new ArrayList<UserVO>();
			while (rs.next()) {
				int id = rs.getInt("uid");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String passwd = rs.getString("passwd");
				UserVO user = new UserVO();
				user.setUid(id);
				user.setName(name);
				user.setEmail(email);
				user.setPasswd(passwd);
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return null;
	}

	@Override
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

}
