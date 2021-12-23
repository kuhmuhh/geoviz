package assignment09;

public class MyString {

    private char[] string;

    public MyString(char... values){
        this.string = copyArray(values);
    }

    /**
     * This method copies a char array
     * @param content char array to be copied
     * @return copied char array
     */
    private char[] copyArray(char[] content){
        char[] copy = new char[content.length];
        for (int i = 0; i < content.length; i++){
            copy[i] = content[i];
        }
        return copy;
    }

    /**
     * This method checks whether a char is a vowel
     * @param a char to be checked
     * @return true or false
     */
    private boolean isVowel(char a){
        if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U'){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method checks whether a char is a consonant
     * @param a char to be checked
     * @return true or false
     */
    private boolean isConsonant(char a) {
        if (a != 'a' && a != 'e' && a != 'i' && a != 'o' && a != 'u' && a != 'A' && a != 'E' && a != 'I' && a != 'O' && a != 'U' && (a >= 65 && a <= 90 || a >= 97 && a <= 122)) {
            return true;
        }
        return false;
    }

    /**
     * This method changes upper case letters to lower case letters in a char array
     * @param array char array to be changed to lower case letters
     * @return char array with only lower case letters
     */
    private char[] toLowerCaseHelper(char[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] >= 65 && array[i] <= 90){
                array[i] = (char) (array[i]+32);
            }
        }
        return array;
    }

    /**
     * This method changes upper case letters to lower case letters in the char array of the object
     */
    public void toLowerCase(){
        for (int i = 0; i < string.length; i++){
            if (string[i] >= 65 && string[i] <= 90){
                string[i] = (char) (string[i]+32);
            }
        }
    }

    /**
     * This method changes lower case letters to upper case letters in the char array of the object
     */
    public void toUpperCase(){
        for (int i = 0; i < string.length; i++){
            if (string[i] >= 97 && string[i] <= 122){
                string[i] = (char) (string[i]-32);
            }
        }
    }

    /**
     * This method adds an arbitrary amount of characters to the char array of the object
     * @param symbols character(s) to be added
     */
    public void addCharacters(char... symbols){
        int j = 0;
        char[] added = new char[string.length+symbols.length];
        for (int i = 0; i < string.length; i++){
            added[i] = string[i];
        }
        for (int i = string.length; i < string.length+symbols.length; i ++){
            added[i] = symbols[j];
            j++;
        }
        string = added;
    }

    /**
     * This method returns the character at a given index
     * @param i index
     * @return character at given index
     */
    public char getCharAt(int i){
        char a;
        if (i >= 0 &&  i <= string.length){
            a = string[i];
            return a;
        }
        else {
            return 0;
        }
    }

    /**
     * This method checks whether the char array of the object is a palindrome
     * @return true or false
     */
    public boolean isPalindrome(){
        char[] test = new char[string.length];
        test = copyArray(string);
        test = toLowerCaseHelper(test);
        int start = 0;
        int end = test.length-1;

        while(end > start){
            if(test[start] != test[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * This method removes all vowels of the char array of the object
     */
    public void removeAllVowels(){
        char[] noVowels = new char[string.length-countVowels()];
        int j = 0;
        for (int i = 0; i < string.length; i++){
            if (!isVowel(string[i])){
                noVowels[j] = string[i];
                j++;
            }
        }
        string = noVowels;
    }

    /**
     * This method counts the amount vowels of the char array of the object
     * @return amount of vowels
     */
    public int countVowels(){
        int vowelCount = 0;
        for (int i = 0; i < string.length; i++){
            if (isVowel(string[i])){
                vowelCount++;
            }
        }
        return vowelCount;
    }

    /**
     * This method removes all consonants of the char array of the object
     */
    public void removeAllConsonants(){
        char[] noConsonants = new char[string.length-countConsonants()];
        int j = 0;
        for (int i = 0; i < string.length; i++){
            if (!isConsonant(string[i])){
                noConsonants[j] = string[i];
                j++;
            }
        }
        string = noConsonants;
    }

    /**
     * This method counts the amount of consonants of the char array of the object
     * @return amount of consonants
     */
    public int countConsonants(){
        int consonantCount = 0;
        for (int i = 0; i < string.length; i++){
            if (isConsonant(string[i])){
                consonantCount++;
            }
        }
        return consonantCount;
    }

    /**
     * This method returns the length of the char array of the object
     * @return length of char array
     */
    public int getLength(){
        int length = string.length;
        return length;
    }

    /**
     * This method checks whether the char array of the object contains a given char
     * @param search char to be searched for
     * @return true or false
     */
    public boolean containsChar(char search){
        for (int i = 0; i < string.length; i++){
            if (search == string[i]){
                return true;
            }
        }
        return false;
    }

    /**
     * This method reverses the char array of the object
     */
    public void reverse(){
        for (int i = 0; i < string.length / 2; i++){
            char temp = string[i];
            string[i] = string[string.length - i - 1];
            string[string.length -i - 1] = temp;
        }
    }

    /**
     * This method prints the char array of the object
     * @return char array
     */
    public char[] printContent(){
        char[] help = copyArray(string);
        return help;
    }

    /**
     * This method returns a  MyString instance only containing characters
     * from the index 0 to the given final end index
     * @param end index of char array
     * @return MyString instance ranging from index 0 to given end index
     */
    public MyString subMyString(int end){
        MyString sub = new MyString();
        char[] help = new char[end+1];
        for (int i = 0; i <= end; i++){
            help[i] = string[i];
        }
        sub.addCharacters(help);
        return sub;
    }

    /**
     * This method returns a MyString instance only containing characters
     * from the given start index to the given end index
     * @param start index of start
     * @param end index of end
     * @return MyString instance ranging from start index to end index
     */
    public MyString subMyString(int start, int end){
        int j = 0;
        MyString sub = new MyString();
        char[] help = new char[end-start+1];
        for (int i = start ; i <= end; i++){
            help[j] = string[i];
            j++;
        }
        sub.addCharacters(help);
        return sub;
    }

    /**
     * This method returns a copy of the array of the object
     * @return char array
     */
    public char[] copyArray(){
        char[] copy = new char[string.length];
        for (int i = 0; i < string.length; i++){
            copy[i] = string[i];
        }
        return copy;
    }

    /**
     * This method returns the sum of decimal values of all character symbols
     * @return sum of decimal values
     */
    public int sumOfDecimal(){
        int sum = 0;
        for (int i = 0;i < string.length; i++){
            sum = sum + string[i];
        }
        return sum;
    }

    /*
    public void output(MyString[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
            System.out.println("length: " + array[i].getLength());
            System.out.println("number of vowels: " + array[i].countVowels());
            System.out.println("sum of characters: " + array[i].sumOfDecimal());
        }
    }*/

}