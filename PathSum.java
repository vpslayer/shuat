import java.util.Deque;
import java.util.ArrayDeque;

class Node {
    int val;
    Node left, right;
    Node(int x) { 
        this.val = x;
        this.left = null;
        this.right = null;
    }
}
// tag: binary tree, post-order traversal
public class PathSum {
    public static boolean hasPathSum(Node root, int sum) {
        int temp = 0;
        // pre指针是上一次访问过的Node
        Node pre = null, cur = root;
        // java.util.Stack is deprecated, ArrayDeque as the substitute
        Deque<Node> stack = new ArrayDeque<Node>();
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                temp += cur.val;
                cur = cur.left;
            }
            // cur是最左侧的Node，可能有右子节点，左->右->中(postorder)
            cur = stack.getFirst(); // 取出stack顶节点，并不删除  
            if(cur.left==null && cur.right==null && temp==sum) return true;
            // pre是之前访问过的右节点，else中==是右子树遍历完了，没找到path，删除右节点，减去右节点的值，下一次直接pop掉中节点，向上回溯
            if(cur.right != null && cur.right != pre) {
                cur = cur.right;
            }
            else {
                pre = cur;
                stack.pop();
                temp -= cur.val;
                cur = null;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // hard coded binary tree :(
        Node tree = new Node(5);
        tree.left = new Node(4);
        tree.right = new Node(8);
        tree.left.left = new Node(11);
        tree.left.left.left = new Node(7);
        tree.left.left.right = new Node(2);
        tree.right.left = new Node(13);
        tree.right.right = new Node(4);
        tree.right.right.right = new Node(1);
        int sum = 22;
        boolean res = hasPathSum(tree, sum);
        System.out.printf("Tree %s a root to leaf path that sums up to %d.", res ? "has": "doesn't hava",sum);
    }
}

