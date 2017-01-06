package StackAndQueue;

public class Queue<T> {
	QueueNode<T> front;
	QueueNode<T> rear;
	
	private void enqueue(T data) {
		QueueNode<T> node = new QueueNode<T>(data);
		if(front == null) {
			front = rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
	}
	
	private QueueNode<T> dequeue() {
		QueueNode<T> temp = null;
		if(front == null) {
			System.out.println("Empty Queue");
		} else {
			temp = front;
			front = front.next;
		}
		
		return temp;
	}
	
	private void print() {
		QueueNode iterator = front;
		while(iterator.next != null) {
			System.out.print(iterator.data+"->");
			iterator = iterator.next;
		}
		System.out.println(iterator.data);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.print();
		System.out.println("Element deleted :"+q.dequeue().data);
		q.print();
		q.dequeue();
		q.dequeue();
		q.print();
		q.enqueue(6);
		q.enqueue(7);
		q.print();
	}

}
