import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// tag: backtracking
// duplicates in input array

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    private static void combine(List<List<Integer>> res, ArrayList<Integer> temp, int[] can, int target, int index) {
        if(target==0) res.add(new ArrayList<>(temp));
        // e.g.: 1,2,2,4... 第一个2用了后(递归函数返回后)，第二个2就要跳过，不然结果会有重复
        for(int i=index; i<can.length && target >= can[i]; ){ 
            int x = can[i];
            temp.add(x);
            combine(res, temp, can, target-can[i], i+1);
            while(i < can.length && can[i] == x) {
                i++;
            }
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(arr, target));
    }
}