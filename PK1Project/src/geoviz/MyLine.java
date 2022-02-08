package geoviz;

import javafx.scene.shape.Line;

public class MyLine extends Line {

    private double slope;
    private double intercept;
    private MyPoint point1;
    private MyPoint point2;

    public MyLine(MyPoint point1, MyPoint point2) {
        slope = Utilities.getSlope(point1.getX(), point1.getY(), point2.getX(), point2.getY());
        intercept = Utilities.getIntercept(point1.getX(), point1.getY(), point2.getX(), point2.getY());
    }

    public double getSlope() {
        return slope;
    }

    public double getIntercept() {
        return intercept;
    }
}
