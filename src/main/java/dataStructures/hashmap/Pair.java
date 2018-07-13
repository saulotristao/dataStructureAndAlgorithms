package dataStructures.hashmap;

public class Pair < K, R>  {

    private K key;
    private R result;
    Pair next;

    public Pair(K key, R result) {
        this.key = key;
        this.result = result;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public R getResult() {
        return result;
    }

    public void setResult(R result) {
        this.result = result;
    }

    public Pair getNext() {
        return next;
    }

    public void setNext(Pair next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", result=" + result +
                ", next=" + next +
                '}';
    }
}
