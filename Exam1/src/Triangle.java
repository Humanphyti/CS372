
public class Triangle extends Shapes {
	//private int side1, side2, side3;
	
	public Triangle(String type, String ID, int side1, int side2, int side3, String color) {
		this.type = type;
		this.ID = ID;
		this.setSide1(side1);
		this.setSide2(side2);
		this.setSide3(side3);
		this.color = color;
		
	}

	/**
	 * @return the side1
	 */
	public int getSide1() {
		return side1;
	}

	/**
	 * @param side1 the side1 to set
	 */
	public void setSide1(int side1) {
		this.side1 = side1;
	}

	/**
	 * @return the side2
	 */
	public int getSide2() {
		return side2;
	}

	/**
	 * @param side2 the side2 to set
	 */
	public void setSide2(int side2) {
		this.side2 = side2;
	}

	/**
	 * @return the side3
	 */
	public int getSide3() {
		return side3;
	}

	/**
	 * @param side3 the side3 to set
	 */
	public void setSide3(int side3) {
		this.side3 = side3;
	}

	@Override
	int getRadius() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return side1+side2+side3;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	void setArea(double area) {
		this.area = area;
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

	String getDetailString() {
		String detailedInfo = type + " " + "(" + "ID#" + ID + ")\n" + "Color: " + color + "\n" + "Side 1: " + side1 + "\n" + "Side 2: " + side2 + "\n" + "Side 3: " + side3 + "\n" + "Area: " + "A number" + "\n" + "Perimeter: " + getPerimeter();
		return detailedInfo;
	}
}
