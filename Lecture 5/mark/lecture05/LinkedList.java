package lecture05;

import java.util.*;

public class LinkedList<AnyType> 
{
	private Node<AnyType> head;
	
	
	public LinkedList()
	{
		head = null;
	}
	
	public boolean isEmpty ()
	{
		return head == null;
	}
	
	public void add (AnyType data)
	{
		Node<AnyType> temp = new Node<AnyType>(data, null);
		Node<AnyType> current = head;
		if (isEmpty())
		{
			//head.setData(data);
			//head.setNext(null);
			head = temp;
		}
		else {
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(temp);
		}
	}
	
	public String getFirst() {
		return head.getData().toString();
	}
	
	public String toString() { 
        String result = "";
        Node<AnyType> current = head;
        while (current.getNext() != null)
        {
        	current = current.getNext();
        	result += current.getData() + ", ";
        }
        return result;
     } 
}

