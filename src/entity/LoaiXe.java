package entity;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(maLoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiXe other = (LoaiXe) obj;
		return maLoai == other.maLoai;
	}
	

}
