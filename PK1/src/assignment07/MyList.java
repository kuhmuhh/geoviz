package assignment07;

public class MyList {

    private Node first;
    private Node current;
    private int size = 0;

    public MyList(){

    }

    public MyList(int value){
        Node root = new Node(value);
        this.first = root;
        this.current = root;
        this.size++;
    }

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

    public int search(int value){
        for (int i = 0; i < size; i++){
            if (value == get(i)){
                return i;
            }
        }
        return 0;
    }

}
