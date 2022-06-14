import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//617. 合并二叉树
public class Merge_Two_Binary_Trees_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null)
            return root2;
        else if(root2==null)
            return root1;

        DFS(root1,root2);
        return root1;
    }

    public void DFS(TreeNode root1,TreeNode root2){
        if(root1!=null && root2!= null){
            root1.val=root1.val+root2.val;
        }
        if(root1.left==null && root2.left!=null){
            root1.left=root2.left;
        }else if(root1.left!=null && root2.left!=null){
            DFS(root1.left,root2.left);
        }
        if(root1.right==null && root2.right!=null){
            root1.right=root2.right;
        }else if(root1.right!=null && root2.right!=null){
            DFS(root1.right,root2.right);
        }
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
            TreeNode root1 = stringToTreeNode(line);
            line = in.readLine();
            TreeNode root2 = stringToTreeNode(line);

            TreeNode ret = new Merge_Two_Binary_Trees_617().mergeTrees(root1, root2);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
