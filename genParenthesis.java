import java.util.List;
import java.util.ArrayList;

// tag: recursion, dfs

public class genParenthesis {
    public static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", 0, 0, n);
        return result;
    }
    private static void dfs(List<String> res, String temp, int open, int close, int pairs) {
        // base case; recursion stops here;
        if(temp.length()==pairs*2) {
            res.add(temp);
            //return;
        }
        // recursive case
        // back to last dfs in recursion stack, but no other task(check from the printed stack trace)
        if(open<pairs) {
            dfs(res, temp+"(", open+1, close, pairs);
            System.out.println(open + " " + close);
        }
        if(close<open) { // 保证递归过程中加入的open和close括号相同
            dfs(res, temp+")", open, close+1, pairs);
            System.out.println(open + " " + close);
        }
    }
    public static void main(String[] args) {
        System.out.println(generate(3));
    }
}