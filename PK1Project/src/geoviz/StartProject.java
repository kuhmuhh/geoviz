package geoviz;

public class StartProject {

    public static void main(String[] args) {

        /*
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
         */

        MyPoint[] points = { new MyPoint(1, 1), new MyPoint(2, 2), new MyPoint(1, 1), new MyPoint(1, 2) };
        MyLine line1 = new MyLine(points[0], points[1]);
        MyCircle circle = new MyCircle(points[2], points[3]);
        MyCircle circle2 = new MyCircle(points[3], points[1]);
        //MyPoint[] points = { new MyPoint(-0.27, 0.741), new MyPoint(-1.102, -1.47), new MyPoint(2.0, 0.0), new MyPoint(0.5, 0.0)};
        //MyCircle circle = new MyCircle(points[0], points[1]);
        //MyCircle circle2 = new MyCircle(points[2], points[3]);
        //MyLine line1 = new MyLine(points[2], points[3]);
        System.out.println("Intersection point1: " + Utilities.getPointOfIntersection(line1, circle).get(0).getX() + " " + Utilities.getPointOfIntersection(line1, circle).get(0).getY());
        System.out.println("Intersection point2: " + Utilities.getPointOfIntersection(line1, circle).get(1).getX() + " " + Utilities.getPointOfIntersection(line1, circle).get(1).getY());
        System.out.println("Intersection point3: " + Utilities.getPointOfIntersection(circle2, circle).get(0).getX() + " " + Utilities.getPointOfIntersection(circle2, circle).get(0).getY());
        System.out.println("Intersection point4: " + Utilities.getPointOfIntersection(circle2, circle).get(1).getX() + " " + Utilities.getPointOfIntersection(circle2, circle).get(1).getY());
    }

}
