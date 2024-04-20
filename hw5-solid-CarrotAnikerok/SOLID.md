#### Какие принципы SOLID **учтены** при реализации _связного списка_? Проиллюстрируйте примером каждый из названых принципов. 

- Учтен принцип Single responsibility, так как каждый метод напрямую относится к классу. 

В иллюстрации ниже принцип Single responsibility учтен.

abstract class MyList {

    int amountOfList = 0;
    abstract void add(int a);
    abstract void addFirst(int a);
    abstract void insert(int a, int i);
    abstract void delete(int i);
    abstract int get(int i);
    int size() {
        return amountOfList;
    }
    abstract int[] toArray();
}

- Учтен принцип Open-closed, так как классы открыты для расширения, 
а существующие методы не нужно дополнительно модифицировать.

В классы LinkedMyList и MyList можно добавлять новые методы, 
а изначальные методы закончены и не требуют модификации, так как выполняют свою функцию вне 
завсимисоти от входных данных. Так, например, метод toArray() всегда выполнит свою задачу вне зависимости от новых методов.

- Учтен принцип Liskov Substitution, так как класс LinkedMyList 
имеет все методы, что и MyList, так как это абстрактный класс, и LinkedMyList никак не
зависит от других возможных наследников MyList, а значит не требует изменений в случае их добавления.

#### Какие принципы SOLID **не были** учтены при реализации _связного списка_? Проиллюстрируйте примером каждый из названых принципов. Объясните, почему

- Не использован принцип Interface segregation, так как для данных классов не используется интерфейсы в силу отсутсвия
  необходимости. Но все методы, использованные в абстрактном классе,
  реализованы и не ставят клиента.
  в зависимость.
- Не совсем учтен принцип Dependency Inversion, так как класс LinkedMyList зависит от деталей класса Node, а именно от
  полей public int value; public Node next, которые постоянно используются в классе LinkedMyList.

#### Какие принципы SOLID **учтены** при реализации _странного связного списка_? Проиллюстрируйте примером каждый из названых принципов.
StrangeMyList - это анонимный класс, который имплементирует класс LinkedMyList.
- Учтен принцип Single responsibility, так как каждый метод напрямую относится к объекту анонимного класса
и отвечает за свои собственные функции, так же как и в LinkedMyList.
- Учтен принцип Open-Closed, так как класс открыт для расширения, в него можно добавить новые методы, а старые не нужно
модифивировать, так же как и в LinkedMyList.



#### Какие принципы SOLID **не были** учтены при реализации _странного связного списка_? Проиллюстрируйте примером каждый из названых принципов.

- Не учтен принцип Liskov Substitution, так как при добавлении в StrangeMylist некоторых чисел, при проверке объема
  списка мы получим не то,
  что ожидали. Так же при попытке удаления числа, наше число не удалится, если оно не делится на 3 или на 5. Таким
  образом, StrangeMyList как наследник Mylist-a
  не удовлетворяет тому, что мы ожидаем от MyList и наш код не отвечает принципу Подстановки Лисков.

  MyList myList = StrangeMyList.getStrangeList()
  MyList.add(4); //добавится
  MyList.add(3); // не добавится
  MyList.add(1); // не добавится
  MyList.delete(0) // не удалится
  MyList.size() // ожидаем 3, получаем 1

- Не учтен принцип Interface segregation, так как для данных классов не используется интерфейсы в силу отсутствия
  необходимости. Но все методы, использованные
  в наследованном классе, реализованы в анонимном классе и не ставят клиента. в зависимость.
- Не совсем учтен принцип Dependency Inversion, так как класс MyStrangeList реализует класс LinkedMyList, который
  зависит от деталей класса Node,
  а именно от полей public int value; public Node next, которые постоянно используются в классе LinkedMyList.
