import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Add_One_Row_to_Tree_623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        int level=0;
        Queue<TreeNode> queue=new LinkedList<>();
        if(depth==1){
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            level++;
            if((level+1)==depth) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    if(node.left!=null){
                        TreeNode treeNode=new TreeNode(val);
                        TreeNode temp=node.left;
                        node.left=treeNode;
                        treeNode.left=temp;
                    }else{
                        TreeNode treeNode=new TreeNode(val);
                        node.left=treeNode;
                    }
                    if(node.right!=null){
                        TreeNode treeNode=new TreeNode(val);
                        TreeNode temp=node.right;
                        node.right=treeNode;
                        treeNode.right=temp;
                    }else{
                        TreeNode treeNode=new TreeNode(val);
                        node.right=treeNode;
                    }

                }
                break;
            }else{
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                }
            }
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
            line = in.readLine();
            int val = Integer.parseInt(line);
            line = in.readLine();
            int depth = Integer.parseInt(line);

            TreeNode ret = new Add_One_Row_to_Tree_623().addOneRow(root, val, depth);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
