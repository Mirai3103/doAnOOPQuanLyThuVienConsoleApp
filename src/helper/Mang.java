package helper;


import Model.TheLoai;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Mang <T > implements Serializable {

    @Serial
    private static final long serialVersionUID = 13422433000119L;
    private T[] arr ;
    private int size ;
    public Mang(){
        arr =null;
        size=0;

    }

    public T[] getAll(){
        return arr;
    }
    public T get(int index){
        return  arr[index];
    }

    public T set(int index, T value){
        arr[index] = value;
        return arr[index] ;
    }


    public void add(int index, T element) {
        T[] temp = (T[]) new Object[size+1];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }
        temp[index] = element;
        for (int i = index+1; i < size+1; i++) {
            temp[i] = arr[i-1];
        }
        arr = temp;
        size++;
    }

    public boolean isInRange(int index){
        return index >= 0 && index < size;
    }
    public boolean add(T value){

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
        return true;
    }


    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(o)){
                remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if(!contains(o)){
                return false;
            }
        }
        return true;
    }


    public boolean addAll(Mang<T> c) {
        for (int i = 0; i < c.size; i++) {
            add(c.get(i));
        }
        return true;
    }


    public boolean addAll(int index, Collection<? extends T> c) {
        for (T t : c) {
            add(index,t);
            index++;
        }
        return true;

    }


    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }


    public boolean retainAll(Collection<?> c) {
        return false;
        // hàm này làm gì vậy
    }


    public void clear() {
        arr = null;
        size = 0;
    }

    public T remove(int index){
        if(!isInRange(index)){
            throw new IndexOutOfBoundsException("Chỉ số nằm ngoài phạm vi");
        }

        if(isInRange(index)){
            T rs= arr[index];

            T[] temp = (T[]) new Object[size-1];
            for (int i = 0; i < index; i++) {
                temp[i] = arr[i];
            }
            for (int i = index+1; i < size; i++) {
                temp[i-1] = arr[i];
            }
            arr = temp;
            size--;
            return rs;
        }
        return null;
    }


    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }


    public int lastIndexOf(Object o) {
        for (int i = size-1; i >= 0; i--) {
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }




    public int size(){
        return size;
    }
  

    public boolean isEmpty() {
        return arr == null || size == 0;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    // dưới đây là những hàm không biết kế thừa sao, mà cũng chẳng cần dùng nên thôi

}
