import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  Combination {

    /**
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
    */
    // optimization 
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Integer[] temp = new Integer[k]; // Integer[] is reusable, so no need to constuct a new one in recursion
        combine(result, temp, 1, n, 0, k);
        return result;
    }
    public static void combine(List<List<Integer>> res,  Integer[] temp, int start, int end, int index, int len) {
        if(len==0 || end<len) {
            res.add(new ArrayList<>(Arrays.asList(temp))); // turn Integer array to an ArrayList
            return;
        }
        // end-(len-1): the stop position. 
        // take C(5, 2) for example: end at 4 which is 5-(2-1)
        for(int i=start; i<=end-len+1; i++) {
            temp[index]=i;
            combine(res, temp, i+1, end, index+1, len-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}