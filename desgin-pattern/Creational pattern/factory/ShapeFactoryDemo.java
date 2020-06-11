interface Shape {
	public void draw();
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.print("Circle");
	}
}

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.print("Rectangle");
	}

}

class Square implements Shape {

	@Override
	public void draw() {
		System.out.print("Square");
	}
}

class ShapeFactory {
	
	public Shape getShape(String shapeType) {
		if(shapeType == null) {
			return null;
		}
		if(shapeType.equals("Circle")) {
			return new Circle();
		}
		if(shapeType.equals("Rectangle")) {
			return new Rectangle();
		}
		if(shapeType.equals("Square")) {
			return new Square();
		}
		return null;
	}
}


public class ShapeFactoryDemo {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape circle = shapeFactory.getShape("Circle");
		Shape rectangle = shapeFactory.getShape("Rectangle");
		Shape square = shapeFactory.getShape("Square");
		circle.draw();
		rectangle.draw();
		square.draw();
	}

}
