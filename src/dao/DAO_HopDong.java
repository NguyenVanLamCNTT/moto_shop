package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListCellRenderer;

import entity.ChiTietHopDong;
import entity.HDTraGop;
import entity.HopDong;
import entity.KhachHang;
import entity.NhanVien;
import entity.XeMay;
import util.ConnectDatabase;

public class DAO_HopDong {
	
	public DAO_HopDong() {
		// TODO Auto-generated constructor stub
	}
	
	public List<ChiTietHopDong> getDSHopDong(){
		List<ChiTietHopDong> list = new ArrayList<ChiTietHopDong>();
		Connection con = ConnectDatabase.getConnection();
		String sql = "select * from HopDong as hd join ChiTietHopDong as cthd on hd.maHD = cthd.maHD join XeMay as xm on xm.maXe = cthd.maXe";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ChiTietHopDong cthd = new ChiTietHopDong();
				NhanVien nhanVien = new NhanVien();
				KhachHang khachHang = new KhachHang();
				XeMay xeMay =new XeMay();
				HopDong hopDong = new HopDong();
				nhanVien.setMaNV(rs.getInt("maNV"));
				khachHang.setMaKH(rs.getInt("maKH"));	
				xeMay.setMaXe(rs.getInt("maXe"));
				hopDong.setMaHD(rs.getInt("maHD"));
				hopDong.setNgayLap(rs.getDate("ngayLap"));
				hopDong.setLoaiHopDong(rs.getString("loaiHopDong"));
				hopDong.setKhachHang(khachHang);
				hopDong.setNhanVien(nhanVien);
				hopDong.setSoTienDaThanhToan(rs.getDouble("soTienDaThanhToan"));
				hopDong.setSoTienPhaiThanhToan(rs.getDouble("soTienPhaiThanhToan"));
				hopDong.setThoiGianBaoHanh(rs.getString("thoiGianBaoHanh"));
				cthd.setHopDong(hopDong);
				cthd.setXeMay(xeMay);
				list.add(cthd);
			}
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public boolean createHopDong(int maXe, HopDong hopDong, int soLanTra, double soTienTra) {
		int maHD = 0;
		String sql1 = "insert into HopDong(ngayLap,soTienPhaiThanhToan,soTienDaThanhToan,thoiGianBaoHanh,maKH,maNV,loaiHopDong) values(?,?,?,?,?,?,?)";
		String sql2 = "insert into ChiTietHopDong(maHD, maXe) values(?,?)";
		String sql3 = "insert into HDTraGop(maHD,soLanTra,soTienTra) values (?,?,?)";
		Connection con = ConnectDatabase.getConnection();
		try {
			PreparedStatement stmt1 = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			stmt1.setDate(1, (Date) hopDong.getNgayLap());
			stmt1.setDouble(2, hopDong.getSoTienPhaiThanhToan());
			stmt1.setDouble(3, hopDong.getSoTienDaThanhToan());
			stmt1.setString(4, hopDong.getThoiGianBaoHanh());
			stmt1.setInt(5, hopDong.getKhachHang().getMaKH());
			stmt1.setInt(6, hopDong.getNhanVien().getMaNV());
			stmt1.setString(7, hopDong.getLoaiHopDong());
			stmt1.executeUpdate();
			ResultSet keys = stmt1.getGeneratedKeys();
			if(keys.next()) {
				maHD = keys.getInt(1);
			}
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			stmt2.setInt(1, maHD);
			stmt2.setInt(2, maXe);
			stmt2.executeUpdate();
			if(soLanTra != 0) {
				PreparedStatement stmt3 = con.prepareStatement(sql3);
				stmt3.setInt(1, maHD);
				stmt3.setInt(2, soLanTra);
				stmt3.setDouble(3, soTienTra);
				stmt3.executeUpdate();
			}
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public HDTraGop getHDTraGop(int maHD) {
		List<HDTraGop> list = new ArrayList<HDTraGop>();
		String sql = "select * from HDTraGop where maHD = " + maHD;
		Connection con = ConnectDatabase.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				HDTraGop hd = new HDTraGop();
				hd.setSoLanTra(rs.getInt("soLanTra"));
				hd.setSoTienTra(rs.getDouble("soTienTra"));
				list.add(hd);
			}
			return list.get(0);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public List<ChiTietHopDong> searchHopDongTheoNgay(Date date){
		List<ChiTietHopDong> list = new ArrayList<ChiTietHopDong>();
		Connection con = ConnectDatabase.getConnection();
		String sql = "select * from HopDong as hd join ChiTietHopDong as cthd on hd.maHD = cthd.maHD join XeMay as xm on xm.maXe = cthd.maXe where ngayLap = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDate(1, date);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ChiTietHopDong cthd = new ChiTietHopDong();
				NhanVien nhanVien = new NhanVien();
				KhachHang khachHang = new KhachHang();
				XeMay xeMay =new XeMay();
				HopDong hopDong = new HopDong();
				nhanVien.setMaNV(rs.getInt("maNV"));
				khachHang.setMaKH(rs.getInt("maKH"));	
				xeMay.setMaXe(rs.getInt("maXe"));
				hopDong.setMaHD(rs.getInt("maHD"));
				hopDong.setNgayLap(rs.getDate("ngayLap"));
				hopDong.setLoaiHopDong(rs.getString("loaiHopDong"));
				hopDong.setKhachHang(khachHang);
				hopDong.setNhanVien(nhanVien);
				hopDong.setSoTienDaThanhToan(rs.getDouble("soTienDaThanhToan"));
				hopDong.setSoTienPhaiThanhToan(rs.getDouble("soTienPhaiThanhToan"));
				hopDong.setThoiGianBaoHanh(rs.getString("thoiGianBaoHanh"));
				cthd.setHopDong(hopDong);
				cthd.setXeMay(xeMay);
				list.add(cthd);
			}
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
