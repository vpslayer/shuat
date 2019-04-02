import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// tag: backtracking

public class CombinationSum {
    public static List<List<Integer>> combineSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(result, temp, candidates, target, 0);
        return result;
    }

    private static void dfs(List<List<Integer>> res, ArrayList<Integer> path, int[] candidates, int target,  int start) {
        if(target >  0) {
            for(int i=start; i<candidates.length && target >= candidates[i]; i++) {
                path.add(candidates[i]);
                dfs(res, path, candidates,  target-candidates[i], i);  // if use start instead of i, results will contain duplicate combinations.
                path.remove(path.size()-1);
            }
        }
        else if(target==0) res.add(new ArrayList<>(path));
        }

    public static void main(String[] args) {
        int[] can = new int[] {2,3,6,7};
        int target = 8;
        System.out.println(combineSum(can, target));
    }
    
}