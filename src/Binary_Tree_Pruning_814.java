import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//814. 二叉树剪枝
public class Binary_Tree_Pruning_814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root==null)
            return null;
        int val = root.val;

        //左边如果不为null，就进行递归，将返回的数据存储到左子数
        if(root.left!=null){
            root.left=pruneTree(root.left);
            //return root;
        }
        //同上逻辑
        if(root.right!=null){
             root.right=pruneTree(root.right);
            //return root;
        }
        //如果该节点左右都没有子树了，值又为0，那就删除这个叶子节点
        if((root.left==root.right && root.left==null)&& val==0){
            root=null;
            return root;

        }
        //如果是1就直接返回
        else if((root.left==root.right && root.left==null)&& val==1){
            return root;
        }

        return root;
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

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            TreeNode ret = new Binary_Tree_Pruning_814().pruneTree(root);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }

}
