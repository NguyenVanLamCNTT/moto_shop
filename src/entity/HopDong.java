package entity;

import java.util.Date;

public class HopDong {
	
	private int maHD;
	private Date ngayLap;
	private double soTienPhaiThanhToan;
	private double soTienDaThanhToan;
	private String thoiGianBaoHanh;
	private String loaiHopDong;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	public HopDong() {
		// TODO Auto-generated constructor stub
	}
	

	


	public HopDong(int maHD, Date ngayLap, double soTienPhaiThanhToan, double soTienDaThanhToan, String thoiGianBaoHanh,
			String loaiHopDong, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.soTienPhaiThanhToan = soTienPhaiThanhToan;
		this.soTienDaThanhToan = soTienDaThanhToan;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.loaiHopDong = loaiHopDong;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}





	public HopDong(Date ngayLap, double soTienPhaiThanhToan, double soTienDaThanhToan, String thoiGianBaoHanh,
			String loaiHopDong, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.ngayLap = ngayLap;
		this.soTienPhaiThanhToan = soTienPhaiThanhToan;
		this.soTienDaThanhToan = soTienDaThanhToan;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.loaiHopDong = loaiHopDong;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}





	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public double getSoTienPhaiThanhToan() {
		return soTienPhaiThanhToan;
	}

	public void setSoTienPhaiThanhToan(double soTienPhaiThanhToan) {
		this.soTienPhaiThanhToan = soTienPhaiThanhToan;
	}

	public double getSoTienDaThanhToan() {
		return soTienDaThanhToan;
	}

	public void setSoTienDaThanhToan(double soTienDaThanhToan) {
		this.soTienDaThanhToan = soTienDaThanhToan;
	}

	public String getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}


	public String getLoaiHopDong() {
		return loaiHopDong;
	}





	public void setLoaiHopDong(String loaiHopDong) {
		this.loaiHopDong = loaiHopDong;
	}
	

}
