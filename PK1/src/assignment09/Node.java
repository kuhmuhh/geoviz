package assignment09;

/**
 * This class implements a generic node
 * @param <E>
 */
public class Node<E>
{
    private Node<E> next;
    private E content;

    /**
     * Constructor
     * @param content content to be added
     */
    public Node(E content)
    {
        this.content = content;
    }

    /**
     * This method sets the next node
     *
     * @param next the next node
     */
    public void setNext(Node<E> next)
    {
        this.next = next;
    }

    /**
     * This method returns the next node
     *
     * @return the next node
     */
    public Node<E> getNext()
    {
        return this.next;
    }

    /**
     * This method gets the content of a node
     *
     * @return the content stored in this node.
     */
    public E getContent()
    {
        return this.content;
    }
}
