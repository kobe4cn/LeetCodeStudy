import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SecondMinimumNodeInTree_671 {
    List<Integer> list=new ArrayList<>();
    public int findSecondMinimumValue(TreeNode root) {
        abs(root);
        list.sort((o1, o2) -> o1-o2);
        if(list.size()<=1){
            return -1;
        }else{
            return list.get(1);
        }

    }
    public void abs(TreeNode root){
        if(!list.contains(root.val)){
            list.add(root.val);
        }
        if(root.left!=null){
            abs(root.left);
        }
        if(root.right!=null){
            abs(root.right);
        }
    }


    // public static TreeNode stringToTreeNode(String input) {
    //     input = input.trim();
    //     input = input.substring(1, input.length() - 1);
    //     if (input.length() == 0) {
    //         return null;
    //     }

    //     String[] parts = input.split(",");
    //     String item = parts[0];
    //     TreeNode root = new TreeNode(Integer.parseInt(item));
    //     Queue<TreeNode> nodeQueue = new LinkedList<>();
    //     nodeQueue.add(root);

    //     int index = 1;
    //     while(!nodeQueue.isEmpty()) {
    //         TreeNode node = nodeQueue.remove();

    //         if (index == parts.length) {
    //             break;
    //         }

    //         item = parts[index++];
    //         item = item.trim();
    //         if (!item.equals("null")) {
    //             int leftNumber = Integer.parseInt(item);
    //             node.left = new TreeNode(leftNumber);
    //             nodeQueue.add(node.left);
    //         }

    //         if (index == parts.length) {
    //             break;
    //         }

    //         item = parts[index++];
    //         item = item.trim();
    //         if (!item.equals("null")) {
    //             int rightNumber = Integer.parseInt(item);
    //             node.right = new TreeNode(rightNumber);
    //             nodeQueue.add(node.right);
    //         }
    //     }
    //     return root;
    // }

    // public static void main(String[] args) throws IOException {
    //     BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //     String line;
    //     while ((line = in.readLine()) != null) {
    //         TreeNode root = stringToTreeNode(line);

    //         int ret = new SecondMinimumNodeInTree_671().findSecondMinimumValue(root);

    //         String out = String.valueOf(ret);

    //         System.out.print(out);
    //     }
    // }
}
// @lc code=end

