
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ShamimMSAS7
 */
public class Level4 {

    static ArrayList<Integer> vertices[];

    public static void main(String[] args) {
        Scanner msas = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int x = msas.nextInt();
        vertices = new ArrayList[x];
        for (int i = 0; i < x; i++) {
            vertices[i] = new ArrayList<Integer>();
        }
        System.out.println("Enter the number of edges");
        int edges = msas.nextInt();
        for (int i = 0; i < edges; i++) {
            int y = msas.nextInt();
            int z = msas.nextInt();
            vertices[z].add(y);//creating indegree list
        }
        int count = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].isEmpty()) {
                System.out.println(i);
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("There exists no vertex that doesn't have any dependency");
        }
    }
}
