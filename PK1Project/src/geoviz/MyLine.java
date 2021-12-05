package geoviz;

public class MyLine {

    private double slope;
    private double intercept;

    public MyLine(MyPoint point1, MyPoint point2){
        slope = Utilities.getSlope(point1.getX(),point1.getY(),point2.getX(),point2.getY());
        intercept = Utilities.getIntercept(point1.getX(),point1.getY(),point2.getX(),point2.getY());
    }

    public double getSlope(){
        return slope;
    }

    public double getIntercept(){
        return intercept;
    }
}
