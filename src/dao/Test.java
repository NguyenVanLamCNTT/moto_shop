package dao;

import java.util.List;

import entity.KhachHang;
import entity.LoaiXe;
import entity.NhanVien;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO_NhanVien dao = new DAO_NhanVien(); 
		
		System.out.println(dao.create(new NhanVien("Lam", "Quan Ly", "0985140102", "lam@gmail.com", "Nam", "admin")));
//		List<KhachHang> list = dao.getalltbNhanVien();
//		list.forEach(item -> {
//			System.out.println(item.toString());
//		});
	}

}
