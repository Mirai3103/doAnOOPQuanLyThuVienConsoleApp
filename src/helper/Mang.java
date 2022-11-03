package helper;


import Model.TheLoai;

import java.io.Serial;
import java.io.Serializable;

public class Mang <T > implements Serializable{
    @Serial
    private static final long serialVersionUID = 13424000119L;
    private T[] arr ;
    private int size ;
    public Mang(){
        arr =null;
        size=0;

    }
    public T get(int index){
        return  arr[index];
    }
    public void set(int index, T value){
        arr[index] = value;
    }
    public boolean isInRange(int index){
        return index >= 0 && index < size;
    }
    public void add(T value){
        if(size == 0){
            arr = (T[]) new Object[1];
            arr[0] = value;
            size++;
        }else {
            T[] temp = (T[]) new Object[size+1];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            temp[size] = value;
            arr = temp;
            size++;
        }
    }
    public void remove(int index){
        if(isInRange(index)){
            T[] temp = (T[]) new Object[size-1];
            for (int i = 0; i < index; i++) {
                temp[i] = arr[i];
            }
            for (int i = index+1; i < size; i++) {
                temp[i-1] = arr[i];
            }
            arr = temp;
            size--;
        }
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        // cach dung;
        Mang<TheLoai> mang = new Mang<>();
        mang.add(new TheLoai("The loai 1", "Mo ta 1"));
        mang.add(new TheLoai("The loai 2", "Mo ta 2"));
        mang.add(new TheLoai("The loai 3", "Mo ta 3"));
        for (int i = 0; i < mang.size(); i++) {
            System.out.println(mang.get(i).getTenTheLoai());
        }

    }
}
