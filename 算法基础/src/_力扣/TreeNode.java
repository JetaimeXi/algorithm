package _力扣;


/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 17:14 2019/10/28
 * @ModifiedBy:
 */
public class TreeNode {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode tree = makeTree(arr);
        printTreeByPreOrder(tree);
    }

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode makeTree(Integer[] arr) {
        return makeTree(arr, 0);
    }

    private static TreeNode makeTree(Integer[] arr, int index) {
        if (index < arr.length) {
            Integer temp = arr[index];
            if (temp == null) {
                return null;
            }
            TreeNode root = new TreeNode(temp);
            root.left = makeTree(arr, (index << 1) + 1);
            root.right = makeTree(arr, ((index + 1) << 1));
            return root;
        }
        return null;
    }

    public static void printTreeByPreOrder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        } else {
            System.out.print(root.val + " ");
        }
        printTreeByPreOrder(root.left);
        printTreeByPreOrder(root.right);
    }


}
