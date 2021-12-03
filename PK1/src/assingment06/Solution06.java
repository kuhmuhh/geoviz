package assingment06;

public class Solution06 {

    public static void main(String[] args) {

        /*
        MyString name = new MyString('S', 'a','t','o','r','?');
        //MyString name = new MyString('A','n','n','a');
        name.printArray();
        name.toLowerCase();
        name.printArray();
        name.toUpperCase();
        name.printArray();
        System.out.println(name.getCharAt(0));
        System.out.println(name.isPalindrome());
        System.out.println(name.printContent());
        name.addCharacters('y','o','y','o');
        System.out.println(name.printContent());
        System.out.println(name.countVowels());
        System.out.println(name.countConsonants());
        System.out.println(name.getLength());
        System.out.println(name.containsChar('i'));
        name.reverse();
        System.out.println(name.printContent());
         */

        MyString name = new MyString('S','a','t','o','r',' ');
        name.addCharacters('a','r','e','p','o',' ','t','e','n','e','t',' ','o','p','e','r','a',' ','r','o','t','a','s');
        System.out.println(name.countConsonants());
        System.out.println(name.countVowels());
        System.out.println(name.getLength());
        System.out.println(name.isPalindrome());
        name.toLowerCase();
        System.out.println(name.printContent());
        name.reverse();
        name.toUpperCase();
        System.out.println(name.printContent());
        System.out.println(name.getCharAt(10));
        System.out.println(name.containsChar(' '));
        name.removeAllConsonants();
        name.removeAllVowels();
        System.out.println(name.countConsonants());
        System.out.println(name.countVowels());
    }

}
