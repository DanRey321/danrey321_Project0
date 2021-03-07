package com.project0.Util;

import com.project0.model.Cars;
import com.project0.model.Offers;

public class CarArrayList<C> {
    protected Cars[] array;
    protected Offers[] Oarray;
    protected int currentIndex = 0;

    public CarArrayList(){
        array = new Cars[0];
        Oarray = new Offers[0];
    }

    public CarArrayList(Cars[] array){
        this.array = array;
    }

    public CarArrayList(Offers[] oArray){
        this.Oarray = oArray;
    }



    public Cars getCar(int i){
        return array[i];
    }

    public Offers getOffer(int i){
        return Oarray[i];
    }

    public int size(){
        return array.length;
    }

    public int sizeOfOfferList(){
        return Oarray.length;
    }

    public void add(Cars c){
        Cars[] newArray = new Cars[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        // add new element
        newArray[array.length] = c;
        array = newArray;
    }
    public void addOffer(Offers o){
        Offers[] newArray = new Offers[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        // add new element
        newArray[Oarray.length] = o;
        Oarray = newArray;
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

    public void removeOffer(Object o) {
        int index = offerIndexOf((Offers) o);
        Offers[] temp = new Offers[Oarray.length - 1];

        for (int i = index; i < (Oarray.length - 1); i++) {
            Oarray[i] = Oarray[i + 1];
        }

        Oarray[Oarray.length - 1] = null;

        for (int i = 0; i < temp.length; i++) {
            temp[i] = Oarray[i];
        }

        Oarray = temp;

    }

    public int indexOf(Cars u) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(u)) {
                return i;
            }
        }

        return -1;
    }

    public int offerIndexOf(Offers u) {
        for (int i = 0; i < Oarray.length; i++) {
            if (Oarray[i].equals(u)) {
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
    protected void clearOffers() {
        for (int i = 0; i < Oarray.length; i++) {
            Oarray[i] = null;
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

//    public void orderOffers() {
//        for (int i = 0; i < Oarray.length; i++) {
//            for (int j = i + 1; j < Oarray.length; j++) {
//                if (Oarray[i].getOfferID().compareTo(Oarray[j].getOfferID()) > 0) {
//                    Cars temp = Oarray[i];
//                    Oarray[i] = Oarray[j];
//                    Oarray[j] = temp;
//                }
//            }
//        }
//    }

    boolean isEmpty() {
        for (Cars eachUser : array) {
            if (eachUser != null) {
                return false;
            }
        }
        return true;
    }

    boolean offerListEmpty() {
        for (Offers eachUser : Oarray) {
            if (eachUser != null) {
                return false;
            }
        }
        return true;
    }



}
