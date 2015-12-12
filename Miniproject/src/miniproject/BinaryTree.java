package miniproject;

import java.util.*;

public class BinaryTree {

    private Node root;
    ArrayList<String> arrayList = new ArrayList<String>();
    String[] inputArray;
    
    private static class Node{
        String data;
        Node left;
        Node right;

        
        Node(String newdata){
            data = newdata;
            left = null;
            right = null;
        }
        
    }
    
    public void BinaryTree(){
        root = null;
    }
    
    public void insertArray(String[] newDataArray)
    {
    	for (int i = 0; i < newDataArray.length; ++i)
    	{
    		insert(newDataArray[i]);
    	}
    	inputArray = newDataArray;
    }
    
    public void insert(String data){
        root = insert(root,data);
    }
    
    public String[] sortArray()
    {
    	arrayList.clear();
    	
    	addElemementsToArrayList(root);
    	
    	String[] sortedArray = new String[arrayList.size()];
    	arrayList.toArray(sortedArray);
    	
    	return sortedArray;
    }
    
    private void addElemementsToArrayList(Node n)
    {
    	addElemementsToArrayList(n.left);
    	arrayList.add(n.data);
    	addElemementsToArrayList(n.right);
    }
    
    private Node insert(Node node, String data){
        if (node==null){
            node = new Node(data);
        }
        else {
            if (data.compareTo(node.data) <= 0){
                node.left = insert(node.left, data);
            }
            else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }
	
}
