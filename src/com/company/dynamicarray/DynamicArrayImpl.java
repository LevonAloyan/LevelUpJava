package com.company.dynamicarray;

public class DynamicArrayImpl implements DynamicArray {
    private static final int DEFAULT_CAPACITY = 16;

    public int[] values;
    private int size;

    private int previousElement;

    public DynamicArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArrayImpl(int capacity) {
        this.values = new int[capacity];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(int element) {
<<<<<<< HEAD
        for (int index = 0; index < values.length; index++) {
            if (values[index] == element) {
                return true;
            }
        }
=======
        for (int i=0; i < size; i++)
            if (values[i]==element){
                return true;
            }
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
        return false;
    }

    @Override
    public int indexOf(int element) {
<<<<<<< HEAD
        for (int index = 0; index < values.length; index++) {
            if (values[index] == element) {
                return index;
=======
        for (int i=0; i < values.length; i++){
            if(values[i]==element){
                return i;
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int element) {
<<<<<<< HEAD
        int indexContains = 0;
        for (int index = 0; index < values.length; index++) {
            if (!contains(element)) {
                return -1;
            } else if (index != values.length && values[index] == element) {
                get(index);
                indexContains = index;
            }
        }
        return indexContains;
=======
        for (int i = values.length-1; i >= 0; i--) {
            if (values[i] == element) {
                return i;
            }
        }
        return -1;
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
    }

    @Override
    public int get(int index) {
        for (int i = 0; i < values.length; i++) {
            if (i == index) {
                return values[index];
            }
        }
        return 0;
    }

    @Override
    public int set(int index, int element) {
<<<<<<< HEAD
        for (int i = 0; i < values.length; i++) {
            if (i == index) {
                previousElement = values[index];
                values[index] = element;
                size--;
            }
        }
        return previousElement;
    }

    @Override
    public boolean add(int element) {
        for (int i = 0; i < values.length; i++) {
            if (size >= values.length) {
                extendArray(values);
            } else if (i == values.length - 1) {
                values[i] = element;
                size++;
                return true;
=======
        if (values[index] != 0){
            int currentElement = values[index];
            values[index]=element;
            size += 1;
            return currentElement;
        }
        else
        {
            values[index]=element;
            size += 1;
            return 0;
        }
    }

    @Override
    public boolean add(int e) {
        if (values.length == size){
            extend(values);
            values[size]=e;
            size += 1;
            return true;

        }else{
            for (int i=values.length-1; i >= 0; i--){
                if (values[i]==0){
                    values[i]=e;
                    size += 1;
                    return true;
                }
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
            }
        }
        return false;
    }

    @Override
    public void add(int index, int element) {
<<<<<<< HEAD
        int i = 0;
        for (; i < values.length; i++) {
            if (i == index) {
                previousElement = values[index];
                if (previousElement != element && previousElement != 0) {
                    values[index + 1] = previousElement;
                }
                values[index] = element;
                size++;
            }
=======
        int j=values.length-1;
        if(values.length==size||values[values.length-1]!=0){
            extend(values);
            for (int i=j; i >= index; i--){
                values[i+1]=values[i];
            }
            values[index]=element;
            size += 1;
        }else if (index==values.length-1){
            values[index]=element;
            size += 1;
        }else{
           for (int i=j; i > index; i--){
               values[i]=values[i-1];
           }
           values[index]=element;
           size += 1;
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
        }
    }


    @Override
    public int removeByIndex(int index) {
        for (int i = 0; i < values.length; i++) {
            if (i == index) {
                values[index] = 0;
                size--;
            }
        }
        return index;
    }

    @Override
    public boolean remove(int o) {
        if (contains(o)) {
            for (int index = 0; index < values.length; index++) {
                if (values[index] == o) {
                    values[index] = 0;
                    size--;
                    index = values.length;
                }
            }
            return true;
        } else {
            return false;
        }
    }

<<<<<<< HEAD
    private void extendArray(int[] array) {
        int[] temporaryArray = new int[values.length * 2];

        System.arraycopy(values, 0, temporaryArray, 0, values.length);
        values = temporaryArray;

=======
    private void extend(int[] array) {
        int[] temp = new int[array.length + 5];
        System.arraycopy(array, 0, temp, 0, array.length);
        values=temp;
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
    }
}
