package entity;

import java.util.Arrays;

public class XeMay {
	private int maXe;
	private String tenXe;
	private int soPK;
	private byte[] hinhAnh;
	private String mauXe;
	private String nuocSanXuat;
	private double dongia;
	private LoaiXe loaiXe;
	
	public XeMay() {
		// TODO Auto-generated constructor stub
	}

	public XeMay(int maXe, String tenXe, int soPK, byte[] hinhAnh, String mauXe, String nuocSanXuat, double dongia,
			LoaiXe loaiXe) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.soPK = soPK;
		this.hinhAnh = hinhAnh;
		this.mauXe = mauXe;
		this.nuocSanXuat = nuocSanXuat;
		this.dongia = dongia;
		this.loaiXe = loaiXe;
	}

	public XeMay(String tenXe, int soPK, byte[] hinhAnh, String mauXe, String nuocSanXuat, double dongia,
			LoaiXe loaiXe) {
		super();
		this.tenXe = tenXe;
		this.soPK = soPK;
		this.hinhAnh = hinhAnh;
		this.mauXe = mauXe;
		this.nuocSanXuat = nuocSanXuat;
		this.dongia = dongia;
		this.loaiXe = loaiXe;
	}

	public int getMaXe() {
		return maXe;
	}

	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public int getSoPK() {
		return soPK;
	}

	public void setSoPK(int soPK) {
		this.soPK = soPK;
	}

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMauXe() {
		return mauXe;
	}

	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}

	public String getNuocSanXuat() {
		return nuocSanXuat;
	}

	public void setNuocSanXuat(String nuocSanXuat) {
		this.nuocSanXuat = nuocSanXuat;
	}

	public double getDongia() {
		return dongia;
	}

	public void setDongia(double dongia) {
		this.dongia = dongia;
	}

	public LoaiXe getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(LoaiXe loaiXe) {
		this.loaiXe = loaiXe;
	}

	@Override
	public String toString() {
		return "XeMay [maXe=" + maXe + ", tenXe=" + tenXe + ", soPK=" + soPK + ", hinhAnh=" + Arrays.toString(hinhAnh)
				+ ", mauXe=" + mauXe + ", nuocSanXuat=" + nuocSanXuat + ", dongia=" + dongia + ", loaiXe=" + loaiXe
				+ "]";
	}
	

}
