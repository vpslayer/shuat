// 不可以用别的文件里面的static方法? import也没用?要用<class>.<static method>?
class Node {
    int val;
    Node left, right;
    //Node(){}// if default constructor is missed, wrong!
    Node(int x) {
        this.val=x;
    }
}

public class DeleteNode {
    public static Node deleteNode(Node root, int key) {
        if(root == null) return null;  // base case, 找到后断开指向该node的指针 被gc处理
        else if(key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            Node minNode = findMinNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    private static Node findMinNode(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);
        deleteNode(root, 3);
        System.out.println(root.left.val);
    }
}