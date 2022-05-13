package entity;

import java.util.Date;

public class HDTraGop {
	private HopDong hopDong;
	private int soLanTra;
	private double soTienTra;
	
	public HDTraGop() {
		// TODO Auto-generated constructor stub
	}

	public HDTraGop(HopDong hopDong, int soLanTra, double soTienTra) {
		super();
		this.hopDong = hopDong;
		this.soLanTra = soLanTra;
		this.soTienTra = soTienTra;
	}
	public HopDong getHopDong() {
		return hopDong;
	}

	public void setHopDong(HopDong hopDong) {
		this.hopDong = hopDong;
	}

	public int getSoLanTra() {
		return soLanTra;
	}

	public void setSoLanTra(int soLanTra) {
		this.soLanTra = soLanTra;
	}

	public double getSoTienTra() {
		return soTienTra;
	}

	public void setSoTienTra(double soTienTra) {
		this.soTienTra = soTienTra;
	}
}
