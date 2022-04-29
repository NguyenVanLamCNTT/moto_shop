package entity;

public class LoaiXe {
	private int maLoai;
	private String tenLoai;
	public LoaiXe(int maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	
	public LoaiXe() {
		// TODO Auto-generated constructor stub
	}

	public LoaiXe(String tenLoai) {
		super();
		this.tenLoai = tenLoai;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@Override
	public String toString() {
		return "LoaiXe [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
	}
	

}
