/*Sedak Puri
 * Muhammed Albow
 * Assignment 3
 * CS-3
 */
import java.awt.Point;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.text.Position;

public class Forest {
	private int[][] trees;
	private int height;
	private int width;

	/**
	 * Constructor
	 * @param height is the height of the array
	 * @param width is the width of the array
	 * @param d is the density 
	 */
	public Forest(int height, int width, double d) {
		this.height = height;
		this.width = width;
		trees = new int[height][width];

		Random rng = new Random();
		//Generate a value for each cell and compare it to d. 
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				trees[i][j] = (rng.nextDouble() <= d) ? 1: 0;
			}
		}
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				result += trees[i][j] + " ";
			}
			result += "\n";
		}
		return result;
	}

	/**
	 * Method to model the spread of a forest fire using depth first
	 * @return boolean if search was true
	 */
	public boolean depthFirstSearch() {
		Stack<Point> cellsToExplore = new Stack<>();								
		for(int i = 0; i < width; i++) {
			if (trees[0][i] == 1) {
				cellsToExplore.push(new Point(0 , i));	
				trees[0][i] = 2;
			} 
		}

		while(!cellsToExplore.isEmpty()) {
			Point currentPosition = cellsToExplore.pop();
			//Reaching the bottom
			if (currentPosition.getX() == height - 1) 
				return true;

			//Checking the neighbors
			int x = (int) currentPosition.getX();
			int y = (int) currentPosition.getY();
			if ((y != (width - 1)) && trees[x][y + 1] == 1) {
				cellsToExplore.push(new Point(x, y + 1));
				trees[x][y + 1] = 2;
			}    
			if ((y > 0) && trees[x][y - 1] == 1) {
				cellsToExplore.push(new Point(x, y - 1));
				trees[x][y - 1] = 2;
			}
			if ((x != (height - 1)) && trees[x + 1][y] == 1) {
				cellsToExplore.push(new Point(x + 1, y));
				trees[x + 1][y] = 2;
			}
		}
		return false;
	}

	/**
	 * Method to model the spread of a forest fire using breath first
	 * @return boolean if search was true
	 */
	public boolean breadthFirstSearch() {
		Queue<Point> cellsToExplore = new LinkedBlockingQueue<>();							
		for(int i = 0; i < width; i++) {
			if (trees[0][i] == 1) {
				cellsToExplore.add(new Point(0 , i));	
				trees[0][i] = 2;
			} 
		}    

		while(!cellsToExplore.isEmpty()) {
			Point currentPosition = cellsToExplore.remove();
			//Reaching the bottom
			if (currentPosition.getX() == height - 1) 
				return true;

			int x = (int) currentPosition.getX();
			int y = (int) currentPosition.getY();
			if ((y != (width - 1)) && trees[x][y + 1] == 1) {
				cellsToExplore.add(new Point(x, y + 1));
				trees[x][y + 1] = 2;
			}    
			if ((y > 0) && trees[x][y - 1] == 1) {
				cellsToExplore.add(new Point(x, y - 1));
				trees[x][y - 1] = 2;
			}
			if ((x != (height - 1)) && trees[x + 1][y] == 1) {
				cellsToExplore.add(new Point(x + 1, y));
				trees[x + 1][y] = 2;
			}
		}
		return false;
	}
}
