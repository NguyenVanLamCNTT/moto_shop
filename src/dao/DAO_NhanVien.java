package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import entity.NhanVien;
import util.ConnectDatabase;


public class DAO_NhanVien {
	public DAO_NhanVien() {
		
	}
	public ArrayList<NhanVien> getalltbNhanVien(){
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				int maNV = rs.getInt(1);
				String tenNV = rs.getString(2);
				String chucVu = rs.getString(3);				
				String soDienThoai = rs.getString(4);
				String email = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String role = rs.getString(7);
				NhanVien nv = new NhanVien(maNV, tenNV, chucVu, soDienThoai, email, gioiTinh, role);
				dsnv.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return dsnv;
		
	}
	public ArrayList<NhanVien> getNhanVienTheoMaNV(String id) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from NhanVien where maNV =?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int maNV = rs.getInt(1);
				String tenNV = rs.getString(2);
				String chucVu = rs.getString(3);				
				String soDienThoai = rs.getString(4);
				String email = rs.getString(5);
				String gioiTinh = rs.getString(6);
				String role = rs.getString(7);
				NhanVien nv = new NhanVien(maNV, tenNV, chucVu, soDienThoai, email, gioiTinh, role);
				dsnv.add(nv);
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
		return dsnv;
	}
	
	public boolean create(NhanVien nv) {
		
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		int n=0;
		try {
			stmt = con.prepareStatement("insert into"
					+ "NhanVien values(?,?,?,?,?,?,?)");
			stmt.setInt(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getChucVu());
			stmt.setString(4, nv.getSoDienThoai());
			stmt.setString(5, nv.getEmail());
			stmt.setString(6, nv.getGioiTinh());
			stmt.setString(7, nv.getRole());
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
	public boolean update(NhanVien nv) {
		
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		int n=0;
		try {
			stmt = con.prepareStatement("update NhanVien set tenNV=?" +
		"chucVu=?, soDienThoai=?, email=?, gioiTinh=?, role=?"+"where maNV=?");
			
			
			stmt.setString(1, nv.getTenNV());
			stmt.setString(2, nv.getChucVu());
			stmt.setString(3, nv.getSoDienThoai());
			stmt.setString(4, nv.getEmail());
			stmt.setString(5, nv.getGioiTinh());
			stmt.setString(6, nv.getRole());
			stmt.setInt(7, nv.getMaNV());
			
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
	public boolean delete(int maNV) {
		String sql = "delete * form NhanVien where maNV=?";
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		int n=0;
		try {
			stmt =con.prepareStatement(sql);
			stmt.setInt(1, maNV);
			
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
