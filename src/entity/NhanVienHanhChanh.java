package entity;

public class NhanVienHanhChanh {
	private NhanVien nhanVien;
	private PhongBan phongBan;
	private String trinhDoHocVan;
	
	public NhanVienHanhChanh() {
		// TODO Auto-generated constructor stub
	}

	public NhanVienHanhChanh(NhanVien nhanVien, PhongBan phongBan, String trinhDoHocVan) {
		super();
		this.nhanVien = nhanVien;
		this.phongBan = phongBan;
		this.trinhDoHocVan = trinhDoHocVan;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public String getTrinhDoHocVan() {
		return trinhDoHocVan;
	}

	public void setTrinhDoHocVan(String trinhDoHocVan) {
		this.trinhDoHocVan = trinhDoHocVan;
	}

	@Override
	public String toString() {
		return "NhanVienHanhChanh [nhanVien=" + nhanVien + ", phongBan=" + phongBan + ", trinhDoHocVan=" + trinhDoHocVan
				+ "]";
	}
	
	
}
