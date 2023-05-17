package com.ps.queue;

import com.ps.Node;

public class MyQueue<T> {
    Node<T> first;
    Node<T> last;

    int length;

    MyQueue(){

    }
    MyQueue(T data){
        Node<T> newNode = new Node(data);
        first= newNode;
        last= newNode;
        length = 1;
    }

    public void insert(T data){ // insert from last FIFO
        Node<T> node = new Node(data);
        if(length ==0){
            first = node;
            last = node;
        }else{
            last.setNext(node);
            last = node;
        }
        length++;
    }

    public Node delete(){ // delete from first
        if(length == 0) return null;
        Node<T> temp = first;
        if(length == 1){
            first = null;
            last = null;
        }else{
            first= first.getNext(); // Pick from first
            temp.setNext(null); //temp next is null
        }
        return first;
    }


    public void printQueue(){
        Node temp = first;
        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
