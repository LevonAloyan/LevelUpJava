package com.company.generics;

import java.util.ArrayList;
import java.util.List;

import com.company.objectmethods.User;

public class Demo {

  public static void main(String[] args) {
    List list = new ArrayList();
    list.add(new User());
    list.add(12);
    list.add("Levon");

//    for (int i = 0; i < list.size(); i++) {
//      User user = (User) list.get(i);
//      System.out.println(user);
//
//    }

    List<String> stringList = new ArrayList<String>();
    stringList.add("Levon");
    stringList.add("Aram");
    stringList.add("Ashot");

    for (int i = 0; i < stringList.size(); i++) {
      String name = stringList.get(i);
      System.out.println(name);
    }


  }

}
