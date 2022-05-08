package entity;

public class NhanVien {

	private int maNV;
	private String tenNV;
	private String chucVu;
	private String soDienThoai;
	private String email;
	private String gioiTinh;
	private String role;
	
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}
	public NhanVien(int maNV) {
		this.maNV = maNV;
	}
	public NhanVien(int maNV, String tenNV, String chucVu, String soDienThoai, String email, String gioiTinh,
			String role) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.chucVu = chucVu;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.role = role;
	}

	public NhanVien(String tenNV, String chucVu, String soDienThoai, String email, String gioiTinh, String role) {
		super();
		this.tenNV = tenNV;
		this.chucVu = chucVu;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.role = role;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", chucVu=" + chucVu + ", soDienThoai=" + soDienThoai
				+ ", email=" + email + ", gioiTinh=" + gioiTinh + ", role=" + role + "]";
	}
	
}
