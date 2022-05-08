package entity;

public class TaiKhoan {
	private int id;
	private NhanVien nhanVien;
	private String password;
	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(int id, NhanVien nhanVien, String password) {
		super();
		this.id = id;
		this.nhanVien = nhanVien;
		this.password = password;
	}
	public TaiKhoan(NhanVien nhanVien, String password) {
		super();
		this.nhanVien = nhanVien;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "TaiKhoan [id=" + id + ", nhanVien=" + nhanVien + ", password=" + password + "]";
	}
	

}
