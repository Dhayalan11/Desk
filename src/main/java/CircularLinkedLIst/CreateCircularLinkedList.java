package CircularLinkedLIst;

import javaClasses.Agent;

public class CreateCircularLinkedList {  
	
    public class Node{  
    	public Agent data;  
        public Node next;  
        public Node(Agent data) {  
            this.data = data;  
        }  
    }    
    public Node head = null;  
    public Node tail = null;    
	public Node CurNode=null;
    public void add(Agent data){  
        Node newNode = new Node(data);    
        if(head == null) {    
            head = newNode;  
            tail = newNode;  
            newNode.next = head;  
        }  
        else {    
            tail.next = newNode;    
            tail = newNode;  
            tail.next = head;  
        }  
    }  
    public Node get() {

    		if(CurNode==null) {
    			CurNode=head;
    		
    		}else {
    			CurNode=CurNode.next;
    		}
    		return  CurNode;
    		
    }
    

    public void display() {  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
        }  
        else {  
            System.out.println("Nodes of the circular linked list: ");  
             do{  
                 
                System.out.println(" "+ current.data);  
                current = current.next;  
            }while(current != head);  
            System.out.println();  
        }  
    }  
  

}  