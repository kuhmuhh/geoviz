package assignment09;


/**
 * This class implements a generic list
 * @param <E>
 */
public class MyList<E>

{
    private Node<E> first;
    private Node<E> current;
    private int size = 0;

    /**
     * This methods adds a new element to the list
     * @param content content to be added
     */
    public void add(E content)
    {
        this.size++;
        Node<E> newNode = new Node<E>(content);

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
     * This method returns the content of a given index
     * @param i index
     * @return element at given index
     */
    public E get(int i)
    {
        if(i >= 0 && i < this.size)
        {
            Node<E> tmp = first;
            if(i == 0)
            {
                return tmp.getContent();
            }
            else
            {
                while(i > 0)
                {
                    tmp = tmp.getNext();
                    i--;
                }
                return tmp.getContent();
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * This method returns the amount of elements in the list
     * @return amount of elements in int
     */
    public int size()
    {
        return this.size;
    }
}