package ua.dp.queue;


public class Node {
    private Object value;
    private Node nextNode;

    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
