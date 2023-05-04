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
public class Level2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> vertices[];
        System.out.println("Enter the number of vertices");
        int n = sc.nextInt();
        vertices = new ArrayList[n];
        int[] l1 = new int[n];
        int[] l2 = new int[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new ArrayList<Integer>();
        }
        System.out.println("Enter the number of edges");
        int edges = sc.nextInt();
        for (int i = 0; i < edges; i++) {
            int y = sc.nextInt();
            int z = sc.nextInt();
            vertices[y].add(z);
            vertices[z].add(y);
        }

        System.out.println("Enter Lina's position");
        int x = sc.nextInt();
        System.out.println("Enter Nora's position");
        int y = sc.nextInt();
        System.out.println("Enter Lara's position");
        int z = sc.nextInt();
        bfs(vertices, l1, y);
        bfs(vertices, l2, z);
        if (l1[x] > l2[x]) {
            System.out.println("Lara");
        } else if (l1[x] < l2[x]) {
            System.out.println("Nora");
        } else {
            System.out.println("Nora, Lara");
        }
    }

    static void bfs(ArrayList<Integer> vertices[], int level[], int n) {
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
