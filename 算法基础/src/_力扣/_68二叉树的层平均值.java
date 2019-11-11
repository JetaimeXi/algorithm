package _力扣;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:Tod
 * @Description:
 * @Date: Create in 23:32 2019/10/29
 * @ModifiedBy:
 */
public class _68二叉树的层平均值 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode tn = TreeNode.makeTree(arr);
        System.out.println(averageOfLevels(tn));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            double sum = 0;
            for (int i = 0; i < length; i++) {
                TreeNode temp = queue.poll();
                sum += temp.val;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            list.add(sum / length);
        }
        return list;
    }
}
