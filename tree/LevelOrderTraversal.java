import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelTraverse(Node root) {

        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if(root == null) return result;
        queue.offer(root);
        /*
        空queue会返回false   IllegalStateException 
        offer               add                 尾部插入
        空queue会返回null   NoSuchElementException
        peek                element             查看头部元素
        空queue会返回null   NoSuchElementException
        poll                remove              删除头部元素
        */
        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> tmp = new LinkedList<Integer>();
            for(int i=0; i<level; i++) {
                // queue的size会因offer增加，所以要在for循环开始前确定该层的node数
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                tmp.add(queue.poll().val);
            }
            result.add(tmp);
        }
        return result;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);
        System.out.println(levelTraverse(root));
    }
}