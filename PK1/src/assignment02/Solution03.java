package assignment02;

public class Solution03 {

    public static void main(String[] args) {

        double number = 2.046234183;
        double firstStep;
        int secondStep;

        firstStep = number * 100;

        System.out.println(firstStep);

        secondStep = (int)firstStep;

        number = secondStep;
        number = number / 100;

        System.out.println(secondStep);
        System.out.println(number);

    }

}
