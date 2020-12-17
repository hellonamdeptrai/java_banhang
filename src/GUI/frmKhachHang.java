package GUI;

import OBJ.KhachHang;
import OBJ.NhanVien;
import Utils.checkData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class frmKhachHang extends javax.swing.JPanel {

    private DefaultTableModel defaultTableModel;
    KhachHang kh = new KhachHang();
    ArrayList<KhachHang> listKH = new ArrayList<>();
    checkData check = new checkData();

    public frmKhachHang() {
        initComponents();
        loadFile();
        getData(listKH);
    }

    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listKH = new ArrayList<>(); //lưu ý
            fr = new FileReader("khachhang.txt");
            br = new BufferedReader(fr);
            String s = null;

            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    KhachHang kh = new KhachHang();
                    kh.setMaKhachHang(arr[0]);
                    kh.setHoTen(arr[1]);
                    kh.setSoDienThoai(arr[2]);
                    kh.setEmail(arr[3]);
                    kh.setDiaChi(arr[4]);
                    kh.setGioiTinh(arr[5]);
                    kh.setTrangThai(Integer.parseInt(arr[6]));
                    listKH.add(kh);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void saveFile() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listKH.size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listKH.get(i).getMaKhachHang() + "\t";
                row = row + listKH.get(i).getHoTen() + "\t";
                row = row + listKH.get(i).getSoDienThoai() + "\t";
                row = row + listKH.get(i).getEmail() + "\t";
                row = row + listKH.get(i).getDiaChi() + "\t";
                row = row + listKH.get(i).getGioiTinh() + "\t";
                row = row + listKH.get(i).getTrangThai() + "\n";
                data += row;
            }
            fw = new FileWriter("khachhang.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getData(ArrayList<KhachHang> listKH) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã KH");
        defaultTableModel.addColumn("Họ tên HK");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("SĐT");
        defaultTableModel.addColumn("Địa chỉ");
        defaultTableModel.addColumn("Trạng Thái");

        for (KhachHang obj : listKH) {
            Vector vector = new Vector();
            vector.add(obj.getMaKhachHang());
            vector.add(obj.getHoTen());
            vector.add(obj.getGioiTinh());
            vector.add(obj.getEmail());
            vector.add(obj.getSoDienThoai());
            vector.add(obj.getDiaChi());
            vector.add(obj.getTrangThai() == 1 ? "Hoạt động" : "Đã khóa");
            defaultTableModel.addRow(vector);
        }
        bangkhachhang.setModel(defaultTableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        bangkhachhang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_maKhachHang = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        txt_diaChi = new javax.swing.JTextField();
        txt_hoTen = new javax.swing.JTextField();
        box_gioiTinh = new javax.swing.JComboBox<>();
        box_trangThai = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        timKiem = new javax.swing.JButton();
        them = new javax.swing.JButton();
        xoa = new javax.swing.JButton();
        sua = new javax.swing.JButton();
        thoat = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setLayout(null);

        bangkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        bangkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangkhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bangkhachhang);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 328, 1000, 140);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 102));
        jLabel1.setText("Zent Coding School");
        add(jLabel1);
        jLabel1.setBounds(65, 20, 124, 17);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quản lý khách hàng");
        add(jLabel2);
        jLabel2.setBounds(479, 11, 229, 29);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Xin chào, Nam Đẹp Trai !");
        add(jLabel3);
        jLabel3.setBounds(39, 57, 202, 22);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Mã Khách hàng");

        jLabel5.setText("Email");

        jLabel6.setText("SĐT");

        jLabel7.setText("Địa chỉ");

        jLabel8.setText("Họ và tên");

        jLabel9.setText("Giới tính");

        jLabel10.setText("Trạng thái");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Thông tin khách hàng");

        txt_maKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maKhachHangActionPerformed(evt);
            }
        });

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        box_gioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        box_gioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_gioiTinhActionPerformed(evt);
            }
        });

        box_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Đã khoá" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_maKhachHang)
                            .addComponent(txt_email)
                            .addComponent(txt_diaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(txt_sdt))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(box_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(box_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(txt_maKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        add(jPanel1);
        jPanel1.setBounds(39, 97, 555, 213);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Tìm kiếm");

        timKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Magnifier-icon.png"))); // NOI18N
        timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timKiem))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        add(jPanel2);
        jPanel2.setBounds(657, 97, 279, 93);

        them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/more.png"))); // NOI18N
        them.setText("Thêm");
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });
        add(them);
        them.setBounds(679, 208, 87, 33);

        xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        xoa.setText("Xóa");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });
        add(xoa);
        xoa.setBounds(823, 208, 89, 33);

        sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wrench.png"))); // NOI18N
        sua.setText("Sửa");
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });
        add(sua);
        sua.setBounds(679, 277, 87, 33);

        thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/turn-on.png"))); // NOI18N
        thoat.setText("Thoát");
        thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoatActionPerformed(evt);
            }
        });
        add(thoat);
        thoat.setBounds(823, 277, 89, 33);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hinh-nen-full-hd-cho-laptop-3.jpg"))); // NOI18N
        jLabel13.setText("jLabel13");
        add(jLabel13);
        jLabel13.setBounds(0, 0, 1000, 530);
    }// </editor-fold>//GEN-END:initComponents

    public void reset (){
        txt_hoTen.setText("");
        txt_email.setText("");
        txt_maKhachHang.setText("");
        txt_sdt.setText("");
        box_trangThai.setSelectedItem("Hoạt động");
        txt_diaChi.setText("");
        box_gioiTinh.setSelectedItem("Nam");
    }
    


    private void txt_maKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maKhachHangActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemActionPerformed
        String tuKhoa = txt_timKiem.getText();
        if(tuKhoa == ""){
            getData(listKH);
        }
        else {
            ArrayList<KhachHang> listKH_timKiem = new ArrayList<>();
            for (int i = 0; i < listKH.size(); i++) {
                if (listKH.get(i).getMaKhachHang().contains(tuKhoa) || listKH.get(i).getSoDienThoai().contains(tuKhoa) || listKH.get(i).getEmail().contains(tuKhoa)){
                    listKH_timKiem.add(listKH.get(i));
                }
            }
            getData(listKH_timKiem);
        }
    }//GEN-LAST:event_timKiemActionPerformed

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed

        String maKH = txt_maKhachHang.getText();
        String hoTen = txt_hoTen.getText();
        String diaChi = txt_diaChi.getText();
        String sdt = txt_sdt.getText();
        String email = txt_email.getText();
        String gioiTinh = "Nam";
        if(box_gioiTinh.getSelectedItem().equals("Nữ")){
            gioiTinh = "Nữ";
        }else if (box_gioiTinh.getSelectedItem().equals("Khác")){
            gioiTinh = "Khác";
        }
        int trangThai = 0;
        if(box_trangThai.getSelectedItem().equals("Hoạt động")){
            trangThai = 1;
        }
        
        KhachHang kh = new KhachHang();
        if (maKH.equals("")) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống !");
            return;
        }
        for (int i = 0; i < listKH.size(); i++) {
            if (maKH.equals(listKH.get(i).getMaKhachHang())) {
                JOptionPane.showMessageDialog(this, "Mã bị trùng, hãy nhập lại");
                return;
            } else {
                kh.setMaKhachHang(maKH);
            }
        }
        if (hoTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Họ và tên không được để trống !");
            return;
        }
        if (!check.kiemTraTen(hoTen)) {
            JOptionPane.showMessageDialog(this, "Tên không được chứa số !");
            return;
        }
        kh.setHoTen(hoTen);
        kh.setGioiTinh(gioiTinh);
        if (email.equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được để trống !");
            return;
        }
        if (!check.kiemTraEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng !");
            return;
        }
        kh.setEmail(email);
        if (sdt.equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống !");
            return;
        }
        if (check.kiemTraSDT(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng !");
            return;
        }
        kh.setSoDienThoai(sdt);
        if (diaChi.equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống !");
            return;
        }
        kh.setDiaChi(diaChi);
        kh.setTrangThai(trangThai);
        
        listKH.add(kh);
        getData(listKH);
        saveFile();
        JOptionPane.showMessageDialog(this, "Thêm mới thành công !");
        reset();
    }//GEN-LAST:event_themActionPerformed

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa khách hàng " + kh.getMaKhachHang()+ " không ?", "Xóa khách hàng", 2);
        if (confirm == JOptionPane.YES_OPTION) {
            if (listKH.remove(kh) == true) {
                saveFile();
                JOptionPane.showConfirmDialog(this, "Xóa thành công !");
                getData(listKH);
                reset();
            } else {
                JOptionPane.showConfirmDialog(this, "Xóa thất bại !");
            }
        }
    }//GEN-LAST:event_xoaActionPerformed

    private void thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_thoatActionPerformed

    private void box_gioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_gioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_gioiTinhActionPerformed
    int index;
    private void bangkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangkhachhangMouseClicked
        sua.setEnabled(true);
        xoa.setEnabled(true);
        // lấy ra bản ghi
        int row = bangkhachhang.getSelectedRow();
        String maKH = bangkhachhang.getValueAt(row, 0).toString();
        for (int i = 0; i < listKH.size(); i++) {
            if (maKH.equals(listKH.get(i).getMaKhachHang())) {
                kh = listKH.get(i);
                index = i;
                break;
            }
        }
        txt_maKhachHang.setEnabled(false);
        them.setEnabled(false);
        
        txt_maKhachHang.setText(kh.getMaKhachHang());
        txt_email.setText(kh.getEmail());
        txt_hoTen.setText(kh.getHoTen());
        txt_sdt.setText(kh.getSoDienThoai());
        txt_diaChi.setText(kh.getDiaChi());
        
        if (kh.getGioiTinh().equals("Nam")) {
            box_gioiTinh.setSelectedItem("Nam");
        }else if (kh.getGioiTinh().equals("Nữ")){
            box_gioiTinh.setSelectedItem("Nữ");
        }else {
            box_gioiTinh.setSelectedItem("Khác");
        }
        if (kh.getTrangThai()==1) {
            box_trangThai.setSelectedItem("Hoạt động");
        }else{
            box_trangThai.setSelectedItem("Đã khóa");
        }
    }//GEN-LAST:event_bangkhachhangMouseClicked

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaActionPerformed
        String maKH = txt_maKhachHang.getText();
        String hoTen = txt_hoTen.getText();
        String diaChi = txt_diaChi.getText();
        String sdt = txt_sdt.getText();
        String email = txt_email.getText();
        String gioiTinh = "Nam";
        if(box_gioiTinh.getSelectedItem().equals("Nữ")){
            gioiTinh = "Nữ";
        }else if (box_gioiTinh.getSelectedItem().equals("Khác")){
            gioiTinh = "Khác";
        }
        int trangThai = 0;
        if(box_trangThai.getSelectedItem().equals("Hoạt động")){
            trangThai = 1;
        }
        
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(maKH);
        if (hoTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Họ và tên không được để trống !");
            return;
        }
        if (!check.kiemTraTen(hoTen)) {
            JOptionPane.showMessageDialog(this, "Tên không được chứa số !");
            return;
        }
        kh.setHoTen(hoTen);
        kh.setGioiTinh(gioiTinh);
        if (email.equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được để trống !");
            return;
        }
        if (!check.kiemTraEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng !");
            return;
        }
        kh.setEmail(email);
        if (sdt.equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống !");
            return;
        }
        if (check.kiemTraSDT(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng !");
            return;
        }
        kh.setSoDienThoai(sdt);
        if (diaChi.equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống !");
            return;
        }
        kh.setDiaChi(diaChi);
        kh.setTrangThai(trangThai);
        
        listKH.set(index, kh);
        getData(listKH);
        saveFile();
        JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công " + kh.getMaKhachHang());
        reset();
    }//GEN-LAST:event_suaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangkhachhang;
    private javax.swing.JComboBox<String> box_gioiTinh;
    private javax.swing.JComboBox<String> box_trangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sua;
    private javax.swing.JButton them;
    private javax.swing.JButton thoat;
    private javax.swing.JButton timKiem;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_maKhachHang;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_timKiem;
    private javax.swing.JButton xoa;
    // End of variables declaration//GEN-END:variables
}
