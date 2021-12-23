package assignment09;

import java.util.Arrays;

public class Solution09 {
    public static void main(String[] args) {

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

    }

}
