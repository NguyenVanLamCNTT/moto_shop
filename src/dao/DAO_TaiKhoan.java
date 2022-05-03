package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.NhanVien;
import entity.TaiKhoan;
import util.ConnectDatabase;

public class DAO_TaiKhoan {
	public DAO_TaiKhoan() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<TaiKhoan> getAllTaiKhoan(){
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		try {
Connection con = ConnectDatabase.getConnection();
			
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql); 
			
			while (rs.next()) {
				int id  = rs.getInt(1);
				NhanVien nhanVien = new NhanVien(rs.getInt(2));
				String password = rs.getString(3);
				TaiKhoan tk = new TaiKhoan(id, nhanVien, password);
				dsTK.add(tk);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTK;
	}
	public boolean create(TaiKhoan tk) {
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;
		int n =0;
		try {
			stmt = con.prepareStatement("insert into" + "TaiKhoan values(?,?,?)");
			stmt.setInt(1, tk.getId());
			stmt.setInt(2, tk.getNhanVien().getMaNV());
			stmt.setString(3, tk.getPassword());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean delete(int id) throws SQLException {
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from PhieuNhanXet" + " where id= ?";
		try {
			stmt.setInt(1, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stmt.executeUpdate()>0;
	}
	public boolean update(TaiKhoan tk) {	
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		int n=0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set maNV=?, password=?"+"where id=?");
				
			stmt.setInt(1, tk.getNhanVien().getMaNV());
			stmt.setString(2, tk.getPassword());	
			stmt.setInt(3, tk.getId());
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
}
