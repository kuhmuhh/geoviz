package assignment03;

public class Solution01 {

    public static void main(String[] args) {

        int a =66;
        int b = 14;
        int c = 70;

        System.out.println(max(a,b,c));

    }

    /**
     * This method returns the maximum value of 3 given values
     *
     * @param value1 - Value 1
     * @param value2 - Value 2
     * @param value3 - Value 3
     * @return maximum
     */
    public static int max(int value1, int value2, int value3){

        int max;

        if(value1 >= value2 && value1 >= value3) {
            max = value1;
        }
        else if(value2 >= value1 && value2 >= value3) {
            max = value2;
        }
        else {
            max = value3;
        }

        return max;
    }

}
