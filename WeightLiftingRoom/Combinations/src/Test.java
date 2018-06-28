import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.combine(8, 6));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new LinkedList<>();
        comb(result, temp, 1, n, k);
        return result;
    }

    public void comb(List<List<Integer>> result, List<Integer> temp, int start, int n, int k) {
        if (k == 0) {
            result.add(new LinkedList<>(temp));
            return;
        }

        for (int i = start; i <= n; i++) {
            temp.add(i);
            comb(result, temp, i + 1, n, k-1);
            temp.remove(temp.size()-1);
        }
    }

}
