package com.company.staticDemo;

import java.util.Date;


public class Car {

  private String model = "";
  private final Date date = new Date();
  private int wheelCount;
  private boolean isAutomatic;

  private static final int carCount;

  static {
    carCount = 5;
  }

  public Car() {
    wheelCount = 5;
//    carCount++;
  }

  public Car(String model, int wheelCount, boolean isAutomatic) {
    this.model = model;
    this.wheelCount = wheelCount;
    this.isAutomatic = isAutomatic;
  }

  protected void print(String s){
    System.out.println(s);
  }

  public static int getCarCount() {
    return carCount;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getWheelCount() {
    return wheelCount;
  }

  public void setWheelCount(int wheelCount) {
    this.wheelCount = wheelCount;
  }

  public boolean isAutomatic() {
    return isAutomatic;
  }

  public void setAutomatic(boolean automatic) {
    isAutomatic = automatic;
  }

}
