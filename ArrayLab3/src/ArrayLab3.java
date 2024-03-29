import java.util.Arrays;
public class ArrayLab3 {

	public static void main(String[] args) {
		// Test your methods here!
		boolean[] trueOrFalse = {true, true, false, true, false};
		System.out.println(lieDetector(trueOrFalse));
		
		
		
		int[] numbers = {5, 6, 7, 8, 9, 10};
		for (int i: numbers) {
			System.out.println(i);
		}
		shiftsLeftByOne(numbers);
		
		String[] studentNums = {"Vanessa", "Areeta", "Charles", "Lucy", "Marcus"};
		System.out.println(Arrays.toString(photoBomb(studentNums)));
		
		String[] fourLetteredOne = {"Vanessa", "Areeta", "Charles", "Nat", "Cata", "Bata"};
		
		
		
		System.out.println(fourLetterWords(fourLetteredOne));
		
		
	}

	/*
	 * Complete the lieDetector method that accepts an array of booleans.  The elements report whether
	 * the person tested was answering truthfully or not.  The method returns the index of the first 
	 * instance of a lie (false).  If there was no lie, the method returns -1.
	 */
	public static int lieDetector (boolean[] questions) {
		int index = 0;
		while (index < questions.length) {
			if (questions[index] == false) {
				return index;
			} else {
				index++;
			}
		}
		return -1;
	}
	
	/* Rotate the array in place (no second copy of an array allowed) one space to the left with 
	 * the first element wrapping around to become the last.  Remember, no for loops are allowed.  ;)
	 */
	public static void shiftsLeftByOne(int[] arr) {
		int firstNum = arr[0];
		int counter = 0;
		
		while(counter <= arr.length-2) { 
			arr[counter] = arr[counter+1];
			counter++;
		}
		arr[arr.length-1] = firstNum;
	}

	/*
	 * Thrasher can't help himself.  At the end of the year, as his students are all taking photos of 
	 * classmates, he just has to dive in!  Complete the photoBomb method that accepts a list of Strings
	 * (names of students in a photo) and add Thrasher as the second element in each array.  The method 
	 * will return a new array that is one element longer than the original.  You can assume that the 
	 * names array will contain at least 2 names.
	 */
	public static String[] photoBomb (String[] names) {
		String[] withThrasher = new String[names.length + 1];
		withThrasher[0] = names[0];
		withThrasher[1] = "Thrasher";
		int counter = 2;
		while (counter <= names.length) { //instead of just names.length-1, it's names.length bc you can go the full length since withThrasher has one extra!!
			withThrasher[counter] = names[counter-1]; //instead of counter+1, it's doing counter-1 bc you're ADDING thrasher inside not REPLACING 
			counter++;
		}
		return withThrasher;
	}
	
	/*
	 * Complete the fourLetterWords method that accepts an array of Strings and returns the number 
	 * of four letter words in the array.  Use a for each loop to write this one.   
	 */
	public static int fourLetterWords (String[] arr) {
		int numOfFourLetterWords = 0;
		int items = 0;
		for (String n: arr) {
			String newWord = arr[items];
			if (newWord.length() == 4) {
				numOfFourLetterWords++;
			}
			items++;
		}
		return numOfFourLetterWords;
	}
}

