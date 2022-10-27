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
		for(NhanVien NV : NVs) {
			if(NV.getMaNV()==MaNV)
				return NV;
		}
		return null;
	}
	
	public NhanVien getByName(String name) {
		for(NhanVien NV : NVs) {
			if(NV.getHoTen()==name)
				return NV;
		}
		return null;
	}
	
	public void NhapNVM() {
		System.out.println("0.Là Quản lí");
		System.out.println("khác 0. Là thủ thư: ");
		System.out.println("Nhân Viên mới là: ");
		int chon = Helper.nhapSoNguyen("Nhập số nguyên: ");
		switch (chon) {
		case 0:
			QuanLi QL = new QuanLi();
			QL.Nhap();
			NhanVien NV = QL;
        	NVs.add(NV);
			break;
		default:
			ThuThu TT = new ThuThu();
        	TT.Nhap();
        	NV = TT;
        	NVs.add(NV);
			break;
		}
		
	}
	
	public void SuaNhanVien() {
		Menu2();
		System.out.println("Nhập phương thức sử dụng: ");
		int chon = Helper.nhapSoNguyen("Lỗi!!!Nên nhập số nguyên: ");
		switch (chon) {
		case 1:
			System.out.println("Nhập mã nhân viên cần sửa thông tin: ");
			String MaNV = Helper.scanner.nextLine();
			NhanVien NV = getByMaNV(MaNV);
			if(NV != null) {
				if(NV instanceof QuanLi) {
					QuanLi QL = (QuanLi) NV;
					QL.Nhap();
				}else {
					ThuThu TT = (ThuThu) NV;
					TT.Nhap();
				}
			}else
				System.out.println("Nhân viên không tồn tại!!");
			break;

		default: 
			System.out.println("Nhập mã nhân viên cần sửa thông tin: ");
			String name = Helper.scanner.nextLine();
			NhanVien NV2 = getByName(name);
			if(NV2 != null) {
				if(NV2 instanceof QuanLi) {
					QuanLi QL = (QuanLi) NV2;
					QL.Nhap();
				}else {
					ThuThu TT = (ThuThu) NV2;
					TT.Nhap();
				}
			}else
				System.out.println("Nhân viên không tồn tại!!!");
			break;
			
		}
	}
	
	public void XoaNhanVien() {
		Menu2();
		System.out.println("Nhập phương thức sử dụng: ");
		int chon = Helper.nhapSoNguyen("Lỗi!!!Nên nhập số nguyên: ");
		switch (chon) {
		case 1:
			System.out.println("Nhập mã nhân viên cần sửa thông tin: ");
			String MaNV = Helper.scanner.nextLine();
			NhanVien NV = getByMaNV(MaNV);
			if(NV != null) {
				XoaNV(NV);
			}else
				System.out.println("Nhân viên không tồn tại!!");
			break;

		default: 
			System.out.println("Nhập mã nhân viên cần sửa thông tin: ");
			String name = Helper.scanner.nextLine();
			NhanVien NV2 = getByName(name);
			if(NV2 != null) {
				XoaNV(NV2);
			}else
				System.out.println("Nhân viên không tồn tại!!!");
			break;
			
		}
	}
	
	public void ShowAll() {
		System.out.println("Quản Lí: ");
		
	}
	
	
	// Ä‘oáº¡n code bÃªn dÆ°á»›i khÃ´ng cháº¯c Ä‘Ãºng
	public List<NhanVien> DocFile() {
	        try {
	            FileInputStream finput = new FileInputStream("E:\\data.obj");
	            ObjectInputStream objinput = new ObjectInputStream(finput);
	            ArrayList<NhanVien> DATA = (ArrayList<NhanVien>) objinput.readObject();
	            return DATA;
	            // náº¿u nhÆ° nÃ y khi Ä‘á»�c cÃ¡i nÃ y thÃ¬ pháº£i dÃ¹ng downcasting??
	        } catch (Exception e) {

	            e.printStackTrace();
	            return null;
	        }
	    }
	
	//ghi file
	public void Ghi() {
		
		// Nhập lần đầu vào:
		
//		System.out.println("Nháº­p sá»‘ nhÃ¢n viÃªn cáº§n táº¡o: ");
//		int n = Helper.nhapSoNguyen("Nháº­p sá»‘ nhÃ¢n viÃªn cáº§n táº¡o: ");
//        for (int i = 0; i < n; i++) {
//        	System.out.println("Nháº­p sá»‘ 0 Ä‘á»ƒ nháº­p quáº£n lÃ­. KhÃ¡c 0 Ä‘á»ƒ nháº­p nhÃ¢n viÃªn: ");
//            int k = Helper.nhapSoNguyen("Nháº­p sá»‘ 0 Ä‘á»ƒ nháº­p quáº£n lÃ­. KhÃ¡c 0 Ä‘á»ƒ nháº­p thá»§ thÆ°");
//            if(k==0) {
//            	QuanLi QL = new QuanLi();
//            	QL.Nhap();
//            	NhanVien NV = QL;
//            	NVs.add(NV);
//            }else {
//            	ThuThu TT = new ThuThu();
//            	TT.Nhap();
//            	NhanVien NV = TT;
//            	NVs.add(NV);
//            }
//        }
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
	
	public void Menu1() {
		System.out.println("1.Nhập nhân viên mới.");
		System.out.println("2.sửa nhân viên.");
		System.out.println("3.Xóa nhân viên.");
		System.out.println("4.Xuất.");
		System.out.println("5.Thoát.");
	}
	public void Menu2() {
		System.out.println("1.Với mã nhân viên.");
		System.out.println("khác 1.với tên nhân viên( nhân viên đầu tiên có tên trong DS):");
	}
	public void LamViec() {
		Menu1();
		int chon;
		System.out.println("chọn thao tác: ");
		chon = Helper.nhapSoNguyen("Yêu cầu nhập số nguyên:");
		switch (chon) {
		case 1:
			NhapNVM();
			break;
//chưa xong
		case 2:
			
			break;
		case 3:
			
			break;

		case 4:
			
			break;
		case 5:
			
			break;
		}
	}
}
