package geoviz;

import javafx.scene.shape.Line;

/**
 * This class represents a line
 */
public class MyLine extends Line {

    /**
     * This field represents the slope of a line
     */
    private double slope;
    /*
    *  This field represents the intercept with the y-axis of two lines
     */
    private double intercept;

    /**
     * Constructor
     * @param point1 point 1
     * @param point2 point 2
     */
    public MyLine(MyPoint point1, MyPoint point2) {
        slope = Utilities.getSlope(point1.getX(), point1.getY(), point2.getX(), point2.getY());
        intercept = Utilities.getIntercept(point1.getX(), point1.getY(), point2.getX(), point2.getY());
    }

    /**
     * This method gets the slope of a line
     * @return slope
     */
    public double getSlope() {
        return slope;
    }

    /**
     * This method gets the intercept with the y-axis of a point
     * @return intercept with y-axis
     */
    public double getIntercept() {
        return intercept;
    }
}
