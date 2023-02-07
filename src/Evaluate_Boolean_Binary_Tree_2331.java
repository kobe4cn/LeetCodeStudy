import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//2331. 计算布尔二叉树的值
public class Evaluate_Boolean_Binary_Tree_2331 {
    public boolean evaluateTree(TreeNode root) {
        Boolean left=null;
        Boolean right=null;
        if(root.left!=null){
            left=evaluateTree(root.left);
        }else{
            if(root.val==0){
                left=false;
            }else{
                left=true;
            }

        }
        if(root.right!=null){
            right=evaluateTree(root.right);
        }else{
            if(root.val==0){
                right=false;
            }else {
                right=true;
            }
        }
        if(left!=null && right!=null){
            if(root.val==2){
                return left||right;
            }else{

                return left && right;
            }
        }else {
            return false;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            boolean ret = new Evaluate_Boolean_Binary_Tree_2331().evaluateTree(root);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }




}
