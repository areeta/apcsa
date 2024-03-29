import java.util.Arrays;

public class Split 
{

	public static void main(String[] args) 
	{
		// String.split()
		// It's a method that acts on a string, <StringName>.split(<String sp>);
		// where sp is the string where the string splits and it returns an array
		
		// Example: "I like apples!".split(" "); 
		//		It will split at spaces and return an array of ["I","like","apples!"]
		//      Note that the spaces have been removed.
		// Example 2: "I really like really red apples"split("really")
		//		It will split at the word "really" and return an array of ["I "," like "," apples!"]
		
		// Play around with String.split()   
		// What do you think will happen if you run the following lines of code and print out the 
		// resulting arrays?  Make a guess and then try it.
		
		System.out.print("Testing it out: \na)  ");
		String[] s1 = "Banana".split("a"); // will come out as [B, n, n]
		System.out.println(Arrays.toString(s1));
				
		System.out.print("\nb)  ");
		String[] s2 = "L-i-c----k-e-t-y".split("-"); //will come out as [L, i, c, , , , , , k, e, t, y]
		System.out.println(Arrays.toString(s2));

		//Your task:
		/* Write a method sandwichHeart() that take in a string like "applespineapplesbreadlettucetomatobaconmayohambreadcheese" 
		 * describing a sandwich.  Use String.split to split up the sandwich by the word "bread" and then print
		 * a String representing what's in the MIDDLE of the sandwich between the slices of bread (ignoring what's on the outside)
		 * 
		 * For this task, assume that there will be exactly 2 pieces of bread.  
		 * Extension: Can you figure out how you would change your code if you knew there could be 3 or 4 pieces of bread
		 * but you want to print everything between the 2 outer pieces 
		*/
		sandwichHeart1("applespineapplesbreadlettucetomatobaconmayohambreadcheese");
		sandwichHeart1("breadpeanutbutterjellybreadplate");
		
		//Your task pt 2:
		/* Write a method sandwichHeart2() that take in a string like "apples pineapples bread lettuce tomato bacon mayo ham bread cheese" 
		 * describing a sandwich.  Use String.split to split up the sandwich at the spaces, " ", and print a String representing what's 
		 * in the middle of the sandwich and ignores what's on the outside
		*/
		sandwichHeart2("apples pineapples bread lettuce tomato bacon mayo ham bread cheese");
		sandwichHeart2("bread peanut butter jelly bread plate");

	}
	
	public static void sandwichHeart1(String s)
	{
		System.out.print("\nSandwichHeart1:\n");
		String[] Heart1 = s.split("bread"); 
		String answer = Heart1[1];
		System.out.println(answer);
	}

	public static void sandwichHeart2(String s)
	{
		System.out.print("\nSandwichHeart2:\n");
		String[] Heart2 = s.split(" "); 
		String answer = "";
		int numOfBread = 0;
		for(int i = 0; i <= Heart2.length - 1; i++) {
			if (!(Heart2[i].equals("bread")) && (numOfBread == 1) ) {
				answer += Heart2[i];
			}
			if ((Heart2[i].equals("bread")) ) {
				numOfBread += 1;
			}
			if (numOfBread == 2) {
				break;
			}
			
		}
		System.out.println(answer);
	}
}


