public class Stack<T> {
    public Node<T> top;
    public int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia.");
            return null;
        } else {
            T data = top.data;
            top = top.next;
            size--;
            return data;
        }
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia.");
            return null;
        } else {
            return top.data;
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia.");
            return;
        }
        System.out.println("Pila: ");
        Node<T> current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
}
