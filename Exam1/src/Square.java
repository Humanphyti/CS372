
public class Square extends Shapes{
	private int side;
	
	public Square(String type, String ID, int side, String color) {
		this.type = type;
		this.ID = ID;
		this.setSide(side);
		this.color = color;
	}

	/**
	 * @return the side
	 */
	public int getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(int side) {
		this.side = side;
	}

	@Override
	int getRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return side*4;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return side*side;
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

	String getDetailString() {
		String detailedInfo = type + " " + "(" + "ID#" + ID + ")\n" + "Color: " + color + "\n" + "Sides: " + side + "\n" + "Area: " + getArea() + "\n" + "Perimeter: " + getPerimeter();
		return detailedInfo;
	}
	
	
}
