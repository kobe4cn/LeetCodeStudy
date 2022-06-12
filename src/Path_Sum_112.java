import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//112. 路径总和
public class Path_Sum_112 {
    List<Integer> result;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        result=new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        DFS(root, list);
        if(result.contains(targetSum)){
            return true;
        }
        return false;
    }


    public void DFS(TreeNode root, List<Integer> list1) {
        List<Integer> list=new ArrayList<>(list1);
        list.add(root.val);
        if(root.left!=null){
            DFS(root.left,list);
        }
        if(root.right!=null){
            DFS(root.right,list);
        }
        if(root.left==null && root.right==null){
            Integer integer1 = list.stream().reduce((integer, integer2) -> integer + integer2).get();

            result.add(integer1);
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
            line = in.readLine();
            int targetSum = Integer.parseInt(line);

            boolean ret = new Path_Sum_112().hasPathSum(root, targetSum);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
