import java.util.Hashtable;

/** 
 * 
Prototype pattern refers to creating duplicate object while keeping performance in mind. 
This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.

This pattern involves implementing a prototype interface which tells to create a clone of the current object. 
This pattern is used when creation of object directly is costly. For example, an object is to be created after a costly database operation. 
We can cache the object, returns its clone on next request and update the database as and when needed thus reducing database calls.*/

abstract class Shape implements Cloneable {

	private String id;
	protected String type;

	abstract void draw();

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object clone() {
		Object clone = null;

		try {
			clone = super.clone();

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return clone;
	}
}

class Circle extends Shape {

	@Override
	void draw() {
		System.out.println("This is Circle");
		
	}
	
	public Circle() {
		this.type = "Circle";
	}

}

class Rectangle extends Shape {

	@Override
	void draw() {
		System.out.println("This is Rectangle");
		
	}
	
	public Rectangle() {
		this.type = "Rectangle";
	}

}

class Square extends Shape {

	@Override
	void draw() {
		System.out.println("This is Square");
		
	}
	
	public Square() {
		this.type = "Square";
	}

}

class ShapeCache {
	
	   private static Hashtable<String, Shape> shapeMap  = new Hashtable<String, Shape>();

	   public static Shape getShape(String shapeId) {
	      Shape cachedShape = shapeMap.get(shapeId);
	      return (Shape) cachedShape.clone();
	   }

	   // for each shape run database query and create shape
	   // shapeMap.put(shapeKey, shape);
	   // for example, we are adding three shapes
	   
	   public static void loadCache() {
		  // it is the temporary replacement to database. We should use DB instead
	      Circle circle = new Circle();
	      circle.setId("1");
	      shapeMap.put(circle.getId(),circle);

	      Square square = new Square();
	      square.setId("2");
	      shapeMap.put(square.getId(),square);

	      Rectangle rectangle = new Rectangle();
	      rectangle.setId("3");
	      
	      Circle circle2 = new Circle();
	      circle2.setId("4");
	      circle2.setType("Big Circle");
	      shapeMap.put(circle2.getId(),circle2);
	      shapeMap.put(rectangle.getId(), rectangle);
	   }

}

public class PrototypeDemo {

	public static void main(String[] args) {
		
		ShapeCache.loadCache(); // this should be replaced by DB
		/*we should connect to the DB and get data only one time, 
		the next time we will retrieve data in cache instead of load data from DB again*/
		
	      Shape clonedShape = (Shape) ShapeCache.getShape("1");
	      System.out.println("Shape : " + clonedShape.getType());		

	      Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
	      System.out.println("Shape : " + clonedShape2.getType());		

	      Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
	      System.out.println("Shape : " + clonedShape3.getType());
	      
	      Shape clonedShape4 = (Shape) ShapeCache.getShape("4");
	      System.out.println("Shape : " + clonedShape4.getType());
	}

}
