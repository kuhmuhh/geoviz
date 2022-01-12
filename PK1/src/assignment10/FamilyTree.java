package assignment10;

public class FamilyTree<E> {

    private Tree<E> root;

    public FamilyTree(Tree<E> root){
        this.root = root;
    }

    public boolean containsName(String name) {
        if (root == null){
            return false;
        }
        else if (name.compareTo((String) root.getContent())==0){
            return true;
        }
        else{
            Tree<E>[] children = root.getChildren();
            for (int i = 0; i<children.length; i++){
                name.compareTo((String) children[i].getContent()==0);
            }
        }
    }



}
