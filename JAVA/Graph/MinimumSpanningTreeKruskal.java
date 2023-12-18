package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTreeKruskal {
    static PriorityQueue<Edge> priorityQueue;
    static int[] parent;
    static int finalWeight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numTestCase = Integer.parseInt(br.readLine());
        while (numTestCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            priorityQueue = new PriorityQueue<>();
            parent = new int[n+1];
            for (int i = 1; i < n+1; i++) {
                parent[i] = i;
            }
            finalWeight = 0;

            while (n-- > 0) {
                String[] tmp = br.readLine().split(" ");
                List<Integer> num = new ArrayList<>();

                for (int i = 0; i < tmp.length; i++) {
                    num.add(Integer.parseInt(tmp[i]));
                }
                makeGraph(num);
            }
            kruskal();

            bw.write(finalWeight + "\n");
            bw.flush();
        }
    }

    static void makeGraph(List<Integer> num) {
        for (int i = 2; i < num.size(); i += 2) {
            priorityQueue.offer(new Edge(num.get(0), num.get(i), num.get(i+1)));
        }
    }

    static void kruskal() {
        while(!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();

            if(find(edge.nodeNumber1) != find(edge.nodeNumber2)) {
                union(edge.nodeNumber1, edge.nodeNumber2);
                finalWeight += edge.weight;
            }
        }
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX > rootY) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
        }

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
}

class Edge implements Comparable<Edge>{
    int nodeNumber1;
    int nodeNumber2;
    int weight;

    public Edge(int nodeNumber1, int nodeNumber2, int weight) {
        this.nodeNumber1 = nodeNumber1;
        this.nodeNumber2 = nodeNumber2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return weight - e.weight;
    }
}