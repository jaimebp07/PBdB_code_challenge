package code_challenge_three;

public class ChallengeThree {

	public ChallengeThree() {
		//		int[] initialArray =  {5, 7, 1, 1, 2, 3, 22};
		//		int[] initialArray = { 1, 5, 1, 1, 1, 10, 15, 20, 100 };
		//		int[] initialArray = {1, 1, 1, 1, 1};
//		int[] initialArray = {1, 3, 3, 6, 7};
		//		int[] initialArray = { 3, 2, 5, 6, 7 };
		int[] initialArray = {1, 2, 3, 8};
		
		int[] arraySureOrder = makeSureOrder(initialArray);
		showArray("ordenado", arraySureOrder);

		int result = findSmallestMissingChange(arraySureOrder);
		System.out.println("result "+ result);
	}

	/**
	 * El método se encarga de analizar una matriz y encontrar el cambio más pequeño que es 
	 * imposible de devolver, solo funciona con una matriz ordenada de forma ascendente.
	 * @param arraySureOrder
	 * @return
	 */
	private int findSmallestMissingChange(int[] arraySureOrder) {
		int minimumChangePossible = 1;
		int cumulativeChange = arraySureOrder[0] +  arraySureOrder[1];
		if(arraySureOrder[0] == minimumChangePossible) {
			minimumChangePossible = 0;
			if((arraySureOrder[0] + 1) < arraySureOrder[1]) {
				return arraySureOrder[0] + 1;
			} else {
				for (int i = 2; i < arraySureOrder.length; i++) {
					if( (cumulativeChange +1) < arraySureOrder[i]) {
						return cumulativeChange +1;
					} else {
						cumulativeChange += arraySureOrder[i];
					}
				}
			}
			return cumulativeChange + 1;
		} else {
			return minimumChangePossible;
		}
	}

	/**
	 * This method is responsible for verifying that a matrix is ​​in ascending
	 * order, if it is not, it performs the respective ordering
	 * 
	 * @param analysis_matrix
	 * @return
	 */
	private int[] makeSureOrder(int[] analysis_matrix) {
		for (int i = 1; i < analysis_matrix.length; i++) {
			if (analysis_matrix[i] < analysis_matrix[i - 1]) {
				int temp_a = analysis_matrix[i];
				analysis_matrix[i] = analysis_matrix[i - 1];
				analysis_matrix[i - 1] = temp_a;
				i = 0;
			}
		}
		return analysis_matrix;
	}

	/**
	 * prints a vector to the console and a message describing this vector
	 * 
	 * @param message
	 * @param showArray
	 */
	private void showArray(String message, int[] showArray) {
		System.out.println("\n" + message);
		for (int i = 0; i < showArray.length; i++) {
			System.out.print(showArray[i] + ", ");
		}
	}

	public static void main(String[] args) {
		new ChallengeThree();
	}
}
