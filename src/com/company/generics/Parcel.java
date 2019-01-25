package com.company.generics;

public class Parcel<E> {

  private E object;

  public void setObject(E o){
    object = o;
  }

  public E getObject(){
    return object;
  }

  public static void main(String[] args) {
    Parcel<String> parcel = new Parcel<>();
    parcel.setObject("gift");
    String object = parcel.getObject();
    System.out.println(object);
  }
}
