package entity;

public class LinhKien {

	private int maLinhKien;
	private String tenLinhKien;
	private PhieuNhanXet phieuNhanXet;

	public LinhKien() {
		// TODO Auto-generated constructor stub
	}

	public LinhKien(int maLinhKien, String tenLinhKien, PhieuNhanXet phieuNhanXet) {
		super();
		this.maLinhKien = maLinhKien;
		this.tenLinhKien = tenLinhKien;
		this.phieuNhanXet = phieuNhanXet;
	}

	public int getMaLinhKien() {
		return maLinhKien;
	}

	public void setMaLinhKien(int maLinhKien) {
		this.maLinhKien = maLinhKien;
	}

	public String getTenLinhKien() {
		return tenLinhKien;
	}

	public void setTenLinhKien(String tenLinhKien) {
		this.tenLinhKien = tenLinhKien;
	}

	public PhieuNhanXet getPhieuNhanXet() {
		return phieuNhanXet;
	}

	public void setPhieuNhanXet(PhieuNhanXet phieuNhanXet) {
		this.phieuNhanXet = phieuNhanXet;
	}

	@Override
	public String toString() {
		return "LinhKien [maLinhKien=" + maLinhKien + ", tenLinhKien=" + tenLinhKien + ", phieuNhanXet=" + phieuNhanXet
				+ "]";
	}
	
	
}
