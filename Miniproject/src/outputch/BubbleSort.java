package outputch;

import java.util.ArrayList;
import java.util.Arrays;


public class BubbleSort {
	
	String[] words;// = {"klo","hjk","hhh","aef","hhh","hhh","hhh","hhh","aef"}; //This is where it needs to import the array from the server
	int[] frequency; //= {1,1,5,2,5,5,5,5,2};
	
	public BubbleSort() {
		
	}

	public BubbleSort(ArrayList<String> wordList) {
		WordCount wc = new WordCount(wordList);
		words = wc.getStringArray();
		frequency = wc.getIntArray();		
		}
	
	public void bubbleSort(){
		int n = frequency.length;
		int temp = 0;
		String temp2;
		
		for (int i = 0; i < n; i++){
			boolean noSwap = true;
			for (int j = 1; j < (n-i); j++){
				if (frequency[j-1] < frequency[j]){
					temp = frequency[j-1];
					temp2 = words[j-1];
					
					frequency[j-1] = frequency[j];
					words[j-1]=words[j];
					
					frequency[j] = temp;
					words[j]=temp2; 
					
					noSwap=false;
				}
				
			}
			if (noSwap) break;
		}
		
		/*int n = array.length;
		String temp;
		String temp2;
		int frequencyCounter;
		int storeResult;
		
		for(int i=1; i < n; i++){
			frequencyCounter = array[i-1].compareTo(array[i]);
			
			if (frequencyCounter==0){
				temp2 = array[i];
				
			}
		}
		
		
		for (int i = 0; i < n; i++){
			boolean noSwap = true;
			for (int j = 1; j < (n-i); j++){
				storeResult = array[j-1].compareTo(array[j]); 
				//the compareTo function compares two strings in the array, a and b, and if the output is above 0 it means 
				//that the argument a being compared to argument b is lexicographically greater than b which means it needs to be later in the array.
		
				if (storeResult>0){
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
					
					noSwap=false;
				}
			}
			if (noSwap) break;
		}*/
	}
	
	public String[] histogram(){
		String[] outputString = new String[frequency.length];
		for(int i=0; i<frequency.length; i++){
		outputString[i] = words[i] +" "+ frequency[i];
		//System.out.print(outputString[i] + " ");
		}
		
		return  outputString;
		
	}
	
	public void printArray(){
	        System.out.println();
	        for (int i=0; i<frequency.length; i++){
	            System.out.print(frequency[i] + words[i]);
	            System.out.print(" ");
	        }
	        System.out.println();
	    }

	 
	/*public static void main(String[] args) {
		
		
		BubbleSort bs = new BubbleSort(wordss);
		
		bs.bubbleSort();
		String[] output = bs.histogram();
		
		
		
	}*/
}
