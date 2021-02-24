import java.util.Comparator;
import java.util.Optional;

public class MyList<T> implements AdvancedList<T>, AuthorHolder {

    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public MyList() {
        head = null;
        tail = null;
    }

    @Override
    public AdvancedList<T> shuffle() {
        return null;
    }

    @Override
    public AdvancedList<T> sort(Comparator<T> comparator) {
        return null;
    }

    //done
    @Override
    public String author() {
        return "Gorolevich Ivan";
    }

    //done
    @Override
    public void add(T item) {
        Node temp = new Node (item);
        if (isEmpty())
            head = temp;
        else
            tail.next = temp;

        temp.prev = tail;
        tail = temp;
    }

    //done
    @Override
    public void insert(int index, T item) throws Exception {
        Node cur = head;
        int c = 0;

        while (cur != null && c != index) {
            cur = cur.next;
            c++;
        }

        Node temp = new Node(item);
        cur.prev.next = temp;
        temp.prev = cur.prev;
        cur.prev = temp;
        temp.next = cur;
    }

    //additional method for removing first item
    public void removeFirst() {
        if (head.next == null)
            tail = null;
        else
            head.next.prev = null;

        head = head.next;
    }

    //additional method for removing last item
    public void removeLast() {
        if (head.next == null)
            head = null;
        else
            tail.prev.next = null;

        tail = tail.prev;
    }

    //done
    @Override
    public void remove(int index) throws Exception {
        Node cur = head;
        int c = 0;

        while (cur != null && c != index) {
            cur = cur.next;
            c++;
        }

        if (cur == head)
            removeFirst();
        else
            cur.prev.next = cur.next;

        if (cur == tail)
            removeLast();
        else
            cur.next.prev = cur.prev;

    }

    //something wrong with type
    @Override
    public Optional<T> get(int index) {
        Node cur = head;
        int c = 0;

        while (cur != null && c != index) {
            cur = cur.next;
            c++;
        }
        return (Optional<T>) cur.data;
    }

    //done
    @Override
    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    //something wrong with type
    @Override
    public void addAll(SimpleList<T> list) {
        for (T item : list) {
            add(item);
        }
    }

    //done
    @Override
    public int first(T item) {
        Node cur = tail;
        int count = 0;

        while (cur.data != item) {
            cur = cur.prev;
            count++;
        }

        return count;
    }

    //done
    @Override
    public int last(T item) {
        Node cur = head;
        int count = 0;

        while (cur.data != item) {
            cur = cur.next;
            count++;
        }

        count = size() - count + 1;
        return count;
    }

    //done
    @Override
    public boolean contains(T item) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == item)
                return true;
            temp = temp.next;
        }
        return false;
    }

    //done
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    //optional
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}