import java.util.LinkedList;
import java.util.Queue;

//919. 完全二叉树插入器
public class Complete_Binary_Tree_Inserter_919 {
    TreeNode root;
   // TreeNode current;
    public Complete_Binary_Tree_Inserter_919(TreeNode root) {
        this.root=root;
    }

    public int insert(int val) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if(node.left==null){
                    node.left=new TreeNode(val);
                    return node.val;
                }else{
                    queue.offer(node.left);
                }
                if(node.right==null){
                    node.right=new TreeNode(val);
                    return node.val;
                }else {
                    queue.offer(node.right);
                }
            }
        }
        return 0;
    }

    public TreeNode get_root() {
        return root;
    }
}
