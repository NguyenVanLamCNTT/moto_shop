package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.KhachHang;
import util.ConnectDatabase;


public class DAO_KhachHang {
	public DAO_KhachHang() {
		
	}
	public ArrayList<KhachHang> getalltbNhanVien(){
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		try {
			
			Connection con = ConnectDatabase.getConnection();
			String sql = "Select * from KhachHang ORDER BY maKH desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				int maKH = rs.getInt(1);
				String tenKH = rs.getString(2);
				String diaChi = rs.getString(3);				
				String soDienThoai = rs.getString(4);
				KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDienThoai);
				dskh.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return dskh;
		
	}
	public ArrayList<KhachHang> getKhachHangTheoMaKH(String id) {
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from KhachHang where maKH =?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int maKH = rs.getInt(1);
				String tenKH = rs.getString(2);
				String diaChi = rs.getString(3);				
				String soDienThoai = rs.getString(4);
				KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDienThoai);
				dskh.add(kh);
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
		return dskh;
	}
	
	public boolean create(KhachHang kh) {
		
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		int n=0;
		try {
			stmt = con.prepareStatement("insert into"
					+ " KhachHang(tenKH, diaChi, soDienThoai) values(?,?,?)");
			stmt.setString(1, kh.getTenKH());
			stmt.setString(2, kh.getDiaChi());
			stmt.setString(3, kh.getSoDienThoai());
			
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
	public boolean update(KhachHang kh) {
		
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		int n=0;
		try {
			stmt = con.prepareStatement("update KhachHang set tenNV=?" +
		" diaChi=?, soDienThoai=? "+"where maKH=?");
			stmt.setString(1, kh.getTenKH());
			stmt.setString(2, kh.getDiaChi());
			stmt.setString(3, kh.getSoDienThoai());
			stmt.setInt(4, kh.getMaKH());
			
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
	public boolean delete(int maKH) {
		String sql = "delete from KhachHang where maKH=?";
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		int n=0;
		try {
			stmt =con.prepareStatement(sql);
			stmt.setInt(1, maKH);
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
