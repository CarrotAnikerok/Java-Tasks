import java.util.ArrayList;

public class MyBinaryTree<T extends Comparable<T>> {
    TreeNode rootNode;
    private int size = 0;

    public MyBinaryTree() {
        rootNode = null;
    }

    public boolean contains(T a) {
        TreeNode currentNode = rootNode;
        while (currentNode != null) {
            if (currentNode.value.compareTo(a) == 0) {
                return true;
            }
            if (currentNode.value.compareTo(a) > 0) {
                currentNode = currentNode.leftChild;
            } else if (currentNode.value.compareTo(a) < 0) {
                currentNode = currentNode.rightChild;
            }
        }
        return false;
    }

    public void add(T a) {
        TreeNode newNode = new TreeNode();
        newNode.value = a;
        if (rootNode == null) {
            rootNode = newNode;
            size += 1;
            return;
        }
        TreeNode currentNode = rootNode;
        while (true) {
            TreeNode parentNode = currentNode;
            if (currentNode.value.compareTo(a) > 0) {
                currentNode = currentNode.leftChild;
                if (currentNode == null) { // если ниже нашего родительского узла ничего нет, назначем ему в потомки этот узел
                    parentNode.leftChild = newNode;
                    size += 1;
                    return;
                }
            } else {
                currentNode = currentNode.rightChild;
                if (currentNode == null) { // если ниже нашего родительского узла ничего нет, назначем ему в потомки этот узел
                    parentNode.rightChild = newNode;
                    size += 1;
                    return;
                }
            }
        }
    }

    /**
     * Находим следующий наибольший элемент после корня, то есть нужного нам потомка
     */
    public TreeNode receiveDescendant(TreeNode treeNode) {
        TreeNode parentNode = treeNode;
        TreeNode descendantNode = treeNode;
        TreeNode currentNode = treeNode.rightChild; // переходим к правому потомку
        while (currentNode != null) { // пока остаются левые потомки
            parentNode = descendantNode; // потомка задаем как текущий узел
            descendantNode = currentNode;
            currentNode = currentNode.leftChild;
        }
        if (descendantNode != treeNode.rightChild) { // если наш потомок не правый узел, идем дальше
            parentNode.leftChild = descendantNode.rightChild;
            descendantNode.rightChild = treeNode.rightChild;
        }
        return descendantNode;
    }

    public void delete(T a) {
        TreeNode currentNode = rootNode;
        TreeNode parentNode = rootNode;
        boolean isLeftChild = true;
        if (!contains(a)) {
            System.out.println("Такого элемента в списке нет :р");
            return;
        }
        while (currentNode.value.compareTo(a) != 0) { // поиск элемента
            parentNode = currentNode;
            if (currentNode.value.compareTo(a) > 0) { //движение влево
                isLeftChild = true;
                currentNode = currentNode.leftChild;
            } else {
                isLeftChild = false;
                currentNode = currentNode.rightChild; //движение вправо
            }
        }
        if (currentNode.rightChild == null && currentNode.leftChild == null) { // если потомков нет
            if (currentNode == rootNode) {
                rootNode = null;
            } else if (isLeftChild) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }
        } else if (currentNode.rightChild == null) { // один левый потомок
            if (currentNode == rootNode) {
                rootNode = currentNode.leftChild;
            } else if (isLeftChild) {
                parentNode.leftChild = currentNode.leftChild;
            } else {
                parentNode.rightChild = currentNode.leftChild;
            }
        } else if (currentNode.leftChild == null) {
            if (currentNode == rootNode) {
                rootNode = currentNode.rightChild;
            } else if (isLeftChild) {
                parentNode.leftChild = currentNode.rightChild;
            } else {
                parentNode.rightChild = currentNode.rightChild;
            }
        } else { // если у узла два потомка
            TreeNode descendant = receiveDescendant(currentNode); //поиск потомка для удаляемого узла
            descendant.leftChild = currentNode.leftChild; // назначаем левый узел
            // меняем наш элемент на нужного потомка
            if (currentNode == rootNode) {
                rootNode = descendant;
            } else if (isLeftChild) {
                parentNode.leftChild = descendant;
            } else {
                parentNode.rightChild = descendant;
            }
        }
    }

    public int size() {
        return size;
    }

    private void calculate(TreeNode node, ArrayList<T> list) {

        if (node == null) {
            return;
        }
        if (node.leftChild != null) {
            list.add((T) node.leftChild.value);
        }
        if (node.rightChild != null) {
            list.add((T) node.rightChild.value);
        }
        if (node.leftChild != null) {
            calculate(node.leftChild, list);
        }
        if (node.rightChild != null) {
            calculate(node.rightChild, list);
        }
    }

    public ArrayList<T> toArray(T[] array) {
        ArrayList<T> list = new ArrayList<>();
        if (size == 0) {
            return list;
        }
        list.add((T) rootNode.value);
        calculate(rootNode, list);
        return list;
    }
}
