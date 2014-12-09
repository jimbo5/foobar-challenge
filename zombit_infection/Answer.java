import java.util.ArrayList;
import java.util.Random;

public class Answer {
	private static int xbound, ybound;
	/**
	 * 
	 * @param population A 2D non-empty array of positive integers.
	 * @param x The X-Coordinate (column) of "Patient Z" in the population array.
	 * @param y The Y-Coordinate (row) of "Patient Z" in the population array.
	 * @param strength A constant integer value representing the Strength of the virus.
	 * @return int[][] A 2D non-empty array of positive integers that have been infected.
	 */
	public static int[][] answer(int[][] population, int x, int y, int strength) {
		//Print the original 2d array
		printGrid(population);
		System.out.println();
		// Check if patient Z can be infected.
		if (population[y][x] > strength) {
			return population;
		} else {
			//set the bounds of 2dArray
			xbound = population[0].length;
			ybound = population.length;
			//spread the infection based on the initial values
			return spreadInfection(population, x, y, strength);
		}
	}

	/**
	 * spreadInfection. 
	 * @param array A 2D non-empty array of positive integers.
	 * @param x The X-Coordinate (column) of "Patient Z" in the population array.
	 * @param y The Y-Coordinate (row) of "Patient Z" in the population array.
	 * @param strength  A constant integer value representing the Strength of the virus.
	 * @return int[][] A 2D non-empty array of positive integers that have been infected. 
	 */
	static int[][] spreadInfection(int[][] array, int x, int y, int strength) {
		//create an arrayList to hold our visited co-ordinates.
		ArrayList<String> positionsList = new ArrayList<String>();
		//add the starting co-ordinates to the array that holds positions to visit.
		positionsList.add("" + x + " " + y);
		int[][] pop = (int[][]) array.clone();
		for (int i = 0; i < positionsList.size(); i++) {
			String[] positionsToVisit = positionsList.get(i).split("\\s+");
			int xToVisit = Integer.parseInt(positionsToVisit[0]);
			int ytoVisit = Integer.parseInt(positionsToVisit[1]);

			if (pop[ytoVisit][xToVisit] <= strength) {
				pop[ytoVisit][xToVisit] = -1;

				//check adjacent cells to see are they in bounds and susceptible to infection.
				if (xToVisit - 1 >= 0
						&& !positionsList.contains("" + (xToVisit - 1) + " "
								+ ytoVisit)) {
					positionsList.add("" + (xToVisit - 1) + " " + ytoVisit);
				}
				//check right cell
				if (xToVisit + 1 < xbound
						&& !positionsList.contains("" + (xToVisit + 1) + " "
								+ ytoVisit)) {
					positionsList.add("" + (xToVisit + 1) + " " + ytoVisit);
				}
				if (ytoVisit - 1 >= 0
						&& !positionsList.contains("" + xToVisit + " "
								+ (ytoVisit - 1))) {
					positionsList.add("" + xToVisit + " " + (ytoVisit - 1));
				}
				if (ytoVisit + 1 < ybound
						&& !positionsList.contains("" + xToVisit + " "
								+ (ytoVisit + 1))) {
					positionsList.add("" + xToVisit + " " + (ytoVisit + 1));
				}
			}
		}
		//return the new infected array. 
		return pop;
	}
	
	public static void main(String[] args) {
		int[][] population = new int[][] { { 0, 0, 10, 0, 0, 0, 0 },
				{ 6, 3, 1, 4, 7, 0, 0 }, { 1, 2, 4, 10, 10, 0, 0 },
				{ 0, 2, 10, 9, 10, 0, 0 }, { 8, 1, 1, 10, 9, 0, 0 } };
		int x = 0;
		int y = 0;
		int str = 5;
		printGrid(answer(population, x, y, str));
	}

	public static void printGrid(int[][] output) {
		int x = output[0].length;
		int y = output.length;
		for (int i = 0; i < y; i++) {
			System.out.print('\n');
			for (int j = 0; j < x; j++) {
				System.out.print('[');
				System.out.print(output[i][j]);
				System.out.print(']');
			}
		}
	}
}