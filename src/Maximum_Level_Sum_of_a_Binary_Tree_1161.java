import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//1161. 最大层内元素和
public class Maximum_Level_Sum_of_a_Binary_Tree_1161 {
    public int maxLevelSum(TreeNode root) {
//        List<Integer> level=new ArrayList<>();
//        //List<Integer> list=new ArrayList<>();
//        TreeSet<Map.Entry<Integer,Integer>> list=new TreeSet<>((o1, o2) -> {
//            if(o1.getKey().equals(o2.getKey())){
//                return o1.getValue()-o2.getValue();
//            }else{
//                return o2.getKey()-o1.getKey();
//            }
//        });
//        TreeMap<Integer,Integer> map=new TreeMap<>((o1, o2) -> )

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int level=0;
        Map<Integer,Integer> map=new HashMap<>();
        //map.put(level,root.val);
        while (!queue.isEmpty()){
            int size=queue.size();
            int count=0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                count+=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            level++;
            map.put(level,count);
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        List<Map.Entry<Integer, Integer>> collect = set.stream().sorted((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            } else {
                return o2.getValue() - o1.getValue();
            }
        }).collect(Collectors.toList());
        return collect.get(0).getKey();
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Maximum_Level_Sum_of_a_Binary_Tree_1161().maxLevelSum(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
