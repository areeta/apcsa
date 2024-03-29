package textExcel;

import java.util.Arrays;

public class Spreadsheet implements Grid {
	
	private Cell[][] grid; 
	
	public Spreadsheet() {
		grid = new Cell[getRows()][getCols()]; 
		for(int r = 0; r < getRows(); r++) {
			for (int c = 0; c < getCols(); c++) {
				grid[r][c] = new EmptyCell();
			}
		}
	}
	
	public static Cell[] selectionSort(Cell[] arr) {
	
		for(int i = 0; i < arr.length; i++) {
			int smallestIndex = i;
			for(int j = 0; j < arr.length; j++) {
				
				if (arr[j] instanceof TextCell) {
					
					TextCell t = (TextCell) arr[j];
					TextCell f = (TextCell) arr[smallestIndex];
					
					if( t.compareTo(f) > 0 ) {
						smallestIndex = j;
					}
					
				} else if (arr[j] instanceof RealCell) {
					
					RealCell t = (RealCell) arr[j];
					RealCell f = (RealCell) arr[smallestIndex];
					
					if( t.compareTo(f) > 0 ) {
						smallestIndex = j;
					}
				}
				
				Cell temp = arr[i];
				arr[i] = arr[smallestIndex];
				arr[smallestIndex] = temp;
			}
		}
		return arr;
	}

	@Override
	public String processCommand(String command) {
		
		String com = command.toLowerCase();
				
		if (com.equals("clear")) {            					//clear the whole spreadsheet
			for(int r = 0; r < getRows(); r++) {
				for (int c = 0; c < getCols(); c++) {
					grid[r][c] = new EmptyCell();
				}
			}
		} else if (command.length() == 2 || command.length() == 3) {       		//cell inspection
						
			SpreadsheetLocation loc = new SpreadsheetLocation(command);
			return grid[loc.getRow()][loc.getCol()].fullCellText();
			
		} else if (command.split(" ", 3).length == 3){							//assignment of string values 

			String[] commandArr = command.split(" ", 3);
						
			String cellName = commandArr[0];
			SpreadsheetLocation loc = new SpreadsheetLocation(cellName);
			
			String stringValue = commandArr[2];
			 			
			if ((stringValue.charAt(stringValue.length()-1)) == '%' ){ 			//find out it is is a percent
				
				PercentCell percent = new PercentCell(stringValue, loc);
				percent.abbreviatedCellText();
				grid[loc.getRow()][loc.getCol()] = percent;
				
			} else if (stringValue.startsWith("(")) { 							//find out if it is a formula
					
				FormulaCell formula = new FormulaCell(stringValue, loc, this);
				formula.abbreviatedCellText();
				grid[loc.getRow()][loc.getCol()] = formula;
					
			} else if (stringValue.startsWith("\"")){ 							//finds out if it is a text
					
				TextCell text = new TextCell(stringValue, loc);
				text.abbreviatedCellText();
				grid[loc.getRow()][loc.getCol()] = text;
					
			} else if (stringValue.contains(".")) { 							//find out if it is a decimal
				
				ValueCell decimal = new ValueCell(stringValue, loc);
				decimal.abbreviatedCellText();
				grid[loc.getRow()][loc.getCol()] = decimal;
				
			} else { 															// if it's just like A2 = 3
					
				ValueCell num = new ValueCell(stringValue, loc);
				num.abbreviatedCellText();
				grid[loc.getRow()][loc.getCol()] = num;
			}
			
		} else if ((command.length() > 5) && (com.contains("sort"))) {

			String[] formula = command.split(" ");
			String[] cellNames = formula[1].split("-");
			
			SpreadsheetLocation firstLoc = new SpreadsheetLocation(cellNames[0]);
			SpreadsheetLocation secondLoc = new SpreadsheetLocation(cellNames[1]);
			
			int length = secondLoc.getRow() - firstLoc.getRow() + 1;
			int height = secondLoc.getCol() - firstLoc.getCol() + 1;
			
			Cell[] arr = new Cell[length*height];
			
			int a = 0;
			
			for (int r = firstLoc.getRow(); r <= secondLoc.getRow(); r++) {
				for (int c = firstLoc.getCol(); c <= secondLoc.getCol(); c++) {
					arr[a] = grid[r][c];
					a++;
				}
			}
							
			selectionSort(arr);

			int i = 0;
			
			if (com.contains("sorta")) { 				//if increasing
				i = 0;
				for (int r = firstLoc.getRow(); r <= secondLoc.getRow(); r++) {
					for (int c = firstLoc.getCol(); c <= secondLoc.getCol(); c++) {
						grid[r][c] = arr[i];
						i++;
					}
				}
			} else if (com.contains("sortd")) {			//if decreasing
				i = length*height-1;
				for (int r = firstLoc.getRow(); r <= secondLoc.getRow(); r++) {
					for (int c = firstLoc.getCol(); c <= secondLoc.getCol(); c++) {
						grid[r][c] = arr[i];
						i--;
					}
				}
			}
			
		} else if (com.contains("clear")) {									//clearing a particular cell 
			
			String[] commandArr = command.split(" ", 2);
			
			String cellName = commandArr[1];
			SpreadsheetLocation loc = new SpreadsheetLocation(cellName);
			
			grid[loc.getRow()][loc.getCol()] = new EmptyCell();
			
		} else {
			return "";
		}
		
		return getGridText();
	}

	@Override
	public int getRows() {
		return 20;
	}

	@Override
	public int getCols() {
		return 12;
	}

	@Override
	public Cell getCell(Location loc) {
		return grid[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText() { //Creates the whole spreadsheet and prints out the entire thing
		
		String gridText = "   |";

		for (int i = 0; i < getCols(); i++) {
			gridText += (char)(i+65) + "         |";
		}
		
		gridText += "\n";
		
		for(int r = 1; r < getRows() + 1; r++) {
			gridText += String.format("%-3s|", r);
			for (int c = 0; c < getCols(); c++) {
				gridText += String.format("%.10s|", (grid[r-1][c].abbreviatedCellText()));
			}
			gridText += "\n";
		}
		return gridText;
	}

	public String toString(String word) {
		return word;
	}
}
