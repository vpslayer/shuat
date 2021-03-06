import java.util.ArrayList;
import java.util.List;

// tag: backtracking

public class SubSets {
    public static List<List<Integer>> subArr(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(num, res, new ArrayList<>(), 0);
        return res;
    }
    //backtracking method: think when and where it stop
    private static void dfs(int[] num, List<List<Integer>> res, List<Integer> path, int index) {
        if(index <= num.length) {
            res.add(new ArrayList<>(path));
        }   
        for(int i=index; i<num.length; i++) {
            path.add(num[i]);   
            dfs(num, res, path, i+1);
            path.remove(path.size()-1);
        }
    }
    public static void main (String[] args) {
        int[] testArr = new int[] {1,2,3,};
        System.out.print(subArr(testArr));
    }
}
