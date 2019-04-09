public class BalancedBT {
    public static boolean isBalanced(Node root) {
        // -1 for unbalanced BT
        return dfs(root) != -1;
    }
    private static int dfs(Node root) {
        if(root == null) return 0;
        int leftHeight = dfs(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = dfs(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(7);

        System.out.println(isBalanced(root));
    }
}