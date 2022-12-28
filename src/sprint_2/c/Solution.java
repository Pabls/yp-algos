package sprint_2.c;

class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

public class Solution {

    public static Node<String> solution(Node<String> head, int idx) {
        if (idx == 0) {
            return head.next;
        }

        removeNodeBy(idx, head, 0);
        return head;
    }

    public static void removeNodeBy(int indexForRemove, Node<String> node, int currentNodeIndex) {
        if (indexForRemove == currentNodeIndex + 1) {
            node.next = node.next.next;
        } else {
            removeNodeBy(indexForRemove, node.next, currentNodeIndex + 1);
        }
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);

        Node<String> newHead = solution(node0, 3);

        assert newHead == node0;
        assert newHead.next == node2;
        assert newHead.next.next == node3;
        assert newHead.next.next.next == null;
        // result is : node0 -> node2 -> node3
    }
}