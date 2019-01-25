package com.company.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Levon");
    list.add("Gagik");
    list.add("Ashot");
    list.add("Aram");
    list.add("Ash");
    list.add(3,"Vahe");

//    String s = list.get(3);
//    System.out.println(s);
    list.remove("Ash");
    String remove = list.remove(2);
    System.out.println("this element was deleted from list: "+ remove);

    for (String s1 : list) {
      System.out.println(s1);
    }

    list = new LinkedList<>();
    list.add("Levon");
    list.add("Gagik");
    list.add("Ashot");
    list.add("Aram");
    list.add("Ash");

    System.out.println();
    System.out.println("LinkedList");

    for (String s : list) {
      System.out.println(s);
    }

    String s = list.get(3);
    System.out.println(s);

  }

}
