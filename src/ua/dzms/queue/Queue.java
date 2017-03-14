package ua.dzms.queue;

public class Queue<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;

    private Node<T> getFirstNode() {
        return firstNode;
    }

    private Node<T> getLastNode() {
        return lastNode;
    }

    public void enqueue(T object) {
        Node node = new Node(object);
        if (isEmpty()) {
            lastNode = node;
            firstNode = node;
        } else {
            lastNode.setNextNode(node);
            lastNode = node;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            T object = firstNode.getValue();
            firstNode = firstNode.getNextNode();
            return object;
        }
    }

    public boolean isEmpty() {
        return (firstNode == null);
    }

    static class Node<T> {
        private T value;
        private Node<T> nextNode;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}