package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import shapes.Shape;
import shapes.Circle;
import shapes.CircleException;
import shapes.Parallelogram;
import shapes.ParallelogramException;
import shapes.Rectangle;
import shapes.Square;
import shapes.SquareException;
import shapes.Triangle;
import shapes.TriangleException;

public class Main {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[50];
		int index = 0;

		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.println("------->Task 1 ... <-------");
		
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
			String s;
			while ((s = br.readLine()) != null) {
				String[] tokens = s.split(",");

				switch (tokens[0]) {
				case "Circle":
					try {
						if (tokens.length == 2) {
							shapes[index] = new Circle(Double.parseDouble(tokens[1]));
						}
					} catch (CircleException e) {
						System.out.println(e.getMessage());
					}
					if (shapes[index] != null) {
						index++;
					}
					break;
				case "Parallelogram":
					try {
						if (tokens.length == 3) {
							shapes[index] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
						}
					} catch (ParallelogramException e) {
						System.out.println(e.getMessage());
					} catch (SquareException e) {
						System.out.println(e.getMessage());
					}
					if (shapes[index] != null) {
						index++;
					}
					break;
				case "Rectangle":
					try {
						if (tokens.length == 3) {
							shapes[index] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
						}
					} catch (ParallelogramException e) {
						System.out.println(e.getMessage());
					} catch (SquareException e) {
						System.out.println(e.getMessage());
					}
					if (shapes[index] != null) {
						index++;
					}
					break;
				case "Square":
					try {
						if (tokens.length == 2) {
							shapes[index] = new Square(Double.parseDouble(tokens[1]));
						}
					} catch (ParallelogramException e) {
						System.out.println(e.getMessage());
					} catch (SquareException e) {
						System.out.println(e.getMessage());
					}
					if (shapes[index] != null) {
						index++;
					}
					break;
				case "Triangle":
					try {
						if (tokens.length == 4) {
							shapes[index] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
						}
					} catch (TriangleException e) {
						System.out.println(e.getMessage());
					}
					if (shapes[index] != null) {
						index++;
					}
					break;
				}

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.printf("\n%d shapes were created:\n", index);
		for (int i = 0; i < index; i++) {
			System.out.println(shapes[i]);
			System.out.println();
		}
		
		System.out.println("------->Task 2 ... <-------");
		Shape[] shapes2 = new Shape[50];
		double maxCirclePerimeter = 0.0;
		double minTrianglePerimeter = 99999.0;
		int index2 = 0;
		
		// find out the circle's maximum perimeter and triangle's minimum perimeter
		for (int i = 0; i < index; i++) {
			if (shapes[i].getClass().getName().equals("shapes.Circle")) {
				if (shapes[i].getPerimeter() > maxCirclePerimeter) {
					maxCirclePerimeter = shapes[i].getPerimeter();
				}
			} else if (shapes[i].getClass().getName().equals("shapes.Triangle")) {
				if (shapes[i].getPerimeter() < minTrianglePerimeter) {
					minTrianglePerimeter = shapes[i].getPerimeter();
				}
			}
		}
		
		// store matched elements into a new array
		for (int i = 0; i < index; i++) {
			if ((shapes[i].getClass().getName().equals("shapes.Circle") && shapes[i].getPerimeter() == maxCirclePerimeter) ||
					(shapes[i].getClass().getName().equals("shapes.Triangle") && shapes[i].getPerimeter() == minTrianglePerimeter)) {
				// do nothing
			} else {
				shapes2[index2] = shapes[i];
				index2++;
			}
		}
		
		shapes = shapes2;
		for (int i = 0; i < index2; i++) {
			System.out.println(shapes[i]);
			System.out.println();
		}
		
		System.out.println("------->Task 3 ... <-------");
		double perimeterParallelogram = 0.0;
		double perimeterTriangle = 0.0;
		for (int i = 0; i < index2; i++) {
			if (shapes[i].getClass().getName().equals("shapes.Parallelogram")) {
				perimeterParallelogram += shapes[i].getPerimeter();
			}
			if (shapes[i].getClass().getName().equals("shapes.Triangle")) {
				perimeterTriangle += shapes[i].getPerimeter();
			}
		}
		System.out.println("Total perimeter of Parallelogram is: " + perimeterParallelogram);
		System.out.println("Total perimeter of Triangle is: " + perimeterTriangle);
		
		
	}
}
