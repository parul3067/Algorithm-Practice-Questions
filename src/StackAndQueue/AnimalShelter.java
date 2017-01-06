package StackAndQueue;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import java.util.Collection;
import java.util.LinkedList;

abstract class Animal {
	String name;
	int order;
	Animal(String name) {
		this.name = name;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public int getOrder() {
		return this.order;
	}
	
	public boolean isOlderThan(Animal a) {
		return (this.order < a.order);
	}
}

class Dog extends Animal {
	Dog(String name) {
		super(name);
	}
}

class Cat extends Animal {
	Cat(String name) {
		super(name);
	}
}

public class AnimalShelter {
	
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	static int order = 0;
	
	private void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if(a instanceof Dog) {
			dogs.add((Dog)a);
		} else {
			cats.add((Cat)a);
		}
	}
	
	public Animal dequeueAny() {
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlderThan(cat)) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}
	
	public Dog dequeueDog() {
		return dogs.poll();
	}
	
	public Cat dequeueCat() {
		return cats.poll();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalShelter as = new AnimalShelter();
		as.enqueue(new Dog("D1"));
		as.enqueue(new Cat("C1"));
		as.enqueue(new Cat("C2"));
		as.enqueue(new Dog("D2"));
		as.enqueue(new Dog("D3"));
		as.enqueue(new Cat("C3"));
		System.out.println("Dequeue any :"+as.dequeueAny().name);
		System.out.println("Dequeue Dog :"+as.dequeueDog().name);
		System.out.println("Dequeue Cat :"+as.dequeueCat().name);
		as.enqueue(new Cat("C4"));
		System.out.println("Dequeue any :"+as.dequeueAny().name);
		
	}

}
