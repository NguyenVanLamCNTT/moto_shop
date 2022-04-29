package entity;

import java.util.Date;

public class HDTraGop {
	private int id;
	private HopDong hopDong;
	private int soLanTra;
	private Date ngayTra;
	private double soTienTra;
	
	public HDTraGop() {
		// TODO Auto-generated constructor stub
	}

	public HDTraGop(int id, HopDong hopDong, int soLanTra, Date ngayTra, double soTienTra) {
		super();
		this.id = id;
		this.hopDong = hopDong;
		this.soLanTra = soLanTra;
		this.ngayTra = ngayTra;
		this.soTienTra = soTienTra;
	}

	public HDTraGop(HopDong hopDong, int soLanTra, Date ngayTra, double soTienTra) {
		super();
		this.hopDong = hopDong;
		this.soLanTra = soLanTra;
		this.ngayTra = ngayTra;
		this.soTienTra = soTienTra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public double getSoTienTra() {
		return soTienTra;
	}

	public void setSoTienTra(double soTienTra) {
		this.soTienTra = soTienTra;
	}

	@Override
	public String toString() {
		return "HDTraGop [id=" + id + ", hopDong=" + hopDong + ", soLanTra=" + soLanTra + ", ngayTra=" + ngayTra
				+ ", soTienTra=" + soTienTra + "]";
	}
	
	
}
