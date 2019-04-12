package oper_test.oper_test;

/**
 * Hello world!
 *
 */
public class IntLinkedList
{ 	  
    Node head = null;
    Node tail = null;
    int size = 0;
    
    static class Node
    { 
    	int data; 
        Node next; 
  
        Node(int data) 
        {
        	this.data = data; 
            this.next = null;
        }
    }
    
    
    public void append (int data)
    {
    	//Create new node
        Node new_node = new Node(data); 
        new_node.next = null;
        
        // provided list is empty, make the new node as head. 
        if (head == null)
        	head = tail = new_node;
        else
        {
            // Insert new node at tail 
            tail.next = new_node;
            tail = tail.next;
        }
        
        size ++;
    }
    
    @Override
    public String toString() 
    { 
        Node curr_Node = head;
        StringBuilder strb = new StringBuilder("IntLinkedList: size=" + size + " [ ");
 
        while (curr_Node != null)
        { 
        	strb.append(curr_Node.data + " ");
            curr_Node = curr_Node.next;
        }
        strb.append("]");
        
        return  strb.toString();
    }
    
    public Node deleteTailNode()
    { 
        Node curr_Node = head;
        Node prev_Node = null; 
        Node removed_Node = null; 
 
        while (curr_Node != null)
        {
        	if(curr_Node.next != null)
        		prev_Node = curr_Node;
        	else
        	{
        		tail = prev_Node;
        		removed_Node = curr_Node;
        		if(prev_Node != null)
        			prev_Node.next = null;
        		else
        			head = tail;
        	}
       		curr_Node = curr_Node.next;
        }
        
        if(size > 0)
        	size--;
        return removed_Node;
    }
    
    public Node deleteDataNode(int data)
    { 
        Node curr_Node = head;
        Node prev_Node = null; 
        Node removed_Node = null; 
 
        while (curr_Node != null)
        {
        	if(curr_Node.data == data)
        	{
        		removed_Node = curr_Node;
        		if(head == removed_Node)
        			head = curr_Node.next;
        		if(tail == removed_Node)
        			tail = prev_Node;
        		if(prev_Node != null)
        			prev_Node.next = curr_Node.next;
        		
        		//exit here
        		curr_Node = null;
        	}
        	else
        	{
        		prev_Node = curr_Node;
        		curr_Node = curr_Node.next;
        	}
       }
        
        if(size > 0)
        	size--;
        return removed_Node;
    }
    
    public static void main(String[] args)
    { 
    	IntLinkedList intlist = new IntLinkedList();

    	intlist.append(1);
    	System.out.println("INIT: " + intlist.toString());
    	
    	intlist.deleteTailNode();
    	System.out.println("Delete Tail: " + intlist.toString());
    	
    	intlist.append(1);
    	intlist.append(2);
    	intlist.append(3);
    	intlist.append(4);
    	System.out.println("INIT: " + intlist.toString());

    	intlist.deleteTailNode();
    	System.out.println("Delete Tail: " + intlist.toString());
    	
    	intlist.deleteDataNode(2);
    	System.out.println("Delete Data '2': " + intlist.toString());
    	intlist.deleteDataNode(1);
    	System.out.println("Delete Data '1': " + intlist.toString());
    	intlist.deleteDataNode(3);
    	System.out.println("Delete Data '3': " + intlist.toString());
    	
    	intlist.append(5);
    	intlist.append(6);
    	System.out.println("INIT: " + intlist.toString());
    	
    }
    
}