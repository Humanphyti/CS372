
public abstract class Shapes {
	protected String type;
	protected String ID;
	protected String color;
	protected int radius, length, width, side1, side2, side3;
	protected double area;
	protected double perimeter;
	
	public Shapes() {
		type = "circle";
		ID = "";
		color = "purple";
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * 
	 *@Override toString
	*/
	public String toString() {
		return String.format("%s (%s)", type, ID);
	}
	
	abstract String getDetailString();
	
	abstract int getRadius(); //necessary for functionality in ExamUI, abstract radius function
	abstract double getPerimeter(); //necessary for functionality in ExamUI, abstract Perimeter function
	abstract double getArea(); //necessary for functionality in ExamUI, abstract Area function
	abstract int getSide1(); //necessary for functionality in ExamUI, abstract side1 getter function
	abstract int getSide2(); //necessary for functionality in ExamUI, abstract side2 getter function
	abstract int getSide3(); //necessary for functionality in ExamUI, abstract side3 getter function
	abstract int getLength(); //necessary for functionality in ExamUI, abstract length getter function
	abstract int getWidth(); //necessary for functionality in ExamUI, abstract width getter function
}
