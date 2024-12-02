//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(13);
        tree.insert(17);
        tree.printTree(tree.root, -5);

        System.out.println("---------------------------------------");

        tree.insert(4);
        tree.insert(16);
        tree.insert(5);
        tree.printTree(tree.root, -5);

        System.out.println("---------------------------------------");

        Node test1 = tree.find(4);
        if (test1 != null) {System.out.println(test1.id);}
        else {System.out.println("4 is not in the tree");}

        Node test2 = tree.find(17);
        if (test2 != null) {System.out.println(test2.id);}
        else {System.out.println("17 is not in the tree");}

        Node test3 = tree.find(1);
        if (test3 != null) {System.out.println(test3.id);}
        else {System.out.println("1 is not in the tree");}
    }
}

class Node {
    int id ;
    Node left;
    Node right;

    public Node(int item) {
        id = item;
    }
}

class BinaryTree {
    Node root;

    Node find(int key) {
        Node curNode = root;
        while (curNode != null) {
            if (curNode.id == key) {
                return curNode;
            } else if (key < curNode.id) {
                curNode = curNode.left;
            } else {
                curNode = curNode.right;
            }
        }
        return null;
    }

    void insert (int key) {
        if (root == null) {root = new Node(key); return;}
        Node curNode = root;
        while (true) {
            if (key == curNode.id) {return;}
            if (key < curNode.id) {
                if (curNode.left == null) {curNode.left = new Node(key); return;}
                curNode = curNode.left;
            } else {
                if (curNode.right == null) {curNode.right = new Node(key); return;}
                curNode = curNode.right;
            }
        }
    }

    void printTree(Node node, int space) {
        if (node == null) {return;}

        space += 5;
        printTree(node.right, space);

        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(node.id);

        printTree(node.left, space);
    }
}
