package dataStructures.linkedlist;

public class LinkedList<T> {

    Node head;

    public void prepending (T para){
        // in the case there is not a a head yet
        if (head == null){
            head = new Node(para);
            return;
        }
        // in the case there is a head, lets save head in a temp value
        Node temp = head;

        // transforming the actual head in second element
        // transforming the new element in the head

        head = new Node(para);
        head.next = temp;
    }

    public void appending (T para){
        // if there is not a head yet
        if (head == null){
            head = new Node(para);
            return;
        }
        // in the case there is a head, goes to the end and add
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(para);
    }

    public <T> void deleting (Node deleted){
        // start from the head
        if (head == null){
            System.out.println("There is no LikeList");
            return;
        }
        if (head == deleted){
            head =head.next;
            return;
        }
        // go through the whole linkedList
        Node temp = head;
        while (temp.next != null){
            // removing the Node
            if (temp.next == deleted){
                // Making the connections to leave that node free
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    public <T> boolean finding ( T found){

        Node testfound = new Node (found);
        // start from the head
        if (head == null){
            return false;
        }
        if (head == testfound){
            head = head.next;
            return true;
        }
        // go through the whole linkedList
        Node temp = head;
        while (temp.next != null) {
            // finding the Node
            if (temp.next == testfound) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

}
