import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//998. 最大二叉树 II
public class Maximum_Binary_Tree_II_998 {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        LinkedList<Integer> list=new LinkedList<>();

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        list.add(root.val);
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if(node.left!=null){
                    int index = list.indexOf(node.val);
                    if(index==0){
                        list.addFirst(node.left.val);
                    }else {

                        List<Integer> temp = list.subList(index, list.size());
                        List<Integer> temp1=list.subList(0,index);
                        list=new LinkedList<>();
                        list.addAll(temp1);
                        list.add(node.left.val);
                        list.addAll(temp);
//                        temp1.add(node.left.val);
//                        list.clear();
//                        list.addAll(temp1);
//                        list.add(node.left.val);
//                        list.addAll(temp);
                    }
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    int index=list.indexOf(node.val);
                    if(index==list.size()-1){
                        list.addLast(node.right.val);
                    }else {
                        List<Integer> temp = list.subList(index+1, list.size());
                        List<Integer> temp1= list.subList(0,index+1);
                        list=new LinkedList<>();
                        list.addAll(temp1);
                        list.add(node.right.val);
                        list.addAll(temp);
                    }
                    queue.offer(node.right);
                }
            }
        }
        list.add(val);

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
            int val = Integer.parseInt(line);

            TreeNode ret = new Maximum_Binary_Tree_II_998().insertIntoMaxTree(root, val);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }

}
