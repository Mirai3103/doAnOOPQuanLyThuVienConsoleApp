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
			int flag=1;
			do {
				flag=1;
				QL.Nhap();
				if(NVs.stream().filter(s -> s.getMaNV()==QL.getMaNV()).findFirst().orElse(null)!=null) {
					System.out.println("Mã nhân viên bị trùng lặp yêu cầu nhập lại mã nhân viên.");
					flag=0;
			}
			}while(flag==0);
			NhanVien NV = QL;
        	NVs.add(NV);
			break;
		default:
			ThuThu TT = new ThuThu();
			int flag2=1;
        	do {
    			flag2=1;
    			TT.Nhap();
    			if(NVs.stream().filter(s -> s.getMaNV()==TT.getMaNV()).findFirst().orElse(null)!=null) {
    				System.out.println("Mã nhân viên bị trùng lặp yêu cầu nhập lại.");
    				flag2=0;
    			}
    		}while(flag2==0);
        	NhanVien NV2 = TT;
        	NVs.add(NV2);
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
					int flag1=1;
		        	do {
		    			flag1=1;
		    			QL.Nhap();
		    			if(NVs.stream().filter(s -> s.getMaNV()==QL.getMaNV()).findFirst().orElse(null)!=null) {
		    				System.out.println("Mã nhân viên bị trùng lặp yêu cầu nhập lại mã nhân viên.");
		    				flag1=0;
		    			}
		    			}while(flag1==0);
				}else {
					ThuThu TT = (ThuThu) NV;
					int flag2=1;
		        	do {
		    			flag2=1;
		    			TT.Nhap();
		    			if(NVs.stream().filter(s -> s.getMaNV()==TT.getMaNV()).findFirst().orElse(null)!=null) {
		    				System.out.println("Mã nhân viên bị trùng lặp yêu cầu nhập lại mã nhân viên.");
		    				flag2=0;
		    			}
		    			}while(flag2==0);
				}
			}else
				System.out.println("Nhân viên không tồn tại!!");
			break;

		default: 
			System.out.println("Nhập Tên nhân viên cần sửa thông tin: ");
			String name = Helper.scanner.nextLine();
			NhanVien NV2 = getByName(name);
			if(NV2 != null) {
				if(NV2 instanceof QuanLi) { //https://codelearn.io/learning/lap-trinh-huong-doi-tuong-trong-java/11157048
					QuanLi QL = (QuanLi) NV2;
					int flag1=1;
		        	do {
		    			flag1=1;
		    			QL.Nhap();
		    			if(NVs.stream().filter(s -> s.getMaNV()==QL.getMaNV()).findFirst().orElse(null)!=null) {
		    				System.out.println("Mã nhân viên bị trùng lặp yêu cầu nhập lại mã nhân viên.");
		    				flag1=0;
		    			}
		    			}while(flag1==0);
				}else {
					ThuThu TT = (ThuThu) NV2;
					int flag2=1;
		        	do {
		    			flag2=1;
		    			TT.Nhap();
		    			if(NVs.stream().filter(s -> s.getMaNV()==TT.getMaNV()).findFirst().orElse(null)!=null) {
		    				System.out.println("Mã nhân viên bị trùng lặp yêu cầu nhập lại mã nhân viên.");
		    				flag2=0;
		    			}
		    			}while(flag2==0);
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
			System.out.println("Nhập Tên nhân viên cần sửa thông tin: ");
			String name = Helper.scanner.nextLine();
			NhanVien NV2 = getByName(name);
			if(NV2 != null) {
				XoaNV(NV2);
			}else
				System.out.println("Nhân viên không tồn tại!!!");
			break;
			
		}
	}
	
	public void ShowQL(QuanLi QL ) {
		System.out.println("");
		// thấy có hàm xuất bản nhưng không biết dùng :))
		
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
		System.out.println("4.Tìm kiếm nhân viên.");
		System.out.println("5.Xuất ra toàn danh sách.");
		System.out.println("6.Thoát.");
	}
	public void Menu2() {
		System.out.println("1.Với mã nhân viên.");
		System.out.println("khác 1.với tên nhân viên( nhân viên đầu tiên có tên trong DS):");
	}
	public void LamViec() {
		Menu1();
		int chon;
		do {
			System.out.println("chọn thao tác: ");
			chon = Helper.nhapSoNguyen("Yêu cầu nhập số nguyên:");
			switch (chon) {
			case 1:
				NhapNVM();
				break;
	//chưa xong
			case 2:
				SuaNhanVien();
				break;
			case 3:
				XoaNhanVien();
				break;
	
			case 4:
				// thấy có hàm xuất mà không biết dùng....
				break;
			case 5:
				// thấy có hàm xuất mà không biết dùng....
				break;
			case 6:
				
				break;
			default:
				System.out.println("Đối số truyền vào không đúng.");
			}
			System.out.println("Nhập 1 để tiếp tục.");
			chon=Helper.nhapSoNguyen("Nhập số nguyên.");
		}while(chon!=6);
	}
}
