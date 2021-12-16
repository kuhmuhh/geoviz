package geoviz;

public class MyCircle {

    private double radius;

    public MyCircle(MyPoint point1, MyPoint point2){
        this.radius = Utilities.getDistance(point1,point2);
    }

}
