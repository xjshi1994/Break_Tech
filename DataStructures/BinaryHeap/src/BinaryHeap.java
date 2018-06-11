public class BinaryHeap {
    private final int d = 2;
    private int heapSize;
    private final int[] heap;


    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(6);
        heap.insert(3);
        heap.printHeap();
        System.out.println("*******************************");
        heap.insert(6);
        heap.printHeap();
        System.out.println("*******************************");
        heap.insert(7);
        heap.printHeap();
        System.out.println("*******************************");
        heap.insert(4);
        heap.printHeap();
        System.out.println("*******************************");
        heap.insert(5);
        heap.printHeap();
        System.out.println("*******************************");
        heap.delete(0);
        heap.printHeap();
        System.out.println("*******************************");
/*        int[] nums = {1,2,3};
        int a = (0-1)/2;
        System.out.println(a);
        System.out.println(nums[a]);*/
    }
    public BinaryHeap(int capacity) {
        this.heapSize = 0;
        heap = new int[capacity];
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    public int parent(int childIdx) {
        return (childIdx - 1) / 2;
    }

    public int getKthChild (int i, int k) {
        return 2 * i + k;
    }

    public void insert(int x) {
        if (!isFull()) {
            heap[heapSize] = x;
            heapifyUp3(heapSize);
            heapSize++;
        } else {
            throw new IllegalArgumentException("full!");
        }
    }


    /*
    * delete -> replace it with the last value of heap
    * heapifyDown the index
    * */
    public void delete(int idx) {
        if (idx >= heapSize) {
            throw new IllegalArgumentException();
        }

        // if there is one element in heap
        if (heapSize == 1) {
            heap[idx] = 0;
            return;
        }

        heap[idx] = heap[heapSize - 1];
        heap[heapSize - 1] = 0;
        heapSize--;
        heapifyDown2(idx);
    }

    /*
    * General idea: find min of 2 child -> swap
    * */

    /*
    assumption: cur has at least one child
    * */
    public int getMinIdx(int childIdx) {
        int leftIdx = getKthChild(childIdx, 1);
        int valLeft = heap[leftIdx];

        // cur has right child
        int rightIdx = getKthChild(childIdx,2);
        if (rightIdx < heapSize) {
            int valRight = heap[rightIdx];
            return (valLeft < valRight) ? leftIdx : rightIdx;
        } else {
            return leftIdx;
        }
    }

    // Recursive
    public void heapifyDown(int childIdx) {
        if (getKthChild(childIdx, 1) >= heapSize) return;

        int minIdx = getMinIdx(childIdx);

        if (heap[childIdx] < heap[minIdx]) return;

        swap(childIdx, minIdx);
        childIdx = minIdx;
        heapifyDown(childIdx);
    }

    // iterative
    public void heapifyDown2(int childIdx) {
        int temp = heap[childIdx];
        while (getKthChild(childIdx, 1) < heapSize) {
            int minIdx = getMinIdx(childIdx);
            if (temp > heap[minIdx]) {
                heap[childIdx] = heap[minIdx];
                childIdx = minIdx;
            } else {
                break;
            }
        }
        heap[childIdx] = temp;
    }

    public void heapifyUp(int childIdx) {
        if (childIdx <= 0) return;

        int parentIdx = parent(childIdx);

        if (heap[childIdx] > heap[parentIdx]) return;

        swap(childIdx, parentIdx);
        heapifyUp(parentIdx);
    }

    /*
    * General idea:
    * Important : if childIdx >= 0 -> parentIndx >= 0
    * */
    public void heapifyUp2(int childIdx) {
        int parentIdx = parent(childIdx);
        while (childIdx > 0 && heap[parentIdx] > heap[childIdx]) {
            swap(parentIdx, childIdx);
            childIdx = parentIdx;
            parentIdx = parent(childIdx);
        }
    }

    /*
    * General idea: use temp to store the childIdx val to decrease the operation of swap
    *
     * 1. store the init val heap[childIdx]
     * 2. swap
     *   2.1 childIdx greater than 0 and smaller than its parent
     *   2.2 assign the parent val to child
     * 3. assign the temp to final child val
     * */
    public void heapifyUp3(int childIdx) {
        int temp = heap[childIdx];
        while (childIdx > 0 && temp < heap[parent(childIdx)]) {
            heap[childIdx] = heap[parent(childIdx)];
            childIdx = parent(childIdx);
        }
        heap[childIdx] = temp;
    }



    public void printHeap() {
        for(int i : heap) {
            System.out.println(i);
        }
    }

    public void swap(int idx1, int idx2) {
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }
}
