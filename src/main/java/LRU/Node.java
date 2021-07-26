package LRU;

public class Node {

    public Node pre;

    public Node next;

    public String key;

    public String value;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

}