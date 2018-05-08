/*Sedak Puri
 * Muhammed Albow
 * Assignment 3
 * CS-3
 */
public class FireProbability {
	/**
	 * Method to return the highest probability of the depth first search.
	 * @param d is the density
	 * @return highest probability
	 */
	public static double probabilityOfFireSpreadDFS(double d) {
		int fireSpreadCount = 0;

		//Running 10000 times
		for (int i = 0; i < 10000; i++) {
			Forest frst = new Forest(20,20,d);
			if (frst.depthFirstSearch() == true) {
				fireSpreadCount++;
			}
		}

		return ((double)fireSpreadCount/10000);
	}

	/**
	 * Method to return the highest probability of breath first search
	 * @param d is the density
	 * @return highest probability
	 */
	public static double probabilityOfFireSpreadBFS(double d) {
		int fireSpreadCount = 0;

		//Running 10000 times
		for (int i = 0; i < 10000; i++) {
			Forest frst = new Forest(20,20,d);
			if (frst.breadthFirstSearch() == true) {
				fireSpreadCount++;
			}
		}

		return ((double)fireSpreadCount/10000);
	}

	/**
	 * Method to determine the highest density in which the probability of the forest fire spreading would be less than 50% (using DFS)
	 * @return highest density
	 */
	public static double highestDensityDFS() {
		double density = 0, 
				lowDensity = 0.0,
				highDensity = 1.0,
				p;

		for (int i = 0; i < 20; i++) {
			//Checking midpoint
			density = (highDensity + lowDensity) / 2.0;

			// get probability of fire spreading in forests of 'density'
			p = probabilityOfFireSpreadDFS(density);

			//Computing the highest density that results in fire spreading
			if (p < 0.5) {
				lowDensity = density;
			} else {
				highDensity = density;
			}

		}
		return highDensity;
	}

	/**
	 * Method to determine the highest density in which the probability of the forest fire spreading would be less than 50% (using BFS)
	 * @return highest density
	 */
	public static double highestDensityBFS() {
		double density = 0, 
				lowDensity = 0.0,
				highDensity = 1.0,
				p;

		for (int i = 0; i < 20; i++) {
			//Checking midpoint
			density = (highDensity + lowDensity) / 2.0;

			// get probability of fire spreading in forests of 'density'
			p = probabilityOfFireSpreadBFS(density);

			//Computing the highest density that results in fire spreading
			if (p < 0.5) {
				lowDensity = density;
			} else {
				highDensity = density;
			}

		}
		return highDensity;
	}
}
