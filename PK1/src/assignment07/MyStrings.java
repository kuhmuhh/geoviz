package assignment07;

public class MyStrings {

    /**
     * This method checks whether two MyString instances are equal
     * @param a MyString instance
     * @param b MyString instance
     * @return true or false
     */
    public static boolean isEqual(MyString a, MyString b){

        char[] aArray = a.copyArray();
        char[] bArray = b.copyArray();

        if (a.getLength() != b.getLength()){
           return false;
        }
        for (int i = 0; i < a.getLength(); i++){
            if (aArray[i] != bArray[i]){
                return false;
            }
        }
        return true;
    }

}
