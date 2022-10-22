package Repository;


import Model.TheLoai;

import java.util.ArrayList;

public class KhoTheLoai {
    private ArrayList<TheLoai> theLoais = new ArrayList<>();

    public ArrayList<TheLoai> getTheLoais() {
        return theLoais;
    }

    public TheLoai findById(int id){
        for (TheLoai theLoai : theLoais) {
            if(theLoai.getId() == id){
                return theLoai;
            }
        }
        return null;
    }
    public void showAll(){
        for (TheLoai theLoai : theLoais) {
            theLoai.xuat();
        }
    }
    //toDo: crud
}
