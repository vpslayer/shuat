import java.util.ArrayList;
import java.util.List;
import SubSetsII;

public class PreInOrder2BTree {
    // static 即不需要Pre...类的对象来初始化TreeNode类，两者是独立的，没有static即从属关系，要用this.new TreeNode()初始化之
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
        public TreeNode getLeft() {return this.left;}
    
        public TreeNode getRight() {return this.right;}
    
        public String getText() {return Integer.toString(this.val);}
    }
    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return helper(0, 0, inOrder.length-1, preOrder, inOrder);
    }
    // pre里面的第一个是根节点，对应到中序里，将中序遍历的数组分成左右两个，递归调用得到root的左右子节点
    private static TreeNode helper(int preOrderStart, int inOrderStart, int inOrderEnd, int[] preOrder, int[] inOrder) {
        if(preOrderStart >= preOrder.length || inOrderStart > inOrderEnd) return null;
        TreeNode root = new TreeNode(preOrder[preOrderStart]);
        int inIndex = 0;
        for(int i=0; i<inOrder.length; i++) {
            if(inOrder[i]==root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = helper(preOrderStart + 1, inOrderStart, inIndex - 1, preOrder, inOrder);
        // preOrderStart + inIndex - inOrderStart + 1: 前序遍历中root右节点的位置，举个例子就看出来了
        root.right = helper(preOrderStart + inIndex - inOrderStart + 1, inIndex + 1, inOrderEnd, preOrder, inOrder);
        return root;
    }
    // 二叉树的可视化
    public static void print(TreeNode tree)
    {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<TreeNode> level = new ArrayList<TreeNode>();
        List<TreeNode> next = new ArrayList<TreeNode>();

        level.add(tree);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.getText();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode tree = buildTree(preOrder, inOrder);
        print(tree);
    }
}