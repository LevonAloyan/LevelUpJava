package com.company.dynamicarray;


public interface DynamicArray {

    /**
<<<<<<< HEAD
     * Returns the number of elements in this DynamicArray.
     *
     * @return the number of elements in this DynamicArray
=======
     * Վերադաձնում է DynamicArray֊ի մեջ գտնվող էլեմենտների քանակը.
     *
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
     */
    int size();

    /**
<<<<<<< HEAD
     * Returns <tt>true</tt> if this DynamicArray contains no elements.
     *
     * @return <tt>true</tt> if this DynamicArray contains no elements
=======
     * Վերադաձնում է true եթե մասիվը չի պարունակում ոչ մի էլեմենտ.
     *
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
     */
    boolean isEmpty();

    /**
<<<<<<< HEAD
     * Returns <tt>true</tt> if this DynamicArray contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this DynamicArray contains
     * at least one element <tt>e</tt> such that
     * o==null ? get(i)==null : o.equals( get(i) ).
     *
     * @param element element whose presence in this DynamicArray is to be tested
     * @return <tt>true</tt> if this DynamicArray contains the specified element
=======
     *
     * Վերադարձնում է true եթե մասիվը պարունակում է նշված էլելմենտը
     *
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
     */
    boolean contains(int element);

    /**
<<<<<<< HEAD
     * Returns the index of the I_12 occurrence of the specified element
     * in this DynamicArray, or -1 if this DynamicArray does not contain the element.
     * More formally, returns the lowest index <tt>i</tt> such that
     * o==null ? get(i)==null : o.equals( get(i) )
     * or -1 if there is no such index.
=======
     * Վերադարձնում է առաջինը հանդիպած տրված էլեմենտի ինդեքսը
     *
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
     */
    int indexOf(int element);

    /**
<<<<<<< HEAD
     * Returns the index of the last occurrence of the specified element
     * in this DynamicArray, or -1 if this DynamicArray does not contain the element.
     * More formally, returns the highest index <tt>i</tt> such that
     * o==null ? get(i)==null : o.equals( get(i) )
     * or -1 if there is no such index.
=======
     *
     * Վերադարձնում է վերջինը հանդիպած տրված էլեմենտի ինդեքսը
     *
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
     */
    int lastIndexOf(int element);

      /**
<<<<<<< HEAD
     * Returns the element at the specified position in this DynamicArray.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this DynamicArray
     * @throws IndexOutOfBoundsException
=======
       *
       * Վերադարձնում է մասսիվի֊ի մեջ գտնվող էլեմենտը ըստ տրված ինդեքսի
       *
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
     */
    int get(int index);

    /**
<<<<<<< HEAD
     * Replaces the element at the specified position in this DynamicArray with
     * the specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException
     */
    int  set(int index, int element);

    /**
     * Appends the specified element to the end of this DynamicArray.
     *
     * @param element -> element to be appended to this DynamicArray
     * @return <tt>true</tt>
     */
    boolean add(int element);

    /**
     * Inserts the specified element at the specified position in this
     * DynamicArray. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException
=======
     *
     * Փոխարինում է տրված ինդեքսի տակ գտնվող էլեմենտը տրված էլեմենտով
     *
     */
    int set(int index, int element);

    /**
     * այս մեթոդը նախատեսված է մասիվի մեջ (վերջում) ավելացնել ընդունող value-ն; ամեն անգամ ավելացնելուց առաջ պետք է ստուգել
     * արդյոք մասիվի մեջ տեղ կա թե ոչ? եթե չկա, կանչել extend մեթոդը
     *
     */
    boolean add(int value);

    /**
     *
     * այս մեթոդը նախատեսված է մասիվի մեջ տրված էլեմենտը տրված ինդեքսում ավելացնելու համար,
     * տրված ինդեքսիդ աջ գտնվող բոլոր էլեմենտները պետք է տեղափոխել մի քայլ աջ, եթե մասիվի մեջ տեղ չկա, կանչել extend մեթոդը
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
     */
    void add(int index, int element);

    /**
<<<<<<< HEAD
     * Removes the element at the specified position in this DynamicArray.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the DynamicArray
     * @throws IndexOutOfBoundsException
=======
     *
     * պեքտ է ջնջել տրված ինդեքսով էլեմենտը մասիվի միջից, հետո տրված ինդեքսից աջ գտնվող բոլոր էլեմենտները տեղափոխել ձախ մի քայլ․
     *
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
     */
    int removeByIndex(int index);

    /**
<<<<<<< HEAD
     * Removes the I_12 occurrence of the specified element from this DynamicArray,
     * if it is present.  If the DynamicArray does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * <tt>i</tt> such that
     * <tt>(o==null? get(i)==null : o.equals( get(i) ) )</tt>
     * (if such an element exists).  Returns <tt>true</tt> if this DynamicArray
     * contained the specified element (or equivalently, if this DynamicArray
     * changed as I_12 result of the call).
     *
     * @param o element to be removed from this DynamicArray, if present
     * @return <tt>true</tt> if this DynamicArray contained the specified element
=======
     *
     * պեքտ է ջնջել տրված էլեմենտը մասիվի միջից (առաջին հանդիպած), հետո տրված ինդեքսից աջ գտնվող բոլոր էլեմենտները տեղափոխել ձախ մի քայլ․
>>>>>>> c4fb05ca73a3263a8a5e86968b51f4c3a85d31ce
     */
    public boolean remove(int o);
}
