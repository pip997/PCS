package lecture05;

import java.util.*;

public class lecture05 {

	public static void main(String[] args) 
	{
		
		int[] arr = { 10, 9, 2, 3, 4, 5, 9, 12, 8, 18, 13, 16 };
		BinaryTree bt = new BinaryTree(new Integer(arr[0])); //Works only with Integer objects (or can be rewritten to int) since we need to compare values.
		
		for (int i = 1; i < arr.length; i++)
		{
			bt.insert(bt.root, new Integer(arr[i]));
		}
		
		//System.out.println(bt.getRoot());
		bt.inOrder(bt.root);
		
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
