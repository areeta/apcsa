// Comment this section out using /*  and  */
//   when you're ready to move on.

import java.util.Scanner;

public class FormattedStrings {

	public static void main(String[] args) {
		// Part 1:  MadLibs
		// Goal:  Show substitution as a use for formatted Strings
		// Things to look for:  %d (int) and %s (String)

		// Directions:  Hit Run and play the game BEFORE reading this code
		Scanner console = new Scanner(System.in);
		System.out.println("Enter 3 integers with the last being a date:");
		int[] nums = new int[3];
		for (int i=0; i<3; i++) {
			nums[i] = Integer.parseInt(console.nextLine());
		}
		
		System.out.println("Enter 5 nouns with the 3rd being a famous person:");
		String[] str = new String[5];
		for (int i=0; i<5; i++) {
			str[i] = console.nextLine();
		}
		
		System.out.println(String.format("A Trip to the Museum    \n Spend a day at the Computer History Museum. Find out why computer history is %d years old. \nLearn about %s history's game-changers in our multimedia exhibitions. \nPlay a game of Pong or %s! \nListen to computer pioneers like %s tell their story from their own perspective. \nDiscover the roots of today's Internet and %s devices. \nSee over %d historic artifacts, including some of the very first %ss from around %d.", nums[0], str[0], str[1], str[2], str[3], nums[1], str[4], nums[2] ));   
 
/*
		// Part 2: Your Name 
		// Goal: Practice substitution
		// Directions:  Fill in your first name and your full name below.
		//              Build a string, str0, that is the sentence:
		//              "____ is my full name, but you can call me ___"
		//              where you use String.format to fill in the blanks
*/
		String firstName = "Victor";
		String fullName = "Veggtor";
		String str0 = String.format("%s is my full name, but you can all me %s", fullName, firstName);
		System.out.println(str0);

/*
		// Part 3: By the numbers
		// Goal:  Figure out what numbers and - mean when you put them
		//        between the % and the s
		// Directions:  Change the number in the strings below to see 
		//              what happens.  The *'s are not important... they
		//              just make it easy to see the beginning and end 
		//              of each String
*/
		String str1 = String.format("*%5s*", "");       // blank input for reference
		String str2 = String.format("*%5s*", firstName);
		String str3 = String.format("*%5s*", firstName);
		String str4 = String.format("*%5s*", firstName);
		
		str1 = String.format("*%2s*", fullName);
		str2 = String.format("*%20s*", fullName);
		str3 = String.format("*%30s*", fullName);

		// This line is just to help you count spaces
		System.out.println("*123456789 123456789 123456789*");
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		
		// Now go back to the strings above and swap in your full name.
		// Try numbers like 5, 20, and 30.  
		
		// Next uncomment the 2 lines below and figure out what - does
		String str5 = String.format("*%-15s*", firstName);
		System.out.println(str5);
		
		// Part 4: Try it yourself
		// Directions:  Fill out the worksheet with what you think the 
		//              right answers should be.  Comment out the rest 
		// 	            of this lab and check your work here.
		
		System.out.println(String.format("%3s", "Hey there!"));
		System.out.println(String.format("000%5s000", "-->"));
		System.out.println(String.format("000%-5s000", "-->"));
		System.out.println(String.format("X%3sX%3sX%-3sX", "O", "O", "O"));
		System.out.println(String.format("#%3s#%3s#%3s#", "", "", ""));
		System.out.println(String.format("#%3s#%3s#%3s#", "tortoise", "race", "hare"));
		
		String a = "3.14";
		String b = "pi";
		
		System.out.println(String.format("%s is %s", a, b));
		System.out.println(String.format("!%5s!%5s!%-5s!%5s!", a, "", b, ""));
	}

}
