package sprint_2.f;

public class StackNode {
    private int value;
    private StackNode next;
    private StackNode prev;
    private int max;

    public int getValue() {
        return value;
    }

    public StackNode getNext() {
        return next;
    }

    public StackNode getPrev() {
        return prev;
    }

    public int getMax() {
        return max;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }

    public void setPrev(StackNode prev) {
        this.prev = prev;
    }

    public StackNode(int value, StackNode next, StackNode prev, int max) {
        this.value = value;
        this.next = next;
        this.prev = prev;
        this.max = max;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", max=" + max +
                '}';
    }
}