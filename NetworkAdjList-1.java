package a4;

import static org.junit.Assert.assertEquals;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/**
 * CS146 Assignment 3 Node class 
 * This class is used for undirected graphs represented as adjacency lists
 * Class contains a breadth first search traversal method that needs to be implemented. 
 * It tells the distance that the 3980 person is from other nodes connected to it.
 * @author Michael Cheung
 * Student id: 014373619
 *
 */

public class NetworkAdjList {
	//initialize variables
	static int max_num_vertices = 5000;
	static LinkedList<Integer>[] adjacencyList = new LinkedList[max_num_vertices];

	// create an adjacency list representation of a graph in java
	public static void createAdjacencyList() {
		//initialize array elements(objects of LinkedList)
		for (int j=0; j<max_num_vertices; j++)
		    adjacencyList[j] = new LinkedList<Integer>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("3980.edges"));
			while (br.ready()) {
				//turns each line of input into a string array 
				//convert each element of the array into an integer, in this case there are two elements
				String in = br.readLine();
				String[] str = new String[2];  
				str = in.split(" ");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				//index of my array at position a has a value of b
				adjacencyList[a].add(b);
			}
		} catch (Exception e) {
			//prints out useful exception message
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean areFriends(int A, int B) {
		if(adjacencyList[A].contains(B)) {
			return true;
		}
		
		
		
		return false;
	}


	public static void BFStraversal(int start) 
    { 
        // make a boolean visited array
		// all values initialized with false
        boolean visited[] = new boolean[5000]; 
  
        // make a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // make start vertex as visited by setting it to true
        // add start vertex into queue
        visited[start] = true; 
        queue.add(start); 
        int level = 0;

        // while queue is non empty
        while (!queue.isEmpty()) 
        { 
            // dequeue top element from queue
            int s = queue.poll(); 
            System.out.println(s + " is at a distance of " + level + " from 3980.");
            
            // iterate through adjacent vertices of vertex s
            // if adjacent vertex is not visited, then enqueue it and mark it as visited  
            // increment level for each level
            Iterator<Integer> iterate = adjacencyList[start].listIterator(); 
            while (iterate.hasNext()) 
            { 
                int nextVisited = iterate.next(); 
                if (!visited[nextVisited]) 
                { 
                    visited[nextVisited] = true; 
                    queue.add(nextVisited);
                } 
            }
            level ++;
        } 
    } 

	public static void main(String[] args) {
		createAdjacencyList();

		BFStraversal(3980);
		
	}

}
