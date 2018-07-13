package dataStructures.binaryTree;

public class ControllerBT {

    public static void main(String[] args) {
        BinaryTree test = new BinaryTree();
        test.insert(5);
        test.insert(8);
        test.insert(3);
        test.insert(10);
        test.insert(9);
        test.insert(4);
        test.insert(1);

        System.out.println(test.hasThevalue(5));
        test.printAllInOrderTraverse();
//        test.printPreOrderTraverse();
//        test.printPostOrderTraverse();
        System.out.println("---------------");
        test.removeParent(10);
        System.out.println("---------------");

        test.printAllInOrderTraverse();


    }

}
