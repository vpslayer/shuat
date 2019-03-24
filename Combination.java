import java.util.ArrayList;
import java.util.List;

public class  Combination {
    public static List<List<Integer>> combine (int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(result, temp, 1, n, k);
        return result;
    }

    public static void dfs(List<List<Integer>> res, ArrayList<Integer> temp, int  start, int n, int  k) {
        if(k==0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<=n; i++) {
            temp.add(i);
            dfs(res, new ArrayList<>(temp), i+1, n, k-1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}