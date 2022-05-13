/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.DAO_PhieuNhanXet;
import entity.KhachHang;
import entity.NhanVien;
import util.ConnectDatabase;

/**
 *
 * @author Admin
 */
public class PhieuNhanXet extends javax.swing.JFrame {
	DefaultTableModel tableModel;
	DAO_PhieuNhanXet dao_pnx = new DAO_PhieuNhanXet();
	List<entity.PhieuNhanXet> listPNX;
    public PhieuNhanXet() throws SQLException {
    	
	    initComponents();
	    setLocationRelativeTo(null);
	    tableModel = (DefaultTableModel) jTable1.getModel();
	    showData();
	    reset();
	}

	/**
     * Creates new form PhieuNhanXet
     */
	
	public void reset() {
		txtPhieuNXMaNV.setText("");
		txtMaKHPNX.setText("");
		txtMaPhieuNX.setText("");
		txtLoiThuocVePNX.setText("");
		txtAreaLyDoBHPNX.setText("");
		txtGiaTienPNX.setText("");
		txtPhieuNXMaNV.setEnabled(false);
		txtMaKHPNX.setEnabled(false);
		txtMaPhieuNX.setEnabled(false);
		txtLoiThuocVePNX.setEnabled(false);
		txtAreaLyDoBHPNX.setEnabled(false);
		txtGiaTienPNX.setEnabled(false);
		btnLuu.setEnabled(false);
		btnSuaPNX.setEnabled(false);
		btnXoaPNX.setEnabled(false);
		btnQuayLaiPNX.setEnabled(false);
		txtPhieuNXMaNV.setBorder(new LineBorder(Color.black));
		txtMaKHPNX.setBorder(new LineBorder(Color.black));
		txtMaPhieuNX.setBorder(new LineBorder(Color.black));
		txtLoiThuocVePNX.setBorder(new LineBorder(Color.black));
		txtAreaLyDoBHPNX.setBorder(new LineBorder(Color.black));
		txtGiaTienPNX.setBorder(new LineBorder(Color.black));
		
	}
	private void showData() throws SQLException {
		listPNX = dao_pnx.getAllPhieuNhanXet();
		tableModel.setRowCount(0);
		for(entity.PhieuNhanXet pnx  : listPNX) {
			tableModel.addRow(new Object[] {pnx.getNhanVien().getMaNV(), pnx.getKhachHang().getMaKH(), pnx.getMaPhieu(),
					pnx.getLiDoBH(), pnx.getLoiThuocVe(), pnx.getGiaTien()});
		}
		
		
	}
	public void regex() {
		int maPhieu = Integer.parseInt(txtMaPhieuNX.getText());
		String liDoBH = txtAreaLyDoBHPNX.getText();
		String loiThuocVe = txtLoiThuocVePNX.getText();
		double giaTien = Double.parseDouble(txtLoiThuocVePNX.getText());
		int nhanVien = Integer.parseInt(txtPhieuNXMaNV.getText());
		int khachHang = Integer.parseInt(txtMaKHPNX.getText());
		if(liDoBH.equals("")) {
			JOptionPane.showMessageDialog(this, "Lí do không được để trống","Error!",JOptionPane.ERROR_MESSAGE);
			txtAreaLyDoBHPNX.setBorder(new LineBorder(Color.red));
		}else {
			txtAreaLyDoBHPNX.setBorder(new LineBorder(Color.green));
		}
		if(maPhieu<=0) {
			JOptionPane.showMessageDialog(this, "Phải nhập mã phiếu ","Error!",JOptionPane.ERROR_MESSAGE);
			txtMaPhieuNX.setBorder(new LineBorder(Color.red));
		}else {
			txtMaPhieuNX.setBorder(new LineBorder(Color.green));
		}
		if(loiThuocVe.equals("")) {
			JOptionPane.showMessageDialog(this, "Không được để trống","Error!",JOptionPane.ERROR_MESSAGE);
			txtLoiThuocVePNX.setBorder(new LineBorder(Color.red));
		}else {
			txtLoiThuocVePNX.setBorder(new LineBorder(Color.green));
		}
		if(giaTien <=0)  {
			JOptionPane.showMessageDialog(this, "Giá tiền phải lớn hơn 0 ","Error!",JOptionPane.ERROR_MESSAGE);
			txtGiaTienPNX.setBorder(new LineBorder(Color.red));
		}else {
			txtGiaTienPNX.setBorder(new LineBorder(Color.green));
		}
		if(khachHang<=0) {
			JOptionPane.showMessageDialog(this, "Phải nhập mã khách hàng","Error!",JOptionPane.ERROR_MESSAGE);
			txtMaKHPNX.setBorder(new LineBorder(Color.red));
		}else {
			txtMaKHPNX.setBorder(new LineBorder(Color.green));
		}
		if(nhanVien<=0) {
			JOptionPane.showMessageDialog(this, "Phải nhập mã nhân viên","Error!",JOptionPane.ERROR_MESSAGE);
			txtPhieuNXMaNV.setBorder(new LineBorder(Color.red));
		}else {
			txtPhieuNXMaNV.setBorder(new LineBorder(Color.green));
		}
		
		
	}
	public boolean KTMaPhieu(int maPhieu) {
		for (entity.PhieuNhanXet pnx :listPNX) {
			if(maPhieu == pnx.getMaPhieu()) {
				JOptionPane.showMessageDialog(this, "Mã phiếu đã tồn tại","Error!",JOptionPane.ERROR_MESSAGE);
	    		txtMaPhieuNX.setBorder(new LineBorder(Color.red));
				return true;
			}
		}
		txtMaPhieuNX.setBorder(new LineBorder(Color.green));
		return false;
	}
	public boolean checkInput() {
		int maPhieu = Integer.parseInt(txtMaPhieuNX.getText());
		String liDoBH = txtAreaLyDoBHPNX.getText();
		String loiThuocVe = txtLoiThuocVePNX.getText();
		double giaTien = Double.parseDouble(txtLoiThuocVePNX.getText());
		int nhanVien = Integer.parseInt(txtPhieuNXMaNV.getText());
		int khachHang = Integer.parseInt(txtMaKHPNX.getText());
		
		if(maPhieu<=0 && liDoBH.equals("") && loiThuocVe.equals("") && giaTien<=0
				&& nhanVien<=0 && khachHang<=0) {
			return false;
		}else {
			return true;
		}
	}
	public boolean checkStatusBtnLuu(String maPhieu) {
		int select = jTable1.getSelectedRow();
		if(select ==-1) {
			return false;
		}else {
			if(maPhieu.equals("")) {
				return false;
			}else {
				return true;
			}
		}
	}
	public void clickBtnThem() {
		reset();
		txtPhieuNXMaNV.setEnabled(true);
		txtMaKHPNX.setEnabled(true);
		txtMaPhieuNX.setEnabled(true);
		txtLoiThuocVePNX.setEnabled(true);
		txtAreaLyDoBHPNX.setEnabled(true);
		txtGiaTienPNX.setEnabled(true);
		btnLuu.setEnabled(true);
		btnQuayLaiPNX.setEnabled(true);
	}
    private int notify(String title, String message) {
    	int n = JOptionPane.showConfirmDialog(this, message,title,JOptionPane.YES_NO_OPTION);
    	return n;
    }
    private void clickBtnLuu() throws SQLException{
    	String maPhieu = txtMaPhieuNX.getText();
    	String liDoBH = txtAreaLyDoBHPNX.getText();
    	String loiThuocVe = txtLoiThuocVePNX.getText();
    	double giaTien = Double.parseDouble(txtGiaTienPNX.getText());
    	int nhanVien = Integer.parseInt(txtPhieuNXMaNV.getText());
    	int khachHang = Integer.parseInt(txtMaKHPNX.getText());
    	entity.PhieuNhanXet pnx = new entity.PhieuNhanXet();
    	pnx.setGiaTien(giaTien);
    	pnx.setKhachHang(new KhachHang(khachHang));
    	pnx.setLiDoBH(liDoBH);
    	pnx.setLoiThuocVe(loiThuocVe);
    	pnx.setNhanVien(new NhanVien(nhanVien));
    	if(checkStatusBtnLuu(maPhieu)==true) {
    		regex();
    		if(checkInput()==true && notify("","Bạn có muốn lưu thay đổi không?")==0) {
    			dao_pnx.update(pnx);
    			showData();
    			reset();
    			JOptionPane.showMessageDialog(this,"Bạn đã lưu thành công!");
    		}
    	}else {
			System.out.println("asdasd");
			regex();
			System.out.println("asdasd");
			if(checkInput()==true && notify("","Bạn có muốn lưu thông tin vừa nhập không?")==0) {
    			dao_pnx.create(pnx);
    			showData();
    			reset();
    			JOptionPane.showMessageDialog(this,"Bạn đã lưu thành công!");
			}
		}
    }
	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnThoatPhieuNX = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblPhieuNXmaNV = new javax.swing.JLabel();
        txtPhieuNXMaNV = new javax.swing.JTextField();
        lblLyDoBHPNX = new javax.swing.JLabel();
        lblLoiThuocVePNX = new javax.swing.JLabel();
        txtLoiThuocVePNX = new javax.swing.JTextField();
        lblMaPhieuNX = new javax.swing.JLabel();
        txtMaPhieuNX = new javax.swing.JTextField();
        lblMaKHPNX = new javax.swing.JLabel();
        txtMaKHPNX = new javax.swing.JTextField();
        lblGiaTienPNX = new javax.swing.JLabel();
        txtGiaTienPNX = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaLyDoBHPNX = new javax.swing.JTextArea();
        btnThemPNX = new javax.swing.JButton();
        btnXoaPNX = new javax.swing.JButton();
        btnSuaPNX = new javax.swing.JButton();
        btnQuayLaiPNX = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Phiếu Nhận Xét");

        btnThoatPhieuNX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoatPhieuNX.setText("Thoát");
        btnThoatPhieuNX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }

			private void btnThoatActionPerformed(ActionEvent evt) {
				dispose();
				
			}
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        lblPhieuNXmaNV.setText("Mã Nhân Viên");

        lblLyDoBHPNX.setText("Lý Do Bảo Hành");

        lblLoiThuocVePNX.setText("Lỗi Thuộc Về");

        lblMaPhieuNX.setText("Mã Phiếu");

        lblMaKHPNX.setText("Mã Khách Hàng");

        lblGiaTienPNX.setText("Giá Tiền");

        txtAreaLyDoBHPNX.setColumns(20);
        txtAreaLyDoBHPNX.setRows(5);
        jScrollPane1.setViewportView(txtAreaLyDoBHPNX);

        btnThemPNX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThemPNX.setText("Thêm");
        btnThemPNX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }

			private void btnThemActionPerformed(ActionEvent evt) {
				clickBtnThem();
				btnThemPNX.setEnabled(false);
				btnThoatPhieuNX.setEnabled(false);
				
			}
        });

        btnXoaPNX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnXoaPNX.setText("Xóa");
        btnXoaPNX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btnXoaActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

			private void btnXoaActionPerformed(ActionEvent evt)throws SQLException {
				int maPhieu = Integer.parseInt(txtMaPhieuNX.getText());
		    	if(PhieuNhanXet.this.notify("","Bạn có chắc muốn xóa phiếu nhận xét này không ?") == 0) {
		    		boolean success =  dao_pnx.delete(maPhieu);
		    		if(success == true) {
		    			JOptionPane.showInputDialog( this,"Bạn đã xóa thành công!");
		    			showData();
		    		}else {
		    			JOptionPane.showInputDialog(this,"Lỗi không thể xóa!");
					}
		    	}
		    	reset();
				
			}
        });
        
        

        btnSuaPNX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fix.png"))); // NOI18N
        btnSuaPNX.setText("Sửa");
        btnSuaPNX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }

			private void btnSuaActionPerformed(ActionEvent evt) {
				txtPhieuNXMaNV.setEnabled(true);
				txtMaKHPNX.setEnabled(true);
				txtLoiThuocVePNX.setEnabled(true);
				txtAreaLyDoBHPNX.setEnabled(true);
				txtGiaTienPNX.setEnabled(true);
				btnLuu.setEnabled(true);
				
			}
        });

        btnQuayLaiPNX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnQuayLaiPNX.setText("Quay Lại");
        btnQuayLaiPNX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }

			private void btnQuayLaiActionPerformed(ActionEvent evt) {
				reset();
				btnThemPNX.setEnabled(true);
				btnThoatPhieuNX.setEnabled(true);
				
			}
        });

        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }

			private void btnLuuActionPerformed(ActionEvent evt) {
				try {
					clickBtnLuu();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				reset();
				
			}
        });
       
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblLyDoBHPNX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPhieuNXmaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblLoiThuocVePNX))
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLoiThuocVePNX, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(txtPhieuNXMaNV))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGiaTienPNX)
                            .addComponent(lblMaPhieuNX))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaPhieuNX)
                            .addComponent(txtGiaTienPNX, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lblMaKHPNX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaKHPNX, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThoatPhieuNX)
                .addGap(211, 211, 211)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnThemPNX)
                .addGap(62, 62, 62)
                .addComponent(btnXoaPNX)
                .addGap(68, 68, 68)
                .addComponent(btnSuaPNX)
                .addGap(73, 73, 73)
                .addComponent(btnQuayLaiPNX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLuu)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThoatPhieuNX, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhieuNXmaNV)
                    .addComponent(txtPhieuNXMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaPhieuNX)
                    .addComponent(txtMaPhieuNX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaKHPNX)
                    .addComponent(txtMaKHPNX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoiThuocVePNX)
                    .addComponent(txtLoiThuocVePNX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGiaTienPNX)
                    .addComponent(txtGiaTienPNX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(lblLyDoBHPNX)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemPNX, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaPNX, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaPNX, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuayLaiPNX, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu))
                .addGap(42, 42, 42))
        );

        btnLuu.getAccessibleContext().setAccessibleName("Lưu");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Mã Phiếu", "Mã Khách Hàng", "Lỗi Thuộc Về", "Giá Tiền"
            }
        ));
        jScrollPane2.setViewportView(jTable1);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }

			private void jTable1MouseClicked(MouseEvent evt) {
			
				int row = jTable1.getSelectedRow();
				if(row!=-1) {
					txtPhieuNXMaNV.setText(jTable1.getValueAt(row, 0).toString());
					txtMaPhieuNX.setText(jTable1.getValueAt(row, 1).toString());
					txtMaKHPNX.setText(jTable1.getValueAt(row, 2).toString());
					txtLoiThuocVePNX.setText(jTable1.getValueAt(row, 3).toString());
					txtGiaTienPNX.setText(jTable1.getValueAt(row, 4).toString());
					txtMaPhieuNX.setEditable(false);
					txtMaKHPNX.setEnabled(false);
					txtMaPhieuNX.setEnabled(false);
					txtLoiThuocVePNX.setEnabled(false);
					txtAreaLyDoBHPNX.setEnabled(false);
					txtGiaTienPNX.setEnabled(false);
					btnSuaPNX.setEnabled(true);
					btnXoaPNX.setEnabled(true);
					btnQuayLaiPNX.setEnabled(true);					
				}
				
				
			}
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
            java.util.logging.Logger.getLogger(PhieuNhanXet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuNhanXet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuNhanXet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuNhanXet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new PhieuNhanXet().setVisible(true);
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemPNX;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnQuayLaiPNX;
    private javax.swing.JButton btnSuaPNX;
    private javax.swing.JButton btnThoatPhieuNX;
    private javax.swing.JButton btnXoaPNX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblGiaTienPNX;
    private javax.swing.JLabel lblLoiThuocVePNX;
    private javax.swing.JLabel lblLyDoBHPNX;
    private javax.swing.JLabel lblMaKHPNX;
    private javax.swing.JLabel lblMaPhieuNX;
    private javax.swing.JLabel lblPhieuNXmaNV;
    private javax.swing.JTextArea txtAreaLyDoBHPNX;
    private javax.swing.JTextField txtGiaTienPNX;
    private javax.swing.JTextField txtLoiThuocVePNX;
    private javax.swing.JTextField txtMaKHPNX;
    private javax.swing.JTextField txtMaPhieuNX;
    private javax.swing.JTextField txtPhieuNXMaNV;
    // End of variables declaration//GEN-END:variables
}
