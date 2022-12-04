package Repository;

import Model.CTMuonTra;
import helper.Helper;

import java.io.Serial;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
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
    public void xoaCTMuonTra(int idPhieuMuon, int idSach){
        for (CTMuonTra ctMuonTra : data) {
            if(ctMuonTra.getIdPhieuMuon()==idPhieuMuon && ctMuonTra.getIDsach()==idSach){
                System.out.print("Bạn có chắc muốn xóa không (y/n): ");
                if(Helper.scanner.nextLine().equals("y")) {
                    System.out.println("Đã xóa!!");
                    data.remove(ctMuonTra);
                }
                System.out.println("Đã hủy xóa!!");
                break;
            }
        }
    }
    public ArrayList<CTMuonTra> getDanhSachQuaHan(){
        ArrayList<CTMuonTra>list=new ArrayList<>();
        for (CTMuonTra ctMuonTra : data) {
            if(ctMuonTra.getNgaytra()==null && ctMuonTra.getNgayhentra().isBefore(LocalDate.now())){
                list.add(ctMuonTra);
            }
        }
        return list;
    }
}
