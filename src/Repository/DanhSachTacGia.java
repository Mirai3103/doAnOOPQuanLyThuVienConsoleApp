package Repository;

import Model.TacGia;

import java.util.ArrayList;

/**
 * @author HuuHoang
 */
public class DanhSachTacGia {
    private ArrayList<TacGia> tacGias = new ArrayList<>();

    public ArrayList<TacGia> getTacGias() {
        return tacGias;
    }
    public TacGia findById(int id){
        for (TacGia tacGia : tacGias) {
            if(tacGia.getId() == id){
                return tacGia;
            }
        }
        return null;
    }

}
