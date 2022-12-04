package Repository;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.NhanVien;
import Model.QuanLi;
import Model.ThuThu;
import helper.Helper;
import helper.Mang;
import helper.Xuat.Table;


public class NhanViens  extends BaseDanhSach<NhanVien>{
	@Serial
	private static final long serialVersionUID = 12121212L;
	public static String FILE_PATH = Helper.dirPath + "NhanViens.bin";
	public void xuatFileBinary() {
		super.xuatFileBinary(FILE_PATH);
	}

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
	public void xuatToanBoNv(ArrayList<NhanVien> nhanViens){
		Mang<ThuThu> a = new Mang<ThuThu>();
		Mang<QuanLi> b = new Mang<QuanLi>();
		for(var i : nhanViens) {
			if(i instanceof ThuThu) {
				a.add((ThuThu)i);
			} else {
				b.add((QuanLi)i);
			}
		}
		System.out.println("Danh sách thủ thư: ");
		System.out.println(Table.taoBang(a));
		System.out.println("\n ------------------------------- \nDanh sách quản lý: ");
		System.out.println(Table.taoBang(b));

	}
	public void xuatToanBoNv(){
		this.xuatToanBoNv(data);
	}
	public Mang<NhanVien> getByName(String name) {
		Mang<NhanVien> a = new Mang<NhanVien>();
		for(NhanVien NV : data) {
			if(NV.getHoTen().toUpperCase().contains(name.toUpperCase()))
				a.add(NV);
		}
		if(a.size()!=0)
			return a;
		else 
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
				System.out.println("Nhập mã nhân viên (6 kí tự): ");
				String maNV ;
				do {
					 maNV = Helper.scanner.nextLine();
					if(maNV.length() !=6){
						System.out.println("Mã nhân viên không hợp lệ !");
					}
				}while (maNV.length() !=6);
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
				String maNV ;
				do {
					maNV = Helper.scanner.nextLine();
					if(maNV.length() !=6){
						System.out.println("Mã nhân viên không hợp lệ !");
					}
				}while (maNV.length() !=6);
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
		System.out.println("Nhập mã nhân viên cần sửa thông tin");
		String MaNV = Helper.scanner.nextLine();
		if (checkId(MaNV)) {
			NhanVien a = getByMaNV(MaNV);
			if(a instanceof QuanLi) {
				var k = new Mang<QuanLi>();
				k.add((QuanLi)a);
				System.out.println(Table.taoBang(k));
				System.out.println();
				((QuanLi) a).sua();
			}
			else {
				var k = new Mang<ThuThu>();
				k.add((ThuThu)a);
				System.out.println(Table.taoBang(k));
				((ThuThu) a).sua();
			}
		} else {
			System.out.println("Nhân viên không tồn tại");
		}
	}
	
	public void XoaNhanVien() {

		
			System.out.println("Nhập mã nhân viên cần xóa: ");
			String MaNV = Helper.scanner.nextLine();
			NhanVien NV = getByMaNV(MaNV);
			if(NV != null) {

				System.out.println("Đây là nhân viên sắp xóa");
				Mang<NhanVien> NhanVienSapXoa = new Mang<>();
				NhanVienSapXoa.add(getByMaNV(MaNV));
				if (NhanVienSapXoa.size() == 0) {
					return;
				}
				System.out.println(Table.taoBang(NhanVienSapXoa));
				 System.out.print("Bạn có chắc muốn xóa không (y/n): ");
			       if(Helper.scanner.nextLine().equals("y")) {
			        	System.out.println("Đã xóa!!");
			        	XoaNV(NV);
                return;
			        } 	
			        System.out.println("Đã hủy xóa!!");
			}else
				System.out.println("Nhân viên không tồn tại!!");
	
	}
	
	public void ShowQL(QuanLi QL ) {
		System.out.println("");
		// thấy có hàm xuất bản nhưng không biết dùng :))
		
	}
	

	public List<NhanVien> DocFile() {
	        try {
	            FileInputStream finput = new FileInputStream("E:\\data.obj");
	            ObjectInputStream objinput = new ObjectInputStream(finput);
	            ArrayList<NhanVien> DATA = (ArrayList<NhanVien>) objinput.readObject();
	            return DATA;

	        } catch (Exception e) {

	            e.printStackTrace();
	            return null;
	        }
	    }
	
	//ghi file
	public void TimKiemNV() {
		Mang<QuanLi> QL = new Mang<QuanLi>();
		Mang<ThuThu> TT = new Mang<ThuThu>();
		Menu2();
		System.out.println("Nhập phương thức cần chọn: ");
		int q = Helper.nhapSoNguyen("yêu cầu nhập số 1 hoặc 2: ");
		switch (q) {
			case 1:{
				System.out.println("Nhập mã nhân viên cần tìm kiếm thông tin: ");
				String MaNV = Helper.scanner.nextLine();
				if (checkId(MaNV)) {
					NhanVien a = getByMaNV(MaNV);
					if(a instanceof QuanLi) {
						QL.add((QuanLi)a);
					}
					else {
						TT.add((ThuThu)a);
					}
				} else {
					System.out.println("Nhân viên không tồn tại");
				}
				break;
			}
			case 2:{
				System.out.println("Nhập tên nhân viên muốn tìm thông tin: ");
				String name = Helper.scanner.nextLine();
				Mang<NhanVien> NV = getByName(name);
				if(NV != null) {
					
					for(int i=0 ; i < NV.size();i++)
						if(NV.get(i) instanceof QuanLi) {
							QL.add((QuanLi)NV.get(i));
						}else
							TT.add((ThuThu) NV.get(i));
				}
				break;
					
			}
			default:
				System.out.println("Tên nhân viên không tông tại");
		}
		System.out.println("Kết quả tìm kiếm: ");
		System.out.println("Quản Lí: ");
		System.out.println(Table.taoBang(QL));
		System.out.println("Thủ thư: ");
		System.out.println(Table.taoBang(TT));
	}

	
	public void Menu1() {
		Helper.clearScreen();

		System.out.println("1.Nhập nhân viên mới.");
		System.out.println("2.sửa nhân viên.");
		System.out.println("3.Xóa nhân viên.");
		System.out.println("4.Tìm kiếm nhân viên.");
		System.out.println("5.Xuất ra toàn danh sách.");
		System.out.println("6.Thoát.");
	}
	public void Menu2() {

		System.out.println("1.Với mã nhân viên()tìm kiếm tuyệt đối).");
		System.out.println("khác 1.với tên nhân viên (tìm kiếm tương đối):");
	}
	public void LamViec() {
		int chon;
		do {
			Menu1();
			System.out.println("chọn thao tác: ");
			chon = Helper.nhapSoNguyen("Yêu cầu nhập số nguyên:");
			switch (chon) {
			case 1:
				NhapNVM();
				break;
			case 2:
				SuaNhanVien();
				break;
			case 3:
				XoaNhanVien();
				break;
	
			case 4:
				TimKiemNV();
				break;
			case 5:
				xuatToanBoNv();
				break;
			case 6:
				this.xuatFileBinary(FILE_PATH);
				break;
			default:
				System.out.println("Đối số truyền vào không đúng.");
			}
		}while(chon!=6);
	}

	public static void main(String[] args) {
	   TongHopDuLieu.getNhanViens().LamViec();
	}

	@Override
	public void copyFrom(IDanhSach<NhanVien> other) {
		var otherList = (NhanViens) other;
		this.data = new ArrayList<>(otherList.data);
	}

	@Override
	public void add(NhanVien item) {
		this.data.add(item);
	}
}
