import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//429. N 叉树的层序遍历
public class NaryTreeLevelOrderTraversal_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> integers = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node node = queue.remove();
                integers.add(node.val);
                List<Node> list = node.children;
                for (Node node1 : list
                ) {
//                    integers.add(node1.val);
                    queue.add(node1);
                }
            }
            res.add(integers);

        }
        return res;
    }


}
