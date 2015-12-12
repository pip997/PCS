package outputch;

public class testingClass {

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		qs.qSort(0, qs.array.length - 1);
		qs.printArray();

	}

}
