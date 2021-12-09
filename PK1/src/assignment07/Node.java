package assignment07;

public class Node {

    private Node next;
    private int content;

    /**
     * Constructor
     * @param content content
     */
    public Node(int content){
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
    public int getContent() {
        return content;
    }
}