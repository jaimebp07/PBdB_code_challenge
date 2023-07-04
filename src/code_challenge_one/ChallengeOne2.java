package code_challenge_one;

import java.util.Iterator;

public class ChallengeOne2 {

	private static final int S = 5;
	
	public ChallengeOne2() {
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
		int[] arrayDone = removeDigitsLargeOrEqual(arrayPositionChange);
		showArray("arrayDone: ", arrayDone);
	}
	
	/**
	 * El metodo retirna un vector sin los digitos mayores o iguales dentro del vector
	 * @param arrayPositionChange
	 * @return
	 */
	private int[] removeDigitsLargeOrEqual(int[] arrayPositionChange) {
		String arrayToString = passArrayToString(arrayPositionChange);
		String newArray = ",";
		for (int i = 0; i < arrayToString.length(); i++) {
			
			if((arrayToString.charAt(i) == ',') && (newArray.charAt(newArray.length()-1) != ',')) {
				newArray += arrayToString.charAt(i);
			} else if(arrayToString.charAt(i) != ',') {
				int value = Integer.parseInt(String.valueOf(arrayToString.charAt(i)));
				if( value < S) {
					newArray += arrayToString.charAt(i);
				}
			}
		}
		System.out.println("cadena "+ newArray);
		return (newArray.length()-1 > 0) ?convertStringToArray(newArray): null;
	}
	
	/**
	 * Es necesario colocar el "-1" en el tamaño del arreglo puersto que
	 *  la primera posicion siempre viene vacia
	 * @param newArray
	 * @return
	 */
	private int[] convertStringToArray(String newArray) {
		String[] newArrayS = newArray.split( ",");
		
			int[] newArrayI = new int[newArrayS.length-1];
			
			for (int i = 1; i < newArrayS.length; i++) {
				if(newArrayS[i] != "") {
					newArrayI[i-1] = Integer.parseInt(newArrayS[i]);
				} 
			}
		
		
		return newArrayI;
	}

	private String passArrayToString(int[] arrayPositionChange) {
		String arrayToString = "";
		for (int i = 0; i < arrayPositionChange.length; i++) {
			arrayToString = arrayToString+arrayPositionChange[i]+",";
		}
		return arrayToString;
	}

	/**
	 * prints a vector to the console and a message describing this vector
	 * @param message
	 * @param showArray
	 */
	private void showArray(String message, int[] showArray) {
		System.out.println("\n"+message);
		if(showArray != null) {
			for (int i = 0; i < showArray.length; i++) {
				System.out.print(showArray[i]+ ", ");
			}
		}
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
	
	public static void main(String[] args) {
		new ChallengeOne2();
	}
}
