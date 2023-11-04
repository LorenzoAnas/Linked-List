public class List {
    private Node head;

    public List() {
        head = null;
    }

    public String toString() {
        Node aux = head;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while(aux!=null) {
            sb.append(aux.getInfo() + " ");
            aux = aux.getNext();
        }
        sb.append("]");
        return sb.toString(); // Questo metodo è proprio della classe StringBuffer, non si riferisce al nome della funzione.
    }

    public boolean isEmpty(){
        return head==null; 
    }

    public void insertHead(int val) {
        Node newElem = new Node(val, head);
        head = newElem;
    }

    public void insertTail(int val) {
        if (isEmpty()) {
        head = new Node(val);
        } else {
        Node aux=head;
        while ( aux.getNext()!=null ) {
        aux = aux.getNext();
        }
        aux.setNext( new Node(val) );
        }
    }   

    public void insertOrdered(int val) {
        if (isEmpty()) {
            head = new Node(val);
        }
            else if (head.getInfo()> val) {
                head = new Node(val,head);
            }
            else {
                Node aux = head;
                while(head.getNext()!=null && (aux.getNext().getInfo()>val)){
                    aux=aux.getNext();
                }
            }
    }
    public Node search(int key) {
        // partiamo dalla testa della Lista
        Node aux = head;
        // cerchiamo un elemento con info uguale a key
        // quindi se ancora non ci siamo e ci ancora sono nodi nella lista
        while (aux!=null && aux.getInfo()!=key) {
        // continuiamo ad andare avanti
        aux = aux.getNext();
        }
        // restituiamo il Node trovato al chiamante
        // (o null se siamo arrivati in fondo alla lista)
        return aux;
       }
       
    public Node searchOrdered(int key) {
        // partiamo dalla testa della Lista
        Node aux = head;
        // cerchiamo un elemento con info >= key
        // quindi se ancora non ci siamo e ci ancora sono nodi nella lista, continuiamo ad andare avanti
        while (aux!=null && aux.getInfo()<key) {
        // continuiamo ad andare avanti
        aux = aux.getNext();
        }
        // se abbiamo effettivamente trovato il nodo
        if (aux != null && aux.getInfo() == key) {
        // lo restituiamo al chiamante
        return aux;
        }
        // altrimenti restituiamo null
        return null;
    }

    public class EmptyListException extends RuntimeException {
        public EmptyListException() {
        super("Lista vuota!");
        }
        public EmptyListException(String msg){
        super(msg);
        }
    }
    
    public int deleteHead() throws EmptyListException {
        // se la lista è vuota lanciamo un’eccezione
        if (isEmpty()) {
        throw new EmptyListException();
        }
        // altrimenti eliminiamo il nodo in testa
        else {
        Node aux = head;
        head = head.getNext();
        return aux.getInfo();
        }
    }
    
    public int deleteTail() throws EmptyListException {
        // se la lista è vuota lanciamo un’eccezione
        if (isEmpty()) {
        throw new EmptyListException();
        }
        // se la lista ha solo il nodo di testa
            else if (head.getNext()==null) {
                // eliminiamolo salvando prima
                // l’attributo info che dobbiamo restituire
                int info = head.getInfo();
                head = null;
                return info;
            }
                // altrimenti eliminiamo l’ultimo Node
                else {
                    Node aux = head;
                    Node prev = null;
                // con aux scorriamo la lista fino all’ultimo nodo
                    while (aux.getNext()!=null) {
                    prev = aux;
                    aux = aux.getNext();
                    }
                // alla fine del while aux punterà all’ultimo nodo e prev al penultimo
                // per eliminare l’ultimo nodo dagli altri basta “sganciarlo” dalla catena di nodi
                prev.setNext(null);
                return aux.getInfo();
                }
    }

    public boolean deleteKey(int key) throws EmptyListException {
        // se la Lista è vuota lanciamo un’eccezione
        if (isEmpty()) {
        throw new EmptyListException();
        }
        // se la Lista ha solo il Node di testa
        // ed è quello giusto (info==key)
        else if (head.getNext()==null && head.getInfo()==key) {
        // dobbiamo eliminarlo e restituire true
        head = null;
        return true;
        }
        // altrimenti partiamo dalla testa e cerchiamo
        // se esiste il Node da eliminare avente
        // il campo info == key
        else {
        Node aux = head;
        Node prev = null;
        // vai avanti se ci sono ancora Nodi nella Lista
        // e il Node con info==key non è stato ancora trovato
        while (aux != null && aux.getInfo() != key) {
        prev = aux;
        aux = aux.getNext();
        }
        if (aux != null) {
        // abbiamo trovato il Node da eliminare (aux)
        if (prev == null) {
        // il Node da eliminare era il Node di testa
        head = head.getNext();
        } else {
        // aggiustiamo i riferimenti a next per “aggirare”
        // il Node aux da eliminare
        prev.setNext(aux.getNext());
        }
        // in entrambi i casi (eliminazione di testa o
        // eliminazione Node intermedio) dobbiamo ritornare true
        return true;
        }
        }
        // se nessuna delle condizioni precedenti si è verificata
        // vuol dire che non abbiamo trovato il Node avente info==key
        // da eliminare, quindi ritorniamo false al chiamante
        return false;
       }
}
