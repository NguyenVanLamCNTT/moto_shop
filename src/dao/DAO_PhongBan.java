package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entity.PhongBan;
import util.ConnectDatabase;

public class DAO_PhongBan {
	public ArrayList<PhongBan> getAllPhongBan(){
		ArrayList<PhongBan> dsPhongBan = new ArrayList<PhongBan>();
		try {
			Connection con = ConnectDatabase.getConnection();
			String sql = "Select * from PhongBan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int maPhongBan = rs.getInt(1);
				String tenPhongBan = rs.getString(2);
				PhongBan p = new PhongBan(maPhongBan, tenPhongBan);
				dsPhongBan.add(p);			
			}
			return dsPhongBan;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public boolean create(PhongBan pb) {
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert into PhongBan(tenPhongBan)" + " values(?)");
			
			stmt.setString(1, pb.getTenPhongBan());
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
	public boolean delete(int maPhongBan) throws SQLException {
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from PhieuNhanXet" + " where maPhongBan= ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, maPhongBan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stmt.executeUpdate()>0;
	}
	public boolean update(PhongBan pb) {
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		int n=0;
		try {
			stmt = con.prepareStatement("update PhongBan set tenPhongBan=?" +" where maPhongBan=?");
			stmt.setString(1, pb.getTenPhongBan());	
			stmt.setInt(2,pb.getMaPhongBan());
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
	public boolean insert(PhongBan pb) {
		Connection con = ConnectDatabase.getConnection();
		PreparedStatement stmt = null;	
		String sql = "insert into PhongBan(tenPhongBan)" + " values(?)";
		int n=0;
		try {
			stmt.setString(1, pb.getTenPhongBan());
			n= stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
