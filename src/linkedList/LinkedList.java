package linkedList;

public class LinkedList<T> implements Cloneable{
	Node<T> head;
	
	
	/*public LinkedList(Node<T> head) {
		// TODO Auto-generated constructor stub
		this.head = head;
	}*/
	public LinkedList() {
		
	}
	
	public LinkedList(LinkedList<T> list) {
		Node temphead = list.head;
		while(temphead != null) {
			this.add((T)temphead.data);
			temphead = temphead.next;
		}
		
	}
	
	public void add(T data) {
		Node<T> node = new Node<T>(data);
		Node<T> iterator;
		if(head == null) {
			head = node;
		} else {
			iterator = head;
			while(iterator.next != null) {
				iterator = iterator.next;
			}
			iterator.next = node;
		}
	}
	
	public void deleteFirstElement() {
		Node<T> iterator;
		if(head == null) {
			System.out.println("Empty List");
		} else {
			iterator = head;
			head = iterator.next;
		}
	}
	
	public LinkedList clone() throws CloneNotSupportedException {
		return (LinkedList) super.clone();
	}
	
	public boolean isPresent(T number) {
		Node<T> iterator = head;
		boolean isPresent = false;
		if(head == null) {
			return isPresent;
		} else {
			//System.out.println("number to check = "+number);
			//System.out.println("link list data");
			while(iterator.next != null) {
				//System.out.print(iterator.data+" ");
				if(iterator.data.toString().equals(number.toString())) {
					//System.out.println("inside");
					isPresent = true;
					break;
				}
				iterator = iterator.next;
			}
			//System.out.println();
			if(iterator.data.toString().equals(number.toString())) {
				isPresent = true;
			}
			
			return isPresent;
		}
	}
	
	public void print(/*Node<T> head*/) {
		Node<T> iterator;
		if(head == null) {
			System.out.println("Empty list");
		} else {
			iterator = head;
			while(iterator.next != null) {
				System.out.print(iterator.data+"->");
				iterator = iterator.next;
			}
			System.out.println(iterator.data);
		}
	}
	
	/*public static void main(String args[]) {
		LinkedList linkList = new LinkedList();
		linkList.add(2);
		linkList.add(3);
		linkList.print();
		System.out.println(linkList.isPresent(4));
		System.out.println("After deletion");
		linkList.deleteFirstElement();
		linkList.print();
	}*/
	
}
