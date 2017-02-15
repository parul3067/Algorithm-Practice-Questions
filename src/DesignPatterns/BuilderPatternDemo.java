package DesignPatterns;

import java.util.ArrayList;

interface Packing {
	public String pack();
}

class Wrapper implements Packing {
	public String pack() {
		return "Wrapper";
	}
}

class Bottle implements Packing {
	public String pack() {
		return "Bottle";
	}
}

interface Item {
	public String getName();
	public Packing getPacking();
	public float getPrice();
}

abstract class Burger implements Item {
	public Packing getPacking() {
		return new Wrapper();
	}
}

class VegBurger extends Burger {
	public String getName() {
		return "Veg Burger";
	}
	
	public float getPrice() {
		return 25.0f;
	}
}

class ChickenBurger extends Burger {
	
	public String getName() {
		return "Chicken Burger";
	}
	
	public float getPrice() {
		return 35.0f;
	}
	
}

abstract class ColdDrink implements Item {
	
	public Packing getPacking() {
		return new Bottle();
	}
}

class Pepsi extends ColdDrink {
	public String getName() {
		return "Pepsi";
	}
	
	public float getPrice() {
		return 10.0f;
	}
}

class Coke extends ColdDrink {
	public String getName() {
		return "Coke";
	}
	
	public float getPrice() {
		return 12.0f;
	}
}


class Meal {
	ArrayList<Item> order = new ArrayList<>();
	
	public void add(Item item) {
		order.add(item);
	}
	
	public float getBill() {
		float total = 0.0f;
		for(Item item : order) {
			total += item.getPrice();
		}
		
		return total;
	}
	
	public void printOrder() {
		System.out.println("Meal Details");
		for(Item item : order) {
			System.out.print("Item Name: "+item.getName()+" | ");
			System.out.print("Item Price: "+item.getPrice()+" | ");
			System.out.print("Item Packing: "+item.getPacking().pack());
			System.out.println();
		}
	}
}

class MealBuilder {
	
	public Meal prepareVegMeal() {
		Meal vegMeal = new Meal();
		vegMeal.add(new VegBurger());
		vegMeal.add(new Coke());
		return vegMeal;
	}
	
	public Meal prepareNonVegMeal() {
		Meal nonVegMeal = new Meal();
		nonVegMeal.add(new ChickenBurger());
		nonVegMeal.add(new Pepsi());
		return nonVegMeal;
	}
	
}

public class BuilderPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MealBuilder mealBuilder = new MealBuilder();
		Meal meal1 = mealBuilder.prepareVegMeal();
		meal1.printOrder();
		System.out.println("Meal price: "+meal1.getBill());
		
		Meal meal2 = mealBuilder.prepareNonVegMeal();
		meal2.printOrder();
		System.out.println("Meal price: "+meal2.getBill());
	}

}
