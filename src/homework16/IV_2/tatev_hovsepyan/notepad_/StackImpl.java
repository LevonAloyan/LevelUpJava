package homework16.IV_2.tatev_hovsepyan.notepad_;


public class StackImpl<E> implements Stack<E> {
    public static final int DEFAULT_CAPACITY = 16;

    /**
     * Data storage to store the StackImpl's values
     */
    private Object[] storage;

    /**
     * Index of the last element in the StackImpl.
     * Initial value must be -1.
     * This is not a length of data storage.
     * It must be increased when new element is added in to StackImpl
     * and decreased on pop action
     */
    private int tos;

//    START OF CONSTRUCTORS' BLOCK
    public StackImpl(int capacity) {
        this.storage = new Object[capacity];
        this.tos = -1;
    }

    public StackImpl() {
        this(DEFAULT_CAPACITY);
    }
//    END OF CONSTRUCTORS

    @Override
    public void push(E value) {
        if (tos == storage.length - 1){
            extendStorage();
        }
        storage[++tos] = value;
    }

    @Override
    public E pop() {
        if (tos == -1){
            return null;
        }
        return (E)storage[tos--];
    }

    private void extendStorage() {
        Object[] temp = new Object[1 + storage.length +  storage.length/2];
        System.arraycopy(storage, 0, temp, 0, storage.length);
        storage = temp;
    }

    public static void main(String[] args) {
        StackImpl box = new StackImpl();



        for (int i = 0; i < 10; i++) {
            System.out.print(box.pop());
        }
        System.out.println();
    }

}
