package assignment09;

import java.util.Arrays;

/**
 * main class
 */
public class Solution09 {
    public static void main(String[] args) {

        /*
        MyString a = new MyString('A', 'l', 'p', 'h', 'a');
        MyString b = new MyString('B', 'e', 't', 'a');
        MyString c = new MyString('G', 'a', 'm', 'm', 'a');
        MyString d = new MyString('D', 'e', 'l', 't', 'a');
        MyString e = new MyString('E', 'p', 's', 'i', 'l', 'o', 'n');
        MyString f = new MyString('Z', 'e', 't', 'a');
        MyString g = new MyString('E', 't', 'a');

        MyString[] toSort = {b, a, d, e,f ,c , g};

        System.out.println("Unsorted Array: \n");
        for (MyString s: toSort){
            System.out.println(s.toString() + " Length is: " + s.getLength() + ", Number of Vowels is: " + s.countVowels() + ", Value is: " + s.sumDecimal());
        }

        Arrays.sort(toSort, new MyStringComparator());

        System.out.println("Sorted Array: \n");
        for (MyString s: toSort){
            System.out.println(s.toString() + " Length is: " + s.getLength() + ", Number of Vowels is: " + s.countVowels() + ", Value is: " + s.sumDecimal());
        }
        */


        Yen.setRate(0.0088);
        Pound.setRate(1.2605);
        MyList<Currency> money = new MyList<Currency>();
        money.add(new Dollar(1000));
        money.add(new Yen(1000));
        money.add(new Pound(1000));

        System.out.println("Based on your money you have to pay: " + calculateTaxes(money) + " US-Dollar in taxes");



    }

    /**
     * This method calculates the taxes in dollar value
     * @param money
     * @return taxes
     */
    public static double calculateTaxes(MyList<Currency> money){
        double end = money.size();
        double value = 0;
        int i = 0;

        while (i < end){
            Currency tmp = money.get(i);
            value  += tmp.dollarValue();
            i++;
        }
        return value * 0.09;
        }
    }


