package edu.guilford;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

//ShapePane will extend Pane because we want exact control over 
//where we place the grapghic objects
public class ShapePane extends Pane{
    //ShapePane does everything Pane does

    //Constructor : This constructor essentially overrides the Pane default constructor
    public ShapePane() {
        //When a class extends another class, the first line should be asking 
        //the superclass to run its constructor
        super(); //*This* refers to the current object; *super* refers to the superclass
        //could do other stuff here as well 
    }

    //add a shape to the pane
    public void addShape(Shape shape) {
        //add the shape to the pane
        this.getChildren().add(shape);
    }

    //remove a shape from the pane
    public void removeShape(Shape shape) {
        //remove the shape from the pane
        this.getChildren().remove(shape);
    }
    
    //clear the pane of all shapes
    public void clearShapes() {
        //remove all shapes from the pane
        this.getChildren().clear();
    }

     

}
