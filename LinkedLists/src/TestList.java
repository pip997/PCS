import java.util.*;

public class TestList{
	
	public static void main (String[] args) {
		LinkedList ll = new LinkedList();
		
		ll.addFirst("3");
		ll.addFirst("2");
		ll.addFirst("1");
		
		ll.addLast("4");
		ll.addLast("5");
		
		ll.printAll();
		
		ll.removeLast();
		ll.removeLast();
		
		ll.printAll();
	}
	
}
