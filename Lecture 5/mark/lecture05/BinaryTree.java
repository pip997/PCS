package lecture05;

import java.util.*;

public class BinaryTree<AnyType>
{
	private Node<AnyType> root;
	
	private static class Node<AnyType> {
		public int data;
		Node left;
		Node right;
		
		Node (int newdata) {
			data = newdata;
			left = null;
			right = null;
		}
		
	}
	
	//BinaryTree () {}
	
	public void BinaryTree() //implement left sub-tree, print right sub-tree, print node
	{
		root = null;
	}
	
	public void insert(int data) 
	{
		root = insert(root,data);
	}
	
	private Node insert(Node node, int data)
	{
		if (node == null){
			node = new Node(data);
		}
		else {
			if (data <= node.data){
				node.left = insert(node.left, data);
			}
			else {
				node.right = insert(node.right, data);
			}
		}
		return node;
	}
	
	public int getRoot ()
	{
		return root.data;
	}
	
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

	/*@Override public String toString()
	{
		return "" 
	}*/
}


