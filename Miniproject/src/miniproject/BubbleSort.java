package miniproject;

public class BubbleSort {

	String[] array = {"klo","hjk","hhh","aef","aef"}; //This is where it needs to import the array
	
	public BubbleSort() {
		
	}

	public BubbleSort(String[] inputArray) {
		array = inputArray;
	}
	
	public void bubbleSort(){
		int n = array.length;
		String temp;
		int storeResult;
		
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
		}
	}
	
	 public void printArray(){
	        System.out.println();
	        for (int i=0; i<array.length; i++){
	            System.out.print(array[i]);
	            System.out.print(" ");
	        }
	        System.out.println();
	    }

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		
		bs.bubbleSort();
		bs.printArray();
		
		
	}
}
