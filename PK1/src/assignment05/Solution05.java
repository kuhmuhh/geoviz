package assignment05;

import java.util.Arrays;

public class Solution05 {

    public static void main(String[] args) {

        //Task 1
        System.out.println("Task 1: ");
        char[] array = {'a','n','n','a'};
        System.out.println(isPalindrome(array,0));

        //Task 2
        System.out.println("Task 2: ");
        collatzSequence(23);
        System.out.println();

        //Task 3
        System.out.println("Task 3: ");
        int[] numbers = {1,6,4,3,2};
        triangleSum(numbers);
    }

    /**
     * This method checks recursively if the given char array is a palindrome
     * @param array char array
     * @param index index
     * @return true or false
     */
    public static boolean isPalindrome(char[] array, int index){

        int end = array.length-1-index;

        if (array.length <= 1){
            return true;
        }
        if (index >= end){
            return true;
        }
        if (array[index] != array[end]){
            return false;
        }

        return isPalindrome(array,index+1);

    }

    /**
     * This method implements the Collatz conjecture recursively
     * @param n any positive integer number
     */
    public static void  collatzSequence(int n){
        System.out.print(n + " | ");
        if (n == 1){
            return;
        }
        if (n%2 == 0){
            n = n / 2;
            collatzSequence(n);
        }
        else if (n%2 == 1){
            n = 3 * n +1;
            collatzSequence(n);
        }
    }

    /**
     * This method recursively sums up two neighboring elements of an array until there is only one element left
     * @param numbers integer array
     */
    public static void triangleSum(int[] numbers){
        int i=0;
        if (numbers.length == 1){
            printArrayRecursive(numbers,0);
        }
        else{
            int [] help = new int[numbers.length -1];
            help = triangleSumHelper(numbers,i,help);
            triangleSum(help);
            System.out.println();
            printArrayRecursive(numbers,0);
        }
    }

    /**
     * This method helps the triangleSum method to sum up the array
     * @param numbers integer array
     * @param i       index
     * @param help    integer array for temporary storage
     * @return int array which has been summed up
     */
    public static int[] triangleSumHelper(int[] numbers, int i, int[] help){
        if (i == numbers.length-1){
            return numbers;
        }
        else {
            help[i] = numbers[i] + numbers[i+1];
            i++;
            triangleSumHelper(numbers,i,help);
            return help;
        }
    }

    /**
     * This method recursively prints out an integer array
     * @param array integer array
     * @param i     index
     */
    public static void printArrayRecursive(int[] array, int i){
        if (i == array.length){
            return;
        }
        else {
            System.out.print(array[i] + " ");
            i++;
            printArrayRecursive(array,i);
        }

    }

}
