import java.util.Arrays;
// made by Areeta who spent 2 days on reverse but then asked charles and he helped me solve my issue in 2 min -_-
public class Lab2 {

	// This method switches the first and last elements in the given array and then returns 
	// a String representing the array as shown below.
	public static String swapFirstLast(int[] arr) {
		int old = arr[0];
		arr[0] = arr[arr.length-1];
		arr[arr.length-1] = old;
		return Arrays.toString(arr);
	}
	
	// This method takes in an array and returns a String representing the array's reverse
	public static String reverse(int[] arr) {
		int j = 0; 
		int[] newArr = new int[arr.length]; 
		for (int i = arr.length-1; i >= 0; i--) { 
			newArr[j] = arr[i];
			j++;
		}
		return Arrays.toString(newArr);
	}
	
	// This method accepts a String and uses the String method split() to split
	// the String on spaces.  Remember that String.split returns an array.
	// The method should then find the target String in the array and replace every 
	// instance of it.  If the target String is found, use your adjusted array to 
	// rebuild a String and return it.  If the target String was not found, return 
	// "String not found" instead.
	// Ex.        findAndReplace("There are clouds in the sky","clouds","sheep");
	// Returns:   There are sheep in the sky
	public static String findAndReplace(String str, String find, String replace)
	{
		String[] s1 = str.split(" ");
		boolean isHere = false;
		String answer = "";
		for(int i = 0; i <= s1.length-1; i++) {
			if (s1[i].equals(find)) {
				s1[i] = replace;
				isHere = true;
			}
		}
		if (isHere == true) {
			for (int i = 0; i <= s1.length-1; i++) {
				answer += s1[i] + " ";
			}
		} else {
			return "String not found";
		}
		return answer;
	}
	
	public static void main(String[] args) 
	{
		// Swap array elements:  Pass the following arrays into your swapFirstLast method.
		// Print the returned Strings.
		int[] swp = {3, 9, 21, 24, 27}; 
		int[] swp2 = {2, 4, 6, -5, -3, -1};
		
		System.out.println(swapFirstLast(swp));
		System.out.println(swapFirstLast(swp2));
		
		// Reversing an array:  Pass the following arrays into your reverse method.
		// Print the returned Strings.
		int[] rev = {1, 2, 3, 4, 5, 6, 7};  // Reversed, it should print [7, 6, 5, 4, 3, 2, 1] 
		int[] rev2 = {1, 2, 3, 4, 5, 6};
		
		System.out.println(reverse(rev));
		System.out.println(reverse(rev2));
		
		// Find and Replace: Pass the following arrays into your findAndReplace method and print the 
		//   returned String.  In the first, try replacing one of the fruits with something else.  
		//   Then try it again and replace "like" with something else.  Try it again looking for
		//   a word that isn't there.  
		String iLike = "I like apples I like bananas I like pineapples I like oranges I like pears";
		String empty = "";
		
		System.out.println(findAndReplace(iLike, "like", "hate"));
		System.out.println(findAndReplace(empty, "", "d"));
		
		System.out.println(remove(rev, 2));
	
	}
	
	public static String sum(int[] arr1, int[] arr2) {
		int[] answer = new int[arr1.length];
		for (int i = 0; i <= answer.length-1; i++) {
			answer[i] = arr1[i] + arr2[i];
		}
		return Arrays.toString(answer);
	}
	
	public static String remove(int[] nums, int index) {
		int[] newNums = new int[nums.length-1];
		for (int i = 0; i <= index-1; i++) {
			newNums[i] = nums[i]; 
			System.out.println(Arrays.toString(newNums));
		}
		for(int j = index; j <= nums.length-2; j++) {
			newNums[j] = nums[j+1];
			System.out.println(Arrays.toString(newNums));
		}
		
		return (Arrays.toString(newNums)) ;
		}
	
	public static void rotateRight(String[] str) {
		String last = str[str.length -1];
		for(int i =str.length - 1; i> 0 ; i--) {
			str[i] = str[i-1];
		}
		str[0] = last;
		System.out.println(last);
		}
	}
	
	



