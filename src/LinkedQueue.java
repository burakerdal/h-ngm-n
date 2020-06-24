

public class LinkedQueue {	

	private Node front = null;
	private Node rear = null;
	private int numberElements = 0;

	public void enqueue(Object item) {	      
		if (front == null) {
			Node newNode = new Node(item);
			rear = newNode;
			front = newNode;
		}
		else {	         
			Node newNode = new Node(item);
			rear.setLink(newNode);
			rear = newNode;
		}
		numberElements++;
	}

	public Object dequeue () {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return null;
		}
		else {
			Object data =front.getData(); 
			front = front.getLink();
			numberElements--;
			return data;
		}
	}

	public Object peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return null;
		}
		else
			return front.getData();
	}

	public boolean isEmpty () {
		return front == null;
	}

	public int size () {
		return numberElements;
	}	
	
	public String display1(LinkedQueue q)
	{
		String s="";
		for (int i = 0; i < q.size(); i++) {
			s+=q.peek();
			q.enqueue(q.dequeue());
		}
		return s;
		
		
	}
	
	public String display2(LinkedQueue q)
	{
		String s="";
		for (int i = 0; i < q.size(); i++) {
			s+=q.peek().toString().toUpperCase();
			s+=" ";
			q.enqueue(q.dequeue());
		}
		return s;
		
		
	}
}
