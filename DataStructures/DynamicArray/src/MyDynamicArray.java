public class MyDynamicArray {
    public int [] data;
    public int size;
    private static final int DEFAUT_SIZE = 10;


    public MyDynamicArray(int size) {
        data = new int[size];
    }

    public MyDynamicArray() {
        this(DEFAUT_SIZE);
    }

    public void ensureCapacity(int curSize) {
        int capacity = data.length;
        if (curSize > capacity) {
            int [] newData = new int[size*2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    public void add(int num) {
        ensureCapacity(size + 1);
        data[size] = num;
        size++;
    }

    public void travesal() {
        for(int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }
}
