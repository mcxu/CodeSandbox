package ctci5th;

/**
 * Question 3.2: Stack which also returns min element.
 * @author MichaelXu
 *
 */
public class Stack3p2
{
    public Node top;
    private Node minNode;
    
    Object pop()
    {
        if(top != null)
        {
            if(top == minNode)
            {
                System.out.println("match found: top=" + top + "   minNode=" + minNode);
                Node n = top.next;
                minNode = n;
                while(n != null)
                {
                    System.out.println("n.data: " + n.data);
                    
                    if(n.data <= minNode.data)
                    {
                        minNode = n;
                    }
                    
                    n = n.next;
                }
                System.out.println("minNode after pop: " + minNode.data);
            }
            
            int item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }
    
    void push(int item)
    {
        Node t = new Node(item);
        System.out.println("curr top: " + top);
        System.out.println("t data: " + t.data);
        if((top == null) || (t.data < minNode.data))
        {
            minNode = t;
        }
        
        t.next = top;
        top = t;
        System.out.println("top: " + top.data);
        System.out.println("minNode: " + minNode.data);
    }
    
    Node min()
    {
        return minNode;
    }
    
    void printStack()
    {
        Node n = top;
        while(n != null)
        {
            System.out.print(n.data + ", ");
            n = n.next;
        }
        System.out.print("\n");
    }
    
    public static void main(String[] args) {
        Stack3p2 stack = new Stack3p2();
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(0);
        stack.push(2);
        stack.push(4);
        System.out.print("stack: "); stack.printStack();
        
        System.out.println("=== popping ===");
        System.out.println("pop1: " + stack.pop());
        System.out.print("stack after pop1: "); stack.printStack();
        System.out.println("pop2: " + stack.pop());
        System.out.println("pop3: " + stack.pop());
        System.out.println("pop4: " + stack.pop());
        System.out.println("pop5: " + stack.pop());
        System.out.println("minNode is: " + stack.min().data);
    }

}