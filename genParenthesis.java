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
        if(temp.length()==pairs*2) {
            res.add(temp);
            return;
        }
        if(open<pairs) {
            dfs(res, temp+"(", open+1, close, pairs);
        }
        if(close<open) {
            dfs(res, temp+")", open, close+1, pairs);
        }
    }
    public static void main(String[] args) {
        System.out.println(generate(3));
    }
}