package shapes;

public class Parallelogram implements Shape {

	private double width;
	private double height;
	
	/**
	 * Constructor accepts two doubles for width and height, throws exception if data is not valid
	 * @param width A positive double representing the width of the parallelogram
	 * @param height A positive double representing the height of the parallelogram
	 * */
	public Parallelogram(double width, double height) throws ParallelogramException, SquareException {
		if(this instanceof Square) {
			if(width <= 0)
				throw new SquareException("Invalid side!");
		}
		
		if(width > 0)
			this.width = width;	
		else
			throw new ParallelogramException("Invalid width!");

		if(height > 0)
			this.height = height;	
		else
			throw new ParallelogramException("Invalid height!");	
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) throws ParallelogramException {
		if(width > 0)
			this.width = width;	
		else
			throw new ParallelogramException("Invalid width!");
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) throws ParallelogramException {
		if(height > 0)
			this.height = height;	
		else
			throw new ParallelogramException("Invalid height!");
	}

	/**
	 * Getting the perimeter of the parallelogram
	 * @return a double indicating the perimeter of the parallelogram
	 * */
	@Override
	public double getPerimeter() {
		return (getWidth() + getHeight()) * 2;
	}

	/**
	 * Returning a String representing the parallelogram
	 * @return a String representing the parallelogram
	 * */
	@Override
	public String toString() {
		return "Parallelogram {w=" + (new Double(getWidth()).toString()) + ", h=" + (new Double(getHeight()).toString()) + "} perimeter = " + String.format("%.4f", getPerimeter());
	}

}