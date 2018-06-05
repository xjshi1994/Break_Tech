public class RingBuffer {
    private final int[] data;
    private final int maxSize;
    public int currentSize;
    private int front;
    private int rear;


    public static void main(String[] args) {
        RingBuffer rb = new RingBuffer(3);
        rb.enQueue(0);
        rb.enQueue(1);
        rb.enQueue(2);
        rb.deQueue();
        rb.deQueue();
        rb.deQueue();
        System.out.println(rb.currentSize);
        int count = rb.currentSize;
        for (int i = 0 ; i < count; i++) {
            System.out.println(rb.deQueue());
        }
    }
    /*
    * 1. rear points to the last element
    * */
    public RingBuffer(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }


    public boolean isFull() {
        return currentSize == maxSize;
    }

    /*
     * 1. if full -> throw exception
     * 2. not full
     *   2.1 rear += 1 && pos = rear % maxSize
     *   2.2 if front == -1 => the first execution
     *   2.3 currentSize++
     * */
    public void enQueue(int num) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        } else {
            rear += 1;
            int pos = rear % maxSize;
            data[pos] = num;

            if (front == -1) {
                front = rear;
            }

            currentSize++;
        }
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    /*
    * 1. if empty -> throw
    * 2. not empty
    *   2.1 record data[front]
    *   2.2 set data[front] = null
    *   2.3 (front + 1) % maxSize
    *   2.4 currentSize--
    * */
    public int deQueue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            int deQueueData = data[front];
            data[front] = 0;
            front = (front + 1) % maxSize;
            currentSize--;
            return deQueueData;
        }
    }
}
