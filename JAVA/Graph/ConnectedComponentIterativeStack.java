package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ConnectedComponentIterativeStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        while (testCase-- != 0) {
            int countNode = sc.nextInt();
            List<AdjLinkedList> headList = new ArrayList<>();
            makeHeadList(countNode, headList);
            DFS(countNode, headList);
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

    static void DFS(int countNode, List<AdjLinkedList> headList) {
        Stack<Integer> stack = new Stack<>();
        boolean[] mark = new boolean[countNode+1];
        int cntConnectedComponent = 0;
        int[] cntNode = new int[countNode+1];

        for(int i = 1; i <= countNode; i++) {
            if (!mark[i]) {
                mark[i] = true;
                stack.push(i);

                while (!stack.isEmpty()) {
                    int tmp = stack.pop();
                    cntNode[i]++;

                    Node tmpNode = headList.get(tmp-1).head;
                    while (tmpNode != null) {
                        tmp = tmpNode.number;
                        if (!mark[tmp]) {
                            mark[tmp] = true;
                            stack.push(tmp);
                        }
                        tmpNode = tmpNode.next;
                    }
                }
                cntConnectedComponent++;
            }
        }
        Arrays.sort(cntNode);

        System.out.print(cntConnectedComponent + " ");
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
