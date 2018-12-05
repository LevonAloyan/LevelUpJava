package com.company.bracechecker;

public class StackImpl implements Stack {

    private static final int DEFAULT_CAPACITY = 16;
    private Object[] array;
    private int tos = -1;

    public StackImpl() {
        array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return 0;
        }
        return array[tos--];
    }

    @Override
    public void push(Object element) {
        if (tos >= array.length - 1) {
            extend();
        }
        array[++tos] = element;
    }


    public int size() {
        return array.length;
    }

    public boolean isEmpty() {
        return tos == -1;
    }

    private void extend() {
        Object[] temp = new Object[array.length * 2];
//        for (int i = 0; i < array.length; i++) {
//            temp[i] = array[i];
//        }
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }

}
