/*

Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.

Sort the array "int[] nums" to make sure we can skip the same value.

when a number has the same value with its previous, we can use this number only if his previous is used*/
/*because we sorted our array so nums[i - 1] == nums[i] to avoid duplicate, but not enough in this situation: 1 1 2
        if you start from 1 value at index 0 , you can use backtracking to go to 1 value at index 1 so the result is : 1 1 2.
        If you only check nums[i - 1] == nums[i], you will be lost this case, but nums[i -1 ] used to go to i
        index so we need more condition to check previous index used or not
, it is to make sure that we are using the duplicate values
in the same permutation and not starting another duplicate permutation .

        */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public static void main(String[] args) {
        Permutations2 p2 = new Permutations2();
        int[] a = {1,1,2};
        System.out.println(p2.permuteUnique(a));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
           if (used[i] == true) continue;
           if (i > 0 && nums[i - 1] == nums[i] && !used[i-1]) continue;
           list.add(nums[i]);
           used[i] = true;
           dfs(nums, used, list, res);
           used[i] = false;
           list.remove(list.size()-1);
        }
    }
}



/*
*  if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
*
*
* */