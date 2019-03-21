import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class subSetsII {
    public static List<List<Integer>> subSetsWithDups(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        dfs(result, num, path, 0);
        return result;
    }

    private static void dfs(List<List<Integer>> res, int[] num, ArrayList<Integer> path, int index) {
        if(index <= num.length) res.add(path);
        for(int i=index; i<num.length; ) {
            path.add(num[i]);
            dfs(res, num, new ArrayList<>(path), i+1);
            path.remove(path.size()-1);
            i++;
            while(i<num.length && num[i] == num[i-1]) {i++;}
        }
        }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,2};
        System.out.print(subSetsWithDups(arr));

    }
}