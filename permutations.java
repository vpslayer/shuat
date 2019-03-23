import java.util.ArrayList;
import java.util.List;

public class permutations {
    public static List<List<Integer>> permuate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(nums, temp, result);
        return result;
    }

    private static void dfs(int[] nums, ArrayList<Integer> temp, List<List<Integer>>  res) {
        if(temp.size()==nums.length) res.add(temp);
        for(int i=0; i<nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            dfs(nums, new ArrayList<>(temp), res);
            temp.remove(temp.size()-1);

        }
    }

    public static void main(String[] args) {
        int[] testArr = {1,2,4};
        System.out.println(permuate(testArr));
    }
}