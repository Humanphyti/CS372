
public class Circle extends Shapes {
	
	public Circle(String type, String ID, int radius, String color) {
		this.type = type;
		this.ID = ID;
		this.radius = radius;
		this.color = color;
	}
	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	//get area of circle
	public double getArea() {
		return Math.PI*radius*radius;
		
	}
	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return Math.PI*2*radius;
	}
	@Override
	int getSide1() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	int getSide2() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	int getSide3() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	//the pretty formatting of additional details
	public String getDetailString() {
		String detailedInfo = type + " " + "(" + "ID#" + ID + ")\n" + "Color: " + color + "\n" + "Radius: " + radius + "\n" + "Area: " + getArea() + "\n" + "Circumference: " + getPerimeter();
		return detailedInfo;
	}
}
