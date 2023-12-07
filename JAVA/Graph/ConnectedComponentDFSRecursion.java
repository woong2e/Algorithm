package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConnectedComponentDFSRecursion {
    static int cntConnectedComponent;
    static int[] cntNode;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        while (testCase-- != 0) {
            int countNode = sc.nextInt();
            List<AdjLinkedList> headList = new ArrayList<>();
            boolean[] mark = new boolean[countNode+1];
            cntNode = new int[countNode+1];
            cntConnectedComponent = 0;
            makeHeadList(countNode, headList);
            for (int i = 1; i <= countNode; i++) {
                DFS(i,i, 1, headList, mark);

            }
            print(countNode, cntNode);
        }
    }

    static void makeHeadList(int countNode, List<AdjLinkedList> headList) {
        Scanner sc = new Scanner(System.in);
        while (countNode-- > 0) {
            AdjLinkedList linkedList = new AdjLinkedList();
            int num = sc.nextInt();
            linkedList.insertNode(num);
            int m = sc.nextInt();
            while (m-- > 0) {
                linkedList.insertNode(sc.nextInt());
            }
            headList.add(linkedList);
        }
    }

    static void DFS(int vertex,int cntIdx, int startNumber, List<AdjLinkedList> headList, boolean[] mark) {
        if (mark[vertex]) {
            return;
        }
        if (startNumber == 1) {
            cntConnectedComponent++;
        }
        mark[vertex] = true;
        cntNode[cntIdx]++;
        Node tmpNode = headList.get(vertex - 1).head.next;
        while (tmpNode != null) {
            DFS(tmpNode.number, cntIdx, 0,  headList, mark);
            tmpNode = tmpNode.next;
        }
    }

    static void print(int countNode, int[] cntNode) {
        Arrays.sort(cntNode);

        System.out.println(cntConnectedComponent + " ");
        for(int i = 1; i <= countNode; i++) {
            if (cntNode[i] > 0) {
                System.out.print(cntNode[i] + " ");
            }
        }
        System.out.println();
    }
}

class Node {
    int number;
    Node next;

    Node(int number) {
        this.number = number;
        this.next = null;
    }
}

class AdjLinkedList {
    Node head;

    AdjLinkedList() {
        head = null;
    }

    void insertNode(int num) {
        Node newNode  = new Node(num);
        if (head == null) {
            this.head = newNode ;
        } else {
            Node tmpNode = head;
            while (tmpNode.next != null) {
                tmpNode = tmpNode.next;
            }
            tmpNode.next = newNode;
        }
    }
}

