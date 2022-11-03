package helper;


import Model.TheLoai;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Mang <T > implements Serializable, List<T> {

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

    public T set(int index, T value){
        arr[index] = value;
        return arr[index] ;
    }

    @Override
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

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(o)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if(!contains(o)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        for (T t : c) {
            add(index,t);
            index++;
        }
        return true;

    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
        // hàm này làm gì vậy
    }

    @Override
    public void clear() {
        arr = null;
        size = 0;
    }

    public T remove(int index){

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

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
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
  
    @Override
    public boolean isEmpty() {
        return arr == null || size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    // dưới đây là những hàm không biết kế thừa sao, mà cũng chẳng cần dùng nên thôi
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return this.arr;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
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
