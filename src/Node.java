public class Node {
    private int info;
    private Node next;

    public Node(int val) {
        this(val, null);
    }

    public Node(int val, Node n){
            info = val;
            next = n;
        }

    public void setInfo(int val) {
        info = val;
    }

    public int getInfo() {
        return info;
    }

    public void setNext(Node n) {
        next = n;
    }

    public Node getNext() {
        return next;
    }
}