import java.util.LinkedList;
import java.util.Queue;

//175 · 翻转二叉树
public class Lintcode_175 {
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();

                TreeNode temp=node.left;
                node.left=node.right;
                node.right=temp;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
    }
}
