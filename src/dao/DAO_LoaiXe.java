package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.LoaiXe;
import util.ConnectDatabase;

public class DAO_LoaiXe {
	public DAO_LoaiXe() {
		
	}
	public ArrayList<LoaiXe> getalltbLoaiXe(){
		ArrayList<LoaiXe> dslx = new ArrayList<LoaiXe>();
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql = "Select * from LoaiXe";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				int maLoai = rs.getInt(1);
				String tenLoai = rs.getString(2);
				
				LoaiXe lx = new LoaiXe(maLoai, tenLoai);
				dslx.add(lx);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return dslx;
		
	}
	public ArrayList<LoaiXe> getNhanVienTheoMaNV(String id) {
		ArrayList<LoaiXe> dslx = new ArrayList<LoaiXe>();
		
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from LoaiXe where maLoai =?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int maLoai = rs.getInt(1);
				String tenLoai = rs.getString(2);
				
				LoaiXe lx = new LoaiXe(maLoai, tenLoai);
				dslx.add(lx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dslx;
	}
	
	public boolean create(LoaiXe lx) {
		
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		int n=0;
		try {
			stmt = con.prepareStatement("insert into"
					+ "LoaiXe values(?,?)");
			
			stmt.setInt(1, lx.getMaLoai());
			stmt.setString(2, lx.getTenLoai());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n >0;
	}
	public boolean update(LoaiXe lx) {
		
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		int n=0;
		try {
			stmt = con.prepareStatement("update LoaiXe set tenLoai=?"+"where maNV=?");
			
			
			stmt.setString(1, lx.getTenLoai());
			stmt.setInt(2, lx.getMaLoai());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n >0;
		
	}
	public boolean delete(int maLoai) {
		String sql = "delete * form LoaiXe where maLoai=?";
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		int n=0;
		try {
			stmt =con.prepareStatement(sql);
			stmt.setInt(1, maLoai);
			
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return n>0;
	}
}
