import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//654. 最大二叉树
public class Maximum_Binary_Tree_654 {
    //这个题目有点没有理解，其实是将每次队列中拿到的最大的左边队列和后边队列再分别递归的方式找剩下的左边队列和右边队列中的最大数据，再分割左右队列

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Integer max = list.stream().max(Integer::compareTo).get();
        TreeNode node=DFS(max,list);

        return node;
    }

    public TreeNode DFS(int max,List<Integer> list){
        TreeNode node=new TreeNode(max);
        List<Integer> left=list.subList(0,list.indexOf(max));
        if(left.size()>0){
            node.left=DFS(left.stream().max(Integer::compareTo).get(),left);
        }
        List<Integer> right=list.subList(list.indexOf(max)+1,list.size());
        if(right.size()>0){
            node.right=DFS(right.stream().max(Integer::compareTo).get(),right);
        }
        return node;
    }



    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
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
            int[] nums = stringToIntegerArray(line);

            TreeNode ret = new Maximum_Binary_Tree_654().constructMaximumBinaryTree(nums);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
