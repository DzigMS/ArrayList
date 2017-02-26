package ua.dzms.list.queue;

import ua.dzms.list.node.Node;

public class Queue<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;

    private Node<T> getFirstNode() {
        return firstNode;
    }

    private Node<T> getLastNode() {
        return lastNode;
    }

    public void enqueue(T object){
        Node node = new Node(object);
        if (isEmpty()){
            lastNode = node;
            firstNode = node;
        }else {
            lastNode.setNextNode(node);
            lastNode = node;
        }
    }

    public T dequeue(){
        if (isEmpty()){
            throw new NullPointerException();
        }else {
            T object = firstNode.getValue();
            firstNode = firstNode.getNextNode();
            return object;
        }
    }

    public boolean isEmpty(){
        return (firstNode == null);
    }
}