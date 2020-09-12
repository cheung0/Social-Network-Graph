package a3;

import static org.junit.Assert.assertEquals;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * This class is used for undirected graphs represented as adjacency lists
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


	public static void BFStraversal(int start) {
		/**
		 * Not needed for now
		 */
	}

	public static void main(String[] args) {
		createAdjacencyList();
		/**
		 * These test cases assume the file 3980.edges was used
		 */
		System.out.println("Testing...");
		assertEquals(areFriends(4038, 4014), true);
		System.out.println("1 of 7");

		System.out.println("Testing...");
		assertEquals(areFriends(3982, 4037), true);
		System.out.println("2 of 7");

		System.out.println("Testing...");
		assertEquals(areFriends(4030, 4017), true);
		System.out.println("3 of 7");

		System.out.println("Testing...");
		assertEquals(areFriends(4030, 1), false);
		System.out.println("4 of 7");

		System.out.println("Testing...");
		assertEquals(areFriends(1, 4030), false);
		System.out.println("5 of 7");

		System.out.println("Testing...");
		assertEquals(areFriends(4003, 3980), true);
		System.out.println("6 of 7");
		
		System.out.println("Testing...");
		assertEquals(areFriends(3985, 4038), false);
		System.out.println("7 of 7");
		System.out.println("Success!");
	}

}
