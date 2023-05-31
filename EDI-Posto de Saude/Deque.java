import java.util.LinkedList;

public class Deque<T> {
    private LinkedList<T> deque;

    public Deque(){
        deque = new LinkedList<>();
    }

    public void adicionaNoInicio(T elemento){
        deque.addFirst(elemento);
    }

    public void adicionaNoFinal(T elemento){
        deque.addLast(elemento);
    }

    public T removeDoInicio(){
        return(deque.removeFirst());
    }

    public T removeDoFim(){
        return(deque.removeLast());
    }

    public T getInicio(){
        return(deque.getFirst());
    }

    public T getFim(){
        return(deque.getLast());
    }

    public boolean isEmpty(){
        return(deque.isEmpty());
    }

    public int size(){
        return(deque.size());
    }

    public void imprimir(){
       //System.out.print("Deque: ");
        for(T elementos : deque){
            System.out.print(elementos +"");
        }
        System.out.println();
    }

}
