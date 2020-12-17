package OBJ;

public class SanPham {
    private String maSanPham;
    private String tenSP;
    private String donViTinh;
    private String giaNhap;
    private String soLuong;
    private String tenNSX;
    private String giaBan;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSP, String donViTinh, String giaNhap, String soLuong, String tenNSX, String giaBan) {
        this.maSanPham = maSanPham;
        this.tenSP = tenSP;
        this.donViTinh = donViTinh;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
        this.tenNSX = tenNSX;
        this.giaBan = giaBan;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    
    
}
