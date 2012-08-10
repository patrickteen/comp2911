package lab02;

public interface List {
    void add(Object o);
    boolean find(Object o);
    int size();
    void print();
    Object getLast();
    Object remove();
}