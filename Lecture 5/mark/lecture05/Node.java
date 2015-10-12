package lecture05;

public class Node<AnyType> {
	private AnyType data;
	private Node<AnyType> next;
	
	public Node(AnyType data, Node<AnyType> next)
	{
		this.data = data;
		this.next = next;
	}
	
	public void setData (AnyType d)
	{
		data = d;
	}
	
	public AnyType getData ()
	{
		return data;
	}
	
	public void setNext (Node<AnyType> n)
	{
		next = n;
	}
	
	public Node<AnyType> getNext ()
	{
		return next;
	}
	
	
}
