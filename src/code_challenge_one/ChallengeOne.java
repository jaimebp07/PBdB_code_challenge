package code_challenge_one;


public class ChallengeOne {

	private static final int S = 6;
	public ChallengeOne() {
//		int[] initialArray =  {1, 2, 3, 4, 5, 6};
//		int[] initialArray =  {10, 20, 30, 40};
//		int[] initialArray =  {6};
//		int[] initialArray =  {66};
//		int[] initialArray =  {6, 2, 1};
//		int[] initialArray =  {60, 6, 5, 4, 3, 2, 7, 7, 29, 1};
		int[] initialArray =  {60, 6, 5, 66, 4, 3, 2, 7, 7, 29, 1};
		showArray("Array inicial: ", initialArray);
		int[] arrayPositionChange = changePosition(initialArray);
		showArray("arrayPositionChange: ", arrayPositionChange);
		int[] arrayRemoveNumberEquals = removeNumberEquals(arrayPositionChange);
		int[] arrayRemoveAllsEquals = removeAllsEquals(arrayRemoveNumberEquals);
		int[] arrayRemoveSomeDigitEquals = removeSomeDigitEquals(arrayRemoveAllsEquals);
		showArray("Resultado: ", arrayRemoveSomeDigitEquals);
		
	}

	/**
	 * leaves the array with the positions inverted
	 * @param initialArray
	 * @return
	 */
	private int[] changePosition(int[] initialArray) {
		int lastPositionArray = initialArray.length -1;
		int[] newArray = new int[initialArray.length];
		for (int i = 0; i < initialArray.length; i++) {
			 newArray[i] = initialArray[lastPositionArray - i];
			 newArray[lastPositionArray-i] = initialArray[i];
		}
		return newArray;
	}

	/**
	 * @param arrayRemoveAllsEquals
	 * @return
	 */
	private int[] removeSomeDigitEquals(int[] arrayRemoveAllsEquals) {
		for (int i = 0; i < arrayRemoveAllsEquals.length; i++) {
			if( ifSomeDigitsEquals( arrayRemoveAllsEquals[i]) ) {
				arrayRemoveAllsEquals[i] = newNumber(arrayRemoveAllsEquals[i]);
			} else {
				arrayRemoveAllsEquals[i] = arrayRemoveAllsEquals[i];
			}
		}
		return arrayRemoveAllsEquals;
	}

	private int newNumber(int number) {
		String 	numberString = String.valueOf(number);
		String newNumber = "";
		for (int i = 0; i < numberString.length(); i++) {
			if(numberString.charAt(i) < String.valueOf(S).charAt(0)) {
				newNumber += numberString.charAt(i);
			}
		}
		return Integer.parseInt(newNumber);
	}

	/**
	 * The method recognizes if a number has any digit equal to S
	 * @param i
	 * @return
	 */
	private boolean ifSomeDigitsEquals(int number) {
		String 	numberString = String.valueOf(number);
		for (int i = 0; i < numberString.length(); i++) {
			if(numberString.charAt(i) >= String.valueOf(S).charAt(0)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * the method returns an array without the numbers that have all digits equal to S
	 * @param arrayRemoveNumberEquals
	 * @return
	 */
	private int[] removeAllsEquals(int[] arrayRemoveNumberEquals) {
		int countAllDigitsEquals = identifyAllDigitsEquals(arrayRemoveNumberEquals);
		int[] newArray = new int[arrayRemoveNumberEquals.length - countAllDigitsEquals];
		int countAlwaysEquals = 0;
		for (int i = 0; i < arrayRemoveNumberEquals.length; i++) {
			if( ifAllDigitsEquals( arrayRemoveNumberEquals[i]) ) {
				countAlwaysEquals++;
			} else {
				newArray[i-countAlwaysEquals] = arrayRemoveNumberEquals[i];
			}
		}
		return newArray;
	}

	/**
	 * goes through the array to identify if all the simultaneity of all digits with S
	 * @param arrayRemoveNumberEquals
	 * @return
	 */
	private int identifyAllDigitsEquals(int[] arrayRemoveNumberEquals) {
		int countNumberEquals = 0;
		for (int i = 0; i < arrayRemoveNumberEquals.length; i++) {
			if(ifAllDigitsEquals(arrayRemoveNumberEquals[i])) {
				countNumberEquals++;
			}
		}
		return countNumberEquals;
	}

	/**
	 * identifies if all the digits of the number are equal to S
	 * @param i
	 * @return
	 */
	private boolean ifAllDigitsEquals(int number) {
		String 	numberString = String.valueOf(number);
		for (int i = 0; i < numberString.length(); i++) {
			if(numberString.charAt(i) != String.valueOf(S).charAt(0)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Elimina los enteros iguales o mayores  a "S" y que son de un solo digito, 
	 * y los restantes los agrega a un  nuevo arreglo
	 * @param initialArray
	 * @return
	 */ 
	private int[] removeNumberEquals(int[] initialArray) {
		int countNumberEquals = identifyNumberEquals(initialArray);
		int[] newArray = new int[initialArray.length - countNumberEquals];
		int countAlwaysEquals = 0;
		for (int i = 0; i < initialArray.length; i++) {
			if( (initialArray[i] == S) || (initialArray[i] > S && isOneDigit(initialArray[i] ))) {
				countAlwaysEquals++;
			} else {
				newArray[i-countAlwaysEquals] = initialArray[i];
			}
		}
		return newArray;
	}

/**
 * Verifica que el numero tenga un solo digito
 * @param number
 * @return
 */
	private boolean isOneDigit(int number) {
		String numberString = String.valueOf(number);
		if(numberString.length() == 1) {
			return true;
		}
		return false;
	}

	/**
	 * Retorna la cantidad de numeros que son iguales o mayores de un solo digito 
	 * @param initialArray
	 * @return
	 */
	private int identifyNumberEquals(int[] initialArray) {
		int countNumberEquals = 0;
		for (int i = 0; i < initialArray.length; i++) {
			if( (initialArray[i] == S) || (initialArray[i] > S && isOneDigit(initialArray[i] ))) {
				countNumberEquals++;
			}
		}
		return countNumberEquals;
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
		new ChallengeOne();
	}
}