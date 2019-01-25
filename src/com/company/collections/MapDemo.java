package com.company.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {

  public static void main(String[] args) {
    Map<String, Integer> map = new TreeMap<>();

    map.put("Levon", 24);
    map.put("Aram", 22);
    map.put("Gagik", 22);
    map.put("Ash", 21);
    map.put(null, 52);

    Integer aNull = map.get(null);
    System.out.println("Null: "+ aNull);
    Integer ash1 = map.put("Ash", 28);

    System.out.println(ash1);

    Integer ash = map.get("Ash");
    System.out.println(ash);

    System.out.println("Keys");

    for (String s : map.keySet()) {
      System.out.println(s);
    }
    System.out.println();
    System.out.println("values");
    for (Integer i : map.values()){
      System.out.println(i);
    }
    System.out.println();
    System.out.println("entry Set");
    Set<Entry<String, Integer>> entries = map.entrySet();
    for (Entry<String, Integer> entry : entries) {
      System.out.println(entry);
    }

  }

}
