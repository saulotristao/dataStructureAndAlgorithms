package dataStructures.binaryTree;

public class BinaryTree {

    Node raiz;

    public BinaryTree() {
    }

    public void insert (int novo){
        insert(raiz, novo);
    }

    public void insert (Node root, int novo){
        if (raiz == null){
            raiz = new Node(novo);
            return;
        }
        if (root.data >= novo){
            if (root.left == null){
                root.left = new Node (novo);
            } else {
                insert(root.left, novo);
            }
        } else{
            if (root.right == null){
                root.right = new Node(novo);
            }else{
                insert(root.right, novo);
            }
        }
    }

    public boolean hasThevalue (int comparasion){
        return hasThevalue(raiz, comparasion);
    }


    public boolean hasThevalue (Node root, int comparasion){
        if (root.data == comparasion){
            return true;
        }
        if (root.data < comparasion){
            if (root.left == null){
                return false;
            }
            else {
                return hasThevalue(root.left, comparasion);
            }
        } else{
            if(root.right == null) {
                return false;
            }else {
                return hasThevalue(root.right, comparasion);
            }
        }
    }

    public void printPreOrderTraverse(){
        printPreOrderTraverse(raiz);
    }

    public void printPreOrderTraverse(Node print){
        System.out.println(print.data);
        if (print.left !=null) {
            printPreOrderTraverse(print.left);
        }
        if (print.right != null) {
            printPreOrderTraverse(print.right);
        }
    }

    public void printAllInOrderTraverse() {
        printAllInOrderTraverse(raiz);
    }

    public void printAllInOrderTraverse(Node print) {
        if (print.left != null) {
            printAllInOrderTraverse(print.left);
        }
        System.out.println(print.data);
        if (print.right != null) {
            printAllInOrderTraverse(print.right);
        }
    }

    public void printPostOrderTraverse() {
        printPostOrderTraverse(raiz);
    }

    public void printPostOrderTraverse(Node print) {
        if (print.left != null) {
            printPostOrderTraverse(print.left);
        }
        if (print.right != null) {
            printPostOrderTraverse(print.right);
        }
        System.out.println(print.data);
    }

    public boolean removeParent(int value){
        return removeParent(value, raiz);
    }


    public boolean removeParent (int value, Node parent) {
        // find the node

        // parent right node is equal to the value
        if (parent.right.data == value){
            // case 2 childs
            if (parent.right.left != null && parent.right.right != null){
                // find the mimimum in the right size
                Node temp = parent.right.right;
                while(temp.left != null){
                    temp = temp.left;
                }
                parent.right = temp;
                removeParent(temp.data,parent.right.right);
                return true;
            }
            // case 1 child
            if (parent.right.left != null || parent.right.right != null){
                if (parent.right.left != null){
                    parent.right = parent.right.left;
                }
                if (parent.right.right != null){
                    parent.right = parent.right.right;
                }
                return true;
            }
            // case 0 child
            parent.right = null;
        }
        if (parent.left.data == value){
            // left node is equal to the value
            // case 2 children
            if (parent.left.left != null && parent.left.right != null){
                // find the mimimum in the right size
                Node temp = parent.left.right;
                while(temp.left != null){
                    temp = temp.left;
                }
                parent.left = temp;
                removeParent(temp.data,parent.left.right);
                return true;
            }
            // case 1 child
            if (parent.left.left != null || parent.left.right != null){
                if (parent.left.left != null){
                    parent.left = parent.left.left;
                }
                if (parent.left.right != null){
                    parent.left = parent.left.right;
                }
                return true;
            }
            // case 0 child
            parent.left = null;

            return false;
        }
        if (parent.data > value){
            removeParent(value, parent.left);
        } else {
            removeParent(value, parent.right);
        }
        return false;
    }
}
