package Lesson8;

public class IntList {
    private IntNode _head;

    public IntList() {
        _head = null;
    }

    
    /** this function gets a number and cancelling all multiple 
     * instances of this value and returned either there was a change or not. */
    public boolean listManip(int value) {
        boolean changed = false;
    
        while (_head != null && _head.getData() == value) {
            _head = _head.getNext();
            changed = true;
        }
    
        if (_head != null) {
            IntNode curr = _head;
            while (curr.getNext() != null) {
                if (curr.getNext().getData() == value) {
                    curr.setNext(curr.getNext().getNext());
                    changed = true;
                } else {
                    curr = curr.getNext();
                }
            }
        }
    
        return changed;
    }
}
