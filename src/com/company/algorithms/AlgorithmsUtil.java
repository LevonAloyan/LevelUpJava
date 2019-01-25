package com.company.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AlgorithmsUtil {

    public static <T> List<T> bubbleSort(List<T> list, Comparator<T> comparator) {

        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    swap(list, j, j + 1);
                }
            }
        }
        return list;
    }

    public static <T> List<T> insertionSort (List<T> list, Comparator<T> comparator){


        return list;
    }

//    public static int [] selectionSort(int [] array){
//        int minIndex;
//        for (int i = 0; i < array.length -2; i++) {
//            minIndex = i;
//            for (int j = i+1; j <= array.length -1; j++) {
//                if (array[minIndex] > array[j]){
//                    minIndex = j;
//                }
//            }
//            swap(array, i, minIndex);
//        }
//        return array;
//    }


    private static <E> void swap(List<E> list, int first, int second) {
        E tmp;
        tmp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, tmp);
    }


    public static void main(String[] args) {
//        int[] array = {5, 3, 4, 2, 8, 9, 1, 7, 6, 0};
//        int[] bubbleSort = bubbleSort(array);
//        int[] selectionSort = selectionSort(array);
//        System.out.println(Arrays.toString(bubbleSort));
//        System.out.println(Arrays.toString(selectionSort));

        StringComparator stringComparator = new StringComparator();
        List<String> strings = new ArrayList<>();
        strings.add("Levon");
        strings.add("Gagik");
        strings.add("Vahe");
        strings.add("Aram");
        strings.add("Ashot");
        strings.add("Ash");

        List<String> strings1 = bubbleSort(strings, stringComparator);
        for (String s : strings1){
            System.out.println(s);
        }
    }
}
