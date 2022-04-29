package entity;

public class PhieuNhanXet {

	private int maPhieu;
	private String liDoBH;
	private String loiThuocVe;
	private double giaTien;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	
	public PhieuNhanXet() {
		// TODO Auto-generated constructor stub
	}

	public PhieuNhanXet(int maPhieu, String liDoBH, String loiThuocVe, double giaTien, NhanVien nhanVien,
			KhachHang khachHang) {
		super();
		this.maPhieu = maPhieu;
		this.liDoBH = liDoBH;
		this.loiThuocVe = loiThuocVe;
		this.giaTien = giaTien;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}
	

	public PhieuNhanXet(String liDoBH, String loiThuocVe, double giaTien, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.liDoBH = liDoBH;
		this.loiThuocVe = loiThuocVe;
		this.giaTien = giaTien;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}

	public int getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(int maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getLiDoBH() {
		return liDoBH;
	}

	public void setLiDoBH(String liDoBH) {
		this.liDoBH = liDoBH;
	}

	public String getLoiThuocVe() {
		return loiThuocVe;
	}

	public void setLoiThuocVe(String loiThuocVe) {
		this.loiThuocVe = loiThuocVe;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
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

	@Override
	public String toString() {
		return "PhieuNhanXet [maPhieu=" + maPhieu + ", liDoBH=" + liDoBH + ", loiThuocVe=" + loiThuocVe + ", giaTien="
				+ giaTien + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + "]";
	}
	
}
