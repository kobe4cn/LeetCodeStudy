package test;




import java.util.*;

//133. 克隆图
public class CloneGraph_133 {
    public Node cloneGraph(Node node) {

        List<Node> nodes = new ArrayList<>();
        Node n1 = new Node();
        if (node == null) {
            return null;
        }
        if (node.neighbors.size() == 0) {
            return new Node(node.val);
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map=new HashMap<>();
        Node newNode=new Node(node.val,new ArrayList<>());
        map.put(node,newNode);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currnode = queue.poll();
            List<Node> list = currnode.neighbors;
            List<Integer> temp=new ArrayList<>();
            for (Node tempno:list
                 ){
                if (!map.containsKey(tempno)) {
                    map.put(tempno, new Node(tempno.val,new ArrayList<>()));
                    queue.add(tempno);
                }
                map.get(currnode).neighbors.add(map.get(tempno));
            }


        }

        return newNode;
    }

    public Node getNode(Map<Integer,List<Integer>> map){
        Node node=new Node();
        Node node1=node;
        Set<Integer> integers = map.keySet();
        while(integers.iterator().hasNext()){
            Integer key=integers.iterator().next();
            List<Integer> ints=map.get(key);
            ArrayList<Node> arrnode=new ArrayList<>();
            for(Integer in:ints){
                Node temp=new Node(in);
                arrnode.add(temp);
            }
            node1=new Node(key,arrnode);

        }
        return node;
    }



}
