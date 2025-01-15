package Lesson8;

public class IntNode {
    private int _data;
    private IntNode _next;

    public IntNode(int data) {
        _data = data;
        _next = null;
    }

    public IntNode getNext() {
        return _next;
    }

    public void setNext(IntNode node) {
        _next = node;
    }

    public int getData() {
        return _data;
    }

    public void setData(int data) {
        _data = data;
    }
}
