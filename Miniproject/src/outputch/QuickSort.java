package outputch;

public class QuickSort {
 	int[] array = {2,6,1,2,7,9,43,2};
 	String[] strArray = {"kat", "we", "qq", "gg", "qq", "ww", "ee", "rr"};

    public QuickSort() {
    }

    public QuickSort(String name) {
    }

    public void qSort(int low, int high){
        int i = low, j = high;
        
        int pivot = array[low + (high-low)/2];
        
        while (i<=j){
            while (array[i] > pivot){
                i++;
            }
            while(array[j] < pivot){
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
    	String[] outputString = new String[array.length];
    	
    	for (int i = 0; i < array.length; i++) {
    		outputString[i] = strArray[i] + " " + array[i];
    		System.out.print(outputString[i] + " ");
    	}
    	
    	
    	
		return outputString;
    }
    
    public void swap(int i, int j) {
    	String strTemp = strArray[i];
    	strArray[i] = strArray[j];
    	strArray[j] = strTemp;
    	
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public void printArray(){
        System.out.println();
        for (int i=0; i < array.length; i++){
            System.out.print(strArray[i] + " " + array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}

