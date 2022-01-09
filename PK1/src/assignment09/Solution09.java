package assignment09;

import java.util.Arrays;

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

        MyString[] toSort = {a, b, c, d, e, f, g};
        Arrays.sort(toSort, new MyStringComparator());
        System.out.println(toSort[0]);
        */

        Yen.setRate(0.0088);
        Pound.setRate(1.2605);
        MyList<Currency> money = new MyList<Currency>();
        money.add(new Dollar(1000));
        money.add(new Yen(1000));
        money.add(new Pound(1000));

        System.out.println("Based on your money you have to pay: " + calculateTaxes(money) + " US-Dollar in taxes");

    }

    public static double calculateTaxes(MyList<Currency> money){
        double tax;
        double total = 0;
        int size;
        double tmp;

        size = money.getSize();

        for (int i = 0; i <= size; i++){
            tmp = money.get(i);
            total = total * tmp;
        }

        tax = total * 0.09;

        return tax;
    }

}
