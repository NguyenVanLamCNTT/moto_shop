package entity;

public class ChiTietHopDong {
	private HopDong hopDong;
	private XeMay xeMay;
	private int soLuong;
	
	public ChiTietHopDong() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHopDong(HopDong hopDong, XeMay xeMay, int soLuong) {
		super();
		this.hopDong = hopDong;
		this.xeMay = xeMay;
		this.soLuong = soLuong;
	}

	public HopDong getHopDong() {
		return hopDong;
	}

	public void setHopDong(HopDong hopDong) {
		this.hopDong = hopDong;
	}

	public XeMay getXeMay() {
		return xeMay;
	}

	public void setXeMay(XeMay xeMay) {
		this.xeMay = xeMay;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietHopDong [hopDong=" + hopDong + ", xeMay=" + xeMay + ", soLuong=" + soLuong + "]";
	}
	

}
