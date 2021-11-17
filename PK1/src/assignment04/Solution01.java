package assignment04;

public class Solution01 {

    public static void main(String[] args) {

        char[] anna = {'a','n','n','a'};
        System.out.println(testPalindrome(anna));
    }

    /**
     * This method checks whether a given char array is a palindrome
     * @param input input char array
     * @return true or false
     */
    public static boolean testPalindrome(char[] input){

        int start = 0;
        int end = input.length-1;

        while(end > start){
            if(input[start] != input[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;

    }

}
