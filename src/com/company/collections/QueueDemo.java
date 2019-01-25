package com.company.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueDemo {

  public static void main(String[] args) {
    Deque<String> dequeue = new ArrayDeque<>();
     dequeue.addFirst("Levon");
     dequeue.addLast("Gagik");
     dequeue.addFirst("Aram");
     dequeue.addFirst("Ashot");
     dequeue.addLast("Ash");
//for getting elements
    String first = dequeue.getFirst();
    System.out.println("First: "+ first);

    String pop = dequeue.pop();
    System.out.println("Pop: "+ pop);

    String peek = dequeue.peek();
    System.out.println("Peek: "+ peek);

    String poll = dequeue.poll();
    System.out.println("Poll: "+ poll);

//    for setting elements

    dequeue.addFirst("Vahe");

    dequeue.push("Davit");

    dequeue.offer("Artur");





    for (String s : dequeue) {
      System.out.println(s);
    }
  }

}
