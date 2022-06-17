import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//108. 将有序数组转换为二叉搜索树
public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs_toTreeNode(nums,new TreeNode());
    }

    public TreeNode dfs_toTreeNode(int[] nums,TreeNode node1){
        int length = nums.length;
        int point=(int)Math.ceil(length/2.0)-1;
        TreeNode node=new TreeNode(nums[point]);
        int[] leftpart=Arrays.copyOfRange(nums,0,point);
        int[] rightpart=Arrays.copyOfRange(nums,point+1,length);
//        if(leftpart.length<=2){
//            int leftlen=leftpart.length;
//            int leftpoint=(int)Math.ceil(leftlen/2.0)-1;
//
//        }else {
        if(leftpart.length>0)
            node.left = dfs_toTreeNode(leftpart, node);
//        }
//        if(rightpart.length<=2) {
//
//        }else{
        if(rightpart.length>0)
            node.right = dfs_toTreeNode(rightpart, node);
//        }
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

            TreeNode ret = new Convert_Sorted_Array_to_Binary_Search_Tree_108().sortedArrayToBST(nums);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
