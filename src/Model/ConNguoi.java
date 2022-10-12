package Model;

public class ConNguoi {
	private String HoTen, NgaySinh, SDT, CMND;
	private DiaChi DC = new DiaChi();
	
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public DiaChi getDC() {
		return DC;
	}
	public void setDC(DiaChi dC) {
		DC = dC;
	}
	
	public ConNguoi() {
		HoTen = NgaySinh = SDT = CMND = null;
		DC = null;
	}
	
	public void Nhap() {
		
	}
	
	public void Xuat() {
		
	}
	
}
