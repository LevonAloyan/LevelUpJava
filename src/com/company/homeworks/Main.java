package com.company.homeworks;

public class Main {

    public static void main(String[] args) {

        Box box1 = new Box("Box1",4,5,-1);
        Box box2 = new Box("Box2",10,1,2);
        Box box3 = new Box("Box2",10,1,2);
        Box box4 = new Box("Box4", 20, 1, 6);

        box1.countVolume();
        box2.countVolume();

        //box1.setWidth(1);
        //box2.setWidth(0);

       //System.out.println();
       //System.out.println(box1.getWidth()+box1.getHeight()+box1.getDepth());
       //System.out.println(box2.getWidth()+box2.getHeight()+box2.getDepth());
    }
}