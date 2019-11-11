package _力扣;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 17:21 2019/10/28
 * @ModifiedBy:
 */
public class _63平衡二叉树 {
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        depthOfBalanced(root);
        return flag;
    }

    private int depthOfBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depthOfBalanced(root.left);
        int right = depthOfBalanced(root.right);
        if (Math.abs(left-right)>1){
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}
