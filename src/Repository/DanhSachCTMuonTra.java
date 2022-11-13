package Repository;

import Model.CTMuonTra;
import helper.Helper;

import java.io.Serial;
import java.util.ArrayList;

public class DanhSachCTMuonTra extends BaseDanhSach<CTMuonTra> {
    @Serial
    private static final long serialVersionUID = 142343249212L;
    public static final String FILE_PATH = Helper.dirPath+ "DanhSachCTMuonTra.bin";


    @Override
    public void copyFrom(IDanhSach<CTMuonTra> other) {
        var otherCTMuonTras = (DanhSachCTMuonTra) other;
        this.data = otherCTMuonTras.data;
    }

    @Override
    public void add(CTMuonTra item) {
        this.data.add(item);
    }
    public ArrayList<CTMuonTra>getChiTietPhieuMuong(int idPhieuMuon){
        ArrayList<CTMuonTra>list=new ArrayList<>();
        for (CTMuonTra ctMuonTra : data) {
            if(ctMuonTra.getIdPhieuMuon()==idPhieuMuon){
                list.add(ctMuonTra);
            }
        }
        return list;
    }
}
