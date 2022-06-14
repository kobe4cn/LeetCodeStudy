import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//530. 二叉搜索树的最小绝对差
public class Minimum_Absolute_Difference_in_BST_530 {
    int min=Integer.MAX_VALUE;
    TreeNode max;
    public int getMinimumDifference(TreeNode root) {

        if(root.left!=null) {
            int left = getMinimumDifference(root.left);
            min = Math.min(left, min);
        }
        if(max!=null){
            min= Math.min(Math.abs(root.val - max.val), min);
        }
        max=root;
        if(root.right!=null) {
            int right = getMinimumDifference(root.right);
            min = Math.min(right, min);
        }


//        if(root.left!=null){
//            min=Math.min(root.val-root.left.val,min);
//            getMinimumDifference(root.left);
//        }
//        if(root.right!=null){
//            min=Math.min(root.right.val-root.val,min);
//            getMinimumDifference(root.right);
//        }
        return min;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Minimum_Absolute_Difference_in_BST_530().getMinimumDifference(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
