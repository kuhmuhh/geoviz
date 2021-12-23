package assignment09;

import java.util.Comparator;

public class MyStringComparator implements Comparator<MyString> {

    @Override
    public int compare(MyString o1, MyString o2) {
        if (o1.getLength() < o2.getLength()) {
            return -1;
        }
        else if (o1.getLength() == o2.getLength()) {
            if (o1.countVowels() < o2.countVowels()) {
                return 0;
            }
            else if (o1.sumOfDecimal() < o2.sumOfDecimal()){
                return 0;
            }
            return 0;
        }
        else {
            return 1;
        }
    }
}
