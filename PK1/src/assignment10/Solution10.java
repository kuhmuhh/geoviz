package assignment10;

public class Solution10 {

    public static void main(String[] args) {

        Tree a = new Tree(new Person("a"));
        Tree b = new Tree(new Person("b"));
        Tree c = new Tree(new Person("c"));
        Tree abc = new Tree(new Person("abc"),a,b,c);
    }

}
