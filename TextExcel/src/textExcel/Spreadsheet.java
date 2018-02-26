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
		
		if (command.equalsIgnoreCase("clear")) {            		//clear the whole spreadsheet
			for(int r = 0; r < getRows(); r++) {
				for (int c = 0; c < getCols(); c++) {
					grid[r][c] = new EmptyCell();
				}
			}
		} else if (command.length() == 2 || command.length() == 3) {       		//cell inspection
						
			SpreadsheetLocation loc = new SpreadsheetLocation(command);
			return grid[loc.getRow()][loc.getCol()].fullCellText() ;
			
		} else if (command.split(" ",3).length == 3){	//assignment of string values 

			String[] commandArr = command.split(" ", 3);
						
			String cellName = commandArr[0];
			SpreadsheetLocation loc = new SpreadsheetLocation(cellName);
			
			TextCell text = new TextCell(commandArr[2], loc);
			text.abbreviatedCellText();
			grid[loc.getRow()][loc.getCol()] = text;
			
		} else if (command.split(" ",2).length == 2) {	//clearing a particular cell 
			
			String[] commandArr = command.split(" ", 2);
			
			String cellName = commandArr[1];
			SpreadsheetLocation loc = new SpreadsheetLocation(cellName);
			
			grid[loc.getRow()][loc.getCol()] = new EmptyCell();
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