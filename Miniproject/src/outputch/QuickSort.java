package outputch;

public class QuickSort {
	String[] array  = {"hej", "med", "error", "redacted", "dig", "wooo"};

    public QuickSort() {
        
    }

    public QuickSort(String[] inputArray) {
        array = inputArray;
    }

    public void qSort(int start, int end){
    	System.out.println(array.length);
        int i = start, j = end;
        System.out.println("i = " + i + " j = " + j + " start = " + start + " end = " + end);
        String pivot = array[i];
        
        while (j > i){
            while (array[i].compareTo(pivot) <= 0 && i < end && j > i){
                i++;
            }
            while(array[i].compareTo(pivot) >= 0 && j > start && j >= i){
                j--;
            }
            if (j > i){
                swap(array, i, j);
            }
        }
        System.out.println("start = " + start);
        System.out.println("j = " + j);
        swap (array, start, j);
        qSort(start, j - 1);
        qSort(j + 1, end);
    }
    
    public void swap(String[] a, int i, int j){
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public void printArray(){
        System.out.println();
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
