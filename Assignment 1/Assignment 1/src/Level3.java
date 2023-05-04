/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author ShamimMSAS7
 */
public class Level3 {

    static int[] level;
    static ArrayList<Integer> vertices[];

    public static void main(String[] args) {
        Scanner msas = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int x = msas.nextInt();
        level = new int[x];
        vertices = new ArrayList[x];
        for (int i = 0; i < x; i++) {
            vertices[i] = new ArrayList<Integer>();
        }
        System.out.println("Enter the number of edges");
        int edges = msas.nextInt();
        for (int i = 0; i < edges; i++) {
            int y = msas.nextInt();
            int z = msas.nextInt();
            vertices[z].add(y); // creating indegree list
        }
        System.out.println("Enter Lina's position");
        int n = msas.nextInt();
        bfs(vertices, n);
        System.out.println("Enter the number of participants");
        int m = msas.nextInt();
        int min = 9999;
        for (int i = 0; i < m; i++) {
            int o = msas.nextInt();
            if (level[o] < min) {
                min = level[o];
            }
        }
        if (min != 9999) {
            System.out.println("Minimum number of moves the winner needs is "+min);
        } else {
            System.out.println("There is no warrior who can kill Lina");
        }
    }

    static void bfs(ArrayList<Integer> vertices[], int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        for (int i = 0; i < level.length; i++) {
            level[i] = 9999;
        }
        level[n] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int i = 0; i < vertices[x].size(); i++) {
                int y = vertices[x].get(i);
                if (level[y] == 9999) {
                    q.add(y);
                    level[y] = level[x] + 1;
                }
            }
        }
    }

}
