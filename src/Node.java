import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node next;
    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}