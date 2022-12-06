package Report;


import helper.Xuat.ITableRowData;

public class SachThinhHanh implements ITableRowData {
    private  int stt;
    private String tenSach;
    private int soLanMuon = 0;

    public SachThinhHanh() {
    }

    public void setStt(int stt) {
        this.stt = stt;
    }



    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setSoLanMuon(int soLanMuon) {
        this.soLanMuon = soLanMuon;
    }

    public int getStt() {
        return stt;
    }


    public String getTenSach() {
        return tenSach;
    }

    public int getSoLanMuon() {
        return soLanMuon;
    }

    public SachThinhHanh(int stt,  String tenSach, int soLanMuon) {
        this.stt = stt;
        this.tenSach = tenSach;
        this.soLanMuon = soLanMuon;
    }

    @Override
    public String[] getRowData() {
        return new String[] {
                String.valueOf(stt),
                tenSach,
                String.valueOf(soLanMuon)
        };
    }

    @Override
    public String[] getHeader() {
        return new String[] {
                "STT",
                "Tên Sách",
                "Số Lần Mượn"
        };
    }
}
