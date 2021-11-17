package assignment04;

import com.sun.javafx.css.PseudoClassState;

public class Solution02 {

    public static void main(String[] args) {

        int[] array = {15,45,37,41,18,48,20,33,25,33,16};

        int[] arraySorted = bubbleSort(array);

        System.out.println("Sorted Array:");
        for (int i=0;i<arraySorted.length;i++){
            System.out.print(arraySorted[i] + " ");
        }

    }

    /**
     * This method sorts an int array using the the bubbleSort algorithm
     * @param array integer array
     * @return sorted array
     */
    public static int[] bubbleSort(int[] array){

        int tmp;

        for (int i = 1; i < array.length; i++){
            for (int j = 0; j < array.length - i; j++){
                if (array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        return array;

    }

}
