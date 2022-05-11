/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.DAO_NhanVien;
import dao.DAO_PhongBan;
import entity.NhanVien;
import entity.NhanVienHanhChanh;
import entity.NhanVienKyThuat;
import entity.PhongBan;

/**
 *
 * @author Admin
 */
public class QuanLyNhanVien extends javax.swing.JFrame {

	List<NhanVienKyThuat> listNVKT;
	List<NhanVienHanhChanh> listNVHC;
	List<PhongBan> listPhongBan;
	DefaultTableModel tableModelHC;
	DefaultTableModel tableModelKT;
	DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
	DAO_PhongBan dao_PhongBan = new DAO_PhongBan();
	int maPB;
	String gioiTinh;
	String role;
    /**
     * Creates new form QuanLyNhanVien
     */
    public QuanLyNhanVien() {
        initComponents();
        this.setLocationRelativeTo(null);
        tableModelHC = (DefaultTableModel) tableNVHC.getModel();
        tableModelKT = (DefaultTableModel) talbeNVKT.getModel();
        showDataNVHC();
        loadCbPhongBan();
        reset();
    }
    private void showDataNVHC(){
    	listNVHC = dao_NhanVien.getListNhanVienHanhChanh();
    	tableModelHC.setRowCount(0);
    	listNVHC.forEach(item -> {
    		tableModelHC.addRow(new Object[] {item.getNhanVien().getMaNV(),item.getNhanVien().getTenNV(),item.getNhanVien().getGioiTinh(),item.getNhanVien().getSoDienThoai(),item.getNhanVien().getDiaChi(),item.getNhanVien().getEmail(),item.getNhanVien().getChucVu(),item.getNhanVien().getRole(),item.getPhongBan().getTenPhongBan(),item.getTrinhDoHocVan()});
    	});
    }

    private void loadCbPhongBan() {
    	cboPhongBan.removeAllItems();
    	listPhongBan = dao_PhongBan.getAllPhongBan();
    	listPhongBan.forEach(item -> {
    		cboPhongBan.addItem(item.getTenPhongBan());
    	});
    }
    private void reset() {
    	txtmaNVHC.setText("");
    	txtChucVuNVHC.setText("");
    	txtDiaChiNVHC.setText("");
    	txtEmailNVHC.setText("");
    	txtsoDTNVHC.setText("");
    	txttenNVHC.setText("");
    	//border
    	txtmaNVHC.setBorder(new LineBorder(Color.black));
    	txtChucVuNVHC.setBorder(new LineBorder(Color.black));
    	txtDiaChiNVHC.setBorder(new LineBorder(Color.black));
    	txtEmailNVHC.setBorder(new LineBorder(Color.black));
    	txtsoDTNVHC.setBorder(new LineBorder(Color.black));
    	txttenNVHC.setBorder(new LineBorder(Color.black));
    	//enable
    	txtmaNVHC.setEnabled(false);
    	txtChucVuNVHC.setEnabled(false);
    	txtDiaChiNVHC.setEnabled(false);
    	txtEmailNVHC.setEnabled(false);
    	txtsoDTNVHC.setEnabled(false);
    	txttenNVHC.setEnabled(false);
    	btnLuuNVHC.setEnabled(false);
    	btnSuaNVHC.setEnabled(false);
    	btnXoaNVHC.setEnabled(false);
    }
    private int regex() {
    	String maNVHC = txtmaNVHC.getText();
    	String tenNVHC = txttenNVHC.getText();
    	String chucVu = txtChucVuNVHC.getText();
    	String diaChi = txtDiaChiNVHC.getText();
    	String soDienThoai = txtsoDTNVHC.getText();
    	String email = txtEmailNVHC.getText();
    	int a = 0;
    	if(tenNVHC.equals("")) {
    		JOptionPane.showMessageDialog(this, "Tên không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txttenNVHC.setBorder(new LineBorder(Color.red));
    		a = a +1;
    	}else {
    		txttenNVHC.setBorder(new LineBorder(Color.green));
    		
		}
    	if(chucVu.equals("")) {
    		JOptionPane.showMessageDialog(this, "Chức vụ không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtChucVuNVHC.setBorder(new LineBorder(Color.red));
    		a = a +1;
    	}else {
    		txtChucVuNVHC.setBorder(new LineBorder(Color.green));
    		
		}
    	if(diaChi.equals("")) {
    		JOptionPane.showMessageDialog(this, "Địa chỉ không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtDiaChiNVHC.setBorder(new LineBorder(Color.red));
    		a = a +1;
    	}else {
    		txtDiaChiNVHC.setBorder(new LineBorder(Color.green));
    		
		}
    	if(soDienThoai.equals("")) {
    		JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtsoDTNVHC.setBorder(new LineBorder(Color.red));
    		a = a +1;
    	}else {
    		txtsoDTNVHC.setBorder(new LineBorder(Color.green));
    		
		}
    	if(email.equals("")) {
    		JOptionPane.showMessageDialog(this, "Email không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtEmailNVHC.setBorder(new LineBorder(Color.red));
    		a = a +1;
    	}else {
    		txtEmailNVHC.setBorder(new LineBorder(Color.green));
    		
		}
    	return a;
    }
    private void clickBtnThem() {
    	reset();
    	txtChucVuNVHC.setEnabled(true);
    	txtDiaChiNVHC.setEnabled(true);
    	txtEmailNVHC.setEnabled(true);
    	txtsoDTNVHC.setEnabled(true);
    	txttenNVHC.setEnabled(true);
    	btnQuayLaiNVHC.setEnabled(true);
    	btnLuuNVHC.setEnabled(true);
    }
    private boolean checkStatusBtnLuu() {
    	String maXe = txtmaNVHC.getText();
    	if(maXe.equals("") == false) {
    		return false;
    	}else {
    		return true;
    	}
    }
    private int notify(String title, String message) {
    	int n = JOptionPane.showConfirmDialog(this, message,title,JOptionPane.YES_NO_OPTION);
    	return n;
    }
    
    private void clickBtnLuu() {
    	String maNVHC = txtmaNVHC.getText();
    	String tenNVHC = txttenNVHC.getText();
    	String chucVu = txtChucVuNVHC.getText();
    	String diaChi = txtDiaChiNVHC.getText();
    	String soDienThoai = txtsoDTNVHC.getText();
    	String email = txtEmailNVHC.getText();
    	
    	listPhongBan.forEach(item -> {
    		if (item.getTenPhongBan().equals(cboPhongBan.getSelectedItem().toString())) {
				maPB = item.getMaPhongBan();
			}
    	});
    	String trinhDo = jComboBox1.getSelectedItem().toString();
    	String role = cboRoleNVHC.getSelectedItem().toString();
    	if(role.equals("Quản Lý")) {
    		this.role = "admin";
    	}else if(role.equals("Hành Chánh")) {
    		this.role = "nvhc";
    	}else {
    		this.role = "nvkt";
    	}
    	if(checkStatusBtnLuu() == true) {
    		if(regex() == 0 && notify("", "Bạn có chắc muốn lưu thông tin vừa nhập không ?") == 0) {
    			NhanVien nhanVien = new NhanVien(tenNVHC, chucVu, soDienThoai, email, gioiTinh, this.role, diaChi);
    			PhongBan phanBan = new PhongBan();
    			phanBan.setMaPhongBan(maPB);
    			if(dao_NhanVien.createNhanVienHC(new NhanVienHanhChanh(nhanVien, phanBan, trinhDo))) {
    				JOptionPane.showMessageDialog(this, "Thêm thành công!!");
    			}else {
    				JOptionPane.showMessageDialog(this, "Thêm không thành công! Hãy thử lại");
				}
    		}
    	}else {
    		if (regex() == 0 && notify("", "Bạn có chắc muốn lưu thay đổi không?") == 0) {
    			NhanVien nhanVien = new NhanVien(tenNVHC, chucVu, soDienThoai, email, trinhDo, role, diaChi);
    			nhanVien.setMaNV(Integer.parseInt(maNVHC));
    			PhongBan phongBan = new PhongBan();
    			phongBan.setMaPhongBan(maPB);
    			if(dao_NhanVien.updateNhanVienHanhChanh(new NhanVienHanhChanh(nhanVien, phongBan, trinhDo))==true) {
    				JOptionPane.showMessageDialog(this, "Thêm thành công!!");
    			}else {
    				JOptionPane.showMessageDialog(this, "Thêm không thành công! Hãy thử lại");
				}
    		}
    	}
    	showDataNVHC();
    	reset();
    }
    private void clickRadio() {
    	if (radNamNVHC.isSelected()) {
			radNuNVHC.setSelected(false);
			gioiTinh = "Nam";
		}else {
			radNamNVHC.setSelected(false);
    		gioiTinh = "Nữ";
		}
    }
    private String getRole(String role) {
    	if(role.equals("admin")) {
    		return "Quản lý";
    	}else if(role.equals("nvhc")) {
    		return "Hành Chánh";
    	}else {
    		return "Kĩ thuật";
    	}
    }
    private void getGioiTinh(String gioiTinh) {
    	if(gioiTinh.equals("Nam")) {
    		radNamNVHC.setSelected(true);
    		clickRadio();
    	}else {
    		radNuNVHC.setEnabled(true);
    		clickRadio();
    	}
    }
    private void selectItemHC() {
    	int index  = tableNVHC.getSelectedRow();
    	txtChucVuNVHC.setText(listNVHC.get(index).getNhanVien().getChucVu());
    	txtDiaChiNVHC.setText(listNVHC.get(index).getNhanVien().getDiaChi());
    	txtEmailNVHC.setText(listNVHC.get(index).getNhanVien().getEmail());
    	txtmaNVHC.setText(String.valueOf(listNVHC.get(index).getNhanVien().getMaNV()));
    	txtsoDTNVHC.setText(listNVHC.get(index).getNhanVien().getSoDienThoai());
    	txttenNVHC.setText(listNVHC.get(index).getNhanVien().getTenNV());
    	cboPhongBan.setSelectedItem(listNVHC.get(index).getPhongBan().getTenPhongBan());
    	getGioiTinh(listNVHC.get(index).getNhanVien().getGioiTinh());
    	cboRoleNVHC.setSelectedItem(getRole(listNVHC.get(index).getNhanVien().getRole()));
    	jComboBox1.setSelectedItem(listNVHC.get(index).getTrinhDoHocVan());
    	txtmaNVHC.setEnabled(false);
    	txtChucVuNVHC.setEnabled(false);
    	txtDiaChiNVHC.setEnabled(false);
    	txtEmailNVHC.setEnabled(false);
    	txtsoDTNVHC.setEnabled(false);
    	txttenNVHC.setEnabled(false);
    	btnLuuNVHC.setEnabled(false);
    	btnSuaNVHC.setEnabled(true);
    	btnXoaNVHC.setEnabled(true);
    	
    }
    private void clickBtnSua() {
    	txtChucVuNVHC.setEnabled(true);
    	txtDiaChiNVHC.setEnabled(true);
    	txtEmailNVHC.setEnabled(true);
    	txtsoDTNVHC.setEnabled(true);
    	txttenNVHC.setEnabled(true);
    	btnLuuNVHC.setEnabled(true);
    }
    private void  clickBtnXoa() {
    	int maNV = Integer.parseInt(txtmaNVHC.getText());
    	if(notify("", "Bạn có chắc muốn xóa sản phẩm này không ?") == 0) {
    		boolean success =  dao_NhanVien.deleteNhanVienHC(maNV);
    		if(success == true) {
    			JOptionPane.showMessageDialog(this,"Bạn đã xóa thành công!");
    			showDataNVHC();
    		}else {
    			JOptionPane.showMessageDialog(this,"Lỗi không thể xóa!","", JOptionPane.ERROR_MESSAGE);
    			showDataNVHC();
			}
    	}
    	reset();
    }
    private void searchNhanVien() {
    	String textSearch = txtTimNVHC.getText();
    	listNVHC = dao_NhanVien.searchNhanVienHC(textSearch);
    	tableModelHC.setRowCount(0);
    	listNVHC.forEach(item -> {
    		tableModelHC.addRow(new Object[] {item.getNhanVien().getMaNV(),item.getNhanVien().getTenNV(),item.getNhanVien().getGioiTinh(),item.getNhanVien().getSoDienThoai(),item.getNhanVien().getDiaChi(),item.getNhanVien().getEmail(),item.getNhanVien().getChucVu(),item.getNhanVien().getRole(),item.getPhongBan().getTenPhongBan(),item.getTrinhDoHocVan()});
    	});
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        pnMainNVHC = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThoatNVHC = new javax.swing.JButton();
        lbltieudeNVHC = new javax.swing.JLabel();
        btnThemNVHC = new javax.swing.JButton();
        btnXoaNVHC = new javax.swing.JButton();
        btnSuaNVHC = new javax.swing.JButton();
        btnLuuNVHC = new javax.swing.JButton();
        btnQuayLaiNVHC = new javax.swing.JButton();
        lblMaNVHC = new javax.swing.JLabel();
        txtmaNVHC = new javax.swing.JTextField();
        lbltenNVHC = new javax.swing.JLabel();
        txttenNVHC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblsoDTNVHC = new javax.swing.JLabel();
        txtsoDTNVHC = new javax.swing.JTextField();
        lblGioiTinhNVHC = new javax.swing.JLabel();
        radNamNVHC = new javax.swing.JRadioButton();
        radNuNVHC = new javax.swing.JRadioButton();
        lblDiaChiNVHC = new javax.swing.JLabel();
        txtDiaChiNVHC = new javax.swing.JTextField();
        lblEmailNVHC = new javax.swing.JLabel();
        txtEmailNVHC = new javax.swing.JTextField();
        lblPhongBan = new javax.swing.JLabel();
        cboPhongBan = new javax.swing.JComboBox<>();
        lblRoleNVHC = new javax.swing.JLabel();
        cboRoleNVHC = new javax.swing.JComboBox<>();
        lblChucVuNVHC = new javax.swing.JLabel();
        txtChucVuNVHC = new javax.swing.JTextField();
        lblTrinhDoNVHC = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblTimNVHC = new javax.swing.JLabel();
        txtTimNVHC = new javax.swing.JTextField();
        btnTimNVHC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNVHC = new javax.swing.JTable();
        pnNhanVienKT = new javax.swing.JPanel();
        btnThoatNVKT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblMaNVKT = new javax.swing.JLabel();
        txtMaNVKT = new javax.swing.JTextField();
        lblTenNVKT = new javax.swing.JLabel();
        txtTenNVKT = new javax.swing.JTextField();
        lblSoDTNVKT = new javax.swing.JLabel();
        txtSoDTNVKT = new javax.swing.JTextField();
        lblDiaChiNVKT = new javax.swing.JLabel();
        txtDiaChiNVKT = new javax.swing.JTextField();
        lblGioiTinhNVKT = new javax.swing.JLabel();
        radNamNVKT = new javax.swing.JRadioButton();
        radNuNVKT = new javax.swing.JRadioButton();
        lblEmailNVKT = new javax.swing.JLabel();
        txtEmailNVKT = new javax.swing.JTextField();
        lblChucVuNVKT = new javax.swing.JLabel();
        cboChucVuNVKT = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        lblBacThoNVKT = new javax.swing.JLabel();
        cboBacThoNVKT = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        lbltimNVKT = new javax.swing.JLabel();
        txtTimNVKT = new javax.swing.JTextField();
        btnTimNVKT = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        talbeNVKT = new javax.swing.JTable();
        txtSoNamKinhNghiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMainNVHC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThoatNVHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoatNVHC.setText("Thoát");

        lbltieudeNVHC.setBackground(new java.awt.Color(0, 204, 204));
        lbltieudeNVHC.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbltieudeNVHC.setForeground(new java.awt.Color(0, 102, 102));
        lbltieudeNVHC.setText("Nhân Viên Hành Chánh");

        btnThemNVHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThemNVHC.setText("Thêm");

        btnXoaNVHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnXoaNVHC.setText("Xóa");

        btnSuaNVHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fix.png"))); // NOI18N
        btnSuaNVHC.setText("Sửa");

        btnLuuNVHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png"))); // NOI18N
        btnLuuNVHC.setText("Lưu");

        btnQuayLaiNVHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnQuayLaiNVHC.setText("Quay Lại");

        lblMaNVHC.setText("Mã Nhân Viên: ");

        txtmaNVHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaNVHCActionPerformed(evt);
            }
        });

        lbltenNVHC.setText("Tên Nhân Viên:");

        lblsoDTNVHC.setText("Số ĐT:");

        lblGioiTinhNVHC.setText("Giới Tính:");

        radNamNVHC.setText("Nam");

        radNuNVHC.setText("Nữ");

        lblDiaChiNVHC.setText("Địa Chỉ: ");

        lblEmailNVHC.setText("Email:");

        lblPhongBan.setText("Phong ban:");

        cboPhongBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chuc vu 1", "Chuc vu  2", "Chuc vu  3", "Chuc vu 4" }));

        lblRoleNVHC.setText("Role:");

        cboRoleNVHC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Hành Chánh", "Kĩ Thuật"}));

        lblChucVuNVHC.setText("Chức vụ:");

        lblTrinhDoNVHC.setText("Trình Độ:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trung Học", "Cao Đẳng", "Đại Học" }));

        lblTimNVHC.setText("Tìm Kiếm Nhân Viên");

        btnTimNVHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-search-20.png"))); // NOI18N
        btnTimNVHC.setText("Tìm");
        radNamNVHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cickRadioNamHC(evt);
            }

			private void cickRadioNamHC(ActionEvent evt) {
				clickRadio();
				
			}
        });
        radNuNVHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cickRadioNuHC(evt);
            }

			private void cickRadioNuHC(ActionEvent evt) {
				clickRadio();
				
			}
        });
        btnLuuNVHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	clickLuu(evt);
            }

			private void clickLuu(ActionEvent evt) {
				clickBtnLuu();
				
			}
        });
        btnThemNVHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	clickThem(evt);
            }

			private void clickThem(ActionEvent evt) {
				clickBtnThem();
				
			}
        });
        tableNVHC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHCMouseClicked(evt);
            }

			private void tableHCMouseClicked(MouseEvent evt) {
				// TODO Auto-generated method stub
				selectItemHC();
			}
        });
        btnSuaNVHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	clickSua(evt);
            }
			private void clickSua(ActionEvent evt) {
				clickBtnSua();
			}
        });

        btnQuayLaiNVHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	clickQuayLai(evt);
            }
			private void clickQuayLai(ActionEvent evt) {
				reset();
			}
        });
        btnXoaNVHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	clickXoa(evt);
            }
			private void clickXoa(ActionEvent evt) {
				clickBtnXoa();
			}
        });
        btnTimNVHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	clickTim(evt);
            }
			private void clickTim(ActionEvent evt) {
				searchNhanVien();
			}
        });
        javax.swing.GroupLayout pnMainNVHCLayout = new javax.swing.GroupLayout(pnMainNVHC);
        pnMainNVHC.setLayout(pnMainNVHCLayout);
        pnMainNVHCLayout.setHorizontalGroup(
            pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMainNVHCLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnThemNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btnXoaNVHC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuaNVHC)
                        .addGap(230, 230, 230)
                        .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                    .addGap(155, 155, 155)
                                    .addComponent(btnQuayLaiNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnMainNVHCLayout.createSequentialGroup()
                                        .addComponent(lblChucVuNVHC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtChucVuNVHC))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnMainNVHCLayout.createSequentialGroup()
                                        .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDiaChiNVHC)
                                            .addComponent(lblEmailNVHC)
                                            .addComponent(lblRoleNVHC))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDiaChiNVHC)
                                            .addComponent(txtEmailNVHC)
                                            .addComponent(cboRoleNVHC, 0, 191, Short.MAX_VALUE)))))
                            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                .addComponent(btnLuuNVHC)
                                .addGap(229, 229, 229))))
                    .addGroup(pnMainNVHCLayout.createSequentialGroup()
                        .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnThoatNVHC)
                                .addGap(224, 224, 224)
                                .addComponent(lbltieudeNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                        .addComponent(lbltenNVHC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txttenNVHC))
                                    .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                        .addComponent(lblMaNVHC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtmaNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnMainNVHCLayout.createSequentialGroup()
                                        .addGap(144, 144, 144)
                                        .addComponent(lblsoDTNVHC)
                                        .addGap(67, 67, 67))
                                    .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(120, 120, 120))
                                            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblPhongBan)
                                                    .addComponent(lblGioiTinhNVHC))
                                                .addGap(18, 18, 18))
                                            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                                .addComponent(lblTrinhDoNVHC)
                                                .addGap(18, 18, 18)))
                                        .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                                .addComponent(radNamNVHC)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(radNuNVHC))
                                            .addComponent(txtsoDTNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cboPhongBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                                    .addGap(1, 1, 1)
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addGap(0, 658, Short.MAX_VALUE))
                    .addGroup(pnMainNVHCLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTimNVHC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(538, 538, 538)))
                .addGap(32, 32, 32))
        );
        pnMainNVHCLayout.setVerticalGroup(
            pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoatNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltieudeNVHC))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMainNVHCLayout.createSequentialGroup()
                        .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaNVHC)
                                    .addComponent(txtmaNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(lblsoDTNVHC)
                                    .addComponent(txtsoDTNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltenNVHC)
                                    .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblGioiTinhNVHC)
                                        .addComponent(radNamNVHC)
                                        .addComponent(radNuNVHC))))
                            .addComponent(txttenNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(lblPhongBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboPhongBan))
                        .addGap(18, 18, 18)
                        .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTrinhDoNVHC)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnQuayLaiNVHC)
                                    .addComponent(btnLuuNVHC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSuaNVHC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTimNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTimNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTimNVHC))
                                .addGap(43, 43, 43)
                                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnThemNVHC)
                                    .addComponent(btnXoaNVHC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnMainNVHCLayout.createSequentialGroup()
                        .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnMainNVHCLayout.createSequentialGroup()
                                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDiaChiNVHC)
                                    .addComponent(txtDiaChiNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEmailNVHC)
                                    .addComponent(txtEmailNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnMainNVHCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblRoleNVHC)
                                    .addComponent(cboRoleNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblChucVuNVHC))
                            .addComponent(txtChucVuNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tableNVHC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Số ĐT", "Địa Chỉ", "Email", "Chức Vụ", "Role", "Phòng Ban", "Trình Độ"
            }
        ));
        jScrollPane1.setViewportView(tableNVHC);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMainNVHC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnMainNVHC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("NhanVienHanhChanh", jPanel2);

        pnNhanVienKT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnThoatNVKT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoatNVKT.setText("Thoát");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Nhân Viên Kỹ Thuật");

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));

        lblMaNVKT.setText("Mã Nhân Viên:");

        lblTenNVKT.setText("Tên Nhân Viên:");

        lblSoDTNVKT.setText("Số ĐT:");

        lblDiaChiNVKT.setText("Địa Chỉ");

        lblGioiTinhNVKT.setText("Giới Tính");

        radNamNVKT.setText("Nam");

        radNuNVKT.setText("Nữ");

        lblEmailNVKT.setText("Email");

        lblChucVuNVKT.setText("Chức Vụ");

        cboChucVuNVKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chức vụ 1", "Chức vụ  2", "Chức vụ 3", "Chức vụ  4" }));

        jLabel3.setText("Role");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Role 1", "Role 2", "Role 3", "Role 4" }));

        lblBacThoNVKT.setText("Bậc Thợ");

        cboBacThoNVKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bậc 1", "Bậc 2", "Bậc 3", "Bậc 4" }));

        jLabel4.setText("Số Năm Kinh Nghiệm");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jButton1.setText("Thêm");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        jButton2.setText("Xóa");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fix.png"))); // NOI18N
        jButton3.setText("Sửa");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png"))); // NOI18N
        jButton4.setText("Lưu");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        jButton5.setText("Quay Lại");

        lbltimNVKT.setText("Tìm Nhân Viên Kỹ Thuật");

        btnTimNVKT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-search-20.png"))); // NOI18N
        btnTimNVKT.setText("Tìm");

        jSeparator3.setBackground(new java.awt.Color(51, 0, 0));

        talbeNVKT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Số ĐT", "Địa Chỉ", "Email", "Chức Vụ", "Role", "Bậc Thợ", "Số Năm KN"
            }
        ));
        jScrollPane2.setViewportView(talbeNVKT);

        javax.swing.GroupLayout pnNhanVienKTLayout = new javax.swing.GroupLayout(pnNhanVienKT);
        pnNhanVienKT.setLayout(pnNhanVienKTLayout);
        pnNhanVienKTLayout.setHorizontalGroup(
            pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThoatNVKT)
                        .addGap(344, 344, 344)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                        .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                                        .addComponent(lbltimNVKT)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTimNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(btnTimNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(136, 136, 136)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(178, 178, 178))))
                            .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                                        .addComponent(lblTenNVKT)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTenNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                                        .addComponent(lblMaNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaNVKT)))
                                .addGap(107, 107, 107)
                                .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSoDTNVKT)
                                    .addComponent(lblGioiTinhNVKT)
                                    .addComponent(lblChucVuNVKT)
                                    .addComponent(lblBacThoNVKT))
                                .addGap(30, 30, 30)
                                .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                                        .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                                                .addComponent(radNamNVKT)
                                                .addGap(18, 18, 18)
                                                .addComponent(radNuNVKT))
                                            .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cboChucVuNVKT, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cboBacThoNVKT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(27, 27, 27))
                                    .addComponent(txtSoDTNVKT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                                .addGap(338, 338, 338)
                                .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(lblEmailNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(38, 38, 38)
                                .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmailNVKT)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSoNamKinhNghiem)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNhanVienKTLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNhanVienKTLayout.createSequentialGroup()
                                        .addComponent(lblDiaChiNVKT)
                                        .addGap(38, 38, 38)
                                        .addComponent(txtDiaChiNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNhanVienKTLayout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addGap(143, 143, 143)
                                        .addComponent(jButton4)
                                        .addGap(135, 135, 135)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)))))))
                .addGap(27, 27, 27))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane2)
        );
        pnNhanVienKTLayout.setVerticalGroup(
            pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoatNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                        .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaNVKT)
                            .addComponent(txtMaNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChiNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenNVKT)
                            .addComponent(txtTenNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmailNVKT)
                            .addComponent(txtEmailNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                            .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                                    .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSoDTNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblSoDTNVKT))
                                    .addGap(18, 18, 18))
                                .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                                    .addComponent(lblDiaChiNVKT)
                                    .addGap(18, 18, 18)))
                            .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(radNamNVKT)
                                .addComponent(radNuNVKT)
                                .addComponent(lblGioiTinhNVKT))
                            .addGap(29, 29, 29)
                            .addComponent(cboChucVuNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboBacThoNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(txtSoNamKinhNghiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnNhanVienKTLayout.createSequentialGroup()
                            .addComponent(lblChucVuNVKT)
                            .addGap(24, 24, 24)
                            .addComponent(lblBacThoNVKT))))
                .addGap(44, 44, 44)
                .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltimNVKT)
                    .addComponent(txtTimNVKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimNVKT))
                .addGap(35, 35, 35)
                .addGroup(pnNhanVienKTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("NhanVienKyThuat", pnNhanVienKT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmaNVHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaNVHCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaNVHCActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuuNVHC;
    private javax.swing.JButton btnQuayLaiNVHC;
    private javax.swing.JButton btnSuaNVHC;
    private javax.swing.JButton btnThemNVHC;
    private javax.swing.JButton btnThoatNVHC;
    private javax.swing.JButton btnThoatNVKT;
    private javax.swing.JButton btnTimNVHC;
    private javax.swing.JButton btnTimNVKT;
    private javax.swing.JButton btnXoaNVHC;
    private javax.swing.JComboBox<String> cboBacThoNVKT;
    private javax.swing.JComboBox<String> cboChucVuNVKT;
    private javax.swing.JComboBox<String> cboPhongBan;
    private javax.swing.JComboBox<String> cboRoleNVHC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lblBacThoNVKT;
    private javax.swing.JLabel lblChucVuNVHC;
    private javax.swing.JLabel lblChucVuNVKT;
    private javax.swing.JLabel lblDiaChiNVHC;
    private javax.swing.JLabel lblDiaChiNVKT;
    private javax.swing.JLabel lblEmailNVHC;
    private javax.swing.JLabel lblEmailNVKT;
    private javax.swing.JLabel lblGioiTinhNVHC;
    private javax.swing.JLabel lblGioiTinhNVKT;
    private javax.swing.JLabel lblMaNVHC;
    private javax.swing.JLabel lblMaNVKT;
    private javax.swing.JLabel lblPhongBan;
    private javax.swing.JLabel lblRoleNVHC;
    private javax.swing.JLabel lblSoDTNVKT;
    private javax.swing.JLabel lblTenNVKT;
    private javax.swing.JLabel lblTimNVHC;
    private javax.swing.JLabel lblTrinhDoNVHC;
    private javax.swing.JLabel lblsoDTNVHC;
    private javax.swing.JLabel lbltenNVHC;
    private javax.swing.JLabel lbltieudeNVHC;
    private javax.swing.JLabel lbltimNVKT;
    private javax.swing.JPanel pnMainNVHC;
    private javax.swing.JPanel pnNhanVienKT;
    private javax.swing.JRadioButton radNamNVHC;
    private javax.swing.JRadioButton radNamNVKT;
    private javax.swing.JRadioButton radNuNVHC;
    private javax.swing.JRadioButton radNuNVKT;
    private javax.swing.JTable tableNVHC;
    private javax.swing.JTable talbeNVKT;
    private javax.swing.JTextField txtChucVuNVHC;
    private javax.swing.JTextField txtDiaChiNVHC;
    private javax.swing.JTextField txtDiaChiNVKT;
    private javax.swing.JTextField txtEmailNVHC;
    private javax.swing.JTextField txtEmailNVKT;
    private javax.swing.JTextField txtMaNVKT;
    private javax.swing.JTextField txtSoDTNVKT;
    private javax.swing.JTextField txtSoNamKinhNghiem;
    private javax.swing.JTextField txtTenNVKT;
    private javax.swing.JTextField txtTimNVHC;
    private javax.swing.JTextField txtTimNVKT;
    private javax.swing.JTextField txtmaNVHC;
    private javax.swing.JTextField txtsoDTNVHC;
    private javax.swing.JTextField txttenNVHC;
    // End of variables declaration//GEN-END:variables
}
