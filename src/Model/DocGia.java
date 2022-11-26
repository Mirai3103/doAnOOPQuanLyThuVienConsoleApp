package Model;
import java.io.Serializable;
import helper.Helper;
import helper.Xuat.ITableRowData;

import java.io.Serial;
import java.time.LocalDate;

public class DocGia extends ConNguoi implements Serializable, ITableRowData {
	@Serial
	private static final long serialVersionUID = -266706354210367639L;
    protected int IDdg;
    protected int IDthe;
    public DocGia()
    {
    }

	public DocGia(String hoTen, String ngaySinh, String sDT, String cMND, DiaChi dC, int IDdg, int IDthe) {
		super(hoTen, ngaySinh, sDT, cMND, dC);
		this.IDdg = IDdg;
		this.IDthe = IDthe;
	}

	public void nhapDocGia()
    {
        super.Nhap();
    }
	public int getIDdg() {
		return IDdg;
	}

	public void setIDdg(int IDdg) {
		this.IDdg = IDdg;
	}

	public int phiTaoThe()
	{
		return LocalDate.now().getYear()- Helper.parseDate(this.getNgaySinh()).getYear() > 18 ? 50000 : 20000;
	}



	public int getIDthe() {
		return IDthe;
	}
	public void setIDthe(int IDthe) {
		this.IDthe = IDthe;
	}
	@Override
	public String[] getRowData() {
	    return new String[]{
	    		this.IDdg+"",
	    		this.IDthe+"",
					    		this.getHoTen(),
					    		this.getNgaySinh(),
					    		this.getSDT(),
					    		this.getCMND(),
					    		this.getDC().toString(),
	        };
	    }
	 @Override
	 public String[] getHeader() {
		 return new String[]{"ID Độc Giả", "ID Thẻ", "Họ Tên", "Ngày Sinh", "Số Điện Thoại", "CMND", "Địa Chỉ"};
	 }

}
