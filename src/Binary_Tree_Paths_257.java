import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//257. 二叉树的所有路径
public class Binary_Tree_Paths_257 {
    List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result=new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        DFS(root, list);

        return result;
    }

    public void DFS(TreeNode root,List<Integer> list1) {
            List<Integer> list=new ArrayList<>(list1);
            list.add(root.val);
            if(root.left!=null){
                DFS(root.left,list);
            }
            if(root.right!=null){
                DFS(root.right,list);
            }
            if(root.left==null && root.right==null){
                String temp="";
                for (int i = 0; i < list.size(); i++) {
                    if(i+1==list.size()){
                        temp+=list.get(i);
                    }else{
                        temp+=list.get(i)+"->";
                    }
                }
                result.add(temp);
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

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
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

            List<String> ret = new Binary_Tree_Paths_257().binaryTreePaths(root);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}
