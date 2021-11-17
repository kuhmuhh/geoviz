package assignment04;

public class Solution03 {

    public static void main(String[] args) {

        int[] array = {15,45,37,41,18,48,20,33,25,33,16};

        System.out.println("Median: " + getMedian(array));

    }

    /**
     * This method returns the median value of a given int array
     * @param array int array
     * @return median value as double
     */
    public static double getMedian(int[] array){

        int length = array.length;
        int middle = (length - 1) / 2;
        double median;

        if (length == 0){
           median = 0;
           return median;
        }
        else if (length % 2 ==  0){
            median = (array[middle] + array[middle+1]) / 2;
            return median;
        }
        else{
            median = array[middle];
            return median;
        }

    }

}
