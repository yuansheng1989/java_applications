package shapes;

public class Rectangle extends Parallelogram {

	/**
	 * Constructor accepts two doubles for width and height, throws exception if data is not valid
	 * @param width A positive double representing the width of the rectangle
	 * @param height A positive double representing the height of the rectangle
	 * @throws SquareException 
	 * */	
	public Rectangle(double width, double height) throws ParallelogramException, SquareException {
		super(width, height);
	}
	
	/**
	 * Getting the perimeter of the rectangle
	 * @return a double indicating the perimeter of the rectangle
	 * */
	@Override
	public double getPerimeter() {
		return (getWidth() + getHeight()) * 2;
	}

	/**
	 * Returning a String representing the rectangle
	 * @return a String representing the rectangle
	 * */
	@Override
	public String toString() {
		return "Rectangle {w=" + (new Double(getWidth()).toString()) + ", h=" + (new Double(getHeight()).toString()) + "} perimeter = " + String.format("%.4f", getPerimeter());
	}
}