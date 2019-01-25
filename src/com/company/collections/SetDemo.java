package com.company.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

  public static void main(String[] args) {

    Set<String> stringSet = new HashSet<>();
    stringSet.add("Levon");
    stringSet.add("Gagik");
    stringSet.add("Ash");
    stringSet.add("Aram");
    stringSet.add("Ashot");
    System.out.println("HashSet");
    for (String s : stringSet) {
      System.out.println(s);
    }

    stringSet = new LinkedHashSet<>();

    stringSet.add("Levon");
    stringSet.add("Gagik");
    stringSet.add("Aram");
    stringSet.add("Ashot");
    stringSet.add("Ash");

    System.out.println("LinkedHashSet");
    for (String s : stringSet) {
      System.out.println(s);
    }

    stringSet = new TreeSet<>();
    stringSet.add("Levon");
    stringSet.add("Gagik");
    stringSet.add("Aram");
    stringSet.add("Ashot");
    stringSet.add("Ash");
    System.out.println("TreeSet");
    for (String s : stringSet) {
      System.out.println(s);
    }


  }

}
