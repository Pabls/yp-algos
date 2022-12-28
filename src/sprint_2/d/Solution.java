package sprint_2.d;

class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}

public class Solution {

    public static int solution(Node<String> head, String elem) {
        return getIndex(head, elem, 0);
    }

    private static int getIndex(Node<String> node, String elem, int currentIndex) {
        if (node.value.equals(elem)) {
            return currentIndex;
        } else if (node.next == null) {
            return -1;
        } else {
            return getIndex(node.next, elem, currentIndex + 1);
        }
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        int idx = solution(node0, "node3");
        assert idx == 2;
    }
}
