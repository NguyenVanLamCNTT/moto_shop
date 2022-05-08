package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuNhanXet;
import util.ConnectDatabase;

public class DAO_PhieuNhanXet {
	public DAO_PhieuNhanXet() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<PhieuNhanXet> getAllPhieuNhanXet(){
		ArrayList<PhieuNhanXet> dsPNX = new ArrayList<PhieuNhanXet>();
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql = "Select * from PhieuNhanXet";
			Statement statement= con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int maPhieu = rs.getInt(1);
				String liDoBH = rs.getString(2);
				String loiThuocVE = rs.getString(3);
				double giaTien = rs.getDouble(4);
				NhanVien nhanVien = new NhanVien(rs.getInt(5));
				KhachHang khachHang = new KhachHang(rs.getInt(6));
				PhieuNhanXet pXN = new PhieuNhanXet(maPhieu, liDoBH, loiThuocVE, giaTien, nhanVien, khachHang);
				dsPNX.add(pXN);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPNX;
	}
	public boolean create(PhieuNhanXet pNX) {
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert into" + " PhieuNhanXet(?,?,?,?,?)");
			stmt.setString(1, pNX.getLiDoBH());
			stmt.setString(2, pNX.getLoiThuocVe());
			stmt.setDouble(3, pNX.getGiaTien());
			stmt.setInt(4, pNX.getNhanVien().getMaNV());
			stmt.setInt(5, pNX.getKhachHang().getMaKH());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean delete(int maPhieu) throws SQLException {
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from PhieuNhanXet" + " where maPhieu= ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, maPhieu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stmt.executeUpdate()>0;
	}
	public boolean update(PhieuNhanXet pNX) {	
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		int n=0;
		try {
			stmt = con.prepareStatement("update PhieuNhanXet set liDoBH=? " +
		"loiThuocVe=?, giaTien=?, maNV=?, maKH=?"+" where maPhieu=?");
				
			stmt.setString(1, pNX.getLiDoBH());
			stmt.setString(2, pNX.getLoiThuocVe());
			stmt.setDouble(3, pNX.getGiaTien());
			stmt.setInt(4, pNX.getNhanVien().getMaNV());
			stmt.setInt(5, pNX.getKhachHang().getMaKH());	
			stmt.setInt(6, pNX.getMaPhieu());
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
