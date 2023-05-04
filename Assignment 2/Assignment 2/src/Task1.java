/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ShamimMSAS7
 */
import java.util.*;

public class Task1 {

    static int graph[][];
    static int[] d;
    static String p[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        graph = new int[v][v];
        d = new int[v];
        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cost = sc.nextInt();
            graph[x][y] = cost;
        }
        dijkstra(graph, 0);
    }

    static void dijkstra(int[][] g, int s) {
        for (int i = 0; i < g.length; i++) {
            d[i] = Integer.MAX_VALUE;
            p[i] = "null";
        }
        d[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(g.length, new Node);

    }
}

class Node {
  
}
