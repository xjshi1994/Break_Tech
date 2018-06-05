public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {6,2,3,4,5,1};
        QuickSort qs = new QuickSort();
        qs.sort(nums, 0, nums.length-1);
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }

    /*
    * 1. partition array
    *   1.1 set end of array sentinel, init pIndex(the future pos of p) = start of array
    *  *1.2 move pIndex point
    *       1.2.1 if nums[i] < sentinel => swap(pIndex, i) && pIndex++
    *   1.3 swap(end, pIndex)
    *   1.4 return pIndex
    * 2. recursive sort left and right
    * */
    public void sort(int[] nums, int start, int end) {
        if (start <= end) {
            int pIndex = partition(nums, start, end);
            sort(nums, start, pIndex - 1);
            sort(nums, pIndex + 1, end);
        }
    }

    public int partition(int[] nums, int start, int end) {
        int sentinel = nums[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < sentinel) {
                swap(nums, pIndex, i);
                pIndex++;
            }
        }
        swap(nums, pIndex, end);
        return pIndex;
    }

    public void swap (int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}
