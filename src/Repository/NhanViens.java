package Repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Model.NhanVien;
import Model.QuanLi;
import Model.ThuThu;
import helper.Helper;


public class NhanViens {
	
	private ArrayList<NhanVien> NVs = new ArrayList<>();

	public ArrayList<NhanVien> getNVs() {
		return NVs;
	}

	public void setNVs(ArrayList<NhanVien> nVs) {
		NVs = nVs;
	}
	
	public void ThemNV(NhanVien e) {
		NVs.add(e);
	}
	
	public void XoaNV(NhanVien e) {
		NVs.remove(e);
	}
	
	public NhanVien getByMaNV(String MaNV) {
		return NVs.stream().filter(s ->s.getMaNV() == MaNV).findFirst().orElse(null);
	}
	
	public NhanVien getByName(String name) {
		return NVs.stream().filter(s ->s.getHoTen() == name).findFirst().orElse(null);
	}
	
	// đoạn code bên dưới không chắc đúng
	public List<NhanVien> DocFile() {
	        try {
	            FileInputStream finput = new FileInputStream("E:\\data.obj");
	            ObjectInputStream objinput = new ObjectInputStream(finput);
	            ArrayList<NhanVien> DATA = (ArrayList<NhanVien>) objinput.readObject();
	            return DATA;
	            // nếu như này khi đọc cái này thì phải dùng downcasting??
	        } catch (Exception e) {

	            e.printStackTrace();
	            return null;
	        }
	    }
	//ghi file
	public void Ghi() {
		System.out.println("Nhập số nhân viên cần tạo: ");
		int n = Helper.nhapSoNguyen("Nhập số nhân viên cần tạo: ");
        for (int i = 0; i < n; i++) {
        	System.out.println("Nhập số 0 để nhập quản lí. Khác 0 để nhập nhân viên: ");
            int k = Helper.nhapSoNguyen("Nhập số 0 để nhập quản lí. Khác 0 để nhập thủ thư");
            if(k==0) {
            	QuanLi QL = new QuanLi();
            	QL.Nhap();
            	NhanVien NV = QL;
            	NVs.add(NV);
            }else {
            	ThuThu TT = new ThuThu();
            	TT.Nhap();
            	NhanVien NV = TT;
            	NVs.add(NV);
            }
        }
        try {
            FileOutputStream fout = new FileOutputStream("E:\\data.obj");
            ObjectOutputStream objout = new ObjectOutputStream(fout);
            objout.writeObject(NVs);
            System.out.println("ghi thanh coong");
            objout.close();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
