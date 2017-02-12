package ua.dp.queue;

public class Queue {
    private Node firstNode;
    private Node lastNode;

    public Queue() {
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public void enqueue(Object object){
        Node node = new Node(object);
        if (isEmpty()){
            lastNode = node;
            firstNode = node;
        }else {
            lastNode.setNextNode(node);
            lastNode = node;
        }
    }

    public Object dequeue(){
        if (isEmpty()){
            throw new NullPointerException();
        }else {
            Object object = firstNode.getValue();
            firstNode = firstNode.getNextNode();
            return object;
        }
    }

    public boolean isEmpty(){
        return (firstNode == null);
    }
}