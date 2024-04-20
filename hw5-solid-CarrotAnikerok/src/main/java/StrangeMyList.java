public class StrangeMyList {
    public static MyList getStrangeList() {
        LinkedMyList strangeMyList = new LinkedMyList() {
            /** В методе add() отсутствуют циклы, длина метода не зависит от параметра и выполняется последовательно
             * Выполняется за o(1)**/
            @Override
            void add(int a) {
                if (a % 2 == 0) {
                    Node element = new Node();
                    element.value = a;
                    if (head == null) {
                        this.head = element;
                        this.tail = element;
                    } else {
                        tail.next = element;
                        tail = element;
                    }
                    amountOfList += 1;
                }
            }

            /** В методе addFirst() отсутствуют циклы, длина метода не зависит от параметра и выполняется последовательно.
             *  Выполняется за o(1)**/
            @Override
            void addFirst(int a) {
                if (a % 2 == 0) {
                    Node element = new Node();
                    element.value = a;
                    if (head == null) {
                        this.head = element;
                        this.tail = element;
                    } else {
                        element.next = head;
                        head = element;
                    }
                    amountOfList += 1;
                }
            }

            /** В методе insert() присутствует один цикл, длина метода зависит только от параметра i и метод выполняется за о(n)**/
            @Override
            void insert(int a, int i) {
                if (a % 2 != 0) {
                    return;
                }
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
                if (i == 0 && (head.value % 3 == 0 || head.value % 5 == 0)) {
                    head = head.next;
                    amountOfList -= 1;
                    return;
                }
                Node start = findI(i);
                if (!(start.next.value % 3 == 0 || start.next.value % 5 == 0)) {
                    return;
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
        };
        return strangeMyList;
    }
}
