package algorithms.classic;

public interface Heap {

    Integer find();
    void add(int e);
    Integer extract();
    void delete();
    void replace(int oldValue, int newValue);
}
