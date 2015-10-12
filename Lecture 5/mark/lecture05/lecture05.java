package lecture05;

import java.util.*;

public class lecture05 {

	public static void main(String[] args) 
	{
		BinaryTree bt = new BinaryTree();
		
		bt.insert(78);
		bt.insert(58);
		bt.insert(31);
		bt.insert(44);
		bt.insert(182);
		
		System.out.println(bt.getRoot());
		System.out.println(bt);
		
		/*LinkedList<String> ll = new LinkedList<String>();
		
		ll.add("bub");
		ll.add("bla");
		ll.add("arr");
		
		System.out.println(ll);
		System.out.println(ll.getFirst());
		
		*/
		/*LinkedList<String> ll = new LinkedList<String>();
		
		ll.add("1");
		ll.add("20");
		ll.add("49");
		ll.add("9");
		ll.add(2, "random"); <---- solved
		
		System.out.println("List: " + ll);
		
		ll.removeFirst();
		
		
		
		
		System.out.println("List: " + ll);
		
		System.out.println("List: " + ll.getFirst()); 
		
		Queue qe = new LinkedList(); //Will give oldest element in list
		qe.add("b");
		qe.add("c");
		qe.add("g");
		qe.add("u");
		
		System.out.println("Queue: " + qe);
		
		System.out.println("Queue first element: " + qe.peek());
		System.out.println("Queue next element: " + qe.poll());
		System.out.println("Queue next element: " + qe.poll());
		System.out.println("Queue next element: " + qe.poll());
		
		System.out.println("Queue: " + qe);
		
		Stack st = new Stack(); //Will give newest element in list
		
		st.push(1.0f);
		st.push("b");
		st.push(3);
		
		System.out.println("Stack: " + st);
		System.out.println("Stack first element: " + st.peek());
		System.out.println("Stack next element: " + st.pop());
		System.out.println("Stack next element: " + st.pop());
		
		BinaryTree bt = new BinaryTree();
		bt.insert(14);
		bt.insert(5);
		bt.insert(8);
		bt.insert(17);
		bt.insert(20);
		bt.insert(1);
		bt.insert(18);
		
		System.out.println("Binary Tree: " + bt);
		*/
	}

}
