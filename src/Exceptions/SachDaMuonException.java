package Exceptions;


public class SachDaMuonException extends RuntimeException{

    public SachDaMuonException() {
        super("Sách đã được mượn");
    }
}
