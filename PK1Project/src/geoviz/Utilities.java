package geoviz;

public class Utilities {

    /*
    public static void main(String[] args) {

        double[][] points = {{1,1},{2,2},{1,2},{2,1}};

        System.out.println(round2(2.046234183));
        System.out.println(getIntercept(3,1,-1,5));
        System.out.println(isParallel(0.3,0.5));
        System.out.println(isOrthogonal(0.1,-10));
        printArray(getPointOfIntersection(points[0],points[1],points[2],points[3]));
    }
    */

    /**
     * This method detects if two double values are equal
     * @param a
     * @param b
     * @return true or false
     */
    public static boolean doubleComparison(double a, double b){

        double delta = 0.00000001;

        if (abs(a - b) < delta){
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * This method calculates the absolute value of a given number
     * @param value
     * @return absolute value
     */
    public static double abs(double value){

        if (value < 0){
            return value * -1;
        }
        else {
            return value;
        }

    }

    /**
     * This method cuts all numbers after the second decimal place
     * @param value
     * @return value with only 2 decimal places
     */
    public static double round2(double value){

    value = value * 100;
    value = (int) value;
    value = value / 100;
    return value;

    }

    /**
     * This method calculates the slope of two given points
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return slope
     */
    public static double getSlope(double x1, double y1, double x2, double y2){

        double slope;
        slope = (y2 -y1) / (x2 - x1);
        return slope;

    }

    /**
     * This method calculates the y-coordinate of the intercept
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return y-coordinate of the intercept
     */
    public static double getIntercept(double x1, double y1, double x2, double y2){

        double intercept;
        double m;
        m = getSlope(x1, y1, x2, y2);

        intercept = y1 - m * x1;

        return intercept;

    }

    /**
     * This method checks if two given slopes are parallel
     * @param slope1
     * @param slope2
     * @return boolean value which indicates
     *         if the slopes are parallel
     */
    public static boolean isParallel(double slope1, double slope2){

        boolean isParallel;

        isParallel = doubleComparison(slope1,slope2);

        return isParallel;

    }

    /**
     * This method checks whether two given lines are orthogonal
     * @param slope1
     * @param slope2
     * @return boolean value which indicates if the lines are orthogonal
     */
    public static boolean isOrthogonal(double slope1, double slope2){

        double delta1 = -1.0000000001;
        double delta2 = -0.9999999999;

        if ((slope1 * slope2) > delta1 && (slope1 * slope2) < delta2){
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * This method takes 4 MyPoints as input (each MyPoint is representing a data point)
     * it calculates the point of intersection by using the lines from point 1 to point 2 and point 3 to point 4
     * @param point1
     * @param point2
     * @param point3
     * @param point4
     * @return coordinates of point of intersection as a MyPoint
     */
    public static MyPoint getPointOfIntersection(MyPoint point1, MyPoint point2, MyPoint point3, MyPoint point4){

        MyLine line1 = new MyLine(point1,point2);
        MyLine line2 = new MyLine(point3,point4);

        double slopeLine1and2 = line1.getSlope();
        double slopeLine3and4 = line2.getSlope();
        double intercept12 = line1.getIntercept();
        double intercept34 = line2.getIntercept();
        double xCoord;
        double yCoord;


        if (doubleComparison(slopeLine1and2,slopeLine3and4)){
            return null;
        }
        else{
            xCoord = ((intercept34-intercept12)/(slopeLine1and2-slopeLine3and4));
            yCoord = slopeLine1and2 * xCoord + intercept12;
        }

        MyPoint intersect = new MyPoint(xCoord,yCoord);

        return intersect;
    }

    /**
     * This method takes 2 MyLine as an input (each MyLine is representing a line between two data points)
     * it calculates the point of intersection by using by using the lines
     * @param line1
     * @param line2
     * @return point of intersection
     */
    public static MyPoint getPointOfIntersection(MyLine line1, MyLine line2){

        double slopeLine1and2 = line1.getSlope();
        double slopeLine3and4 = line2.getSlope();
        double intercept12 = line1.getIntercept();
        double intercept34 = line2.getIntercept();
        double xCoord;
        double yCoord;


        if (doubleComparison(slopeLine1and2,slopeLine3and4)){
            return null;
        }
        else{
            xCoord = ((intercept34-intercept12)/(slopeLine1and2-slopeLine3and4));
            yCoord = slopeLine1and2 * xCoord + intercept12;
        }

        MyPoint intersect = new MyPoint(xCoord,yCoord);

        return intersect;
    }

    /**
     * This method prints out a double array
     * @param a
     */
    public static void printArray(double[] a){
        for (double element : a){
            System.out.println(element + " ");
        }
        System.out.println();
    }

    public static double getDistance(MyPoint point1, MyPoint point2){
        double distance;
        distance = Math.pow(((point1.getX()- point2.getX())*(point1.getX()- point2.getX())+(point1.getY()- point2.getY())*(point1.getY()- point2.getY()));
        return distance;
    }

}
