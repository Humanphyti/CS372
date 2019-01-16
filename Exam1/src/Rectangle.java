
public class Rectangle extends Shapes {
	private int length;
	private int width;
	
	public Rectangle(String type, String ID, int length, int width, String color) {
		this.type = type;
		this.ID = ID;
		this.setLength(length);
		this.setWidth(width);
		this.color = color;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	int getRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getPerimeter() {
		return ((length*2)+(width*2));
	}

	@Override
	double getArea() {
		return length*width;
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

	//the pretty formatting of additional details

	String getDetailString() {
		String detailedInfo = type + " " + "(" + "ID#" + ID + ")\n" + "Color: " + color + "\n" + "Length: " + length + "\n" + "Width: " + width + "\n" + "Area: " + getArea() + "\n" + "Perimeter: " + getPerimeter();
		return detailedInfo;
	}
}
