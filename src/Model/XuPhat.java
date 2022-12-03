


package Model;


import helper.Helper;
import helper.Xuat.ITableRowData;

import java.io.Console;
import java.io.Serial;
import java.io.Serializable;

public class XuPhat implements ITableRowData, Serializable {
    @Serial
    private static final long serialVersionUID = 321299L;
    private int idXuPhat ;
    private String tenLoi;
    private int tienPhat;

    public XuPhat(int idXuPhat, String tenLoi, int tienPhat) {
        this.idXuPhat = idXuPhat;
        this.tenLoi = tenLoi;
        this.tienPhat = tienPhat;
    }

    public XuPhat() {

    }

    public void setTenLoi(String tenLoi) {
        this.tenLoi = tenLoi;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }

    public void setIdXuPhat(int idXuPhat) {
        this.idXuPhat = idXuPhat;
    }

    public int getIdXuPhat() {
        return idXuPhat;
    }

    public String getTenLoi() {
        return tenLoi;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void nhapXuPhat(){
        System.out.println("Nhap ten loi: ");
        tenLoi = Helper.scanner.nextLine();
        System.out.println("Nhap tien phat: ");
        tienPhat = Helper.nhapSoTuNhien("Tien phat khong hop le, vui long nhap lai: ");
    }


    @Override
    public String[] getRowData() {
        return new String[] {idXuPhat+"",tenLoi,tienPhat==-1?"phí bằng giá sách":tienPhat+""};
    }

    @Override
    public String[] getHeader() {
        return new String[] {"id", "Tên lỗi","tiền"};
    }
}
