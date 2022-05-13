/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.DAO_HopDong;
import dao.DAO_KhachHang;
import dao.DAO_XeMay;
import entity.ChiTietHopDong;
import entity.HDTraGop;
import entity.HopDong;
import entity.KhachHang;
import entity.NhanVien;
import entity.XeMay;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Pv
 */
public class QuanLyHopDong extends javax.swing.JFrame {

	DAO_XeMay dao_XeMay = new DAO_XeMay();
	DAO_HopDong dao_HopDong = new DAO_HopDong();
	DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
	String path = "";
	List<ChiTietHopDong> list;
	DefaultTableModel tableModel;
	SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
	DecimalFormat formatterTien = new DecimalFormat("###,###,###");
	String loaiHD ="";
	Double soTienPhaiTra = 0.0;
	int maNV = 22;
	int maKH = 0;
	int maXe = 0;
	NhanVien nhanVien;
    /**
     * Creates new form QuanLyHopDong
     */
    public QuanLyHopDong(int maXe, NhanVien nhanVien) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        tableModel = (DefaultTableModel) tableHopDong.getModel();
        loadData();
        reset();
        clickBtnThem();
        DateNgayLapHoaDon.setDate(new Date());
        loadDetailXe(maXe);
        List<KhachHang> listKH =  dao_KhachHang.getalltbNhanVien();
    	this.maKH = listKH.get(0).getMaKH();
    	txtMaKhachHang2.setText(String.valueOf(maKH));
    	txtMaNhanVien.setText(String.valueOf(maNV));
    	this.maNV = nhanVien.getMaNV();
    	this.nhanVien = nhanVien;
    }
    public QuanLyHopDong(NhanVien nhanVien) {
        initComponents();
        setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tableHopDong.getModel();
        loadData();
        reset();
        this.nhanVien = nhanVien;
    }

    private void loadDetailXe(int maXe) {
    	XeMay xeMay = dao_XeMay.getXeMayByMaXe(maXe);
    	this.maXe = maXe;
    	this.soTienPhaiTra = xeMay.getDongia();
    	txtSoTienPhaiThanhToan.setText(formatterTien.format(soTienPhaiTra));
    	lblTenSanPham.setText(xeMay.getTenXe());
    	try {
    		path = dao_XeMay.getImage(maXe);
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
    private void loadData() {
    	list = dao_HopDong.getDSHopDong();
    	tableModel.setRowCount(0);
    	list.forEach(item -> {
    		tableModel.addRow(new Object[] {item.getHopDong().getMaHD(),formatter.format(item.getHopDong().getNgayLap()),formatterTien.format(item.getHopDong().getSoTienPhaiThanhToan()),formatterTien.format(item.getHopDong().getSoTienDaThanhToan()), item.getHopDong().getThoiGianBaoHanh(), item.getHopDong().getNhanVien().getMaNV(), item.getHopDong().getKhachHang().getMaKH(),item.getHopDong().getLoaiHopDong()});
    	});
    }

    private void clickBtnThem() {
    	reset();
    	txtSoTienDaThanhToan.setEnabled(true);
    	txtSoTienPhaiThanhToan.setEnabled(true);
    	txtThoiGianBaoHanh.setEnabled(true);
    	btnLuu.setEnabled(true);
    }
    private void ThemHoadon() {
    	dispose();
    	new BanHangFrame().setVisible(true);
    }
    private void reset() {
    	txtMaHopDong.setText("");
    	txtMaKhachHang2.setText("");
    	txtMaNhanVien.setText("");
    	txtSoLanTra.setText("");
    	txtSoTienDaThanhToan.setText("");
    	txtSoTienPhaiThanhToan.setText("");
    	txtSoTienTraMotLan.setText("");
    	txtThoiGianBaoHanh.setText("");
    	DateNgayLapHoaDon.setDate(null);
    	
    	DateNgayLapHoaDon.setEnabled(false);
    	txtMaHopDong.setEnabled(false);
    	txtMaKhachHang2.setEnabled(false);
    	txtMaNhanVien.setEnabled(false);
    	txtSoLanTra.setEnabled(false);
    	txtSoTienDaThanhToan.setEnabled(false);
    	txtSoTienPhaiThanhToan.setEnabled(false);
    	txtSoTienTraMotLan.setEnabled(false);
    	txtThoiGianBaoHanh.setEnabled(false);
    	btnLuu.setEnabled(false);
    	btnIn.setEnabled(false);
    	DateNgayLapHoaDon.setBorder(new LineBorder(Color.black));
    	txtSoTienDaThanhToan.setBorder(new LineBorder(Color.black));
    	txtThoiGianBaoHanh.setBorder(new LineBorder(Color.black));
    	txtSoLanTra.setBorder(new LineBorder(Color.black));
    }
    private void clickRadio() {
    	if (radTraDu.isSelected()) {
			radTraGop.setSelected(false);
			loaiHD = "Trả đủ";
		}else {
			radTraDu.setSelected(false);
    		loaiHD = "Trả góp"; 
    		txtSoLanTra.setEnabled(true);
    		txtSoTienTraMotLan.setEnabled(true);
		}
    }
    private int regex() {
    	int a = 0;
    	Date date = DateNgayLapHoaDon.getDate();
    	String soTienDaTra = txtSoTienDaThanhToan.getText();
    	String thoiGianBH = txtThoiGianBaoHanh.getText();
    	if (date == null) {
    		JOptionPane.showMessageDialog(this, "Ngày lập không chính xác","Error!",JOptionPane.ERROR_MESSAGE);
    		DateNgayLapHoaDon.setBorder(new LineBorder(Color.red));
    		a = a +1;
		}else {
    		DateNgayLapHoaDon.setBorder(new LineBorder(Color.green));
    		
		}
    	if(soTienDaTra.equals("")) {
    		JOptionPane.showMessageDialog(this, "Tên không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtSoTienDaThanhToan.setBorder(new LineBorder(Color.red));
    		a = a +1;
    	}else {
    		txtSoTienDaThanhToan.setBorder(new LineBorder(Color.green));
    		
		}
    	if(thoiGianBH.equals("")) {
    		JOptionPane.showMessageDialog(this, "Tên không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
    		txtThoiGianBaoHanh.setBorder(new LineBorder(Color.red));
    		a = a +1;
    	}else {
    		txtThoiGianBaoHanh.setBorder(new LineBorder(Color.green));
    		
		}
    	if(txtSoLanTra.getText().equals("") == false) {
    		if(Integer.parseInt(txtSoLanTra.getText()) > 3 || Integer.parseInt(txtSoLanTra.getText())<0) {
    			JOptionPane.showMessageDialog(this, "Số lần trả góp không hợp lệ","Error!",JOptionPane.ERROR_MESSAGE);
        		txtSoLanTra.setBorder(new LineBorder(Color.red));
        		a = a +1;
    		}
    	}
    	return a;
    }
    private int notify(String title, String message) {
    	int n = JOptionPane.showConfirmDialog(this, message,title,JOptionPane.YES_NO_OPTION);
    	return n;
    }
    private void clickBtnLuu() {
    	Date date1 = DateNgayLapHoaDon.getDate();
    	java.sql.Date date = new java.sql.Date(date1.getTime());
    	Double soTienDaTra = Double.valueOf(txtSoTienDaThanhToan.getText());
    	String thoiGianBH = txtThoiGianBaoHanh.getText();
    	int soLanTra = 0;
    	Double soTienTra1lan = (double) 0;
    	if(txtSoLanTra.getText().equals("") == false) {
    		soLanTra = Integer.parseInt(txtSoLanTra.getText());
    		soTienTra1lan = (soTienPhaiTra - Double.valueOf(txtSoTienDaThanhToan.getText()))/soLanTra;
    	}
    	if(regex() == 0 && notify("", "Bạn có chắc muốn lưu thông tin vừa nhập không ?") == 0) {
    		NhanVien nv = new NhanVien();
    		KhachHang kh = new KhachHang();
    		nv.setMaNV(maNV);
    		kh.setMaKH(maKH);
    		HopDong hd = new HopDong(date, soTienPhaiTra, soTienDaTra, thoiGianBH, loaiHD,nv,kh);
    		if(dao_HopDong.createHopDong(maXe, hd, soLanTra, soTienTra1lan)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công!!");
			}else {
				JOptionPane.showMessageDialog(this, "Thêm không thành công! Hãy thử lại");
			}
    	}
    	loadData();
    	reset();
    	btnIn.setEnabled(true);
    }
    private void selectItemTable() {
    	int index = tableHopDong.getSelectedRow();
    	txtMaHopDong.setText(list.get(index).getHopDong().getMaHD() + "");
    	DateNgayLapHoaDon.setDate(list.get(index).getHopDong().getNgayLap());
    	txtSoTienPhaiThanhToan.setText(formatterTien.format(list.get(index).getHopDong().getSoTienPhaiThanhToan()));
    	txtSoTienDaThanhToan.setText(formatterTien.format(list.get(index).getHopDong().getSoTienDaThanhToan()));
    	txtThoiGianBaoHanh.setText(list.get(index).getHopDong().getThoiGianBaoHanh());
    	txtMaKhachHang2.setText(list.get(index).getHopDong().getKhachHang().getMaKH() + "");
    	txtMaNhanVien.setText(list.get(index).getHopDong().getNhanVien().getMaNV() + "");
    	loadDetailXe(list.get(index).getXeMay().getMaXe());
    	if(list.get(index).getHopDong().getLoaiHopDong().equals("Trả đủ")) {
    		radTraDu.setSelected(true);
    		clickRadio();
    	}else {
			radTraGop.setSelected(true);
			clickRadio();
			HDTraGop hdtg = dao_HopDong.getHDTraGop(list.get(index).getHopDong().getMaHD());
			txtSoLanTra.setText(hdtg.getSoLanTra() +"");
			txtSoTienTraMotLan.setText(formatterTien.format(hdtg.getSoTienTra()));
		}
    	txtSoLanTra.setEnabled(false);
    	txtSoTienTraMotLan.setEnabled(false);
    }

    private void searchHopDong() {
    	Date date1 = dateNgayLapHoaDonTimKiem.getDate();
    	java.sql.Date date = new java.sql.Date(date1.getTime());
    	list = dao_HopDong.searchHopDongTheoNgay(date);
    	tableModel.setRowCount(0);
    	list.forEach(item -> {
    		tableModel.addRow(new Object[] {item.getHopDong().getMaHD(),formatter.format(item.getHopDong().getNgayLap()),formatterTien.format(item.getHopDong().getSoTienPhaiThanhToan()),formatterTien.format(item.getHopDong().getSoTienDaThanhToan()), item.getHopDong().getThoiGianBaoHanh(), item.getHopDong().getNhanVien().getMaNV(), item.getHopDong().getKhachHang().getMaKH(),item.getHopDong().getLoaiHopDong()});
    	});
    }
    private void clickBtnIn() {
    		Connection con = util.ConnectDatabase.getConnection();
    	
    	try {
			JasperDesign jd =  JRXmlLoader.load("src\\hoadon\\hoadon.jrxml");
	    	JasperReport report = JasperCompileManager.compileReport("src\\hoadon\\hoadon.jrxml");
	    	JasperPrint jp = JasperFillManager.fillReport(report, new HashMap(), con);
	    	JasperViewer.viewReport(jp);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

        jPanelNorth = new javax.swing.JPanel();
        lblMaHD = new javax.swing.JLabel();
        lblNgayLapHoaDon = new javax.swing.JLabel();
        lblSoTienPhaiThanhToan = new javax.swing.JLabel();
        lblSoTienDaThanhToan = new javax.swing.JLabel();
        lblThoiGianBaoHanh = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblMaKH = new javax.swing.JLabel();
        txtSoTienPhaiThanhToan = new javax.swing.JTextField();
        txtSoLanTra = new javax.swing.JTextField();
        txtThoiGianBaoHanh = new javax.swing.JTextField();
        txtMaHopDong = new javax.swing.JTextField();
        txtMaNhanVien = new javax.swing.JTextField();
        txtSoTienDaThanhToan = new javax.swing.JTextField();
        DateNgayLapHoaDon = new com.toedter.calendar.JDateChooser();
        labLoaiHopDong = new javax.swing.JLabel();
        radTraDu = new javax.swing.JRadioButton();
        radTraGop = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSoTienTraMotLan = new javax.swing.JTextField();
        txtMaKhachHang2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHopDong = new javax.swing.JTable();
        lblQuanLyHopDong = new javax.swing.JLabel();
        btnTroVe = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        labelHinhAnh = new javax.swing.JLabel();
        lblTenSanPham = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnIn = new javax.swing.JButton();
        dateNgayLapHoaDonTimKiem = new com.toedter.calendar.JDateChooser();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMaHD.setText("Mã hợp đồng");

        lblNgayLapHoaDon.setText("Ngày lập ");

        lblSoTienPhaiThanhToan.setText("Số tiền phải thanh toán");

        lblSoTienDaThanhToan.setText("Số tiền đã thanh toán");

        lblThoiGianBaoHanh.setText("Thời gian bảo hành");

        lblMaNV.setText("Mã nhân viên");

        lblMaKH.setText("Mã khách hàng");

        txtThoiGianBaoHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoiGianBaoHanhActionPerformed(evt);
            }
        });

        labLoaiHopDong.setText("Loại hợp đồng:");

        radTraDu.setText("Trả đủ");

        radTraGop.setText("Trả góp");

        jLabel1.setText("Số lần trả: ");

        jLabel2.setText("Số tiền trả một lần: ");

        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        radTraDu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radTraDuActionPerformed(evt);
            }

			private void radTraDuActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				radTraGop.setSelected(false);
				clickRadio();
			}
        });
        radTraGop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radTraGopActionPerformed(evt);
            }

			private void radTraGopActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				radTraDu.setSelected(false);
				clickRadio();
			}
        });
        txtSoLanTra.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(txtSoLanTra.getText().equals("")) {
					txtSoTienTraMotLan.setText("");
				}else {
					Double soTienTra1lan = (soTienPhaiTra - Double.valueOf(txtSoTienDaThanhToan.getText()))/(Integer.parseInt(txtSoLanTra.getText()));
					txtSoTienTraMotLan.setText(formatterTien.format(soTienTra1lan));
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	clickLuu(evt);
            }

			private void clickLuu(ActionEvent evt) {
				clickBtnLuu();
				
			}
        });
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	clickIn(evt);
            }

			private void clickIn(ActionEvent evt) {
				clickBtnIn();
				
			}
        });
        tableHopDong.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				selectItemTable();
				
			}
		});
        btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					dispose();
		         new Home(nhanVien).setVisible(true);
			}
		});
        javax.swing.GroupLayout jPanelNorthLayout = new javax.swing.GroupLayout(jPanelNorth);
        jPanelNorth.setLayout(jPanelNorthLayout);
        jPanelNorthLayout.setHorizontalGroup(
            jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNorthLayout.createSequentialGroup()
                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNorthLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMaHD)
                            .addComponent(lblThoiGianBaoHanh)
                            .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoTienPhaiThanhToan))
                        .addGap(35, 35, 35))
                    .addGroup(jPanelNorthLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)))
                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelNorthLayout.createSequentialGroup()
                        .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNorthLayout.createSequentialGroup()
                                .addComponent(txtThoiGianBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtSoTienPhaiThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNorthLayout.createSequentialGroup()
                                .addComponent(lblNgayLapHoaDon)
                                .addGap(18, 18, 18)
                                .addComponent(DateNgayLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelNorthLayout.createSequentialGroup()
                                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMaNV)
                                    .addComponent(lblSoTienDaThanhToan))
                                .addGap(18, 18, 18)
                                .addComponent(txtSoTienDaThanhToan))
                            .addGroup(jPanelNorthLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(labLoaiHopDong))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelNorthLayout.createSequentialGroup()
                                        .addComponent(radTraDu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(radTraGop)
                                        .addGap(9, 9, 9))
                                    .addComponent(txtMaNhanVien)
                                    .addGroup(jPanelNorthLayout.createSequentialGroup()
                                        .addComponent(txtSoTienTraMotLan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(201, 201, 201))
            .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelNorthLayout.createSequentialGroup()
                    .addGap(175, 175, 175)
                    .addComponent(txtMaKhachHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(545, Short.MAX_VALUE)))
        );
        jPanelNorthLayout.setVerticalGroup(
            jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNorthLayout.createSequentialGroup()
                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNorthLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateNgayLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayLapHoaDon)))
                    .addGroup(jPanelNorthLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaHD))))
                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNorthLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSoTienPhaiThanhToan)
                            .addComponent(txtSoTienPhaiThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelNorthLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoTienDaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoTienDaThanhToan))
                        .addGap(43, 43, 43)
                        .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaNV)
                            .addComponent(txtThoiGianBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThoiGianBaoHanh))
                        .addGap(59, 59, 59)
                        .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radTraGop)
                            .addComponent(radTraDu)
                            .addComponent(labLoaiHopDong)
                            .addComponent(lblMaKH))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtSoLanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTienTraMotLan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNorthLayout.createSequentialGroup()
                    .addContainerGap(254, Short.MAX_VALUE)
                    .addComponent(txtMaKhachHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(115, 115, 115)))
        );

        tableHopDong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày lập", "Số tiền phải thanh toán", "Số tiền đã thanh toán", "Thời gian bảo hành", "Mã nhân viên", "Mã khách hàng", "Loại hợp đồng"
            }
        ));
        jScrollPane1.setViewportView(tableHopDong);

        lblQuanLyHopDong.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblQuanLyHopDong.setText("QUẢN LÝ HỢP ĐỒNG");

        btnTroVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnTroVe.setText("Trở về");
        btnTroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVeActionPerformed(evt);
            }
        });

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/out.png"))); // NOI18N
        btnThoat.setText("Thoát");

        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png"))); // NOI18N
        btnLuu.setText("Lưu");

        labelHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHinhAnh.setText("Ảnh");
        labelHinhAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTenSanPham.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTenSanPham.setText("Tên Sản Phẩm");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/printer.png"))); // NOI18N
        btnIn.setText("In");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-search-20.png"))); // NOI18N
        btnSearch.setText("Tìm theo ngày lập:");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnThem)
                        .addGap(102, 102, 102)
                        .addComponent(btnTroVe)
                        .addGap(79, 79, 79)
                        .addComponent(btnLuu)
                        .addGap(97, 97, 97)
                        .addComponent(btnIn)
                        .addGap(226, 226, 226)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(dateNgayLapHoaDonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(btnThoat))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(45, 45, 45)
                                    .addComponent(labelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(lblTenSanPham)))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuanLyHopDong)
                            .addComponent(jPanelNorth, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuanLyHopDong)
                    .addComponent(btnThoat))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblTenSanPham)
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addComponent(jPanelNorth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnTroVe)
                        .addComponent(btnLuu)
                        .addComponent(btnIn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSearch)
                            .addComponent(dateNgayLapHoaDonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtThoiGianBaoHanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThoiGianBaoHanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThoiGianBaoHanhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    	ThemHoadon();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        // TODO add your handling code here:
    	reset();
    }//GEN-LAST:event_btnTroVeActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    	searchHopDong();
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new QuanLyHopDong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateNgayLapHoaDon;
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTroVe;
    private com.toedter.calendar.JDateChooser dateNgayLapHoaDonTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelNorth;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labLoaiHopDong;
    private javax.swing.JLabel labelHinhAnh;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblNgayLapHoaDon;
    private javax.swing.JLabel lblQuanLyHopDong;
    private javax.swing.JLabel lblSoTienDaThanhToan;
    private javax.swing.JLabel lblSoTienPhaiThanhToan;
    private javax.swing.JLabel lblTenSanPham;
    private javax.swing.JLabel lblThoiGianBaoHanh;
    private javax.swing.JRadioButton radTraDu;
    private javax.swing.JRadioButton radTraGop;
    private javax.swing.JTable tableHopDong;
    private javax.swing.JTextField txtMaHopDong;
    private javax.swing.JTextField txtMaKhachHang2;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtSoLanTra;
    private javax.swing.JTextField txtSoTienDaThanhToan;
    private javax.swing.JTextField txtSoTienPhaiThanhToan;
    private javax.swing.JTextField txtSoTienTraMotLan;
    private javax.swing.JTextField txtThoiGianBaoHanh;
    // End of variables declaration//GEN-END:variables
}
