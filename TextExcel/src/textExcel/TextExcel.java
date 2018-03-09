package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextExcel {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Spreadsheet newOne = new Spreadsheet();
		System.out.println(newOne.getGridText());

		
		boolean run = true;
		while (run) {

    		System.out.println("What is your command?");
    		String command = input.nextLine();
    		
    		if (command.equals("quit")) {
    			run = false;
    		} else {
    			System.out.println(newOne.processCommand(command));
    		}		
		}
		
	input.close();
	
	}
}
