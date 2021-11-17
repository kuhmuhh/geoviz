package assignment04;

public class Solution04 {

    public static void main(String[] args) {

        int[] oldArray = {15,45,37,41,18,48,20,33,25,33,16};
        int[] newArray = deleteElement(oldArray, 37);

        System.out.println("new Array: ");
        for (int i=0;i<newArray.length;i++){
            System.out.print(newArray[i] + " ");
        }

    }

    /**
     * This method deletes a given element if its in the array
     * @param a         int array
     * @param element   element which should be deleted
     * @return new array without the given element
     */
    public static int[] deleteElement(int[] a, int element){

        int pos = 0;
        boolean containsElement = false;

        for (int i=0;i<a.length;i++){
            if (a[i] == element) {
                pos = i;
                containsElement = true;
            }

        }


        if (containsElement == true) {
            int[] newArray = new int[a.length-1];
            for (int i=0;i<pos;i++){
                newArray[i] = a[i];
            }
            for (int i=pos+1;i<a.length;i++){
                newArray[i-1] = a[i];
            }
            return newArray;
        }
        else{
            return a;
        }


    }


}
