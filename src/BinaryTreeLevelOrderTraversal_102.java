import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> returnlist=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> rootlist=new ArrayList<>();
        rootlist.add(root.val);
        returnlist.add(rootlist);
//        int k=0;
        while(!queue.isEmpty()){
            //if((k+1)%2==0){
//            Queue<TreeNode> t=resrveQ(queue);
//            queue.clear();
//            queue=t;
            //}
            int queuesize= queue.size();
            List<Integer> queuelist=new ArrayList<>();
            for (int i = 0; i < queuesize; i++) {
                TreeNode node=queue.remove();
                List<TreeNode> nodelist=getNode(node);
                for(TreeNode value:nodelist){
                    queuelist.add(value.val);
                    queue.add(value);
                }

//                if(k%2==0){
//                    if(queuelist.size()==2){
//
//                    }
//                }

            }
//            k++;

            if(queuelist.size()>0){
                returnlist.add(queuelist);
            }

        }
        return returnlist;
    }
    public static Queue<TreeNode> resrveQ(Queue<TreeNode> q){
        Queue<TreeNode> queue=new LinkedList<>();
        List<TreeNode> treeNodes = q.stream().toList();

        for (int i = treeNodes.size()-1; i>=0; i--) {
            queue.add(treeNodes.get(i));
        }
        return queue;
    }
    public static List<TreeNode> getNode(TreeNode root){
        List<TreeNode> list=new ArrayList<>();

            if (root.left != null) {
                list.add(root.left);
            }
            if (root.right != null) {
                list.add(root.right);
            }




        return list;
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

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            List<List<Integer>> ret = levelOrder(root);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
