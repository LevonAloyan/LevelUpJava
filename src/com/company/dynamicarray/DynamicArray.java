package com.company.dynamicarray;


public interface DynamicArray {

    /**
     * Վերադաձնում է DynamicArray֊ի մեջ գտնվող էլեմենտների քանակը.
     *
     */
    int size();

    /**
     * Վերադաձնում է true եթե մասիվը չի պարունակում ոչ մի էլեմենտ.
     *
     */
    boolean isEmpty();

    /**
     *
     * Վերադարձնում է true եթե մասիվը պարունակում է նշված էլելմենտը
     *
     */
    boolean contains(int element);

    /**
     * Վերադարձնում է առաջինը հանդիպած տրված էլեմենտի ինդեքսը
     *
     */
    int indexOf(int element);

    /**
     *
     * Վերադարձնում է վերջինը հանդիպած տրված էլեմենտի ինդեքսը
     *
     */
    int lastIndexOf(int element);

      /**
       *
       * Վերադարձնում է մասսիվի֊ի մեջ գտնվող էլեմենտը ըստ տրված ինդեքսի
       *
     */
    int get(int index);

    /**
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
     */
    void add(int index, int element);

    /**
     *
     * պեքտ է ջնջել տրված ինդեքսով էլեմենտը մասիվի միջից, հետո տրված ինդեքսից աջ գտնվող բոլոր էլեմենտները տեղափոխել ձախ մի քայլ․
     *
     */
    int removeByIndex(int index);

    /**
     *
     * պեքտ է ջնջել տրված էլեմենտը մասիվի միջից (առաջին հանդիպած), հետո տրված ինդեքսից աջ գտնվող բոլոր էլեմենտները տեղափոխել ձախ մի քայլ․
     */
    public boolean remove(int o);
}
