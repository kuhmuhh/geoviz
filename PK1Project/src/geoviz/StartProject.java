package geoviz;

public class StartProject {

    public static void main(String[] args) {

        MyPoint[] points = { new MyPoint(1, 1), new MyPoint(2, 2),
                new MyPoint(2, 1), new MyPoint(1, 2) };
        MyLine line1 = new MyLine(points[0], points[1]);
        MyLine line2 = new MyLine(points[2], points[3]);
        MyPoint intersection1 = Utilities.getPointOfIntersection(points[0], points[1], points[2], points[3]);
        MyPoint intersection2 = Utilities.getPointOfIntersection(line1, line2);
        System.out.println("Intersection: " + intersection1.getX() + " " + intersection1.getY());
        System.out.println("Intersection: " + intersection2.getX() + " " + intersection2.getY());
        System.out.println("Slope of line1: " + line1.getSlope() + " intercept: " + line1.getIntercept());
        System.out.println("Slope of line2: " + line2.getSlope() + " intercept: " + line2.getIntercept());

    }

}
