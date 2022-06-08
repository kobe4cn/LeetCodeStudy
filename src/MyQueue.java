import java.util.Stack;

//232. 用栈实现队列
public class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> out;
    public MyQueue() {
        stack=new Stack<>();
        out=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if(out.isEmpty()){
            while(!stack.isEmpty()){
                out.push(stack.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        if(out.isEmpty()){
            while(!stack.isEmpty()){
                out.push(stack.pop());
            }
        }
        return out.peek();

    }

    public boolean empty() {
        return stack.isEmpty()&&out.isEmpty();
    }
}
