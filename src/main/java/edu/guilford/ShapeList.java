package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

// ShapeList is a list of shapes, so let's have it extends ArrayList<Shape>
public class ShapeList extends ArrayList<Shape> {
    //Instantiate a Random Object
    Random random = new Random();

    //Method to return a random color with any possible value
    public Color getRandomColor() {
        //Return a random color with any possible value
        //this returns a Color with random values for red, green, and blue
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    //Constructor to add random shape objects to the list
    public ShapeList() {
        //call the superclass constructor
        super();
        //add random shape objects to the list (between 0 and 10)
        int nShapes = random.nextInt(40) + 10;
        for (int i = 0; i < nShapes; i++) {
            //add a random shape to the list
            this.add(getRandomShape());
        }
        // If we try to instantiate an abstract class, we get an error
        // because abstract classes can only be extended (not instantiated)
        // Shape theShape = new Shape();
    }

    //method to return a random shape
    public Shape getRandomShape() {
        int shapeChoice = random.nextInt(5);
        switch (shapeChoice) {
            case 0:
                //circle needs a center x, center y, radius, and color
                Circle circle = new Circle(random.nextInt(800), random.nextInt(600), random.nextInt(100), getRandomColor());
                return circle;
            case 1:
                //generate a random ellipse
                Ellipse ellipse = new Ellipse(random.nextInt(800), random.nextInt(600), random.nextInt(100), random.nextInt(100));
                ellipse.setFill(getRandomColor());
                return ellipse;
            case 2:
                //generate a random rectangle
                Rectangle rectangle = new Rectangle(random.nextInt(800), random.nextInt(600), random.nextInt(100), random.nextInt(100));
                //set the color of the rectangle
                rectangle.setFill(getRandomColor());
                return rectangle;
            case 3:
                //generate a random line
                Line line = new Line(random.nextInt(800), random.nextInt(600), random.nextInt(800), random.nextInt(600));
                //set the color of the line
                line.setStroke(getRandomColor());
                line.setStrokeWidth(random.nextInt(10) + 2);
                return line;
            case 4:
                //generate a random polygon with 3-10 sides
                int nSides = random.nextInt(8) + 3;
                // create an array of doubles to hold the x and y coordinates of the vertices
                double[] vertices = new double[nSides * 2];
                //fill in the array with random x and y coordinates
                for (int i = 0; i < nSides * 2; i++) {
                    vertices[i] = random.nextDouble() * 800;
                }
                Polygon polygon = new Polygon(vertices);
                polygon.setFill(getRandomColor());
                return polygon;
            default:
                //this should never happen
                return null;
        }
    }

    //Add a toString() method to return a string representation of the list
    @Override
    public String toString() {
        //go through the list and print out something relevant to each kind of shape
        StringBuilder s = new StringBuilder();
        
        // Asking each kind of shape to do something, and each shape responds in a different 
        // way depending on what kind of shape it is, is an example of *polymorphism*
        // thing we're asking each shape to : print out something about itself
        for (Shape shape: this) {
            // instanceof is a keyword that checks to see if an object is an 
            // instance of a specified class
            // using instanceof is an example of object reflection
            if (shape instanceof Circle) {
                // Tell java that the shape we're looking at right now is a Circle
                // using a *cast* : take shape and (Circle)shape tells java 
                // to treat shape as a Circle
                Circle circle = (Circle) shape;
                s.append("Circle with radius ");
                s.append(circle.getRadius());
                s.append(" at (");
                s.append(circle.getCenterX());
                s.append(", ");
                s.append(circle.getCenterY());
                s.append(")\n");
            } else if (shape instanceof Ellipse) {
                Ellipse ellipse = (Ellipse) shape;
                s.append("Ellipse with radii ");
                s.append(ellipse.getRadiusX());
                s.append(" and ");
                s.append(ellipse.getRadiusY());
                s.append(" at (");
                s.append(ellipse.getCenterX());
                s.append(", ");
                s.append(ellipse.getCenterY());
                s.append(")\n");
            } else if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                s.append("Rectangle with width ");
                s.append(rectangle.getWidth());
                s.append(" and height ");
                s.append(rectangle.getHeight());
                s.append(" at (");
                s.append(rectangle.getX());
                s.append(", ");
                s.append(rectangle.getY());
                s.append(")\n");
            } else if (shape instanceof Line) {
                Line line = (Line) shape;
                s.append("Line with endpoints (");
                s.append(line.getStartX());
                s.append(", ");
                s.append(line.getStartY());
                s.append(") and (");
                s.append(line.getEndX());
                s.append(", ");
                s.append(line.getEndY());
                s.append(")\n");
            } else if (shape instanceof Polygon) {
                s.append("Polygon with vertices (");
                for (int i = 0; i < ((Polygon) shape).getPoints().size(); i += 2) {
                    s.append(((Polygon) shape).getPoints().get(i));
                    s.append(", ");
                    s.append(((Polygon) shape).getPoints().get(i + 1));
                    s.append(") (");
                }
                s.append(")\n");
            } else {
                s.append("Unknown shape\n");
            }
        }
        return s.toString();
    }

    
}
