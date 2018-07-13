package dataStructures.linkedlist;

public class TestingLinkedList<T> {

    public static void main(String[] args) {
        LinkedList <Integer> test = new LinkedList<Integer>();
        test.appending(5);
        test.appending(10);
        System.out.println(test.finding(5));
        System.out.println(test.finding(10));
    }

}
