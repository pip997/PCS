import java.util.*;

public class LinkedList<AnyType> {
	private Node<AnyType> head;
	
	public LinkedList() {
		head = null;
	}
	
	// Returns true if the list is empty
	public boolean isEmpty() {
		return head == null;
	}
	
	//Inserts a new node at the beginning of this list.
	public void addFirst(AnyType item) {
	    head = new Node<AnyType>(item, head);
	}
	
	//Returns the first element in the list.
	public AnyType getFirst() {
	      if(head == null) throw new NoSuchElementException();

	      return head.getData();
	}
	
	//Adds an element at the end of a list
	public void addLast(AnyType item) {
		Node<AnyType> tempNode = new Node<AnyType>(item, null);
		Node<AnyType> currNode = head;
		if (head == null) {
			head = tempNode;
		}
		else {
			while (currNode.getNext() != null) {
				currNode = currNode.getNext();
			}
			currNode.setNext(tempNode);
		}
	}
	
	//Removes the last element on the list
	public void removeLast() {
		Node<AnyType> currNode = head;
		Node<AnyType> prevNode = null;
		while (currNode.getNext() != null) {
			prevNode = currNode;
			currNode = currNode.getNext();
		}
		prevNode.setNext(null);
	}
	
	//Prints every element, then exclamation marks
	public void printAll() {
		Node<AnyType> currNode = head;
		while (currNode.getNext() != null) {
			System.out.println(currNode.getData());
			currNode = currNode.getNext();
		}
		System.out.println(currNode.getData() + "!!!!!!!!");
	}
}