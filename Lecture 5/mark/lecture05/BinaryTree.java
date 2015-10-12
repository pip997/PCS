package lecture05;

import java.util.*;

public class BinaryTree<AnyType>
{
	public Node<AnyType> root;
	
	private static class Node<AnyType> {
		public AnyType data;
		Node left;
		Node right;
		
		Node (AnyType newdata) {
			data = newdata;
			left = null;
			right = null;
		}
		
	}
	
	//BinaryTree () {}
	
	public BinaryTree(Object data) //implement left sub-tree, print right sub-tree, print node
	{
		root = new Node(data);
	}
	
	public void insert(int data) 
	{
		root = insert(root,data);
	}
	
	Node insert(Node node, int data)
	{
		if (node == null){
			node = new Node(data);
		}
		else {
			if (data <= (Integer) node.data){ //IF THE NUMBER IS SMALLER THAN THE CURRENT NUMBER
				node.left = insert(node.left, data); //INSERT CHILD TO THE LEFT
			}
			else {
				node.right = insert(node.right, data);
			}
		}
		return node;
	}
	
	/*public int getRoot ()
	{
		//return root.data.toString();
	}*/
	
	public String toString()
	{
		return subTreetoString(root);
	}

	private String subTreetoString (Node n)
	{
		String result = "";
		if (root == null)
			return result;
		result += n.data;
		result += " " + n.left.data + " " + n.right.data;
		
		return result;
	}
	
	public void ascOrder(Node node) {
		  if (node != null) {
		   ascOrder(node.left);
		   System.out.print(((Integer) node.data).intValue() + ",");
		   ascOrder(node.right);
		  }
		 }
	
	public void descOrder(Node node) {
		  if (node != null) {
		   descOrder(node.right);
		   System.out.print(((Integer) node.data).intValue() + ",");
		   descOrder(node.left);
		  }
		 }
	
	public void search (int searchItem, Node node)
	{
		boolean isFound = false;
		if(node != null)
		{
			search(searchItem, node.left);
			search(searchItem, node.right);
			if (((Integer) node.data).intValue() == searchItem)
			{
				isFound = true;
			}
			else
				isFound = false;
		}
		if (isFound)
		{
			System.out.println("" + searchItem + " has been found to be same as " + (((Integer) node.data).intValue()));
		}
		
	}

	/*@Override public String toString()
	{
		return "" 
	}*/
}


