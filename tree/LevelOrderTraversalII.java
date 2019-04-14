import java.util.List;
import java.util.LinkedList;

public class LevelOrderTraversalII {

    public static List<List<Integer>> traverse(Node root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        dfs(res, root, 0);
        return res;
    }
    // bfs和之前一样，只不过使用LinkedList的 add(index, List)方法，index=0即每次在头部插入new List
    private static void dfs(List<List<Integer>> res, Node root, int level) {
        if(root == null) return;
        if(level >= res.size()) res.add(0, new LinkedList<Integer>());
        // post-order traversal
        dfs(res, root.left, level + 1);
        dfs(res, root.right, level + 1);
        res.get(res.size()-level-1).add(root.val);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);
        System.out.println(traverse(root));
    }
}