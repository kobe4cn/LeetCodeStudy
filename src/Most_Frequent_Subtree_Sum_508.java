import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//508. 出现次数最多的子树元素和
public class Most_Frequent_Subtree_Sum_508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        DFS(root,map);
        List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).toList();
        for (int i = 0; i < entries.size(); i++) {
            if(i+1<entries.size()) {
                if(entries.get(i).getValue() > entries.get(i + 1).getValue()){
                    list.add(entries.get(i).getKey());
                    return list.stream().mapToInt(Integer::intValue).toArray();
                }else{
                    list.add(entries.get(i).getKey());
                }
            }else{
                list.add(entries.get(i).getKey());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public int DFS(TreeNode root, Map<Integer,Integer> map1){
        if(root.left==null && root.right==null){
            if(!map1.containsKey(root.val)){
                map1.put(root.val,1);
            }else{
                map1.computeIfPresent(root.val,(integer, integer2) -> ++integer2);
            }
            return root.val;
        }
        int left=0;
        if(root.left!=null){
               left=DFS(root.left,map1);
        }
        int right=0;
        if(root.right!=null){
            right=DFS(root.right,map1);
        }
        int value=left+right+root.val;
        if(!map1.containsKey(value)){
            map1.put(value,1);
        }else{
            map1.computeIfPresent(value,(integer, integer2) -> ++integer2);
        }
        return value;
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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int[] ret = new Most_Frequent_Subtree_Sum_508().findFrequentTreeSum(root);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
