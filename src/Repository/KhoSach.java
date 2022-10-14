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
    public boolean kiemTraIdTrung(int id){
        return data.stream().filter(s ->s.getId() == id).findFirst().orElse(null) !=null;
    }

}
