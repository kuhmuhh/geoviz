package assignment10;

public class Solution10 {

    public static void main(String[] args) {

        Tree a = new Tree(new Person("a"));
        Tree b = new Tree(new Person("b"));
        Tree c = new Tree(new Person("c"));
        Tree abc = new Tree(new Person("abc"), a, b, c);
        Tree d = new Tree(new Person("d"));
        Tree e = new Tree(new Person("e"));
        Tree de = new Tree(new Person("de"), d, e);
        Tree abcde = new Tree(new Person("abcde"), abc, de);
        Tree f = new Tree(new Person("f"));
        Tree g = new Tree(new Person("g"));
        Tree root = new Tree(new Person("abcdefg"), abcde, f, g);

        FamilyTree tree = new FamilyTree(root);
        //tree.printChildren("a");
        tree.printChildren("abcde");
        tree.printSiblings("d");
        tree.printAllDescendants("abcde");
        tree.printAncestors("de");
    }

}
