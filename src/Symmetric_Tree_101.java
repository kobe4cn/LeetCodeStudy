import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//101. 对称二叉树
public class Symmetric_Tree_101 {
    public boolean isSymmetric(TreeNode root) {

        //TreeNode root= root1;
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return true;
        }
        String strroot1=treeNodeToString(root);
        queue.offer(root);


        while(!queue.isEmpty()){
            int count=queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode treeNode=queue.remove();
                TreeNode left=treeNode.left;
                TreeNode right=treeNode.right;

                //判断一个二叉树是否是轴对称的可以将该二叉树进行所有节点的左右交换，如果交换之后的还是跟之前的一致，那就是轴对称的。
                if(left!=null && right!=null){
                    TreeNode temp=left;
                    treeNode.left=right;
                    treeNode.right=temp;
                    queue.offer(treeNode.left);
                    queue.offer(treeNode.right);
                }
                if(left==null && right!=null){
                    treeNode.left=right;
                    treeNode.right=null;
                    queue.offer(treeNode.left);
                }
                if(right==null && left!=null){
                    treeNode.right=left;
                    treeNode.left=null;
                    queue.offer(treeNode.right);
                }
            }
        }
        String strroot=treeNodeToString(root);

        if(strroot.equals(strroot1)){
            return true;
        }
        return false;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            boolean ret = new Symmetric_Tree_101().isSymmetric(root);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
