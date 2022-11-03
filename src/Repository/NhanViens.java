package Repository;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import Model.NhanVien;
import Model.QuanLi;
import Model.ThuThu;
import helper.Helper;


public class NhanViens  extends BaseDanhSach<NhanVien>{
	public static String FILE_PATH = Helper.dirPath + "NhanViens.bin";
	

	public ArrayList<NhanVien> getNVs() {
		return data;
	}

	public void setNVs(ArrayList<NhanVien> nVs) {
		data = nVs;
	}
	
	public void ThemNV(NhanVien e) {
		data.add(e);
	}
	
	public void XoaNV(NhanVien e) {
		data.remove(e);
	}
	
	public NhanVien getByMaNV(String MaNV) {
		for(NhanVien NV : data) {
			if(NV.getMaNV().equalsIgnoreCase(MaNV))
				return NV;
		}
		return null;
	}
	
	public NhanVien getByName(String name) {
		for(NhanVien NV : data) {
			if(NV.getHoTen().equalsIgnoreCase(name))
				return NV;
		}
		return null;
	}
	public boolean checkId(String id) {
		for(NhanVien NV : data) {
			if(NV.getMaNV().equalsIgnoreCase(id))
				return true;
		}
		return false;
	}
	
	public void NhapNVM() {
		System.out.println("0.Là Quản lí");
		System.out.println("khác 0. Là thủ thư: ");
		System.out.println("Nhân Viên mới là: ");
		int chon = Helper.nhapSoNguyen("Nhập số nguyên: ");
		switch (chon) {
		case 0:
			QuanLi QL = new QuanLi();
			boolean maCoTrungHayK=false;
			do {
				System.out.println("Nhập mã nhân viên: ");
				String maNV = Helper.scanner.nextLine();
				if(checkId(maNV)) {
					System.out.println("Mã nhân viên đã tồn tại, mời nhập lại: ");
					maCoTrungHayK=true;
				}
				else {
					QL.Nhap(maNV);
					maCoTrungHayK=false;
				}
			}while(maCoTrungHayK);
        	data.add(QL);
			break;
		default:
			ThuThu TT = new ThuThu();
			boolean maCoTrungHayK1=false;
			do {
				System.out.println("Nhập mã nhân viên: ");
				String maNV = Helper.scanner.nextLine();
				if(checkId(maNV)) {
					System.out.println("Mã nhân viên đã tồn tại, mời nhập lại: ");
					maCoTrungHayK1=true;
				}
				else {
					TT.Nhap(maNV);
					maCoTrungHayK1=false;
				}
			} while (maCoTrungHayK1);
        	data.add(TT);
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
		    			if(data.stream().filter(s -> s.getMaNV()==QL.getMaNV()).findFirst().orElse(null)!=null) {
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
		    			if(data.stream().filter(s -> s.getMaNV()==TT.getMaNV()).findFirst().orElse(null)!=null) {
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
		    			if(data.stream().filter(s -> s.getMaNV()==QL.getMaNV()).findFirst().orElse(null)!=null) {
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
		    			if(data.stream().filter(s -> s.getMaNV()==TT.getMaNV()).findFirst().orElse(null)!=null) {
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
				System.out.println("Nhập tên nhân viên cần tìm: "); // hoac id hay gi do
				String name = Helper.scanner.nextLine();
				NhanVien NV = getByName(name);
				if(NV != null) {
					System.out.println("Nhân viên có tên "+name+" là: ");
					NV.Xuat();
				}else
					System.out.println("Nhân viên không tồn tại!!!");

				break;
			case 5:
				xuatConsoleDangTable();
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

	public static void main(String[] args) {
	   TongHopDuLieu.getNhanViens().LamViec();
	}
}
