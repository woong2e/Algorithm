package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTreePrim {
    static PriorityQueue<Node> priorityQueue;
    static List<AdjLinkedList> linkedLists;
    static boolean[] visited;
    static int finalWeight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numTestCase = Integer.parseInt(br.readLine());
        while (numTestCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            priorityQueue = new PriorityQueue<>();
            linkedLists = new ArrayList<>();
            visited = new boolean[n+1];
            finalWeight = 0;

            while (n-- > 0) {
                String[] tmp = br.readLine().split(" ");
                List<Integer> num = new ArrayList<>();

                for (int i = 0; i < tmp.length; i++) {
                    num.add(Integer.parseInt(tmp[i]));
                }
                makeGraph(num);
            }
            prim();

            bw.write(finalWeight + "\n");
            bw.flush();
        }
    }

    static void makeGraph(List<Integer> num) {
        AdjLinkedList list = new AdjLinkedList();
        list.insertNode(num.get(0), 0);
        for (int i = 2; i < num.size(); i += 2) {
            list.insertNode(num.get(i), num.get(i+1));
        }
        linkedLists.add(list);

    }

    static void prim() {
        Node node = linkedLists.get(0).head;
        priorityQueue.offer(node);
        do {
            node = priorityQueue.poll();
            if (visited[node.adjVertex]) {
                continue;
            }
            visited[node.adjVertex] = true;
            finalWeight += node.weight;

            node = linkedLists.get(node.adjVertex-1).head;
            while (node != null) {
                if (!visited[node.adjVertex]) {
                    priorityQueue.offer(node);
                }
                node = node.next;
            }
        }
        while (!priorityQueue.isEmpty());
    }
}

class Node implements Comparable<Node> {
    int adjVertex;
    int weight;
    Node next;

    Node(int vertex, int weight) {
        this.adjVertex = vertex;
        this.weight = weight;
        this.next = null;
    }

    @Override
    public int compareTo(Node n) {
        return weight - n.weight;
    }
}

class AdjLinkedList {
    Node head;

    AdjLinkedList() {
        head = null;
    }

    void insertNode(int num, int weight) {
        Node newNode  = new Node(num, weight);
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