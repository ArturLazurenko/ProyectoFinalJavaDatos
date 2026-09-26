public class LinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    public int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void appendNode(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void showList() {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
            return;
        }
        System.out.println("La lista: ");
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public boolean search(T data) {
        if (isEmpty()) return false;

        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void delete(T data) {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
            return;
        }
        Node<T> current = head;
        Node<T> previous = null;
        boolean found = false;
        while (current != null) {
            if (current.data.equals(data)) {
                found = true;
                break;
            }
            previous = current;
            current = current.next;
        }
        if (!found) {
            System.out.println("Elemento no encontardo");
            return;
        }
        if (current == head) {
            head = head.next;
            if (head == null) tail = null;
        } else {
            previous.next = current.next;
            if (current == tail) tail = previous;
        }
        size--;
        System.out.println("Elemento eliminado");
    }

}
