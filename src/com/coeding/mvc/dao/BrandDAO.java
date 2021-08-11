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


@Component(value = "brandDao")
public class BrandDAO implements DAO<BrandVO> {
	private DataSource ds;
	private final String BRAND_INSERT = "insert into tbl_brand (name) " + "values (?)";
	private final String BRAND_UPDATE = "update tbl_brand set name=? where id=?";
	private final String BRAND_DELETE = "delete from tbl_brand where id=?";// use primary key
	private final String BRAND_GET = "select * from tbl_brand where id=?";
	private final String BRAND_LIST = "select * from tbl_brand";

	@Override
	public List<BrandVO> selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(BRAND_LIST);
			List<BrandVO> list = new ArrayList<BrandVO>();
			while (rs.next()) {
				BrandVO brandVO = new BrandVO();
				brandVO.setId(rs.getLong("id"));
				brandVO.setName(rs.getString("name"));
				list.add(brandVO);
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
	public BrandVO selectOne(BrandVO arg) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(BRAND_GET);
			ps.setLong(1, arg.getId());
			rs = ps.executeQuery();
			BrandVO vo = new BrandVO();
			while (rs.next()) {
				vo.setId(rs.getLong("id"));
				vo.setName(rs.getString("name"));
			}
			return vo;
		} catch (SQLException e) {
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
	public void insert(BrandVO arg) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(BRAND_INSERT);
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
	public void delete(BrandVO arg) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(BRAND_DELETE);
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
	public void update(BrandVO arg) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(BRAND_UPDATE);
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
