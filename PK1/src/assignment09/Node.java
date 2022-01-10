package assignment09;

/**
 * This class implements a generic node
 * @param <T>
 */
public class Node<T> {

    private Node next;
    private T content;

    /**
     * Constructor
     * @param content content
     */
    public Node(T content){
        this.content = content;
    }

    /**
     * This method sets the next node
     * @param next next node
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * This method gets the next node
     * @return next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * This method gets the content of a node
     * @return content
     */
    public T getContent() {
        return content;
    }
}