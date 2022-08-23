import java.util.*;

//655. 输出二叉树
public class Print_Binary_Tree_655 {
    List<List<String>> list;

    public List<List<String>> printTree(TreeNode root) {
        list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int level=-1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            level++;
        }
        int n=(int)(Math.pow(2,level+1)-1);
        int m=level+1;
        for (int i = 0; i < m; i++) {
            List<String> str=new ArrayList<>();
            for (int j = 0; j < n; j++) {
                str.add("");
            }
            list.add(str);
        }

        DFS(root,(n-1)/2,0,level);

        return list;
    }

    public void DFS(TreeNode node,int position,int level,int height){
        if(level==0){
            List<String> stringList = list.get(level);
            stringList.set(position,String.valueOf(node.val));
        }
        if(node.left!=null){
            int leveltemp=level+1;
            List<String> stringList = list.get(leveltemp);
            int postemp=position-(int)Math.pow(2,height-level-1);
            stringList.set(postemp,String.valueOf(node.left.val));
            DFS(node.left,postemp,leveltemp,height);
        }
        if(node.right!=null){
            int leveltemp=level+1;
            List<String> stringList = list.get(leveltemp);
            int postemp=position+(int)Math.pow(2,height-level-1);
            stringList.set(postemp,String.valueOf(node.right.val));
            DFS(node.right,postemp,leveltemp,height);
        }
    }

    public static void main(String[] args) {
        Print_Binary_Tree_655 print_binary_tree_655=new Print_Binary_Tree_655();
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        print_binary_tree_655.printTree(node);
    }
}
