import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//144. 二叉树的前序遍历
public class Binary_Tree_Preorder_Traversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.offer(root);
        DFS(queue,list);
        return list;
//        while(!queue.isEmpty()){
//            TreeNode treeNode=queue.remove();
//            if(treeNode.left!=null){
//                queue.offer(treeNode.left);
//            }
//            if(treeNode.right!=null){
//                queue.offer(treeNode.right);
//            }
//        }
    }

    public void DFS(Queue<TreeNode> queue,List<Integer> list){
        while(!queue.isEmpty()){
            TreeNode treeNode=queue.remove();
            list.add(treeNode.val);
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
                DFS(queue,list);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
                DFS(queue,list);
            }
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            List<Integer> ret = new Binary_Tree_Preorder_Traversal_144().preorderTraversal(root);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
