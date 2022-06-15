import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//236. 二叉树的最近公共祖先
public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {
    TreeNode max;
    List<List<TreeNode>> node;
//    List<TreeNode> listP;
//    List<TreeNode> listQ;
    //第一种实现方法，通过遍历，然后返回找到的相关P和Q，再返回该路径上的节点，在判断相同的节点
//    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p, TreeNode q) {
//        node=new ArrayList<>();
//        DFSP(root,p,q,new ArrayList<>());
////        DFSQ(root,q,new ArrayList<>());
//        if(node.size()==2){
//            List<TreeNode> listP=node.get(0);
//            List<TreeNode> listQ=node.get(1);
//
//                for (int i = listQ.size()-1; i >=0; i--) {
//                    for (int j = listP.size()-1; j >=0; j--) {
//                        if(listQ.get(i).val==listP.get(j).val){
//                            return listQ.get(i);
//                        }
//                    }
//                }
//
//        }
//        return null;
//    }

    //第二种实现方式，因为是二叉树，左边小，右边大，如果P，Q都比这个root的val小那就是左边，比p和Q大那就是右边，不断递归直到返回root
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p, TreeNode q) {
        //if(root==null) return root;
        if(root==null || p==root ||q==root) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) return root;
        return left==null?right:left;
    }

    public void DFSP(TreeNode root,TreeNode p,TreeNode q,List<TreeNode> list1){
        List<TreeNode> list=new ArrayList<>(list1);
        list.add(root);
        if(root.val==p.val){
            node.add(list);
        }
        if(root.val==q.val){
            node.add(list);
        }
        if(root.left!=null){
                DFSP(root.left,p,q,list);
        }
        if(root.right!=null){
                DFSP(root.right,p,q,list);
        }
        if(root.left==null && root.right==null){
            list=new ArrayList<>();
        }

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
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int p = Integer.parseInt(line);
            TreeNode nodep=new TreeNode(p);
            line = in.readLine();
            int q = Integer.parseInt(line);
            TreeNode nodeq=new TreeNode(q);

            TreeNode ret = new Lowest_Common_Ancestor_of_a_Binary_Tree_236().lowestCommonAncestor(root, nodep, nodeq);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
