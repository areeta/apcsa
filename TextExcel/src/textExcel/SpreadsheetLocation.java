package textExcel;

public class SpreadsheetLocation implements Location {
	
	private int row;
	private int col;
	
    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getCol() {
        return this.col;
    }
    
    public SpreadsheetLocation(String cellName) {
            	
    	char letter = cellName.charAt(0); 
    	letter = Character.toUpperCase(letter);
    	this.col = ((int) letter) - 65;
    	
    	String num = cellName.substring(1); 
    	this.row = (Integer.parseInt(num)) - 1;
    	
    }
}