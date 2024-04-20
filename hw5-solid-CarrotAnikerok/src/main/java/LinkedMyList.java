public class LinkedMyList extends MyList {

    public Node head;
    public Node tail;

    Node findI(int i) {
        Node start = head;
        for (int j = 1; j < i; j++) {
            start = start.next;
        }
        return start;
    }

    /**
     * В методе add() отсутствуют циклы, длина метода не зависит от параметра и выполняется последовательно
     * Выполняется за o(1)
     **/
    @Override
    void add(int a) {
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

    /** В методе addFirst() отсутствуют циклы, длина метода не зависит от параметра и выполняется последовательно.
     *  Выполняется за o(1)**/
    @Override
    void addFirst(int a) {
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

    /** В методе insert() присутствует один цикл, длина метода зависит только от параметра i и метод выполняется за о(n)**/
    @Override
    void insert(int a, int i) {
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
        Node element = new Node();
        element.value = a;
        Node start = findI(i);
        Node end = start.next;
        start.next = element;
        element.next = end;
        amountOfList += 1;
    }

    /** В методе delete() присутствует один цикл, длина метода зависит только от параметра i и метод выполняется за о(n)**/
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
        Node start = findI(i);
        if (i == this.size() - 1) {
            start.next = null;
            tail = start;
            amountOfList -= 1;
            return;
        }
        start.next = start.next.next;
        amountOfList -= 1;
    }

    /** В методе get() присутствует один цикл, длина метода зависит только от параметра i и метод выполняется за о(n)**/
    @Override
    int get(int i) {
        if (i >= this.size()) {
            System.out.println("Размер связного списка меньше, чем заданный индекс.");
            return 0;
        }
        Node start = findI(i);
        return start.value;
    }

    /** В методе size() отсутствуют циклы, длина метода не зависит от параметра и по своей сути просто выдает число.
     *  Выполняется за o(1)**/

    /** В методе toArray() присутствует один цикл, длина метода зависит только от параметра i и метод выполняется за о(n)**/
    @Override
    int[] toArray() {
       int[] list = new int[this.size()];
        Node start = head;
        for (int i = 0; i < this.size(); i++) {
            list[i] = start.value;
            start = start.next;
        }
        return list;
    }
}
