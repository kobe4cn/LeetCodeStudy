import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//543. 二叉树的直径
public class DiameterofBinaryTree_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(root,list);
        return list.stream().max((o1, o2) -> o1-o2).get();
    }

    public int dfs(TreeNode root, List<Integer> list){
        if(root==null){
            return 0;
        }
        int nodevalue=root.val;
        TreeNode nodeleft=root.left;
        TreeNode noderight=root.right;
        int left=0;
        int right=0;
        if(nodeleft==null && noderight ==null){
            list.add(0);
            return 0;
        }
        if(nodeleft!=null){

            left=dfs(nodeleft,list)+1;
        }
        if(noderight!=null){
            right=dfs(noderight,list)+1;
        }
        list.add(left+right);
        return Math.max(left,right);
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

            int ret = new DiameterofBinaryTree_543().diameterOfBinaryTree(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
