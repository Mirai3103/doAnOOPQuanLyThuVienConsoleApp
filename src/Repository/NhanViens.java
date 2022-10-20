package Repository;

import java.util.ArrayList;

import Model.NhanVien;


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
}
