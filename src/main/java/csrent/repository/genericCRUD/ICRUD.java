package csrent.repository.genericCRUD;

import java.util.ArrayList;

public interface ICRUD <T,Interger>{

    public T add (T element);
    public ArrayList<T> getAll();
    public T update (T element);
    public T edit (T element);
    public T delete (Interger id);
    public T search (Interger id);


}
