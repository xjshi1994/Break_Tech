public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinarySearch b = new BinarySearch();
        System.out.println(b.search(nums, 0, nums.length - 1, 11));
    }

    public int search(int[] nums, int lo, int hi, int target) {
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] < target) return search(nums, mid + 1, hi, target);
            if (nums[mid] > target) return search(nums, lo, mid - 1, target);
        }
        return -1;
    }
}
