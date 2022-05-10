import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//124. 二叉树中的最大路径和
public class BinaryTreeMaximumPathSum_124 {
    int returvalue=Integer.MIN_VALUE;
    public  int maxPathSum(TreeNode root) {
        dfs(root);
        return returvalue;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rootvalue = root.val;
        int left=dfs(root.left);
        int right=dfs(root.right);
        returvalue=Math.max(rootvalue+Math.max(0,left)+Math.max(0,right),returvalue);
        return rootvalue+Math.max(0,Math.max(left,right));
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

            int ret = new BinaryTreeMaximumPathSum_124().maxPathSum(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
