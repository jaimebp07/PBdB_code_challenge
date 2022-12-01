package code_challenge_two;

public class ChallengeTwo {

	private byte s = 6;

	public ChallengeTwo() {
		int[] initialArray =  {-10, 10};
		int[]  initialArrayorder = makeSureOrder(initialArray);
		int[] arraySqueares = calculateSqueares(initialArrayorder);
		int ss = Integer.parseInt(s+""+s);
		int[] arrayRemoveGreater = removeGreaterSS(arraySqueares, ss);
		int[] finalArray = makeSureOrder(arrayRemoveGreater);
		showArray("Resultado: ", finalArray);
	}

	/**
	 * returns a vector without numbers greater than ss
	 * @param arraySqueares
	 * @param ss
	 * @return
	 */
	private int[] removeGreaterSS(int[] arraySqueares, int ss) {
		int countRemove = countNumberRemove(arraySqueares, ss);
		int[] newArray = new int[arraySqueares.length-countRemove];
		int alwaysRemove = 0;
		for (int i = 0; i < arraySqueares.length; i++) {
			if(arraySqueares[i] > ss) {
				alwaysRemove++;
			} else {
				newArray[i-alwaysRemove] = arraySqueares[i];
			}
		}
		return newArray ;
	}

	/**
	 * calculate how many numbers to eliminate
	 * @param arraySqueares
	 * @param ss
	 * @return
	 */
	private int countNumberRemove(int[] arraySqueares, int ss) {
		int countRemove = 0;
		for (int i = 0; i < arraySqueares.length; i++) {
			if(arraySqueares[i] > ss) {
				countRemove ++;
			}
		}
		return countRemove;
	}

	/**
	 * Calculate the squares of the numbers in the original array and return it
	 * @param initialArray
	 * @return 
	 */
	private int[] calculateSqueares(int[] initialArray) {
		int[] newArray = new int[initialArray.length];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = initialArray[i] * initialArray[i];
		}
		return newArray;
	}

	/**
	 * This method is responsible for verifying that a matrix is ​​in ascending order,
	 *  if it is not, it performs the respective ordering
	 * @param analysis_matrix
	 * @return
	 */
	private int[] makeSureOrder(int[]  analysis_matrix) {
		for (int i = 1; i < analysis_matrix.length; i++) {
			if(analysis_matrix[i] < analysis_matrix[i-1]) {
				int temp_a = analysis_matrix[i];
				analysis_matrix[i] = analysis_matrix[i-1];
				analysis_matrix[i-1] = temp_a;
				i = 0;
			}
		}
		return analysis_matrix;
	}

	/**
	 * prints a vector to the console and a message describing this vector
	 * @param message
	 * @param showArray
	 */
	private void showArray(String message, int[] showArray) {
		System.out.println("\n"+message);
		for (int i = 0; i < showArray.length; i++) {
			System.out.print(showArray[i]+ ", ");
		}
	}

	public static void main(String[] args) {
		new ChallengeTwo();
	}
}