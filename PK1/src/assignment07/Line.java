package assignment07;

public class Line {

    private Point point1;
    private Point point2;

    /**
     * Constructor
     * @param point1 Point 1
     * @param point2 Point 2
     */
    public Line(Point point1, Point point2){
        this.point1 = point1;
        this.point2 = point2;
    }

    /**
     * This method calculates the length of the connecting line of 2 Points
     * @return length between the 2 points
     */
    public double getLength(){
        double length;
        length = Math.sqrt((point2.getX()-point1.getX())*(point2.getX()-point1.getX())+(point2.getY()-point1.getY())*(point2.getY()-point1.getY()));
        return length;
    }

    /**
     * This method puts the two points out
     * @return two points as String
     */
    @Override
    public String toString() {
        return point1 + "->" + point2;
    }
}