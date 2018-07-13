package dataStructures;

import dataStructures.hashmap.Hashmap;

public class TestingHashmap {

    public static void main(String[] args) {
        Hashmap< String , Double > test2 = new Hashmap<String, Double>();

        test2.add("Saulo", 10.0);

        System.out.println(test2.get("Saulo"));

        test2.remove("Saulo");

        System.out.println(test2.get("Saulo"));

        test2.add("Saulo", 10.0);
        test2.add("Duncan", 10.0);
        test2.add("Ryan", 10.0);
        test2.add("Ashley", 10.0);
        test2.add("Madoka", 10.0);
        test2.add("Nami", 10.0);

        test2.listing();

    }
}
