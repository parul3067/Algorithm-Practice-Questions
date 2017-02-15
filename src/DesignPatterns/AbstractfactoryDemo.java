package DesignPatterns;

interface Shape {
	public void draw();
}

class Circle implements Shape {
	public void draw() {
		System.out.println("get circle");
	}
}

class Rectangle implements Shape {
	public void draw() {
		System.out.println("get Rectangle");
	}
}

class Square implements Shape {
	public void draw() {
		System.out.println("get Square");
	}
}

interface Color {
	public void fillColor();
}

class Red implements Color {
	public void fillColor() {
		System.out.println("fill Red");
	}
}

class Blue implements Color {
	public void fillColor() {
		System.out.println("fill Blue");
	}
}

class Green implements Color {
	public void fillColor() {
		System.out.println("fill Green");
	}
}

abstract class Abstractfactory {
	public abstract Shape getShape(String shape);
	public abstract Color getColor(String color);
}

class ShapeFactory extends Abstractfactory{
	public Shape getShape(String shape) {
		if(shape.equals("circle")) {
			return new Circle();
		} else if(shape.equals("rectangle")) {
			return new Rectangle();
		} else if(shape.equals("square")) {
			return new Square();
		} else {
			return null;
		}
	}
	
	public Color getColor(String color) {
		return null;
	}
}

class ColorFactory extends Abstractfactory {
	public Shape getShape(String shape) {
		return null;
	}
	
	public Color getColor(String color) {
		if(color.equals("red")) {
			return new Red();
		} else if(color.equals("blue")) {
			return new Blue();
		} else if(color.equals("green")) {
			return new Green();
		} else {
			return null;
		}
	}
}

class FactoryProducer {
	public static Abstractfactory getFactory(String factory) {
		if(factory.equals("shape")) {
			return new ShapeFactory();
		} else {
			return new ColorFactory();
		}
	}
}

public class AbstractfactoryDemo extends FactoryProducer{

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		Abstractfactory factory = FactoryProducer.getFactory("shape");
		Shape shape1 = factory.getShape("circle");
		shape1.draw();
		
		Shape shape2 = factory.getShape("rectangle");
		shape2.draw();
		
		
		Abstractfactory factory2 = FactoryProducer.getFactory("color");
		Color color1 = factory2.getColor("red");
		color1.fillColor();
	}

}
