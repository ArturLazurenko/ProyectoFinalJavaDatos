public class Queue<T> {
    public Node<T> front;
    public Node<T> back;
    public int size;

    public Queue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(T data) {
        Node<T> nuevoNode = new Node<T>(data);
        if (isEmpty()) {
            front = nuevoNode;
            back = nuevoNode;
        } else {
            back.next = nuevoNode;
            back = nuevoNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("La cola esta vacia");
            return null;
        }
        T data = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            back = null;
        }
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("La cola esta vacia");
            return null;
        }
        return front.data;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("La cola esta vacia");
            return;
        }
        Node<T> current = front;
        System.out.println("=== Inicio ===");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("=== Final ===");
    }

    public int getSize() {
        return size;
    }
}
