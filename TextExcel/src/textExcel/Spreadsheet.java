package textExcel;

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

	@Override
	public String processCommand(String command) {
		
		String lower = command.toLowerCase();
				
		if (command.equalsIgnoreCase("clear")) {            					//clear the whole spreadsheet
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
					
				FormulaCell formula = new FormulaCell(stringValue, loc);
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
			
		} else if (lower.contains("clear")) {									//clearing a particular cell 
			
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
	public String getGridText() {
		
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
