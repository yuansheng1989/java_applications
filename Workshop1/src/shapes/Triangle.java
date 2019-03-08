package shapes;

public class Triangle implements Shape {

	/** triangle side length */
	private double side1;
	private double side2;
	private double side3;

	/**
	 * Constructor accepts three doubles for the triangle side lengths, throws exception if data is not valid
	 * @param side1 A positive double representing side1 of the triangle
	 * @param side2 A positive double representing side2 of the triangle
	 * @param side3 A positive double representing side3 of the triangle
	 * */
	public Triangle(double side1, double side2, double side3) throws TriangleException {

		if(side1 > 0 && side2 > 0 && side3 > 0 &&
		   side1 + side2 > side3 && side1 + side3 > side2 && side3 + side2 > side1) {
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
		else {
			throw new TriangleException("Invalid side(s)!");
		}
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) throws TriangleException {
		if(side1 > 0)
			this.side1 = side1;
		else
			throw new TriangleException("Invalid side(s)!");
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) throws TriangleException {
		if(side2 > 0)
			this.side2 = side2;
		else
			throw new TriangleException("Invalid side(s)!");
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) throws TriangleException {
		if(side3 > 0)
			this.side3 = side3;
		else
			throw new TriangleException("Invalid side(s)!");
	}


	/**
	 * Getting the perimeter of the triangle
	 * @return a double indicating the perimeter of the triangle
	 * */
	public double getPerimeter() {
		return side1 + side2 + side3;
	}

	/**
	 * Returning a String representing the triangle
	 * @return a String representing the triangle
	 * */
	@Override
	public String toString(){ 
		return "Triangle {s1=" + (new Double(side1).toString()) + ", s2=" + (new Double(side2).toString()) + 
				", s3=" + (new Double(side3).toString()) +"} perimeter = " + String.format("%.4f", getPerimeter());
	}

}