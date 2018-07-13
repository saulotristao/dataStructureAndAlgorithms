package dataStructures.hashmap;

public class Hashmap< K, R > {

    private int FIRST_SIZE_HASHMAP = 5;
    private double SECURITY_PERCENTAGE = .6;
    private Pair<K, R>[] arrayOfPairs;
    private int counter;

    public Hashmap() {
        arrayOfPairs = new Pair[FIRST_SIZE_HASHMAP];
        counter = 0;
    }

    public void remove(K key){
        if (find(key) == false){
            System.out.println("this key is not in the hashmap");
            return;
        }

        int removekey = hash(key);

        if (arrayOfPairs[removekey].getKey() == key){
            arrayOfPairs[removekey] = arrayOfPairs[removekey].next;
            counter--;
            return;
        }else {
            while (arrayOfPairs[removekey].next != null) {
                if(arrayOfPairs[removekey].next.getKey() == key){
                    arrayOfPairs[removekey].next = arrayOfPairs[removekey].next.next;
                    counter--;
                }
            }
        }
    }


    public void add (K key, R result){
        try {
            if (find(key) == true) {
                System.out.println("this key is already in the hashMap");
                return;
            }

            // get the hash for the key
            int hash = hash(key);

            // is that hash already in the array?
            if (arrayOfPairs[hash] == null) {
                arrayOfPairs[hash] = new Pair(key, result);
                return;
            }
            // in case that hash is already taken
            // select the head of that Node
            Pair<K, R> temp = arrayOfPairs[hash];
            // interact in the node

            if (temp.next == null) {
                // if second element of the link list is empty, lets add
                temp.next = new Pair(key, result);
                return;
            } else {
                while ((temp.next != null)) {
                    temp = temp.next;
                }
                // adding the pair in the end of the linkedlist
                temp.next = new Pair(key, result);
            }
        }catch (Exception e){
            e.getMessage();
        }finally {
            counter++;
            checkResize();
        }

    }

    public void checkResize(){
        if (counter >= SECURITY_PERCENTAGE * arrayOfPairs.length){
            resize();
        }
    }

    public R get(K key) {

        // checking for the key
        // get the hash for the key
        int hash = hash(key);
        // checking for the key

        if (arrayOfPairs[hash] == null){
            System.out.println("didn't find the key ");
            return null;
        }
        else{
            // if that hash is already in the array, let go over the linkedlist
            Pair <K,R> f = arrayOfPairs[hash];
            // lopping over the linkedList
            while (f != null) {
                if (f.getKey() == key) {
                    // key found case
                    return f.getResult();
                }
                f = f.next;
            }
        }
        // found the hash but din't find the key case
        System.out.println("didn't find the key ");
        return null;
    }

    public boolean find(K key) {

        // checking for the key
        // get the hash for the key
        int hash = hash(key);
        // is that hash already in the array?
        if (arrayOfPairs[hash] == null){
            return false;
        }
        // if that hash is already in the array, let go over the linkedlist
        Pair <K,R> f = arrayOfPairs[hash];
        // lopping inside the linkedList
        while (f != null) {
            if (f.getKey() == key) {
                return true;
            }
            f = f.next;
        }
        return false;
    }

    /**
     * Resize, first creates a new array
     * then copy the old in the new
     */
    public void resize() {
        Pair< K,R > [] temp = arrayOfPairs;
        arrayOfPairs= new Pair [2* arrayOfPairs.length];
        counter = 0;
        for (Pair<K,R> k: temp ) {
            // in case one array position is null, keep going over the array
            if (k != null) {
                // copying the array head
                add(k.getKey(), k.getResult());
                // copying the linkedList of each position in the array
                while (k.next != null) {
                    k = k.next;
                    add(k.getKey(), k.getResult());
                }
            }else{
                continue;
            }

        }
        System.out.println("resize has run");
    }

    public int hash(K key){
        int k = Math.abs(key.hashCode() % arrayOfPairs.length);
        return k;
    }

    public void listing (){
        for (Pair <K, R > f : arrayOfPairs) {
            // checking if there is a pair in that hash
            if (f != null ){
                // printing the head if there is one
                System.out.println(f.toString());
                // printing the linkedlist
                while (f.next !=null){
                    System.out.println(f.next.toString());
                    f = f.next;
                }
            }else{
                continue;
            }
        }
        System.out.println("That the whole list ");
    }

}
