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
import com.coeding.mvc.vo.ProductVO;

@Component(value = "productDao")
public class ProductDAO implements DAO<ProductVO> {
	private DataSource ds;
	private final String PRODUCT_INSERT= "insert into tbl_product (name, img, price, size, id_color, id_category, id_brand, amount) "
			+ "values (?,?,?,?,?,?,?,?)";
	private final String PRODUCT_UPDATE= "update tbl_product "
			+ "set name=?, img=?, price=?, size=?, id_color=?, id_category=?, id_brand=?, amount=? "
			+ "where id=?";
	private final String PRODUCT_DELETE= "delete from tbl_product where id=?";
	private final String PRODUCT_GET= "select * from tbl_product where id=?";
	private final String PRODUCT_LIST= "select * from tbl_product";
	@Override
	public List<ProductVO> selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(PRODUCT_LIST);
			List<ProductVO> list = new ArrayList<ProductVO>();
			while (rs.next()) {
				ProductVO productVO = new ProductVO();
				productVO.setId(rs.getLong("id"));
				productVO.setImg(rs.getString("img"));
				productVO.setName(rs.getString("name"));
				productVO.setPrice(rs.getDouble("price"));
				productVO.setSize(rs.getInt("size"));
				productVO.setAmount(rs.getInt("amount"));
				productVO.setId_brand(rs.getLong("id_brand"));
				productVO.setId_color(rs.getLong("id_color"));
				productVO.setId_category(rs.getLong("id_category"));
				list.add(productVO);

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
	public ProductVO selectOne(ProductVO arg) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(PRODUCT_GET);
			ps.setLong(1, arg.getId());
			rs = ps.executeQuery();
			ProductVO productVO = new ProductVO();
			while (rs.next()) {
				productVO.setId(rs.getLong("id"));
				productVO.setImg(rs.getString("img"));
				productVO.setName(rs.getString("name"));
				productVO.setPrice(rs.getDouble("price"));
				productVO.setSize(rs.getInt("size"));
				productVO.setAmount(rs.getInt("amount"));
				productVO.setId_brand(rs.getLong("id_brand"));
				productVO.setId_color(rs.getLong("id_color"));
				productVO.setId_category(rs.getLong("id_category"));
			}
			return productVO;
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
	public void insert(ProductVO arg) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(PRODUCT_INSERT);
			ps.setString(1, arg.getName());
			ps.setString(2, arg.getImg());
			ps.setDouble(3, arg.getPrice());
			ps.setInt(4, arg.getSize());
			ps.setLong(5, arg.getId_color());
			ps.setLong(6, arg.getId_category());
			ps.setLong(7, arg.getId_brand());
			ps.setInt(8, arg.getAmount());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// memory free, close
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(ProductVO arg) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(PRODUCT_DELETE);
			ps.setLong(1, arg.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// memory free, close
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(ProductVO arg) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(PRODUCT_UPDATE);
			ps.setString(1, arg.getName());
			ps.setString(2, arg.getImg());
			ps.setDouble(3, arg.getPrice());
			ps.setInt(4, arg.getSize());
			ps.setLong(5, arg.getId_color());
			ps.setLong(6, arg.getId_category());
			ps.setLong(7, arg.getId_brand());
			ps.setInt(8, arg.getAmount());
			ps.setLong(9, arg.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// memory free, close
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
}
