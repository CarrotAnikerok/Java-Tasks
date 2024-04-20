import java.lang.reflect.Array;

public class LinkedMyList<T> extends MyList<T> {
    public Node<T> head;
    public Node<T> tail;

    @Override
    void add(T a) {
        Node element = new Node();
        element.value = a;
        if (head == null) {
            head = element;
        } else {
            tail.next = element;
        }
        tail = element;
        amountOfList += 1;
    }

    @Override
    void addFirst(T a) {
        Node element = new Node();
        element.value = a;
        if (head == null) {
            head = element;
            tail = element;
        } else {
            element.next = head;
            head = element;
        }
        amountOfList += 1;
    }

    @Override
    void insert(T a, int i) {
        if (i > this.size()) {
            System.out.println("Размер связного списка меньше, чем заданный индекс.");
            return;
        }
        if (i == 0) {
            this.addFirst(a);
            return;
        }
        if (i == this.size()) {
            this.add(a);
            return;
        }
        Node<T> element = new Node<>();
        element.value = a;
        Node start = head;
        for (int j = 1; j < i; j++) {
            start = start.next;
        }
        Node end = start.next;
        start.next = element;
        element.next = end;
        amountOfList += 1;
    }

    @Override
    void delete(int i) {
        if (i >= this.size()) {
            System.out.println("Размер связного списка меньше, чем заданный индекс.");
            return;
        }
        if (i == 0) {
            head = head.next;
            amountOfList -= 1;
            return;
        }
        Node start = head;
        for (int j = 1; j < i; j++) {
            start = start.next;
        }
        if (i == this.size() - 1) {
            start.next = null;
            tail = start;
            amountOfList -= 1;
            return;
        }
        start.next = start.next.next;
        amountOfList -= 1;
    }

    @Override
    T get(int i) {
        if (i >= this.size()) {
            System.out.println("Размер связного списка меньше, чем заданный индекс.");
            return null;
        }
        Node<T> start = head;
        for (int j = 0; j < i; j++) {
            start = start.next;
        }
        return start.value;
    }

    @Override
    T[] toArray(T[] array) {
        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), this.size());
        Node<T> start = head;
        for (int i = 0; i < this.size(); i++) {
            newArray[i] = start.value;
            start = start.next;
        }
        return newArray;
    }
}
