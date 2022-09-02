//687. 最长同值路径
public class Longest_Univalue_Path_687 {
   int res;
    public int longestUnivaluePath(TreeNode root) {
        res=0;
        DFS(root);
        return res;
    }

    public int DFS(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=DFS(node.left);
        int right=DFS(node.right);
        int leftcount=0;
        int rightcount=0;
        if(node.left!=null && node.val==node.left.val){
            leftcount=left+1;
        }
        if(node.right!=null && node.val==node.right.val){
            rightcount=right+1;
        }
        res=Math.max(res,leftcount+rightcount);
        return Math.max(leftcount,rightcount);

    }
}
