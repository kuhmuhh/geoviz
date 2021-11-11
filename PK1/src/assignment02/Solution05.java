package assignment02;

public class Solution05 {
    public static void main(String[] args) {

        double length = 35;
        double width = 20;
        double pi = 3.141592;

        double diameter = length / pi;

        double baseArea = pi * (length/pi)*(length/pi);

        double curvedSurfaceArea = length * width;

        double overallArea = 2 * baseArea + curvedSurfaceArea;

        double capacity = baseArea * width;

        //Test der Formeln durch einsetzen beliebiger Werte in die length und width variablen

        System.out.println("diameter: " + diameter);
        System.out.println("base Area: " + baseArea);
        System.out.println("curved surface area: " + curvedSurfaceArea);
        System.out.println("overall area: " + overallArea);
        System.out.println("capacity: " + capacity);

    }
}
