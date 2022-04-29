package entity;

public class KhachHang {
	private int maKH;
	private String tenKH;
	private String diaChi;
	private String soDienThoai;
	public KhachHang(int maKH, String tenKH, String diaChi, String soDienThoai) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}
	public KhachHang(String tenKH, String diaChi, String soDienThoai) {
		super();
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai
				+ "]";
	}
	
	

}
