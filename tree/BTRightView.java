import java.util.*;

public class BTRightView {
    public static List<Integer> view(Node root) {
        List<Integer> res = new LinkedList<>();
        dfs(res, 0, root);
        return res;
    }

    private static void dfs(List<Integer> res, int level, Node root) {
        if(root == null) return;
        if(res.size() == level) res.add(root.val);
        dfs(res, level+1, root.right);
        dfs(res, level+1, root.left);
    }
    public static List<Integer> bfs(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<Node> queue = new ArrayDeque<Node>();
        if(root==null) return res;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> tmp = new ArrayDeque<Integer>();
            for(int i=0; i<size; i++) {
                tmp.offer(queue.peek().val);
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                tmp.add(queue.poll().val);
            }
            res.add(tmp.getLast());
        }
        return res;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);
        //System.out.println(view(root));
        System.out.println(bfs(root));
    }
}