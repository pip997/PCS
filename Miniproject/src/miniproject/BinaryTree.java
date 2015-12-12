package miniproject;

import java.util.*;

public class BinaryTree {

    private Node root;
	private ArrayList<String> arrayList = new ArrayList<String>();
    
    private static class Node{
        String data;
        int dataCount;
        Node left;
        Node right;
        
        Node(String newdata, int newDataCount){
            data = newdata;
            dataCount = newDataCount;
            left = null;
            right = null;
        }
        
    }
    
    
    
    public BinaryTree(){
        root = null;
    }
    
    BinaryTree(String[] s)
    {
        WordCount wordCount = new WordCount(s);
        
        String[] wordArray = wordCount.getStringArray();
        int[] countArray = wordCount.getIntArray();
        
        insertArray(wordArray, countArray);
        
    	root = null;
    	
    }
    
    
    
    public void insertArray(String[] newDataArray, int[] newDataCountArray)
    {
    	for (int i = 0; i < newDataArray.length; ++i)
    	{
    		insert(newDataArray[i], newDataCountArray[i]);
    	}
    }
    
    public void insert(String data, int dataCount){
        root = insert(root,data, dataCount);
    }
    
    public String[] sortArray()
    {
      	addElemementsToArrayList(root);
    	
    	String[] sortedArray = new String[arrayList.size()];
    	arrayList.toArray(sortedArray);
    	
    	return sortedArray;
    }
    
    private void addElemementsToArrayList(Node n)
    {
    	if (n == null)
    	{
    		return;
    	}
    	else
    	{
    		addElemementsToArrayList(n.left);
        	arrayList.add(n.data + " " + n.dataCount);
        	addElemementsToArrayList(n.right);
    	}
    	
    	
    }
    
    private Node insert(Node node, String data, int dataCount){
        if (node==null){
            node = new Node(data, dataCount);
        }
        else {
        	if (dataCount > node.dataCount){
                node.left = insert(node.left, data, dataCount);
            }
            else 
            {
                node.right = insert(node.right, data, dataCount);
            }
        }
        return node;
    }
	
}
