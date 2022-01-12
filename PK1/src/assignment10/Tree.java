package assignment10;

/**
 * (*2*)
 * The binary tree data structure.
 * This data structures contains 3 constructors:
 * 1. empty tree
 * 2. leaf
 * 3. binary tree with two children
 * Relations between parent and children are realized using relations between BinaryTrees.
 * All necessary features like getting data, traversing the tree etc. has to be accessible
 * via our BinaryTree.java class.
 *
 * As you can see, our binary tree has just 3 properties (fields). This is the
 * content being generic, and the relationships to the left and right children. It is a
 * unidirectional relationship. The root knows its children but not the other way round.
 *
 * @author Fuchs
 *
 */
public class Tree<E>
{
    //The current tree knows its left and right child
    private Tree<E>[] children;

    //Each binary tree has some content except for an empty tree.
    private E content;
    private E parent;

    /**
     * Creates an empty tree
     */
    public Tree()
    {
        /*
         * content is set to null because this binary tree is just empty.
         * Empty trees are necessary because we do not expect our final binary
         * tree to be balanced. Therefore, it could happen that a binary tree
         * just has a left child but no right child. In such a case, the left
         * child would be another binary tree with content and potential children
         * the right child would be just an empty binary tree with the content
         * reference set to null.
         */
        this.content = null;
    }

    /**
     * Creates a tree with some content. This would be a leaf node in our
     * final binary tree. The characteristic of a leaf node is that it does not
     * have any children.
     *
     * @param content
     */
    public Tree(E content)
    {
        /*
         * Our leaf is just a node, which contains data but has no relations
         * to children. In fact, there are no children.
         */
        this.content = content;
    }


    public Tree(E content, Tree<E>... children){
        this.children = children;
        this.content = content;
        for (int i = 0; i < children.length; i++){
            children[i].setParent(content);
        }
    }

    /**
     * Method to get the content, which is stored in the root of this binary tree.
     *
     * @return return the content of this binary tree, which is a generic type.
     */
    public E getContent()
    {
        return this.content;
    }

    public Tree<E>[] getChildren() {
        return children;
    }

    public void setParent(E parent) {
        this.parent = parent;
    }

    /**
     * Checks whether this tree is empty.
     *
     * @return true, if tree is empty, false, otherwise
     */
    public boolean isEmpty()
    {
        /*
         * As you can see in the first constructor that if we initialize an
         * empty tree its content is set to null.
         */
        return this.content == null;
    }
    //->switch to DataStructure.java (*3*)
}

