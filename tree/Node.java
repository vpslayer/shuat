class Node {
    // 如果属性前面都改成private，类的实例就不能访问了
    // 但是最好用private，使用getter和setter来访问和修改属性值
    int val;
    Node left, right;

    Node(int x) { 
        this.val = x;
        this.left = null;
        this.right = null;
    }
    Node getLeft() {
        return this.left;
    }
    
    Node getRight() {
        return this.right;
    }
    
    String getText() {
        return Integer.toString(this.val);
    }
    public static void main(String[] args) {
        Node tree = new Node(5);
        tree.left = new Node(4);
        tree.right = new Node(8);
        System.out.println(tree.getText());
    }
}