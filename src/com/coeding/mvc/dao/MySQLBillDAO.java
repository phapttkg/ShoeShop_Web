package com.coeding.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import com.coeding.mvc.annotation.Component;
import com.coeding.mvc.vo.BillVO;
import com.coeding.mvc.vo.ProductVO;

@Component("billDao")
public class MySQLBillDAO implements DAO<BillVO> {
	private DataSource ds;
	private ProductDAO pdao;
	private String INSERT = "insert into tbl_bill (cus_name, id_product, price_unit, amount, total_price) values (?, ?, ?, ?, ?)";
	private String GET = "select * from tbl_bill where id=";
	private String LIST = "select * from tbl_bill";
	private String UPDATE = "update tbl_bill set cus_name=?, id_product=?, price_unit=?, amount=?, total_price=? where id=?";
	private String DELETE = "delete from tbl_bill where id=";

	@Override
	public List<BillVO> selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(LIST);
			List<BillVO> list = new ArrayList<BillVO>();
			while(rs.next()) {
				long bid = rs.getLong("id");
				String cName = rs.getString("cus_name");
				double uPrice = rs.getDouble("price_unit");
				double totalPrice = rs.getDouble("total_price");
				long pid = rs.getLong("id_product");
				int amount = rs.getInt("amount");
				
				
				BillVO bill = new BillVO();
				bill.setBid(bid);
				bill.setcName(cName);
				bill.setPid(pid);
				bill.setuPrice(uPrice);
				bill.setAmount(amount);
				bill.setTotalPrice(totalPrice);
				list.add(bill);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// memory free, close
			try {
				if( rs != null) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public BillVO selectOne(BillVO arg) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(GET+arg.getBid());
			rs = pstmt.executeQuery();
			
			BillVO bill = new BillVO();
			while(rs.next()) {
				bill.setBid(rs.getLong("id"));
				bill.setcName(rs.getString("cus_name"));							
				bill.setPid(rs.getLong("id_product"));
				bill.setuPrice(rs.getDouble("price_unit"));
				bill.setAmount(rs.getInt("amount"));
				bill.setTotalPrice(rs.getDouble("total_price"));
			}
			return bill;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// memory free, close
			try {
				if( rs != null) rs.close();
				if( pstmt != null ) pstmt.close();
				if( conn != null ) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}		
		return null;
	}

	@Override
	public void insert(BillVO arg) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ProductVO product = new ProductVO();
		product.setId(arg.getPid());
		double uprice = (pdao.selectOne(product)).getPrice();
		double total = uprice * arg.getAmount();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, arg.getcName());
			pstmt.setLong(2, arg.getPid());
			pstmt.setDouble(3, uprice);
			pstmt.setInt(4, arg.getAmount());
			pstmt.setDouble(5,  total);	
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// memory free, close
			try {
				if( pstmt != null ) pstmt.close();
				if( conn != null ) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void delete(BillVO arg) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(DELETE + arg.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// memory free, close
			try {
				if( pstmt != null ) pstmt.close();
				if( conn != null ) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(BillVO arg) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ProductVO product = new ProductVO();
		product.setId(arg.getPid());
		double uprice = (pdao.selectOne(product)).getPrice();
		double total = uprice * arg.getAmount();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(UPDATE);	
			pstmt.setString(1, arg.getcName());
			pstmt.setLong(2, arg.getPid());
			pstmt.setDouble(3, uprice);
			pstmt.setInt(4, arg.getAmount());
			pstmt.setDouble(5, total);
			pstmt.setLong(6, arg.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// memory free, close
			try {
				if( pstmt != null ) pstmt.close();
				if( conn != null ) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void setDataSource(DataSource ds) {
		System.out.println(ds + " injected into " +this);
		this.ds = ds;
	}
	public void setPdao(ProductDAO pdao) {
		this.pdao = pdao;
	}
	
}
