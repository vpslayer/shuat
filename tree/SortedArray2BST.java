public class SortedArray2BST {

    public static Node buildBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return dfs(nums, 0, nums.length-1);
    }

    private static Node dfs(int[] nums, int start, int end) {
        if(start > end) return null;
        if(start == end) return new Node(nums[start]);
        int mid = start + (start + end) / 2;
        Node root = new Node(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Print.printTree(buildBST(nums));
    }
}