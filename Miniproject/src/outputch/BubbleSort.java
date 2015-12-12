package outputch;

public class BubbleSort extends Sorting {

	public BubbleSort() {
		super("BubbleSort");
	}

	public BubbleSort(String name) {
		super(name);
	}
	
	public void bSort(){
		int n = array.length;
		int temp = 0;
		
		for (int i = 0; i < n; i++){
			boolean noSwap = true;
			for (int j = 1; j < (n-i); j++){
				if (array[j-1] > array[j]){
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
					increaseCounter();
					noSwap=false;
				}
				increaseCounter();
			}
			if (noSwap) break;
		}
	}
	

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		bs.getUserInput();
		bs.printArray();
		bs.bSort();
		bs.printArray();
		bs.printComplexity();
		
	}
}
