import java.util.List;
import java.util.ArrayList;

// tag: backtracking

public class CombinationSum3 {
    public static List<List<Integer>> combination (int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combination(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    private static void combination(List<List<Integer>> res, ArrayList<Integer> temp, int len, int target, int start) {
        if(temp.size() == len && target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // prune branches in for loop
        // 递归函数执行完 if没有返回值 结束返回到上一个递归函数 so不用return
        for(int i=start; i<10 && temp.size()<len && i<=target; i++) {
            temp.add(i);
            combination(res, temp, len, target-i, i+1);  // i+1 -> avoid duplicates in recursion
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(combination(3, 7));
    }
}