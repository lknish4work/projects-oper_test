package oper_test.oper_test;

/**
 * IntLinkedList
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
        		//last node to remove
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
    
    //Removes first node with data provided.
    public Node deleteDataNode(int data)
    { 
        Node curr_Node = head;
        Node prev_Node = null; 
        Node removed_Node = null; 
 
        while (curr_Node != null)
        {
        	if(curr_Node.data == data)
        	{
        		//found node to remove
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
        		//go to next node
        		prev_Node = curr_Node;
        		curr_Node = curr_Node.next;
        	}
       }
        
        if(size > 0 && removed_Node != null)
        	size--;
        return removed_Node;
    }
    
    public static void main(String[] args)
    { 
    	IntLinkedList intlist = new IntLinkedList();
    	Node d_node = null;
    	
    	intlist.append(1);
    	System.out.println("APPEND '1': \n" + intlist.toString());
    	
    	d_node = intlist.deleteTailNode();
    	System.out.println("DELETE Tail: \n" + intlist.toString() + " Deleted Node - " + (d_node==null?"N/A":d_node.data));
    	
    	intlist.append(1);
    	intlist.append(2);
    	intlist.append(3);
    	intlist.append(4);
    	System.out.println("APPEND Data: '1,2,3,4': \n" + intlist.toString());

    	d_node = intlist.deleteTailNode();
    	System.out.println("DELETE Tail: \n" + intlist.toString() + " Deleted Node - " + (d_node==null?"N/A":d_node.data));
    	
    	d_node = intlist.deleteDataNode(2);
    	System.out.println("DELETE Data: '2'\n" + intlist.toString() + " Deleted Node - " + (d_node==null?"N/A":d_node.data));
    	d_node = intlist.deleteDataNode(1);
    	System.out.println("DELETE Data: '1'\n" + intlist.toString() + " Deleted Node - " + (d_node==null?"N/A":d_node.data));
    	intlist.append(8);
    	System.out.println("APPEND Data: '8'\n" + intlist.toString());
    	d_node = intlist.deleteDataNode(3);
    	System.out.println("DELETE Data: '3'\n" + intlist.toString() + " Deleted Node - " + (d_node==null?"N/A":d_node.data));
    	
    	intlist.append(5);
    	intlist.append(6);
    	System.out.println("APPEND data: '5,6':\n" + intlist.toString());
    	
    	d_node = intlist.deleteDataNode(30);
    	System.out.println("DELETE Data: '30'\n" + intlist.toString() + " Deleted Node - " + (d_node==null?"N/A":d_node.data));
    }
    
}