package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.LoaiXe;
import entity.XeMay;
import util.ConnectDatabase;

public class DAO_XeMay {

	public DAO_XeMay() {
		
	}
	public List<XeMay> getDanhSachXeMay(){
		List<XeMay> dsSach = new ArrayList<XeMay>();
		Connection con = ConnectDatabase.getConnection();
		String sql = "select * from XeMay as xm join LoaiXe as lx on xm.maLoai = lx.maLoai";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				XeMay xeMay = new XeMay();
				xeMay.setMaXe(rs.getInt("maXe"));
				xeMay.setDongia(rs.getDouble("dongia"));
				xeMay.setLoaiXe(new LoaiXe(rs.getInt("maLoai"), rs.getString("tenLoai")));
				xeMay.setMauXe(rs.getString("mauXe"));
				xeMay.setNuocSanXuat(rs.getString("nuocSanXuat"));
				xeMay.setSoPK(rs.getInt("soPK"));
				xeMay.setTenXe(rs.getString("tenXe"));
				dsSach.add(xeMay);
			}
			return dsSach;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public boolean insertXeMay(XeMay xeMay, String path) {
		String sql = "insert into XeMay(tenXe,soPK,mauXe,nuocSanXuat,dongia,hinhAnh, maLoai) values (?,?,?,?,?,?,?)";
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt;
		try {
			FileInputStream in = new FileInputStream(path);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, xeMay.getTenXe());
			stmt.setInt(2, xeMay.getSoPK());
			stmt.setString(3, xeMay.getMauXe());
			stmt.setString(4, xeMay.getNuocSanXuat());
			stmt.setDouble(5, xeMay.getDongia());
			stmt.setBinaryStream(6, in);
			stmt.setInt(7, xeMay.getLoaiXe().getMaLoai());
			int n = stmt.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateXeMay(XeMay xeMay, String path) {
		String sql = "update XeMay set tenXe = ?, soPK = ?, mauXe = ?, nuocSanXuat = ?, dongia = ? hinhAnh = ?, maLoai = ?";
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt;
		try {
			FileInputStream in = new FileInputStream(path);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, xeMay.getTenXe());
			stmt.setInt(2, xeMay.getSoPK());
			stmt.setString(3, xeMay.getMauXe());
			stmt.setString(4, xeMay.getNuocSanXuat());
			stmt.setDouble(5, xeMay.getDongia());
			stmt.setBinaryStream(6, in);
			stmt.setInt(7, xeMay.getLoaiXe().getMaLoai());
			int n = stmt.executeUpdate();
			return n>0;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteXeMay(int id) throws SQLException {
		String sql =  "Delete from XeMay where maXe = " + id;
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		int n = stmt.executeUpdate();
		return n>0;
	}
}
