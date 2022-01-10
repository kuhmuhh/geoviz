package assignment09;

import java.util.Comparator;

/**
 * This class implements the comparator  interface
 */
public class MyStringComparator implements Comparator<MyString> {

    /**
     * This method compares two objects of the type MyString
     * @param o1 MyString object
     * @param o2 MyString object
     * @return if o1<o2 -> -1
     *         if o1=o2 -> 0
     *         if 01>o2 -> 1
     */
    @Override
    public int compare(MyString o1, MyString o2) {

        if(o1.getLength()>o2.getLength())
        {
            return 1;
        }
        if(o1.getLength()<o2.getLength())
        {
            return -1;
        }
        else
        {
            if(o1.countVowels()>o2.countVowels())
            {
                return 1;
            }
            if(o1.countVowels()<o2.countVowels())
            {
                return -1;
            }
            else
            {
                if(o1.sumDecimal()>o2.sumDecimal())
                {
                    return 1;
                }
                if(o1.sumDecimal()<o2.sumDecimal())
                {
                    return -1;
                }
                return 0;		//in diesem Fall wären a und b gleich.
            }
        }

    }
}
