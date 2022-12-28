package sprint_2.b;

class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}

public class Solution {

    public static void solution(Node<String> head) {
        StringBuilder builder = new StringBuilder();
        print(head, builder);
        System.out.println(builder);
    }

    private static void print(Node<String> node, StringBuilder builder) {
        builder.append(node.value).append("\n");
        if (node.next != null) {
            print(node.next, builder);
        }
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        solution(node0);
        /*
        Output is:
        node0
        node1
        node2
        node3
        */
    }
}