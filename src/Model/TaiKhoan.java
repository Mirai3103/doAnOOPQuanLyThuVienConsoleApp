package Model;

public class TaiKhoan {

    private String username;
    private String password;
    private String access;
   
    public TaiKhoan(){
        username="";
        password="";
        access="";
    }

    public TaiKhoan(String username, String password, String access){
        this.username=username;
        this.password=password;
        this.access=access;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
