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
import com.coeding.mvc.vo.ColorVO;

@Component(value = "colorDAO")
public class ColorDAO implements DAO<ColorVO> {
	private DataSource ds;
	private final String COLOR_INSERT = "insert into tbl_color (name) " + "values (?)";
	private final String COLOR_UPDATE = "update tbl_color set name=? where id=?";
	private final String COLOR_DELETE = "delete from tbl_color where id=?";// use primary key
	private final String COLOR_GET = "select * from tbl_color where id=?";
	private final String COLOR_LIST = "select * from tbl_color";

	@Override
	public List<ColorVO> selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(COLOR_LIST);
			List<ColorVO> list = new ArrayList<ColorVO>();
			while (rs.next()) {
				ColorVO vo = new ColorVO();
				vo.setId(rs.getLong("id"));
				vo.setName(rs.getString("name"));
				list.add(vo);
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
	public ColorVO selectOne(ColorVO arg) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(COLOR_GET);
			ps.setLong(1, arg.getId());
			rs = ps.executeQuery();
			ColorVO vo = new ColorVO();
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
	public void insert(ColorVO arg) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(COLOR_INSERT);
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
	public void delete(ColorVO arg) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(COLOR_DELETE);
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
	public void update(ColorVO arg) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(COLOR_UPDATE);
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
