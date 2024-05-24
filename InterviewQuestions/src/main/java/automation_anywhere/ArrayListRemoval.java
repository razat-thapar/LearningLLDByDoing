package automation_anywhere;

import java.util.ArrayList;

public class ArrayListRemoval<E> {
    private ArrayList<E> arrayList;
    public ArrayListRemoval() {
        this.arrayList = new ArrayList<>();
    }
    public void add(E element) {
        arrayList.add(element);
    }
    public void remove(Integer value){
        //linear search.
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i).equals(value)){
                //swap
                swap(i,arrayList.size()-1);
                //remove last element. O(1)
                arrayList.remove(arrayList.size()-1);
            }
        }
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }

    public void swap(int i, int j){
        E temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }
    public static void main(String[] args) {
        ArrayListRemoval<Integer> arrayListRemoval = new ArrayListRemoval<>();
        arrayListRemoval.add(1);
        arrayListRemoval.add(2);
        arrayListRemoval.add(3);
        arrayListRemoval.add(5);
        arrayListRemoval.add(8);
        arrayListRemoval.add(9);
        System.out.println(arrayListRemoval);
        arrayListRemoval.remove(3);
        System.out.println(arrayListRemoval);
    }
}
