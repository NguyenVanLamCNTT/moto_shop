package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.NhanVien;
import entity.NhanVienHanhChanh;
import entity.NhanVienKyThuat;
import entity.PhongBan;
import util.ConnectDatabase;


public class DAO_NhanVien {
	public DAO_NhanVien() {
		
	}
//	public ArrayList<NhanVien> getalltbNhanVien(){
//		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
//		try {
//			Connection con = ConnectDatabase.getConnection();
//			String sql = "Select * from NhanVien";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			
//			while (rs.next()) {
//				int maNV = rs.getInt(1);
//				String tenNV = rs.getString(2);
//				String chucVu = rs.getString(3);				
//				String soDienThoai = rs.getString(4);
//				String email = rs.getString(5);
//				String gioiTinh = rs.getString(6);
//				String role = rs.getString(7);
//				NhanVien nv = new NhanVien(maNV, tenNV, chucVu, soDienThoai, email, gioiTinh, role);
//				dsnv.add(nv);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		return dsnv;
//		
//	}
//	public ArrayList<NhanVien> getNhanVienTheoMaNV(String id) {
//		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
//		
//		Connection con = ConnectDatabase.getConnection();
//		PreparedStatement statement = null;
//		try {
//			String sql = "Select * from NhanVien where maNV =?";
//			statement = con.prepareStatement(sql);
//			statement.setString(1, id);
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				int maNV = rs.getInt(1);
//				String tenNV = rs.getString(2);
//				String chucVu = rs.getString(3);				
//				String soDienThoai = rs.getString(4);
//				String email = rs.getString(5);
//				String gioiTinh = rs.getString(6);
//				String role = rs.getString(7);
//				NhanVien nv = new NhanVien(maNV, tenNV, chucVu, soDienThoai, email, gioiTinh, role);
//				dsnv.add(nv);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				statement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return dsnv;
//	}
//	
//	public boolean create(NhanVien nv) {
//		
//		Connection con = ConnectDatabase.getConnection();
//		PreparedStatement stmt = null;	
//		int n=0;
//		try {
//			stmt = con.prepareStatement("insert into"
//					+ " NhanVien(tenNV, chucVu, soDienThoai, email, gioiTinh, role) values(?,?,?,?,?,?)");
//			stmt.setString(1, nv.getTenNV());
//			stmt.setString(2, nv.getChucVu());
//			stmt.setString(3, nv.getSoDienThoai());
//			stmt.setString(4, nv.getEmail());
//			stmt.setString(5, nv.getGioiTinh());
//			stmt.setString(6, nv.getRole());
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}
//		return n >0;
//	}
//	public boolean update(NhanVien nv) {
//		
//		Connection con = ConnectDatabase.getConnection();
//		PreparedStatement stmt = null;	
//		int n=0;
//		try {
//			stmt = con.prepareStatement("update NhanVien set tenNV=? " +
//		"chucVu=?, soDienThoai=?, email=?, gioiTinh=?, role=? "+" where maNV=?");
//			
//			
//			stmt.setString(1, nv.getTenNV());
//			stmt.setString(2, nv.getChucVu());
//			stmt.setString(3, nv.getSoDienThoai());
//			stmt.setString(4, nv.getEmail());
//			stmt.setString(5, nv.getGioiTinh());
//			stmt.setString(6, nv.getRole());
//			stmt.setInt(7, nv.getMaNV());
//			
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}
//		return n >0;
//		
//	}
//	public boolean delete(int maNV) {
//		String sql = "delete from NhanVien where maNV=?";
//		Connection con = ConnectDatabase.getConnection();
//		PreparedStatement stmt = null;	
//		int n=0;
//		try {
//			stmt =con.prepareStatement(sql);
//			stmt.setInt(1, maNV);
//			
//			n = stmt.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}
//		
//		return n>0;
//	}
	public List<NhanVienHanhChanh> getListNhanVienHanhChanh(){
		List<NhanVienHanhChanh> list = new ArrayList<NhanVienHanhChanh>();
		Connection con = ConnectDatabase.getConnection();
		String sql = "select * from NhanVien as nv join NhanVienHanhChanh as nvhc on nv.maNV = nvhc.maNV join PhongBan as pb on nvhc.maPhongBan= pb.maPhongBan";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNV(rs.getInt("maNV"));
				nhanVien.setTenNV(rs.getString("tenNV"));
				nhanVien.setChucVu(rs.getString("chucVu"));
				nhanVien.setEmail(rs.getString("email"));
				nhanVien.setGioiTinh(rs.getString("gioiTinh"));
				nhanVien.setRole(rs.getString("role"));
				nhanVien.setSoDienThoai(rs.getString("soDienThoai"));
				nhanVien.setDiaChi(rs.getString("diaChi"));
				PhongBan phongBan = new PhongBan();
				phongBan.setMaPhongBan(rs.getInt("maPhongBan"));
				phongBan.setTenPhongBan(rs.getString("tenPhongBan"));
				NhanVienHanhChanh nhanVienHanhChanh = new NhanVienHanhChanh();
				nhanVienHanhChanh.setNhanVien(nhanVien);
				nhanVienHanhChanh.setPhongBan(phongBan);
				nhanVienHanhChanh.setTrinhDoHocVan(rs.getString("trinhDoHocVan"));
				list.add(nhanVienHanhChanh);
			}
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public List<NhanVienKyThuat> getListNhanVienKyThuat(){
		List<NhanVienKyThuat> list = new ArrayList<NhanVienKyThuat>();
		Connection con = ConnectDatabase.getConnection();
		String sql = "select * from NhanVien as nv join NhanVienKyThuat as nvkt on nv.maNV = nvkt.maNV";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNV(rs.getInt("maNV"));
				nhanVien.setTenNV(rs.getString("tenNV"));
				nhanVien.setChucVu(rs.getString("chucVu"));
				nhanVien.setEmail(rs.getString("email"));
				nhanVien.setGioiTinh(rs.getString("gioiTinh"));
				nhanVien.setRole(rs.getString("role"));
				nhanVien.setDiaChi(rs.getString("diaChi"));
				nhanVien.setSoDienThoai(rs.getString("soDienThoai"));
				NhanVienKyThuat nhanVienKyThuat = new NhanVienKyThuat();
				nhanVienKyThuat.setNhanVien(nhanVien);
				nhanVienKyThuat.setBacTho(rs.getString("bacTho"));
				nhanVienKyThuat.setSoNamKinhNghiem(rs.getInt("soNamKinhNghiem"));
				list.add(nhanVienKyThuat);
			}
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public boolean createNhanVienHC(NhanVienHanhChanh nhanVienHanhChanh) {
		int nv_id = 0;
		String sql = "insert into NhanVien(tenNV,chucVu,soDienThoai,email,diaChi,gioiTinh,role) values(?,?,?,?,?,?,?)";
		String sql1 = "insert into NhanVienHanhChanh values(?,?,?)";
		Connection con = ConnectDatabase.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nhanVienHanhChanh.getNhanVien().getTenNV());
			stmt.setString(2, nhanVienHanhChanh.getNhanVien().getChucVu());
			stmt.setString(3, nhanVienHanhChanh.getNhanVien().getSoDienThoai());
			stmt.setString(4, nhanVienHanhChanh.getNhanVien().getEmail());
			stmt.setString(5, nhanVienHanhChanh.getNhanVien().getDiaChi());
			stmt.setString(6, nhanVienHanhChanh.getNhanVien().getGioiTinh());
			stmt.setString(7, nhanVienHanhChanh.getNhanVien().getRole());
			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if(generatedKeys.next()) {
				nv_id = generatedKeys.getInt(1);
			}
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.setInt(1, nv_id);
			stmt1.setInt(2, nhanVienHanhChanh.getPhongBan().getMaPhongBan());
			stmt1.setString(3, nhanVienHanhChanh.getTrinhDoHocVan());
			stmt1.executeUpdate();
			return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateNhanVienHanhChanh(NhanVienHanhChanh nhanVienHanhChanh) {
		String sql1 = "update NhanVien set tenNV = ?, gioiTinh = ?, soDienThoai = ?, diaChi=?,email = ? ,chucVu=? where maNV = ?";
		String sql2 = "update NhanVienHanhChanh set maNV = ?, maPhongBan =?, trinhDoHocVan=? where maNV = ?";
		Connection con = ConnectDatabase.getConnection();
		try {
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.setString(1, nhanVienHanhChanh.getNhanVien().getTenNV());
			stmt1.setString(2, nhanVienHanhChanh.getNhanVien().getGioiTinh());
			stmt1.setString(3,nhanVienHanhChanh.getNhanVien().getSoDienThoai());
			stmt1.setString(4, nhanVienHanhChanh.getNhanVien().getDiaChi());
			stmt1.setString(5, nhanVienHanhChanh.getNhanVien().getEmail());
			stmt1.setString(6, nhanVienHanhChanh.getNhanVien().getChucVu());
			stmt1.setInt(7, nhanVienHanhChanh.getNhanVien().getMaNV());
			stmt1.executeUpdate();
			
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			stmt2.setInt(1, nhanVienHanhChanh.getNhanVien().getMaNV());
			stmt2.setInt(2, nhanVienHanhChanh.getPhongBan().getMaPhongBan());
			stmt2.setString(3, nhanVienHanhChanh.getTrinhDoHocVan());
			stmt2.setInt(4, nhanVienHanhChanh.getNhanVien().getMaNV());
			stmt2.executeUpdate();
			
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteNhanVienHC(int maNV) {
		String sql1 = "delete from NhanVienHanhChanh where maNV = ?";
		String sql2 = "delete from NhanVien where maNV = ?";
		Connection con = ConnectDatabase.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(sql1);
			stmt.setInt(1, maNV);
			stmt.executeUpdate();
			PreparedStatement stmt1 = con.prepareStatement(sql2);
			stmt1.setInt(1, maNV);
			stmt1.executeUpdate();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public List<NhanVienHanhChanh> searchNhanVienHC(String search){
		List<NhanVienHanhChanh> list = new ArrayList<NhanVienHanhChanh>();
		Connection con = ConnectDatabase.getConnection();
		String sql = "select * from NhanVien as nv join NhanVienHanhChanh as nvhc on nv.maNV = nvhc.maNV join PhongBan as pb on nvhc.maPhongBan= pb.maPhongBan where tenNV like '%"+search+"%'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNV(rs.getInt("maNV"));
				nhanVien.setTenNV(rs.getString("tenNV"));
				nhanVien.setChucVu(rs.getString("chucVu"));
				nhanVien.setEmail(rs.getString("email"));
				nhanVien.setGioiTinh(rs.getString("gioiTinh"));
				nhanVien.setRole(rs.getString("role"));
				nhanVien.setSoDienThoai(rs.getString("soDienThoai"));
				nhanVien.setDiaChi(rs.getString("diaChi"));
				PhongBan phongBan = new PhongBan();
				phongBan.setMaPhongBan(rs.getInt("maPhongBan"));
				phongBan.setTenPhongBan(rs.getString("tenPhongBan"));
				NhanVienHanhChanh nhanVienHanhChanh = new NhanVienHanhChanh();
				nhanVienHanhChanh.setNhanVien(nhanVien);
				nhanVienHanhChanh.setPhongBan(phongBan);
				nhanVienHanhChanh.setTrinhDoHocVan(rs.getString("trinhDoHocVan"));
				list.add(nhanVienHanhChanh);
			}
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public List<NhanVienKyThuat> getNhanVienKyThuat(){
		List<NhanVienKyThuat> list = new ArrayList<NhanVienKyThuat>();
		Connection con = ConnectDatabase.getConnection();
		String sql = "select * from NhanVien as nv join NhanVienKyThuat as nvkt on nv.maNV = nvkt.maNV";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNV(rs.getInt("maNV"));
				nhanVien.setTenNV(rs.getString("tenNV"));
				nhanVien.setChucVu(rs.getString("chucVu"));
				nhanVien.setEmail(rs.getString("email"));
				nhanVien.setGioiTinh(rs.getString("gioiTinh"));
				nhanVien.setRole(rs.getString("role"));
				nhanVien.setSoDienThoai(rs.getString("soDienThoai"));
				nhanVien.setDiaChi(rs.getString("diaChi"));
				NhanVienKyThuat nhanVienKyThuat = new NhanVienKyThuat();
				nhanVienKyThuat.setBacTho(rs.getString("bacTho"));
				nhanVienKyThuat.setNhanVien(nhanVien);
				nhanVienKyThuat.setSoNamKinhNghiem(rs.getInt("soNamKinhNghiem"));
				list.add(nhanVienKyThuat);
			}
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
}
}
