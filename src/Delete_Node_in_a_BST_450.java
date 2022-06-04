//450. 删除二叉搜索树中的节点
public class Delete_Node_in_a_BST_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        if(root.val<key){
            root.right=deleteNode(root.right,key);
            return root;
        }
        if(root.val>key){
            root.left=deleteNode(root.left,key);
            return root;
        }
        if(root.val==key){
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.right==null){
                return root.left;
            }
            if(root.left==null){
                return root.right;
            }
            TreeNode succ=root.right;
            while(succ.left!=null){
                succ=succ.left;
            }
            root.right=deleteNode(root.right, succ.val);
            succ.right=root.right;
            succ.left=root.left;
            return succ;
        }
        return root;
    }
}
