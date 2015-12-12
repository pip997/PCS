package outputch;

import java.util.ArrayList;
import java.util.Arrays;

public class testingClass {

	public static void main(String[] args) {
		ArrayList<String> words= new ArrayList<String>(Arrays.asList("hey", "I", "just", "met", "you", "just", "you"));
		QuickSort qs = new QuickSort(words);
		qs.qSort(0, qs.count.length - 1);
		qs.printArray();
		qs.histogram();
	}

}
