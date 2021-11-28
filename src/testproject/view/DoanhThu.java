/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package testproject.view;

import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import testproject.model.DatPhong;
import testproject.model.DocGhiFile;
import testproject.model.KhachHang;
import testproject.model.Phong;

/**
 *
 * @author phuon
 */
public class DoanhThu extends javax.swing.JFrame {

    /**
     * Creates new form DoanhThu
     */
    private DefaultTableModel tableModel;
    private int id = 0;
    private static final String curentDir = System.getProperty("user.dir");
    private static final String separator = File.separator;
    private static final String PATH_FILE_CSV_DATPHONG = curentDir + separator + "data" + separator + "DatPhong.csv";
    private static final String PATH_FILE_CSV_khachHang = curentDir + separator + "data" + separator + "KhachHang.csv";
    private static final String PATH_FILE_CSV_Phong = curentDir + separator + "data" + separator + "Phong.csv";

    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    private DateFormat df1 = new SimpleDateFormat("MM");

    private DocGhiFile dc = new DocGhiFile();
    private List<DatPhong> listDatPhong = new ArrayList<>();
    private List<KhachHang> listKH = new ArrayList<>();
    private List<Phong> listPhong = new ArrayList<>();

    private File fKH = new File(PATH_FILE_CSV_khachHang);
    private File fDP = new File(PATH_FILE_CSV_DATPHONG);
    private File fP = new File(PATH_FILE_CSV_Phong);

    private double tongtien = 0;

    public DoanhThu() {
        initComponents();
        if (fKH.exists() && fDP.exists() && fP.exists()) {
            try {
                listDatPhong = dc.docFileDatPhong();
            } catch (CsvValidationException ex) {
                Logger.getLogger(DoanhThu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(DoanhThu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                listKH = dc.docFileKhachHang();
            } catch (CsvValidationException ex) {
                Logger.getLogger(DoanhThu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                listPhong = dc.docFilePhong();
            } catch (CsvValidationException ex) {
                Logger.getLogger(DoanhThu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void hienThiDatPhong(List<DatPhong> listDatPhong) {
        tableModel.setRowCount(0);
        for (DatPhong item : listDatPhong) {
            String maDatPhong = item.getMaDatPhong();
            String maphong = item.getMaPhong();
            String maKhachHang = item.getMaKhachHang();
            Date ngayDat = item.getNgayDat();
            String ngayDat1 = df.format(ngayDat);
            Date ngayTra = item.getNgayTra();
            String ngayTra1 = df.format(ngayTra);
            double tongTien = item.getTongTien();
            tableModel.addRow(new Object[]{maDatPhong, maphong, maKhachHang, ngayDat1, ngayTra1, tongTien});
        }
    }

    public void TongTienNgay() {
        for (DatPhong item : listDatPhong) {
            if (df.format(item.getNgayTra()).equals(txtNgay.getText())) {
                tongtien += item.getTongTien();
            }
        }
    }

    public void TongTienThang() {
        DateFormat format = new SimpleDateFormat("MM");
        for (DatPhong item : listDatPhong) {
            if (format.format(item.getNgayTra()).equals(txtNgay.getText())) {
                tongtien += item.getTongTien();
            }

        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
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

        txtNgay = new javax.swing.JTextField();
        DoanhThu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatPhong = new javax.swing.JTable();
        txttongTien = new javax.swing.JTextField();
        DoanhThu1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNgay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        DoanhThu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DoanhThu.setText("Doanh Thu ngày");
        DoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoanhThuActionPerformed(evt);
            }
        });

        tblDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đặt phòng", "Mã phòng", "Mã khách hàng", "Ngày đặt", "Ngày trả", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatPhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatPhong);

        txttongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        DoanhThu1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DoanhThu1.setText("Doanh Thu tháng");
        DoanhThu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoanhThu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(txttongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(DoanhThu)
                .addGap(38, 38, 38)
                .addComponent(DoanhThu1)
                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DoanhThu1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txttongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDatPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatPhongMouseClicked

    }//GEN-LAST:event_tblDatPhongMouseClicked

    private void DoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoanhThuActionPerformed

        TongTienNgay();
        System.out.println(tongtien);
        txttongTien.setText(String.valueOf(tongtien));
        tableModel.setRowCount(0);
        for (DatPhong item : listDatPhong) {
            if (txtNgay.equals(df1.format(item.getNgayTra()))) {
                String maDatPhong = item.getMaDatPhong();
                String maphong = item.getMaPhong();
                String maKhachHang = item.getMaKhachHang();
                Date ngayDat = item.getNgayDat();
                String ngayDat1 = df.format(ngayDat);
                Date ngayTra = item.getNgayTra();
                String ngayTra1 = df.format(ngayTra);
                double tongTien = item.getTongTien();
                tableModel.addRow(new Object[]{maDatPhong, maphong, maKhachHang, ngayDat1, ngayTra1, tongTien});
            }
        }
    }//GEN-LAST:event_DoanhThuActionPerformed

    private void DoanhThu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoanhThu1ActionPerformed
        if (isNumeric(txtNgay.getText()) == true) {
            TongTienThang();
            System.out.println(tongtien);
            txttongTien.setText(String.valueOf(tongtien));
        }
        tableModel.setRowCount(0);
        for (DatPhong item : listDatPhong) {
            if (txtNgay.equals(df.format(item.getNgayTra()))) {
                String maDatPhong = item.getMaDatPhong();
                String maphong = item.getMaPhong();
                String maKhachHang = item.getMaKhachHang();
                Date ngayDat = item.getNgayDat();
                String ngayDat1 = df.format(ngayDat);
                Date ngayTra = item.getNgayTra();
                String ngayTra1 = df.format(ngayTra);
                double tongTien = item.getTongTien();
                tableModel.addRow(new Object[]{maDatPhong, maphong, maKhachHang, ngayDat1, ngayTra1, tongTien});
            }
        }

    }//GEN-LAST:event_DoanhThu1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main() {
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
            java.util.logging.Logger.getLogger(DoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoanhThu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DoanhThu;
    private javax.swing.JButton DoanhThu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatPhong;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txttongTien;
    // End of variables declaration//GEN-END:variables
}
