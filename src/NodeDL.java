public class NodeDL {
    // attributi
    private int info;
    private NodeDL next;
    private NodeDL prev;
    // costruttori
    public NodeDL(int val) {
    this(val, null, null);
    }
    public NodeDL(int val, NodeDL p, NodeDL n) {
    info = val;
    next = n;
    prev = p;
    }
    // metodi getter e setter
    public void setInfo(int val) {
    info = val;
    }
    public int getInfo() {
    return info;
    }
    public void setNext(NodeDL n) {
    this.next = n;
    }
    public NodeDL getNext() {
    return next;
    }
    public void setPrev(NodeDL p) {
    this.prev = p;
    }
    public NodeDL getPrev() {
    return prev;
 }
}