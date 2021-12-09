package assignment07;

public class Line {

    private Point point1;
    private Point point2;

    public Line(Point point1, Point point2){
        this.point1 = point1;
        this.point2 = point2;
    }


    public double getLength(){
        double length;
        length = Math.sqrt((point2.getX()-point1.getX())*(point2.getX()-point1.getX())+(point2.getY()-point1.getY())*(point2.getY()-point1.getY()));
        return length;
    }

    @Override
    public String toString() {
        return point1 + "->" + point2;
    }
}