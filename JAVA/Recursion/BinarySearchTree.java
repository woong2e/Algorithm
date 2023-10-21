package Recursion;
import java.util.Scanner;

public class BinarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    Node root = null;
    void insert(int data){
        root = insert(root, data);

    }
    Node insert(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data < root.data){
            root.left = insert(root.left, data);
        }else if(root.data < data){
            root.right = insert(root.right, data);
        }
        return root;
    }

    void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    int size(Node node){
        int count = 0;
        if(node != null){
            count = 1 + size(node.left) + size(node.right);
        }
        return count;
    }

    int height(Node node){
        int height = 0;
        if(node == null){
            return -1;
        }else{
            height = 1 + Math.max(height(node.left), height(node.right));
        }
        return height;
    }

    void mirror(Node node){
        if(node == null){
            return;
        }
        Node tmp;

        mirror(node.left);
        mirror(node.right);

        tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

    int sumOfWeight(Node node){
        int sow = 0;
        if(node != null){
            sow = node.data + sumOfWeight(node.left) + sumOfWeight(node.right);
        }
        return sow;
    }

    int maxPathWeight(Node node){
        int mpw = 0;
        if(node != null){
            mpw = node.data + Math.max(maxPathWeight(node.left), maxPathWeight(node.right));
        }
        return mpw;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        while (numTestCases > 0){
            BinarySearchTree bt = new BinarySearchTree();
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                int data = sc.nextInt();
                bt.insert(data);
            }
            System.out.println(bt.size(bt.root));
            System.out.println(bt.height(bt.root));
            System.out.println(bt.sumOfWeight(bt.root));
            System.out.println(bt.maxPathWeight(bt.root));

            bt.mirror(bt.root);
            bt.preOrder(bt.root);
            System.out.println();
            bt.inOrder(bt.root);
            System.out.println();
            bt.postOrder(bt.root);
            System.out.println();

            System.out.println("0");
            numTestCases--;
        }
    }
}

//class Node {
//    int data;
//    Node left;
//    Node right;
//    public Node(int data){
//        this.data = data;
//    }
//}

//class BinaryTree {
//
//    Node root = null;
//    void insert(int data){
//        root = insert(root, data);
//
//    }
//    Node insert(Node root, int data){
//        if(root == null){
//            root = new Node(data);
//            return root;
//        }
//
//        if(data < root.data){
//            root.left = insert(root.left, data);
//        }else if(root.data < data){
//            root.right = insert(root.right, data);
//        }
//        return root;
//    }
//
//    void preOrder(Node node){
//        if(node == null){
//            return;
//        }
//        System.out.print(node.data + " ");
//        preOrder(node.left);
//        preOrder(node.right);
//    }
//
//    void inOrder(Node node){
//        if(node == null){
//            return;
//        }
//        inOrder(node.left);
//        System.out.print(node.data + " ");
//        inOrder(node.right);
//    }
//
//    void postOrder(Node node){
//        if(node == null){
//            return;
//        }
//        postOrder(node.left);
//        postOrder(node.right);
//        System.out.print(node.data + " ");
//    }
//
//    int size(Node node){
//        int count = 0;
//        if(node != null){
//            count = 1 + size(node.left) + size(node.right);
//        }
//        return count;
//    }
//    // return -1;
//    int height(Node node){
//        int height = 0;
//        if(node == null){
//            return -1;
//        }else{
//            height = 1 + Math.max(height(node.left), height(node.right));
//        }
//        return height;
//    }
//
//    void mirror(Node node){
//        if(node == null){
//            return;
//        }else{
//            Node tmp;
//
//            mirror(node.left);
//            mirror(node.right);
//
//            tmp = node.left;
//            node.left = node.right;
//            node.right = tmp;
//        }
//    }
//
//    int sumOfWeight(Node node){
//        int sow = 0;
//        if(node != null){
//            sow = node.data + sumOfWeight(node.left) + sumOfWeight(node.right);
//        }
//        return sow;
//    }
//
//    int maxPathWeight(Node node){
//        int mpw = 0;
//        if(node != null){
//            mpw = node.data + Math.max(maxPathWeight(node.left), maxPathWeight(node.right));
//        }
//        return mpw;
//    }
//}
