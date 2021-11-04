package geoviz;

public class Utilities {

    public static void main(String[] args) {

        System.out.println("yo");
        System.out.println(round2(2.046234183));


    }

    /*
    public static boolean doubleComparison(double a, double b){



    }
    */

    public static double round2(double value){

        //double number = 2.046234183;
        double firstStep;
        int secondStep;

        firstStep = value * 100;

        //System.out.println(firstStep);

        secondStep = (int)firstStep;

        value = secondStep;
        value = value / 100;

        //System.out.println(secondStep);
        //System.out.println(value);
        return value;

    }

}
