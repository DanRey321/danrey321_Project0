package com.project0.Util;

import com.project0.model.Cars;

public class CarArrayList<C> {
    protected Cars[] array;
    protected int currentIndex = 0;

    public CarArrayList(){
        array = new Cars[0];
    }

    public CarArrayList(Cars[] array){
        this.array = array;
    }

    public Cars get(int i){
        return array[i];
    }

    public int size(){
        return array.length;
    }

    public void add(Cars c){
        Cars[] newArray = new Cars[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        // add new element
        newArray[array.length] = c;
        array = newArray;
    }

    public void remove(Object o) {
        int index = indexOf((Cars) o);
        Cars[] temp = new Cars[array.length - 1];

        for (int i = index; i < (array.length - 1); i++) {
            array[i] = array[i + 1];
        }

        array[array.length - 1] = null;

        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[i];
        }

        array = temp;

    }

    public int indexOf(Cars u) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(u)) {
                return i;
            }
        }

        return -1;
    }

    protected void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    public void order() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].getMake().compareTo(array[j].getMake()) > 0) {
                    Cars temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    boolean isEmpty() {
        for (Cars eachUser : array) {
            if (eachUser != null) {
                return false;
            }
        }
        return true;
    }



}
