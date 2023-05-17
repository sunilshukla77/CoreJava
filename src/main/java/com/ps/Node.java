package com.ps;

public class Node <T>{

    private T data;
    protected Node next;

    public Node(){

    }

    public Node(T data){
        this.data = data;
    }

    public Node(T data, Node next){
        this.data = data;
        this.next = next;
    }

    public T getData(){
        return this.data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
