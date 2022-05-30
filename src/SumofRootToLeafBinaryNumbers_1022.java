import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//1022. 从根到叶的二进制数之和
public class SumofRootToLeafBinaryNumbers_1022 {
    public int sumRootToLeaf(TreeNode root) {
        List<String> list=new ArrayList<>();
        if(root==null){
            return 0;
        }
        StringBuilder builder=new StringBuilder();
        dfs(root,builder,list);
        int asInt = list.stream().mapToInt(value -> Integer.parseInt(value, 2)).reduce((left, right) -> left + right).getAsInt();
        return asInt;
    }

    public void dfs(TreeNode root, StringBuilder stringBuilder1, List<String> list){
        StringBuilder stringBuilder=new StringBuilder(stringBuilder1);
        stringBuilder.append(root.val);
        StringBuilder leftBuilder=new StringBuilder(stringBuilder);
        StringBuilder rightBuilder=new StringBuilder(stringBuilder);
        if(root.left!=null){
            dfs(root.left,leftBuilder,list);
        }

        if(root.right!=null){
            dfs(root.right,rightBuilder,list);
        }

        if(root.left==null && root.right==null){
            list.add(rightBuilder.toString());
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

            int ret = new SumofRootToLeafBinaryNumbers_1022().sumRootToLeaf(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
