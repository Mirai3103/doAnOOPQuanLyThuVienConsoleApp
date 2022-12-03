package Report;


import helper.Xuat.ITableRowData;

public class TheLoaiThinhHanh implements ITableRowData {
    int stt;
    String tenTheLoai;
    int soLanMuon = 0;

    public TheLoaiThinhHanh() {
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }


    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public int getSoLanMuon() {
        return soLanMuon;
    }

    public void setSoLanMuon(int soLanMuon) {
        this.soLanMuon = soLanMuon;
    }

    @Override
    public String[] getRowData() {
        return new String[] {
                String.valueOf(stt),
                tenTheLoai,
                String.valueOf(soLanMuon)
        };
    }

    @Override
    public String[] getHeader() {
        return new String[] {
                "STT",
                "Tên thể loại",
                "Số lần mượn"
        };
    }
}
