import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//111. 二叉树的最小深度
public class Minimum_Depth_of_Binary_Tree_111 {
    public int minDepth(TreeNode root) {
        List<Integer> minpath=new ArrayList<>();
        int count=0;
        if(root==null){
            return 0;
        }
        DFS(root,minpath,count);
        return minpath.stream().sorted().findFirst().get();
    }

    public void DFS(TreeNode root,List<Integer> minpath,int count){
        count++;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left==right && left==null){
            minpath.add(count);
        }
        if(left!=null){
            DFS(left,minpath,count);
        }
        if(right!=null){
            DFS(right,minpath,count);
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Minimum_Depth_of_Binary_Tree_111().minDepth(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
