/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import dao.DAO_LoaiXe;
import dao.DAO_XeMay;
import entity.LoaiXe;
import entity.NhanVien;
import entity.XeMay;

/**
 *
 * @author Lenovo
 */
public class QuanLyXeMayFrame extends javax.swing.JFrame {

	DefaultTableModel tableModel;
	List<XeMay> listXeMay;
	List<LoaiXe> listLoai;
	DAO_XeMay dao_xeMay = new DAO_XeMay();
	DAO_LoaiXe dao_LoaiXe = new DAO_LoaiXe();
	String path = "";
	NumberFormat formatter = new DecimalFormat("#0.00");
	NhanVien nhanVien;
    /**
     * Creates new form NewJFrame
     */
    public QuanLyXeMayFrame(NhanVien nhanVien) {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        tableModel = (DefaultTableModel) tableXeMay.getModel();
        showData();
        loadCbLoaiXe();
        reset();
        this.nhanVien = nhanVien;
    }

    private void showData() {
    	listXeMay = dao_xeMay.getDanhSachXeMay();
    	tableModel.setRowCount(0);
    	for(XeMay item: listXeMay) {
    		tableModel.addRow(new Object[] {item.getLoaiXe().getTenLoai(), item.getMaXe(), item.getTenXe(), item.getSoPK(),item.getMauXe(),item.getNuocSanXuat(),formatter.format(item.getDongia())});
    	}
    }
    private void loadCbLoaiXe() {
    	cbLoaiXe.removeAllItems();
    	listLoai = dao_LoaiXe.getalltbLoaiXe();
    	listLoai.forEach(item -> {
    		cbLoaiXe.addItem(item.getTenLoai());
    	});
    }
    private void reset() {
    	txtMauXe.setEnabled(false);
    	txtMaXe.setEnabled(false);
    	txtNuocSanXuat.setEnabled(false);
    	txtSoPK.setEnabled(false);
    	txtTenXe.setEnabled(false);
    	txtĐongia.setEnabled(false);
    	txtMauXe.setText("");
    	txtMaXe.setText("");
    	txtNuocSanXuat.setText("");
    	txtSoPK.setText("");
    	txtTenXe.setText("");
    	txtĐongia.setText("");
    	txtMauXe.setBorder(new LineBorder(Color.black));
    	txtMaXe.setBorder(new LineBorder(Color.black));
    	txtNuocSanXuat.setBorder(new LineBorder(Color.black));
    	txtSoPK.setBorder(new LineBorder(Color.black));
    	txtTenXe.setBorder(new LineBorder(Color.black));
    	txtĐongia.setBorder(new LineBorder(Color.black));
    	btnLuu.setEnabled(false);
    	btnSua.setEnabled(false);
    	btnXoa.setEnabled(false);
    	btnReset.setEnabled(false);
    	labelHinhAnh.setIcon(null);
    }
    private int regex() {
    	String mauXe = txtMauXe.getText();
    	String tenXe = txtTenXe.getText();
    	String nuocSanXuat = txtNuocSanXuat.getText();
    	String soPK = txtSoPK.getText();
    	String donGia = txtĐongia.getText();
    	int a = 0;
    	if(mauXe.equals("")) {
    		JOptionPane.showMessageDialog(this, "Màu xe không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtMauXe.setBorder(new LineBorder(Color.red));
    		a = a +1;
    	}else {
    		txtMauXe.setBorder(new LineBorder(Color.green));
    		
		}
    	if(tenXe.equals("")) {
    		JOptionPane.showMessageDialog(this, "Tên xe không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtTenXe.setBorder(new LineBorder(Color.red));
    		a = a +1;
    	}else {
    		txtTenXe.setBorder(new LineBorder(Color.green));
    		
		}
    	if(nuocSanXuat.equals("")) {
    		JOptionPane.showMessageDialog(this, "Nước sản xuất không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtNuocSanXuat.setBorder(new LineBorder(Color.red));
    		a = a +1;
    	}else {
    		txtNuocSanXuat.setBorder(new LineBorder(Color.green));
    		
		}
    	if(soPK.equals("")) {
    		JOptionPane.showMessageDialog(this, "Số phân khối không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtSoPK.setBorder(new LineBorder(Color.red));
    		a = a +1;
    	}else {
    		txtSoPK.setBorder(new LineBorder(Color.green));
    		
		}
    	if(donGia.equals("")) {
    		JOptionPane.showMessageDialog(this, "Đơn giá không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtĐongia.setBorder(new LineBorder(Color.red));
    		a = a +1;
    	}else {
    		txtĐongia.setBorder(new LineBorder(Color.green));
		}
    	if (path.equals("")) {
    		JOptionPane.showMessageDialog(this, "Bạn chưa chọn hình ảnh","Error!",JOptionPane.ERROR_MESSAGE);
    		txtĐongia.setBorder(new LineBorder(Color.red));
    		a = a +1;
		}
    	return a;
    }
    private void clickBtnThem() {
    	reset();
    	txtMauXe.setEnabled(true);
    	txtNuocSanXuat.setEnabled(true);
    	txtSoPK.setEnabled(true);
    	txtTenXe.setEnabled(true);
    	txtĐongia.setEnabled(true);
    	btnReset.setEnabled(true);
    	btnLuu.setEnabled(true);
    }
    private boolean checkStatusBtnLuu() {
    	String maXe = txtMaXe.getText();
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
    private void clickBtnChonAnh() {
    	JFileChooser chooser = new JFileChooser();
    	chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        chooser.setDialogTitle("Chọn ảnh");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image","jpg", "png");
        chooser.addChoosableFileFilter(filter);

        int result = chooser.showSaveDialog(null);
        File file = chooser.getSelectedFile();
        String filename = file.getName();
        if(filename.endsWith(".jpg")||filename.endsWith(".JPG")||filename.endsWith(".png")||filename.endsWith(".PNG")){
            if(result == JFileChooser.APPROVE_OPTION){
                path = file.getAbsolutePath();
                ImageIcon imgIcon = new ImageIcon(path);
                Image img = imgIcon.getImage();

                Image newImg = img.getScaledInstance(labelHinhAnh.getWidth(), labelHinhAnh.getHeight(), Image.SCALE_SMOOTH);

                ImageIcon icon = new ImageIcon(newImg);
                labelHinhAnh.setIcon(icon);

            }
        }else
        JOptionPane.showMessageDialog(this,"Chọn sai tệp, vui lòng chọn tệp hình ảnh");
    }
    private void clickBtnLuu() {
    	String tenLoai = cbLoaiXe.getSelectedItem().toString();
    	String mauXe = txtMauXe.getText();
    	String tenXe = txtTenXe.getText();
    	String nuocSanXuat = txtNuocSanXuat.getText();
    	String soPK = txtSoPK.getText();
    	String donGia = txtĐongia.getText();
    	if(checkStatusBtnLuu() == true) {
    		if(regex() == 0 && notify("", "Bạn có chắc muốn lưu thông tin vừa nhập không ?") == 0) {
    			XeMay xeMay = new XeMay();
    			listLoai.forEach(item -> {
    				xeMay.setLoaiXe(item);
    			});
    			xeMay.setDongia(Double.valueOf(donGia));
    			xeMay.setMauXe(mauXe);
    			xeMay.setNuocSanXuat(nuocSanXuat);
    			xeMay.setSoPK(Integer.parseInt(soPK));
    			xeMay.setTenXe(tenXe);
    			if(dao_xeMay.insertXeMay(xeMay, path)) {
    				JOptionPane.showMessageDialog(this, "Thêm thành công!!");
    			}else {
    				JOptionPane.showMessageDialog(this, "Thêm không thành công! Hãy thử lại");
				}
    		}
    	}else {
    		XeMay xeMay = new XeMay();
    		listLoai.forEach(item -> {
    			xeMay.setLoaiXe(item);
    		});
    		xeMay.setMaXe(Integer.parseInt(txtMaXe.getText()));
    		xeMay.setDongia(Double.valueOf(donGia));
    		xeMay.setMauXe(mauXe);
    		xeMay.setNuocSanXuat(nuocSanXuat);
    		xeMay.setSoPK(Integer.parseInt(soPK));
    		xeMay.setTenXe(tenXe);
    		if (regex() == 0 && notify("", "Bạn có chắc muốn lưu thay đổi không?") == 0) {
    			if(dao_xeMay.updateXeMay(xeMay, path)) {
    				JOptionPane.showMessageDialog(this, "Thêm thành công!!");
    			}else {
    				JOptionPane.showMessageDialog(this, "Thêm không thành công! Hãy thử lại");
				}
			}
    	}
    	showData();
    	reset();
    }
    private void clickItemTable() {
    	int index = tableXeMay.getSelectedRow();
    	txtMauXe.setText(listXeMay.get(index).getMauXe());
    	txtMaXe.setText(String.valueOf(listXeMay.get(index).getMaXe()));
    	txtNuocSanXuat.setText(listXeMay.get(index).getNuocSanXuat());
    	txtSoPK.setText(String.valueOf(listXeMay.get(index).getSoPK()));
    	txtTenXe.setText(listXeMay.get(index).getTenXe());
    	txtĐongia.setText(formatter.format(listXeMay.get(index).getDongia()));
    	cbLoaiXe.setSelectedItem(listXeMay.get(index).getLoaiXe().getTenLoai());
    	btnSua.setEnabled(true);
    	btnXoa.setEnabled(true);
    	btnReset.setEnabled(true);
    	txtMauXe.setEnabled(false);
    	txtMaXe.setEnabled(false);
    	txtNuocSanXuat.setEnabled(false);
    	txtSoPK.setEnabled(false);
    	txtTenXe.setEnabled(false);
    	txtĐongia.setEnabled(false);
    	try {
    		path = dao_xeMay.getImage(listXeMay.get(index).getMaXe());
    		ImageIcon icon = new ImageIcon(path);
			Image img = icon.getImage();
			Image newImg = img.getScaledInstance(labelHinhAnh.getWidth(), labelHinhAnh.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon imgIcon = new ImageIcon(newImg);
			labelHinhAnh.setIcon(imgIcon);
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void clickBtnSua() {
    	txtMauXe.setEnabled(true);
    	txtNuocSanXuat.setEnabled(true);
    	txtSoPK.setEnabled(true);
    	txtTenXe.setEnabled(true);
    	txtĐongia.setEnabled(true);
    	btnReset.setEnabled(true);
    	btnLuu.setEnabled(true);
    }
    private void clickBtnXoa() throws HeadlessException, SQLException {
    	String maXe = txtMaXe.getText();
    	if(notify("", "Bạn có chắc muốn xóa sản phẩm này không ?") == 0) {
    		boolean success =  dao_xeMay.deleteXeMay(Integer.parseInt(maXe));
    		if(success == true) {
    			JOptionPane.showMessageDialog(this,"Bạn đã xóa thành công!");
    			showData();
    		}else {
    			JOptionPane.showMessageDialog(this,"Lỗi không thể xóa!","", JOptionPane.ERROR_MESSAGE);
    			showData();
			}
    	}
    	reset();
    }
    private void searchSanPham() {
    	String textSearch = txtTenSPTimKiem.getText();
    	listXeMay = dao_xeMay.getListXeMayByTen("'%"+ textSearch+"%'");
    	tableModel.setRowCount(0);
    	for(XeMay item: listXeMay) {
    		tableModel.addRow(new Object[] {item.getLoaiXe().getTenLoai(), item.getMaXe(), item.getTenXe(), item.getSoPK(),item.getMauXe(),item.getNuocSanXuat(),formatter.format(item.getDongia())});
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

        panelQuanLySP = new javax.swing.JPanel();
        labelQLSP = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThoat = new javax.swing.JButton();
        labelHinhAnh = new javax.swing.JLabel();
        labelMaSP = new javax.swing.JLabel();
        txtMaXe = new javax.swing.JTextField();
        labelTenSP = new javax.swing.JLabel();
        txtTenXe = new javax.swing.JTextField();
        labelDonGia = new javax.swing.JLabel();
        txtSoPK = new javax.swing.JTextField();
        txtNuocSanXuat = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtTenSPTimKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        labelTenSPTimKiem = new javax.swing.JLabel();
        labelLoaiSP = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        cbLoaiXe = new javax.swing.JComboBox<>();
        txtMauXe = new javax.swing.JTextField();
        labelDonGia1 = new javax.swing.JLabel();
        labelSoLuongTon1 = new javax.swing.JLabel();
        labelTrangThai1 = new javax.swing.JLabel();
        txtĐongia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableXeMay = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelQuanLySP.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labelQLSP.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelQLSP.setText("QUẢN LÝ XE MÁY");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        labelHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHinhAnh.setText("Ảnh");
        labelHinhAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelMaSP.setText("Mã xe");

        labelTenSP.setText("Tên xe");

        labelDonGia.setText("Số phân khối");

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fix.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnReset.setText("Quay lại");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        labelTenSPTimKiem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTenSPTimKiem.setText("Tên Sản Phẩm");

        labelLoaiSP.setText("Loại Xe");

        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        cbLoaiXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLoaiXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoaiXeActionPerformed(evt);
            }
        });

        labelDonGia1.setText("Màu xe");

        labelSoLuongTon1.setText("Nước sản xuất");

        labelTrangThai1.setText("Đơn giá");

        javax.swing.GroupLayout panelQuanLySPLayout = new javax.swing.GroupLayout(panelQuanLySP);
        panelQuanLySP.setLayout(panelQuanLySPLayout);
        panelQuanLySPLayout.setHorizontalGroup(
            panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelQuanLySPLayout.createSequentialGroup()
                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(labelDonGia1)
                                .addGap(18, 18, 18)
                                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMauXe, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(122, 122, 122)
                                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(112, 112, 112)
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                        .addComponent(labelLoaiSP)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                                        .addComponent(labelDonGia)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSoPK, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelSoLuongTon1)
                                .addGap(18, 18, 18)
                                .addComponent(txtNuocSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(197, 197, 197)
                                .addComponent(labelTrangThai1)
                                .addGap(18, 18, 18)
                                .addComponent(txtĐongia, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(400, 400, 400)
                        .addComponent(labelMaSP)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201)
                        .addComponent(labelTenSP)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenXe, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnThoat)
                        .addGap(370, 370, 370)
                        .addComponent(labelQLSP)))
                .addGap(51, 51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuanLySPLayout.createSequentialGroup()
                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnChonAnh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTenSPTimKiem)
                    .addComponent(txtTenSPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        panelQuanLySPLayout.setVerticalGroup(
            panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuanLySPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThoat)
                    .addComponent(labelQLSP))
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(labelMaSP)
                            .addComponent(txtMaXe)
                            .addComponent(labelTenSP)
                            .addComponent(txtTenXe)
                            .addComponent(labelLoaiSP)
                            .addComponent(cbLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDonGia)
                            .addComponent(txtSoPK)
                            .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelTrangThai1)
                                .addComponent(txtĐongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNuocSanXuat)
                                .addComponent(labelSoLuongTon1)))
                        .addGap(39, 39, 39)
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDonGia1)
                            .addComponent(txtMauXe)))
                    .addComponent(labelHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelQuanLySPLayout.createSequentialGroup()
                        .addComponent(labelTenSPTimKiem)
                        .addGap(18, 18, 18)
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTim, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenSPTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(panelQuanLySPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua)
                            .addComponent(btnLuu)
                            .addComponent(btnReset)
                            .addComponent(btnXoa)
                            .addComponent(btnThem)))
                    .addComponent(btnChonAnh))
                .addContainerGap())
        );

        tableXeMay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên loại", "Mã xe", "Tên xe", "Số phân khối", "Màu xe", "Nước sản xuất", "Đơn giá"
            }
        ));
        tableXeMay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCNNCCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableXeMay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelQuanLySP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelQuanLySP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableCNNCCMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
    	clickItemTable();
	}
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
    	dispose();
        new Home(nhanVien).setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
			clickBtnXoa();
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    	clickBtnSua();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
    	clickBtnLuu();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    	reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
    	searchSanPham();
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
    	clickBtnChonAnh();
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    	clickBtnThem();
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbLoaiXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLoaiXeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLoaiXeActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyXeMayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyXeMayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyXeMayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyXeMayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new QuanLyXeMayFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbLoaiXe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDonGia;
    private javax.swing.JLabel labelDonGia1;
    private javax.swing.JLabel labelHinhAnh;
    private javax.swing.JLabel labelLoaiSP;
    private javax.swing.JLabel labelMaSP;
    private javax.swing.JLabel labelQLSP;
    private javax.swing.JLabel labelSoLuongTon1;
    private javax.swing.JLabel labelTenSP;
    private javax.swing.JLabel labelTenSPTimKiem;
    private javax.swing.JLabel labelTrangThai1;
    private javax.swing.JPanel panelQuanLySP;
    private javax.swing.JTable tableXeMay;
    private javax.swing.JTextField txtMaXe;
    private javax.swing.JTextField txtMauXe;
    private javax.swing.JTextField txtNuocSanXuat;
    private javax.swing.JTextField txtSoPK;
    private javax.swing.JTextField txtTenSPTimKiem;
    private javax.swing.JTextField txtTenXe;
    private javax.swing.JTextField txtĐongia;
    // End of variables declaration//GEN-END:variables
}
