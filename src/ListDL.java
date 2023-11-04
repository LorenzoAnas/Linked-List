import java.util.Scanner;

public class ListDL {
    private NodeDL head;
    private NodeDL tail;
    
    public ListDL() {
       head = null;
       tail = null;
    }
    
    public String toString() {
       NodeDL aux = head;
       StringBuffer sb = new StringBuffer();
       sb.append("[");
       while (aux!=null) {
       sb.append(aux.getInfo() + " ");
       aux = aux.getNext();
       }
       sb.append("]");
       return sb.toString();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertTail(int val){
    if (isEmpty()) {
        head = new NodeDL(val);
        tail = head;
    }
    else {
        NodeDL nuovoNodo = new NodeDL(val, tail, null);
        tail.setNext(nuovoNodo);
        System.out.println(nuovoNodo.getPrev());
        tail = nuovoNodo;
    }
   }

   public class EmptyListException extends RuntimeException {
    public EmptyListException() {
    super("Lista vuota!");
    }
    public EmptyListException(String msg){
    super(msg);
    }
}

   public int deleteTail() throws EmptyListException {
    // se la lista è vuota lanciamo un’eccezione
    if (isEmpty()) {
    throw new EmptyListException();
    }
    // se la lista ha solo il nodo di testa
    // vuol dire che ha anche un solo nodo in coda
    else if (head.getNext()==null) {
    // eliminiamolo salvando prima
    // l’attributo info che dobbiamo restituire
    // e ricordandoci di aggiustare anche la coda
    int info = head.getInfo();
    head = null;
    tail = null;
    return info;
    }
    // altrimenti eliminiamo l’ultimo Nodo
    else {
    // aux punta alla vecchia coda
    NodeDL aux = tail;
    // tail scorre verso sinistra di un nodo
    // e punta alla nuova coda
    tail = tail.getPrev();
    // scolleghiamo i nodi
    tail.setNext(null);
    aux.setPrev(null);
    // ritorniamo il l’info del nodo eliminato al chiamante
    return aux.getInfo();
    }
   }

   public static void main (String [] args){
    Scanner scanner = new Scanner(System.in);
    ListDL testList = new ListDL();
    int elemNum = 5;
    for (int i=0; i < elemNum ; i++) {
        System.out.println("Inserisci 5 numeri (" + (i + 1) + "/" + elemNum + "):"); 
        int userInp = scanner.nextInt();
        testList.insertTail(userInp);
        System.out.println(testList.toString());
    }
    scanner.close();

    System.out.println("Procedo con l'eliminazione degli ultimi due numeri della lista");
    testList.deleteTail();
    testList.deleteTail();
    System.out.println(testList.toString());
}
}