package assignment07;

public class MyList {

    private Node first;
    private Node current;
    private int size = 0;

    /**
     * Constructor
     */
    public MyList(){

    }

    /**
     * Constructor
     * @param value content of first Node
     */
    public MyList(int value){
        Node root = new Node(value);
        this.first = root;
        this.current = root;
        this.size++;
    }

    /**
     * This method adds a new node to the list
     * @param value content of the added node
     */
    public void add(int value)
    {
        Node newNode = new Node(value);
        this.size++;
        if (this.first == null)
        {
            this.first = newNode;
            this.current = newNode;
        }
        else
        {
            this.current.setNext(newNode);
            this.current = newNode;
        }
    }


    /**
     * This method gets the content of a node at the given index
     * @param i index of desired node
     * @return content of node
     */
    public int get(int i)
    {
        if(i >= 0 && i < this.size){
            Node tmp = first;
            if(i == 0){
                return tmp.getContent();
            }
            else{
                while(i > 0){
                    tmp = tmp.getNext();
                    i--;
                }
                return tmp.getContent();
            }
        }
        else {
            return -1;
        }
    }

    /**
     * This method removes a node containing a given value from the list
     * @param value value of node to be removed
     * @return true or false
     */
    public boolean remove(int value){
        Node tmp = first;
        Node tmp2 = first;


        for (int i = 0; i < size; i++){
            if (value == get(i)){
                if (tmp == first){
                    first = first.getNext();
                }
                else {
                    tmp2.setNext(tmp.getNext());
                }
                this.size--;
                return true;
            }
            else {
                tmp2 = tmp;
                tmp = tmp.getNext();
            }
        }
        return false;
    }

    /**
     * This method searches for the index of a node containing a given value
     * @param value value to be searched for
     * @return index of node containing given value
     */
    public int search(int value){
        for (int i = 0; i < size; i++){
            if (value == get(i)){
                return i;
            }
        }
        return 0;
    }

}
