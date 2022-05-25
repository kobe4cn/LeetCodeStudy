import java.util.*;

//993. 二叉树的堂兄弟节点
public class CousinsinBinaryTree_993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //循环每一层
            //判断已经第一层了
            int level=0;
            int count=queue.size();
            List<Integer> list=new ArrayList<>();

            for (int i = 0; i < count; i++) {
                TreeNode treeNode=queue.remove();
                if(treeNode!=null){
                    list.add(treeNode.val);
                    TreeNode left=treeNode.left;
                    TreeNode right=treeNode.right;
                    if(left!=null)
                        queue.add(left);
                    if(right!=null)
                        queue.add(right);
//                    每次根节点产生子节点的地方都判断下是否一个根下面的两个数字就是x和y
                    if(left!=null && right!=null){
                        if(left.val==x && right.val==y){
                            return false;
                        }else if(left.val==y && right.val==x){
                            return  false;
                        }
                    }
                }
            }
            if(list.contains(x) && list.contains(y)){
                return true;
            }

            level++;
        }
        return false;

    }
}
