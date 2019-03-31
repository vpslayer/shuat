// binary tree 数组表示

public class BinaryTree {
    Node root;
    static class Node {
        int val;
        Node left, right;
        //Node(){}// if default constructor is missed, wrong!
        Node(int x) {
            this.val=x;
            this.left=null;
            this.right=null;
        }
    }
    public static void inOrderTraversal(Node root) {
        // no need to output string form, need to pass a sb, or else the local var can't store the final info
        // base case: to the leaf node -> null -> return(use if to skip this)
        if(root != null) {
            inOrderTraversal(root.left);
            System.out.printf("%s ", root.val);
            inOrderTraversal(root.right);
        }
    }

    // null in arr
    public static Node insertLevelOrder(Integer[] arr, Node root, int i) {
        // constructor call when new a class, no need of return value
        if(i < arr.length && arr[i] != null) {
            Node temp = new Node(arr[i]);
            root = temp;
            // insert left & right node
            root.left = insertLevelOrder(arr, root.left, 2*i+1);
            root.right = insertLevelOrder(arr, root.right, 2*i+2);
        }
        return root;
    }
    public static Node arr2Tree(Integer[] arr, int start) {
        /*
        for(int i=0; 2*(i+1) < arr.length; i++) {
            if(arr[i]==null) continue;
            if(i==0) this.root=new Node(arr[i]);
            Node nd = this.root;
            int left_idx=2*i+1, right_idx=2*(i+1);
            if(left_idx >= arr.length) continue;
            if(arr[left_idx]!=null) nd.left=new Node(arr[right_idx]);
            if(right_idx >= arr.length) continue;
            if(arr[right_idx]!=null) nd.left=new Node(arr[right_idx]);
            */
        if(arr[start]==null) return null;
        Node root = new Node(arr[start]);
        int left_idx = 2*start+1;
        int right_idx = 2*start+2;

        if(left_idx >= arr.length) {root.left  = null;}
        else {root.left = arr2Tree(arr, left_idx);}

        if(right_idx >= arr.length) {root.right = null;}
        else {root.right = arr2Tree(arr, right_idx);}

        return root;
        

    }
    public static void main(String[] args) {
        // auto trans between int and Int
        // if null exits in arr, how to deal with it?
        Integer[] arr0 = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        Integer[] arr = {5,3,7,null,4,null,null}; //数组仅仅适合表示满二叉树和完全二叉树?
        //BinaryTree bt = new BinaryTree();
        //Node n = new Node(); constructor overloaded then the default one won't be generated
        Node x = arr2Tree(arr, 0);
        inOrderTraversal(x);
    }
}