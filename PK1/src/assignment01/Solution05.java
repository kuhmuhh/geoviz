package assignment01;

public class Solution05 {
    public static void main(String[] args) {

        int length;
        int width;
        double pi = 3.141592;

        double baseArea = pi * (length/pi)^2;

        double curvedSurfaceArea = length * width;

        double overallArea = 2 * baseArea + curvedSurfaceArea;

        double capacity = baseArea * width;

    }
}
