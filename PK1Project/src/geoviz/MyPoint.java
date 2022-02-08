package geoviz;

import javafx.scene.shape.Circle;

/**
 * This Class represents a Point
 */
public class MyPoint extends Circle {

    /**
     * This field represents the x coordinate of a point
     */
    private double x;
    /**
     * This field represents the y coordinate of a point
     */
    private double y;

    /**
     * Constructor
     * @param xCoordinate x-coordinate
     * @param yCoordinate y-coordinate
     */
    public MyPoint(double xCoordinate, double yCoordinate) {
        this.x = xCoordinate;
        this.y = yCoordinate;
    }

    /**
     * This method gets the x-coordinate
     * @return x-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * This method gets the y-coordinate
     * @return y-coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * This method prints out the x- and y-coordinate of a point
     * @return point coordinates as a string
     */
    @Override
    public String toString() {
        return "MyPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
