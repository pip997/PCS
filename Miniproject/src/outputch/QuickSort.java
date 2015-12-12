package outputch;

import java.util.ArrayList;

public class QuickSort {
	int[] count;
	String[] words;

    public QuickSort(ArrayList<String> wordList) {
    	WordCount wc = new WordCount(wordList);
    	count = wc.getIntArray();
    	words = wc.getStringArray();
    }

    public void qSort(int low, int high){
        int i = low, j = high;
        
        int pivot = count[low + (high-low)/2];
        
        while (i<=j){
            while (count[i] > pivot){
                i++;
            }
            while(count[j] < pivot){
                j--;
            }
            if (i <= j){
                swap(i,j);
                i++;
                j--;
            }
        }
        if (low < j)
            qSort(low,j);
        if (i < high)
            qSort (i, high);
    }
    
    public String[] histogram() {
    	String[] outputString = new String[count.length];
    	
    	for (int i = 0; i < count.length; i++) {
    		outputString[i] = words[i] + " " + count[i];
    		System.out.print(outputString[i] + " ");
    	}
    	
    	
    	
		return outputString;
    }
    
    public void swap(int i, int j) {
    	String strTemp = words[i];
    	words[i] = words[j];
    	words[j] = strTemp;
    	
        int temp = count[i];
        count[i] = count[j];
        count[j] = temp;
    }
    
    public void printArray(){
        System.out.println();
        for (int i=0; i < count.length; i++){
            System.out.print(words[i] + " " + count[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}

