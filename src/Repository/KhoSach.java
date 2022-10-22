package Repository;


import Model.Sach;

import java.util.ArrayList;
import java.util.List;

public class KhoSach {
    private ArrayList<Sach> data= new ArrayList<>();

    public ArrayList<Sach> getAll() {
        return data;
    }
    public Sach getById(int id) {
        return data.stream().filter(s ->s.getId() == id).findFirst().orElse(null);
    }
    public List<Sach> getByName(String name){
        return data.stream().filter(s ->s.getTenSach().toLowerCase().equals(name.toLowerCase())).toList();
    }
    // doi them class DocGia
//    public List<Sach> timCacSachCoTaiThuVien(){
//        return data.stream().filter(s ->s.get).toList();
//    }
    public void themSach(Sach sach){
        this.data.add(sach);
    }
    public void themSach(){
        Sach sach = new Sach();
        sach.nhapSach();
        this.data.add(sach);
    }
    public boolean kiemTraIdTrung(int id){
        return data.stream().filter(s ->s.getId() == id).findFirst().orElse(null) !=null;
    }
    public Sach findById(int id){
        for (Sach sach : data) {
            if(sach.getId() == id){
                return sach;
            }
        }
        return null;
    }
    public List<Sach> timSachCuaTacGia(int id){
        return data.stream().filter(s ->s.getTacGia().getId() == id).toList();
    }
    public void xuatsach(){
        for (Sach sach : data) {
            sach.xuatSach();
        }
    }

}
