import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserialize_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        buildString(root,stringBuilder);
        return stringBuilder.toString();

    }
    public static void buildString(TreeNode root,StringBuilder stringBuilder){
        if(root==null){
            stringBuilder.append("null").append(",");
        }else{
            stringBuilder.append(root.val).append(",");
            buildString(root.left,stringBuilder);
            buildString(root.right,stringBuilder);
        }

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] strArr=data.split(",");
        Queue<String> queue=new LinkedList();
        Collections.addAll(queue,strArr);
        return buildTree(queue);

    }
    public static TreeNode buildTree(Queue<String> queue){
        if (queue.isEmpty()) {
            return null;
        }
        String s=queue.poll();
        if(s.equals("null")) return null;
        TreeNode root=new TreeNode(Integer.parseInt(s));
        root.left=buildTree(queue);
        root.right=buildTree(queue);
        return root;
    }
}
