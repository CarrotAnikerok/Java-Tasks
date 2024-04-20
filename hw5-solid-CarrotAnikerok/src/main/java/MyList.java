abstract class MyList {
    int amountOfList = 0;
    abstract void add(int a);
    abstract void addFirst(int a);
    abstract void insert(int a, int i);
    abstract void delete(int i);
    abstract int get(int i);

    public int size() {
        return amountOfList;
    }

    abstract int[] toArray();
}

