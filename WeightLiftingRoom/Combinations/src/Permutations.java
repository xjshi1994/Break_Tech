import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        Permutations p = new Permutations();
        System.out.println(p.permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(result, temp, nums);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new LinkedList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtrack(result, temp, nums);
            temp.remove(temp.size()-1);
        }
    }
}
