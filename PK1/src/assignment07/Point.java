package assignment07;

public class Point {

    private double x;
    private double y;

    public Point(double xCoordinate, double yCoordinate){
        this.x = xCoordinate;
        this.y = yCoordinate;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX(){
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY(){
        return y;
    }

    @Override
    public String toString() {
        return "(" + x +", " + y + ")";
    }
}
