package assignment03;

public class Solution02 {

    public static void main(String[] args) {

        System.out.println(bmi(70, 1.7));

    }

    /**
     * This method calculates a BMI and returns the category
     * @param kg
     * @param height
     * @return category of BMI as a String
     */
    public static String bmi(double kg, double height){

        double bmi;

        String status = "";

        bmi = kg / (height * height);

        System.out.println("your BMI is: " + bmi);

        if(bmi <= 18.5) {
            status = "underweight";
        }
        else if(18.5 < bmi && bmi <= 25) {
            status = "normal";
        }
        else if(25 < bmi && bmi <= 30) {
            status = "overweight";
        }
        else if(bmi > 30) {
            status = "overweight";
        }

        return status;

    }


}
