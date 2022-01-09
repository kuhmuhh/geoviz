package assignment09;

public class MyList<T>{

    private static final Object T = -1;
    private Node first;
    private Node current;
    private int size = 0;

    /*
     * Constructor
     */
    public MyList(){

    }

    /**
     * This method returns the size of the list
     * @return size of list
     */
    public int getSize() {
        return size;
    }

    /**
     * Constructor
     * @param value content of first Node
     */
    public MyList(T value){
        Node root = new Node(value);
        this.first = root;
        this.current = root;
        this.size++;
    }

    /**
     * This method adds a new node to the list
     * @param value content of the added node
     */
    public void add(T value)
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
    public <T> T get(int i)
    {
        if(i >= 0 && i < this.size){
            Node tmp = first;
            if(i == 0){
                return (T) tmp.getContent();
            }
            else{
                while(i > 0){
                    tmp = tmp.getNext();
                    i--;
                }
                return (T) tmp.getContent();
            }
        }
        else {
            return (T) T;
        }


    }

    /**
     * This method removes a node containing a given value from the list
     * @param value value of node to be removed
     * @return true or false
     */
    public boolean remove(T value){
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
    public int search(T value){
        for (int i = 0; i < size; i++){
            if (value == get(i)){
                return i;
            }
        }
        return 0;
    }



}
