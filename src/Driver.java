/*Sedak Puri
 * Muhammed Albow
 * Assignment 3
 * CS-3
 */
public class Driver {
	public static void main(String[] args) {
		/*
		After running both methods, the depth first method runs approximately 1 second faster than the breadth first searching method 
		(runtime of 3065msvs a runtime of 2122ms approximately respectively). This can be atributed to the implementations of such 
		methods, where the depth first method attempts to find the exit at the bottom by continually trying to search downward. The 
		breadth first method however attempts to find the exit by expanding a "radius" and testing all directions of trees until it
		eventually tests one on the edge.
		
		 */


		//Display

		//		//DFS Search
		//		Forest f = new Forest(20 , 20, .6);
		//		System.out.println("Original:\n" + f);
		//		boolean found = f.depthFirstSearch();
		//		System.out.println("DFS: " + found + "\n" + f);
		//
		//		//BFS Search
		//		Forest a = new Forest(20 , 20, .6);
		//		System.out.println("Original:\n" + a);
		//		found = a.breadthFirstSearch();
		//		System.out.println("DFS: " + found + "\n" + a);

		//Testing run-times for the BFS
		long start = System.currentTimeMillis();
		double densityBFS = FireProbability.highestDensityBFS();
		long end = System.currentTimeMillis();
		long highestDensityTimeBFS = end - start;

		System.out.println("Highest Density of Fire Speading less than 50% chance (BFS): " + densityBFS + "\nRuntime (BFS): " + (highestDensityTimeBFS));
		System.out.println("Probability of Fire Spreading at this highest density (BFS): " + FireProbability.probabilityOfFireSpreadBFS(densityBFS));
		System.out.println("");

		//Testing run-times for the DFS
		start = System.currentTimeMillis();
		double densityDFS = FireProbability.highestDensityDFS();
		end = System.currentTimeMillis();
		long highestDensityTimeDFS = end - start;

		System.out.print("Highest Density of Fire Speading less than 50% chance (DFS): " + densityDFS + "\nRuntime (DFS): " + (highestDensityTimeDFS));
		System.out.println("\nProbability of Fire Spreading at this highest density (DFS): " + FireProbability.probabilityOfFireSpreadDFS(densityDFS));
	}
}

