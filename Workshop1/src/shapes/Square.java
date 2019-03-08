package shapes;

public class Square extends Rectangle {
	
	/**
	 * Constructor accepts a double for the side, throws exception if data is not valid
	 * @param side A positive double representing the side of the square
	 * */	
	public Square(double side) throws ParallelogramException, SquareException {
		super(side, side);
	}
	
	/**
	 * Getting the perimeter of the square
	 * @return a double indicating the perimeter of the square
	 * */
	@Override
	public double getPerimeter() {
		return 4 * getWidth();
	}
	
	/**
	 * Returning a String representing the square
	 * @return a String representing the square
	 * */
	@Override
	public String toString() {
		return "Square {s=" + (new Double(getWidth()).toString()) + "} perimeter = " + String.format("%.4f", getPerimeter());
	}
}