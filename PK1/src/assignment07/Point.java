package assignment07;

public class Point {

    private double x;
    private double y;

    /**
     * Constructor
     * @param xCoordinate x Coordinate of point
     * @param yCoordinate y Coordinate of point
     */
    public Point(double xCoordinate, double yCoordinate){
        this.x = xCoordinate;
        this.y = yCoordinate;
    }

    /**
     * This method sets the x value of the object
     * @param x x value as double
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * This method gets the x value of the object
     * @return x value as double
     */
    public double getX(){
        return x;
    }

    /**
     * This method sets the y value of the object
     * @param y y value as double
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * This method gets the y value of the object
     * @return y value as double
     */
    public double getY(){
        return y;
    }

    /**
     * This method puts the data of the point out
     * @return data of point as String
     */
    @Override
    public String toString() {
        return "(" + x +", " + y + ")";
    }
}
