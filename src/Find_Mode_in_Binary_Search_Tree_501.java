import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//501. 二叉搜索树中的众数
public class Find_Mode_in_Binary_Search_Tree_501 {
    Map<Integer,Integer> map;
    public int[] findMode(TreeNode root) {
        map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        DFS(root);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Integer value = map.entrySet().stream().max((o1, o2) -> o1.getValue() - o2.getValue()).get().getValue();

       // int[] result=new int[entries1.size()];
        List<Map.Entry<Integer, Integer>> collect = entries.stream().sorted((o1, o2) -> o2.getValue()-o1.getValue()).collect(Collectors.toList());


        for (int i = 0; i < collect.size(); i++) {
            if(collect.get(i).getValue()==value){
                list.add(collect.get(i).getKey());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }
    public void DFS(TreeNode root){
        if(map.containsKey(root.val)){
            map.computeIfPresent(root.val,(integer, integer2) -> ++integer2);

        }else{
            map.put(root.val,1);
        }

        if(root.left!=null){
            DFS(root.left);
        }
        if(root.right!=null){
            DFS(root.right);
        }
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

            int[] ret = new Find_Mode_in_Binary_Search_Tree_501().findMode(root);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
