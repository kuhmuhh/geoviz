package assignment02;

public class Solution01 {

    public static void main(String[] args) {

        int a =66;
        int b = 14;
        int c = 70;

        max(a,b,c);

    }

    public static int max(int value1, int value2, int value3){

        if(value1 >= value2 && value1 >= value3)
            System.out.println("the biggest number is: " + value1);
        else if(value2 >= value1 && value2 >= value3)
            System.out.println("the biggest number is: " + value2);
        else
            System.out.println("the biggest number is: " +value3);

        return 0;
    }

}
