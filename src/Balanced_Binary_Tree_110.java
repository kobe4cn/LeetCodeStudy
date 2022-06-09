import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//110. 平衡二叉树
public class Balanced_Binary_Tree_110 {
//     List<Integer> leftpath;
//    List<Integer> rightpath;
   // List<Integer> list;
    public boolean isBalanced(TreeNode root) {
       return getDepth(root)==-1?false:true;
    }

    public int getDepth(TreeNode root){
        if(root==null){
            //因为是递归，如果最后一个叶子节点的话，是没有left和right的，所以再递归进来的时候
            //root就为null，返回0之后，left和right相减之后然后是0，所以一定小于1，
            //那就选该根节点下来的两个子节点的最深那个节点的值返回

            return 0;
        }
        int leftdeep=getDepth(root.left);

        if(leftdeep==-1) return -1;
        int rightdeep=getDepth(root.right);
        if(rightdeep==-1) return -1;
        int result=0;
        if(Math.abs(leftdeep-rightdeep)>1){
            //左右节点，如果已经产生深度差大于1，那就可以返回了

            result=-1;
        }else {
            result=1+Math.max(leftdeep,rightdeep);
        }
        return result;
    }
//




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
        while (!nodeQueue.isEmpty()) {
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

            boolean ret = new Balanced_Binary_Tree_110().isBalanced(root);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
