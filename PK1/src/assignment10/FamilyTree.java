package assignment10;

/**
 * This method implements a Family tree.
 */
public class FamilyTree
{
    private Tree root;

    /**
     * Constructor for an empty Tree
     */
    public FamilyTree()
    {
        this.root = null;


    }

    /**
     * Constructor for a Tree without children
     * @param root
     */
    public FamilyTree(Tree root)
    {
        this.root=root;
    }


    /**
     * check, whether there is a person stored in the family tree with the corresponding name
     * @param name
     * @return true or false
     */
    public boolean containsName(String name)
    {
        boolean value=false;
        if(root == null)
        {
            return false;
        }

        if(name.compareTo(root.getContent().getName())==0)
        {
            return true;
        }

        else
        {
            if(root.getChildren() != null)
            {
                Tree[] children = root.getChildren();
                for(int i=0; i<children.length; i++)
                {
                    if(name.compareTo(children[i].getContent().getName())==0)
                    {
                        return true;
                    }
                    value = helpContainsName(name, children[i].getChildren());
                    if (value==true)
                    {
                        return value;
                    }
                }

            }

            return value;
        }
    }

    /**
     * Helper method for containsName
     * @param name
     * @param children as Tree[]
     * @return true or false
     */
    private boolean helpContainsName(String name, Tree[] children)
    {
        boolean value = false;
        if(children != null)
        {
            for(int i=0; i<children.length; i++)
            {
                if(name.compareTo(children[i].getContent().getName())==0)
                {
                    return true;
                }
                value=helpContainsName(name, children[i].getChildren());
                if (value==true)
                {
                    return value;
                }
            }
        }
        return value;
    }

    /**
     * print the names of all people stored in the family tree to the console
     */
    public void printAllEntries()
    {
        if(root!=null)
        {
            System.out.println("All Entries");
            System.out.println(root.getContent().getName());
        }
        if(root.getChildren()!=null)
        {
            Tree[] children = root.getChildren();
            for(int i=0; i<children.length; i++)
            {
                printAllEntries(children[i]);
            }
        }

    }

    /**
     * helper method for printAllEntries
     * @param child
     */
    public void printAllEntries(Tree child)
    {
        if(child!=null)
        {
            System.out.print(child.getContent().getName() + " ");
        }
        if(child.getChildren()!=null)
        {
            Tree[] children = child.getChildren();
            for(int i=0; i<children.length; i++)
            {
                printAllEntries(children[i]);
            }
        }

    }

    /**
     * this method prints all children of a given name
     * @param name
     */
    public void printChildren(String name)
    {
        if(root.getChildren() == null)
        {
            System.out.println(name + " has no children");
            return;

        }
        if(root.getContent().getName().compareTo(name)==0)
        {
            Tree[] children = root.getChildren();
            System.out.println("children from " + name);
            for(int i=0; i<children.length; i++)
            {
                System.out.print(children[i].getContent().getName() + " ");
            }
            System.out.println();
        }
        if(containsName(name)== false)
        {
            System.out.println(name + " is not in family tree");
            return;
        }
        else
        {
            Tree[] children = root.getChildren();
            helpPrintChildren(name, children);
        }

    }

    /**
     * helper Method for the method printChildren
     * @param name
     * @param children
     */
    private void helpPrintChildren(String name, Tree[] children)
    {

        if(children != null)
        {
            for(int i=0; i<children.length; i++)
            {
                if(name.compareTo(children[i].getContent().getName())==0)
                {
                    if(children[i].getChildren()!=null)
                    {
                        Tree[] children2 = children[i].getChildren();
                        System.out.println("children of " + name);
                        for(int a=0; a<children2.length; a++)
                        {
                            System.out.print(children2[a].getContent().getName() + " ");
                        }
                        System.out.println();
                        return;
                    }
                    else
                    {
                        System.out.println(name + " has no children");
                    }
                }
                helpPrintChildren(name, children[i].getChildren());
            }
        }
        return;
    }

    /**
     * given the name of a person, print his/her descendants to the console
     * @param name
     */
    public void printAllDescendants(String name)
    {
        if(root.getChildren() == null)
        {
            System.out.println(name + " has no children");
            return;

        }
        if(containsName(name)== false)
        {
            System.out.println(name + " is not in family tree");
            return;
        }
        if(root.getContent().getName()==name)
        {
            System.out.println("Descendants of " + name);
            helpPrintAllDescendants(name, root);
            System.out.println();
        }
        else
        {
            Tree[] children = root.getChildren();
            helpFindNameForDescendants(name, children);
        }
    }


    /**
     * helper Method for printAllDescendants
     * @param name
     * @param children
     */
    private void helpFindNameForDescendants(String name, Tree[] children)
    {
        if(children != null)
        {
            for(int i=0; i<children.length; i++)
            {
                if(name.compareTo(children[i].getContent().getName())==0)
                {
                    if(children[i].getChildren()!=null)
                    {
                        System.out.println("Descendants of " + name);
                        helpPrintAllDescendants(name, children[i]);
                        System.out.println();
                    }
                    else
                    {
                        System.out.println(name + " has no children");
                    }
                }
                helpFindNameForDescendants(name, children[i].getChildren());
            }
        }
        return;

    }

    /**
     * This method prints out all entries for the Method printAllDescendants
     * @param name
     * @param root
     */
    private void helpPrintAllDescendants(String name, Tree root)
    {
        if(root.getChildren() != null)
        {
            Tree[] children = root.getChildren();
            for(int i=0; i<children.length; i++)
            {
                printAllEntries(children[i]);
            }
        }
        return;
    }

    /**
     * given the name of a person, print his/her ancestors to the console
     * @param name
     */
    public void printAncestors(String name)
    {
        if(root==null)
        {
            System.out.println("There is no family tree.");
            return;
        }
        if(name.compareTo(root.getContent().getName())==0)
        {
            if(root.getParent()==null)
            {
                System.out.println("Ancestors unkown");
                return;
            }
            else
            {
                System.out.println("Ancestors of " + name);
                helpPrintAncestors(name, root);
                System.out.println();
            }
        }
        else
        {
            helpFindAncestors(name, root.getChildren());
        }
        return;
    }

    /**
     * This method is a helper Method for print Ancestors, it is to find name
     * @param name
     * @param children
     */
    private void helpFindAncestors(String name, Tree[] children)
    {
        if(children != null)
        {
            for(int i=0; i<children.length; i++)
            {
                if(name.compareTo(children[i].getContent().getName())==0)
                {
                    System.out.println("Ancestors of " + name);
                    helpPrintAncestors(name, children[i]);
                    System.out.println();
                }
                helpFindAncestors(name, children[i].getChildren());
            }
        }
        return;

    }

    /**
     * This method is a helper Method for print Ancestors
     * @param name
     * @param child
     */
    private void helpPrintAncestors(String name, Tree child)
    {
        if(child.getParent() !=null)
        {
            System.out.print(child.getParent().getContent().getName() + " ");
            helpPrintAncestors(name, child.getParent());			//wird nur eine Generation ausgeprintet - rekursive Aufruf tut nicht

        }
        return;
    }

    /**
     * given the name of a person, print his/her siblings to the console
     * @param name
     */
    public void printSiblings(String name)
    {
        if(root==null)
        {
            System.out.println("There is no family tree.");
            return;
        }
        if(containsName(name)== false)
        {
            System.out.println(name + " is not in family tree");
            return;
        }
        if(name.compareTo(root.getContent().getName())==0)
        {
            if(root.getParent()==null)
            {
                System.out.println("Parents and Siblings are not known of " + name);
                return;
            }
            else
            {
                helpPrintSiblings(name, root);
                return;

            }
        }
        else
        {
            findNameSiblings(name, root.getChildren());
        }

        return;
    }

    /**
     * this is a helper method for the method printSiblings, to find the place of name
     * @param name
     * @param children
     */
    private void findNameSiblings (String name, Tree[] children)
    {
        if(children != null)
        {
            for(int i=0; i<children.length; i++)
            {
                if(name.compareTo(children[i].getContent().getName())==0)
                {
                    helpPrintSiblings(name, children[i]);
                }
                findNameSiblings(name, children[i].getChildren());
            }
        }
        return;
    }

    /**
     * this is a helper method for the method printSiblings
     * @param name
     * @param treeName
     */
    private void helpPrintSiblings (String name, Tree treeName)
    {
        if(treeName.getParent()!=null)
        {
            Tree parent = treeName.getParent();
            Tree[] siblings = parent.getChildren(); // !!! name ist noch enthalten
            System.out.println("Siblings of " + name);
            // Index from name
            int a=0;
            for(int i=0; i<siblings.length; i++)
            {
                if(name.compareTo(siblings[i].getContent().getName())==0)
                {
                    a=i;
                }
            }

            for(int i=0; i<a; i++)
            {
                System.out.print(siblings[i].getContent().getName() + " ");
            }
            for(int i=a+1; i<siblings.length; i++)
            {
                System.out.print(siblings[i].getContent().getName() + " ");
            }
            System.out.println();
        }
        else
        {
            System.out.println("Parents and Siblings are not known");
            return;
        }
    }

}