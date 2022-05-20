import java.util.ArrayList;
import java.util.List;

public class AverageofLevelsinBinaryTree_637 {
    List<Double> list;
    public List<Double> averageOfLevels(TreeNode root) {
        list=new ArrayList<>();
        List<TreeNode> treeNodes=new ArrayList<>();
        treeNodes.add(root);
        while(treeNodes.size()>0){
            treeNodes=getListNode(treeNodes);
        }
        return list;
    }
    public List<TreeNode> getListNode(List<TreeNode> treenode){
        List<TreeNode> treeNodes=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        for (TreeNode tn:treenode
             ) {

            list1.add(tn.val);
            if(tn.left!=null){
                treeNodes.add(tn.left);
            }
            if(tn.right!=null){
                treeNodes.add(tn.right);
            }

        }
        list.add(list1.stream().mapToDouble(Integer::doubleValue).average().getAsDouble());
        return treeNodes;
    }
}
