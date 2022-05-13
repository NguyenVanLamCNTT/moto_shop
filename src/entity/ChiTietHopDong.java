package entity;

public class ChiTietHopDong {
	private HopDong hopDong;
	private XeMay xeMay;
	
	public ChiTietHopDong() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHopDong(HopDong hopDong, XeMay xeMay) {
		super();
		this.hopDong = hopDong;
		this.xeMay = xeMay;
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

}
