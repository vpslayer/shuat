public class Node {
    int val;
    Node left, right;

    Node(int x) { 
        this.val = x;
        this.left = null;
        this.right = null;
    }

    public Node getLeft() {return this.left;}
    
        public Node getRight() {return this.right;}
    
        public String getText() {return Integer.toString(this.val);}
}