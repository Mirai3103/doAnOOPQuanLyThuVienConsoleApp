package Model;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.io.Serializable;

import Repository.DocGias;
import Repository.TongHopDuLieu;
import helper.Helper;
import helper.Xuat.ITableRowData;
import java.io.Serial;
public class TheThuVien implements Serializable, ITableRowData{
	@Serial
	private static final long serialVersionUID = -266706354210367639L;
	private  int IDthe;
	private int IDuser;
	private LocalDate ngaybd;
	private LocalDate ngayhh;
	private String ghichu;
	public TheThuVien()
	{
		Date date = new Date();
		ngaybd = LocalDate.now();
		ngayhh = LocalDate.now().plusYears(1);
	}
	public TheThuVien(String IDthe,LocalDate ngaybd,int IDuser,LocalDate ngayhh,String ghichu)
	{
		this.IDuser=IDuser;
		this.ngaybd=ngaybd;
		this.ngayhh=ngayhh;
		this.ghichu=ghichu;
	}
	public void giaHanThe()
	{
		this.ngayhh = this.ngayhh.plusYears(1);
	}

	public void setIDthe(int IDthe) {
		this.IDthe = IDthe;
	}

	public void setNgaybd(LocalDate ngaybd) {
		this.ngaybd = ngaybd;
	}

	public int getIDthe() {
		return IDthe;
	}
	public int getIDuser()
	{
		return IDuser;
	}
	public void setIDuser(int IDuser)
	{
		this.IDuser=IDuser;
		TongHopDuLieu.getDanhSachDocGia().getById(IDuser).setIDthe(IDthe);
	}
	public LocalDate getNgayHetHan()
	{
		return ngayhh;
	}
	public LocalDate getNgaybdDate() {
		return ngaybd;
	}
	public void setNgayhh(LocalDate ngayhh) {
		this.ngayhh = ngayhh;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	@Override
	public String toString() {
		return "TheThuVien [IDthe=" + IDthe + ",IDuser=" + IDuser + ", ngaybd=" + ngaybd + ", ngayhh=" + ngayhh + ", ghichu=" + ghichu + "]";
	}
	public void xuatTheThuVien()
	{
		System.out.println("ID thẻ: "+IDthe);
		System.out.println("ID độc giả: "+IDuser +"Tên độc giả: "+getUser().getHoTen());
		System.out.println("Ngày bắt đầu: "+ngaybd);
		System.out.println("Ngày hết hạn: "+ngayhh);
		System.out.println("Ghi chu: "+ghichu);
	}
	public void themTheThuVien()
	{
		System.out.print("Nhập IDuser: ");
		this.IDuser = Integer.parseInt(Helper.inputNoneEmptyString());
		String dateStr;
		var isDateValid = false;
		do {
			System.out.print("Nhập ngày hết hạn(dd/MM/yyyy): ");
			dateStr = Helper.inputNoneEmptyString();
			isDateValid = Helper.checkNgayThang(dateStr);
		}while (!isDateValid);


		System.out.print("Nhập ghi chú: ");
		this.ghichu = Helper.inputNoneEmptyString();
	}
	public DocGia getUser(){
		return TongHopDuLieu.getDanhSachDocGia().getById(IDuser);
	}
	public void themTheThuVien(int IDuser)
	{
		this.IDuser = IDuser;
		String dateStr;
		var isDateValid = false;
		do {
			System.out.print("Nhập ngày hết hạn(dd/MM/yyyy): ");
			dateStr = Helper.inputNoneEmptyString();
			isDateValid = Helper.checkNgayThang(dateStr);
		}while (!isDateValid);
		System.out.print("Nhập ghi chú: ");
		this.ghichu = Helper.inputNoneEmptyString();
	}
	public void inThe()
	{
		var chuThe = getUser();
		System.out.println("ID thẻ: "+IDthe);
		System.out.println("ID user: "+IDuser);
		System.out.println("Họ tên chủ thẻ: "+chuThe.getHoTen());
		System.out.println("Ngày bắt đầu: " + this.ngaybd);
		System.out.println("Ngày hết hạn: " + this.ngayhh);
		System.out.println("Ghi chú: " + this.ghichu);
	}
	public boolean checkHetHan()
	{
		return LocalDate.now().isAfter(ngayhh);
	}
	public void suaTheThuVien()
	{


		System.out.println("1. Sửa ngày hết hạn");
		System.out.println("2. Sửa ghi chú");
		System.out.println("3. Quay lại");
		System.out.print("Nhập lựa chọn: ");
		int luachon = Integer.parseInt(Helper.inputNoneEmptyString());
		switch(luachon)
		{
			case 1:
				String dateStr;
				var isDateValid = false;
				do {
					System.out.print("Nhập ngày hết hạn(dd/MM/yyyy): ");
					dateStr = Helper.inputNoneEmptyString();
					isDateValid = Helper.checkNgayThang(dateStr);
				}while (!isDateValid);
				break;
			case 2:
				System.out.print("Nhập ghi chú: ");
				this.ghichu = Helper.inputNoneEmptyString();
				break;
			case 3:
				break;
		}
	}
	@Override
	public String[] getRowData() {
		return new String[]{
				this.IDthe + "",
				this.IDuser + "",
				this.ngaybd.format(Helper.DATE_FORMAT),
				this.ngayhh.format(Helper.DATE_FORMAT),
				this.ghichu,
		};
	}
	@Override
	public String[] getHeader() {
		return new String[]{"IDthe", "IDuser", "Ngày bắt đầu", "Ngày hết hạn", "Ghi chú"};
	}


}