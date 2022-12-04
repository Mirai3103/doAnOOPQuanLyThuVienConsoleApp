package Report;


import helper.Xuat.ITableRowData;

public class ThongKeDocGia  implements ITableRowData {
    private int stt;
    private int maDocGia;
    private int maThe;
    private String hoTen;
    private int soSachMuon;
    private int soLanViPham;

    public ThongKeDocGia() {
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    public int getMaThe() {
        return maThe;
    }

    public void setMaThe(int maThe) {
        this.maThe = maThe;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getSoSachMuon() {
        return soSachMuon;
    }

    public void setSoSachMuon(int soSachMuon) {
        this.soSachMuon = soSachMuon;
    }

    public int getSoLanViPham() {
        return soLanViPham;
    }

    public void setSoLanViPham(int soLanViPham) {
        this.soLanViPham = soLanViPham;
    }

    @Override
    public String[] getRowData() {
        return new String[]{
                String.valueOf(stt),
                String.valueOf(maDocGia),
                String.valueOf(maThe),
                hoTen,
                String.valueOf(soSachMuon),
                String.valueOf(soLanViPham)
        };
    }

    @Override
    public String[] getHeader() {
        return new String[]{
                "STT",
                "Mã độc giả",
                "Mã thẻ",
                "Họ tên",
                "Số sách mượn",
                "Số lần vi phạm"
        };
    }
}
