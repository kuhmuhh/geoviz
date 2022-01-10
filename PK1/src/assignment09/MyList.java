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
     * (*12*)
     * We also have to modify the add method because here the parameter needs
     * to be more flexible. We cannot just store Strings but any kind of type.
     * Therefore, we have to replace:
     * 					String content
     * with
     * 					E content
     *
     * @param content - any object can be stored in our data structure
     */
    public void add(E content)
    {
        this.size++;
        /*
         * Again, we have to specify what kind of type the Node expects. It is
         * the same type as the MyList data structure.
         */
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
     * What kind of type do we get from our data structure? Previously, it was
     * just Strings. But now, since we are more flexible it is a type variable.
     *
     * @param i - the position in the data structure we are looking at
     * @return - the object stored in the data structure
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