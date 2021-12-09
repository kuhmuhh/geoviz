package assignment07;

public class Node {

    private Node next;
    private int content;

    public Node(int content){
        this.content = content;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getContent() {
        return content;
    }
}