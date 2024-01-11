package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;


public class ShortestPathDijkstra {
    static List<AdjLinkedList> linkedList;
    static int[] weight;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numTestCase = Integer.parseInt(br.readLine());
        while (numTestCase-- > 0) {
            linkedList = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            weight = new int[n+1];
            Arrays.fill(weight, Integer.MAX_VALUE);
            visited  = new boolean[n+1];
            int k = n;
            while (k-- > 0) {
                String[] tmp = br.readLine().split(" ");
                List<Integer> num = new ArrayList<>();

                for (int i = 0; i < tmp.length; i++) {
                    num.add(Integer.parseInt(tmp[i]));
                }
                addList(num);
            }

            dijkstra(n);
            int sum = 0;
            for (int i = 1; i < n+1; i++) {
                sum += weight[i];
            }
            bw.write(sum + "\n");
            bw.flush();
        }
    }

    static void addList(List<Integer> num) {
        AdjLinkedList list = new AdjLinkedList();
        for (int i = 2; i < num.size(); i += 2) {
            list.insertNode(num.get(i), num.get(i+1));
        }
        linkedList.add(list);
    }

    static void dijkstra(int n) {
        PriorityQueue<PqFormat> pq = new PriorityQueue<>();
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new PqFormat(1,0));
        distance[1] = 0;
        weight[1] = 0;

        while (!pq.isEmpty()) {
            PqFormat now = pq.poll();

            if (visited[now.index]) {
                continue;
            }

            visited[now.index] = true;
            Node node = linkedList.get(now.index-1).head;
            while (node != null) {
                if (distance[node.number] > distance[now.index] + node.weight) {
                    if (weight[node.number] > node.weight) {
                        weight[node.number] = node.weight;
                    }
                    distance[node.number] = distance[now.index] + node.weight;
                    pq.add(new PqFormat(node.number, distance[node.number]));
                }
                node = node.next;
            }
        }
    }
}
class PqFormat implements Comparable<PqFormat>{
    int index, dist;
    PqFormat(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(PqFormat o) {
        // dist 기준 오름차순 정렬
        return this.dist - o.dist;
    }
}

class Node {
    int number;
    int weight;
    Node next;

    Node(int number, int weight) {
        this.number = number;
        this.weight = weight;
        this.next = null;
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
