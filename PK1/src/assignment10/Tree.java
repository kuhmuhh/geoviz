package assignment10;

import java.util.ArrayList;


/**
 * (2)
 * The binary tree data structure.
 * This data structures contains 3 constructors:
 * 1. empty tree
 * 2. leaf
 * 3. binary tree with two children
 * Relations between parent and children are realized using relations between BinaryTrees.
 * All necessary features like getting data, traversing the tree etc. has to be accessible
 * via our BinaryTree.java class.
 *
 *
 */
public class Tree
{

    private Person content;
    private Tree parent;
    private Tree[] children;

    /**
     * Creates an empty tree
     */
    public Tree()
    {
        this.content = null;
    }

    /**
     * Creates a tree with some content. This would be a leaf node in our
     * final binary tree. The characteristic of a leaf node is that it does not
     * have any children.
     *
     * @param content
     */
    public Tree(Person content)
    {
        this.content = content;
    }

    /**
     * Creates a tree, with some content, and an Array for the children from the content.
     * @param content
     * @param children
     */
    public Tree(Person content, Tree ... children)
    {
        this.content = content;
        this.children = children;
        for(int i=0; i<children.length; i++)
        {
            children[i].setParent(this);
        }


    }

    /**
     * Method to get the content, which is stored in the root of this binary tree.
     * @return return the content of this binary tree
     */
    public Person getContent()
    {
        return this.content;
    }

    /**
     * this method is getter for children
     * @return
     */
    public Tree[] getChildren()
    {
        return children;
    }

    /**
     * this method is a getter for parent
     * @return
     */
    public Tree getParent()
    {
        return parent;
    }

    /**
     * this method is a setter for parent
     * @param parent
     */
    public void setParent(Tree parent)
    {
        this.parent = parent;
    }

    /**
     * this method is a getter for children
     * @param children
     */
    public void setChildren(Tree[] children)
    {
        this.children = children;
    }

    /**
     * Checks whether this tree is empty.
     *
     * @return true, if tree is empty, false, otherwise
     */
    public boolean isEmpty()
    {
        return this.content == null;
    }


}