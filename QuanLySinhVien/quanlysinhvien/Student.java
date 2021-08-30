package quanlysinhvien;

import java.io.Serializable;

public class Student implements Serializable {
    private String maSV;
    private String hoTen;
    private int nhom;

    public Student(String maSV, String hoTen, int nhom) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.nhom = nhom;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNhom() {
        return nhom;
    }

    public void setNhom(int nhom) {
        this.nhom = nhom;
    }

    @Override
    public String toString() {
        return  "Mã Sinh Viên = '" + maSV + '\'' + ", Họ Tên = '" + hoTen + '\'' + ", Nhóm Lớp = '" + nhom + '\'';
    }
}
