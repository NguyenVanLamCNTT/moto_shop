package entity;

public class NhanVienKyThuat {

	private NhanVien nhanVien;
	private String bacTho;
	private int soNamKinhNghiem;
	
	public NhanVienKyThuat() {
		// TODO Auto-generated constructor stub
	}

	public NhanVienKyThuat(NhanVien nhanVien, String bacTho, int soNamKinhNghiem) {
		super();
		this.nhanVien = nhanVien;
		this.bacTho = bacTho;
		this.soNamKinhNghiem = soNamKinhNghiem;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getBacTho() {
		return bacTho;
	}

	public void setBacTho(String bacTho) {
		this.bacTho = bacTho;
	}

	public int getSoNamKinhNghiem() {
		return soNamKinhNghiem;
	}

	public void setSoNamKinhNghiem(int soNamKinhNghiem) {
		this.soNamKinhNghiem = soNamKinhNghiem;
	}

	@Override
	public String toString() {
		return "NhanVienKyThuat [nhanVien=" + nhanVien + ", bacTho=" + bacTho + ", soNamKinhNghiem=" + soNamKinhNghiem
				+ "]";
	}
	
}
