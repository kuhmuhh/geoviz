package geoviz;

import javafx.scene.shape.Circle;

/**
 *  This Method represents a circle
 */
public class MyCircle extends Circle {
    /**
     * This field represents the radius of a circle
     */
    private double radius;
    /**
     * This field represents the center point of a circle
     */
    private MyPoint center;

    /**
     * Constructor
     *
     * @param point1 point1
     * @param point2 point2
     */
    public MyCircle(MyPoint point1, MyPoint point2) {
        this.radius = Utilities.getDistance(point1, point2);
        this.center = point1;
    }

    /**
     * This method gets the center of the circle
     *
     * @return center
     */
    public MyPoint getCenter() {
        return center;
    }

    /**
     * This method gets the radius of the circle
     *
     * @return radius
     */
    public double getMyRadius() {
        return radius;
    }

    /**
     * This method sets the center of a circle
     *
     * @param center center
     */
    public void setCenter(MyPoint center) {
        this.center = center;
    }

    /**
     * This method sets the radius of a circle
     *
     * @param radius radius
     */
    public void setMyRadius(double radius) {
        this.radius = radius;
    }

}