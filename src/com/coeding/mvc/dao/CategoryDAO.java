package com.coeding.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.vo.BrandVO;
import com.coeding.mvc.vo.CategoryVO;
import com.coeding.mvc.vo.ColorVO;

@Component(value = "categoryDao")
public class CategoryDAO implements DAO<CategoryVO> {
	private DataSource ds;
	private final String CATEGORY_INSERT = "insert into tbl_category (name) " + "values (?)";
	private final String CATEGORY_UPDATE = "update tbl_category set name=? where id=?";	
	private final String CATEGORY_DELETE = "delete from tbl_category where id=?";
	private final String CATEGORY_GET = "select * from tbl_category where id=?";
	private final String CATEGORY_LIST = "select * from tbl_category";

	@Override
	public List<CategoryVO> selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CATEGORY_LIST);
			List<CategoryVO> list = new ArrayList<CategoryVO>();
			while (rs.next()) {
				CategoryVO categoryVO = new CategoryVO();
				categoryVO.setId(rs.getLong("id"));
				categoryVO.setName(rs.getString("name"));
				list.add(categoryVO);
			}
			return list;
		} catch (SQLException e) {
			// error handling
			e.printStackTrace();
		} finally {
			// memory free, close
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public CategoryVO selectOne(CategoryVO arg) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(CATEGORY_GET);
			ps.setLong(1, arg.getId());
			rs = ps.executeQuery();
			CategoryVO vo = new CategoryVO();
			while (rs.next()) {
				vo.setId(rs.getLong("id"));
				vo.setName(rs.getString("name"));
			}
			return vo;
		} catch (SQLException e) {
			// error handling
			e.printStackTrace();
		} finally {
			// memory free, close
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void insert(CategoryVO arg) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(CATEGORY_INSERT);
			stmt.setString(1, arg.getName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// error handling
			e.printStackTrace();
		} finally {
			// memory free, close
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(CategoryVO arg) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(CATEGORY_DELETE);
			stmt.setLong(1, arg.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// error handling
			e.printStackTrace();
		} finally {
			// memory free, close
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(CategoryVO arg) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(CATEGORY_UPDATE);
			stmt.setString(1, arg.getName());
			stmt.setLong(2, arg.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// error handling
			e.printStackTrace();
		} finally {
			// memory free, close
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

}
