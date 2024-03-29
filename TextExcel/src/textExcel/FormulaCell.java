package textExcel;

public class FormulaCell extends RealCell {
	
	private Spreadsheet spread;
	
	public FormulaCell(String text, Location loc, Spreadsheet spread) {
		super(text, loc);
		this.spread = spread;
	}
		
	@Override
	public String abbreviatedCellText() {
		return String.format("%-10.10s", getDoubleValue());
	}

	@Override
	public String fullCellText() {
		return String.format("%s", super.fullCellText());
	}
	
	public double getSum(String cells) {            //Computes the ( SUM A4-A6 )
		
		String[] cellLocations = cells.split("-");
		
		SpreadsheetLocation cell1 = new SpreadsheetLocation(cellLocations[0]);
		SpreadsheetLocation cell2 = new SpreadsheetLocation(cellLocations[1]);
		
		double ans = 0.0;

		for(int r = cell1.getRow(); r <= cell2.getRow(); r++) {
			for (int c = cell1.getCol(); c <= cell2.getCol(); c++) {
				SpreadsheetLocation newCell = new SpreadsheetLocation(r, c);
				ans += ((RealCell)spread.getCell(newCell)).getDoubleValue();			
			}
		}

		return ans;
	}
	
	public double getAvg(String cells) {            //Computes the ( AVG A4-A6 )
		
		double ans = getSum(cells);
		
		String[] cellLocations = cells.split("-");
		
		SpreadsheetLocation cell1 = new SpreadsheetLocation(cellLocations[0]);
		SpreadsheetLocation cell2 = new SpreadsheetLocation(cellLocations[1]);
	
		int height = cell2.getCol()-cell1.getCol() + 1;
		int width = cell2.getRow()-cell1.getRow() + 1;
		
		return ans / (height * width);
		
	}
	
	public double getDoubleValue() {
		
		String[] formula = super.fullCellText().split(" ");
		int forLen = formula.length;
		double ans = 0.0;
		
		if (formula[1].equalsIgnoreCase("SUM")){
						
			ans += getSum(formula[2]);
			
		} else if (formula[1].equalsIgnoreCase("AVG")){
			
			ans += getAvg(formula[2]);
			
		} else {
			
			for(int j = 1; j < forLen; j = j+2) {
				if(formula[j].toUpperCase().charAt(0) >= 65 && formula[j].toUpperCase().charAt(0) <= 90) {
					SpreadsheetLocation loc = new SpreadsheetLocation(formula[j]);
					double a = ((RealCell)spread.getCell(loc)).getDoubleValue();
					formula[j] = Double.toString(a);
				}
			}
	
			ans =  Double.parseDouble(formula[1]);
			
			for(int i = 2; i < forLen-2; i = i+2) {
				if(formula[i].equals("+")){
					ans += Double.parseDouble(formula[i + 1]);
				} else if(formula[i].equals("-")){
					ans -= Double.parseDouble(formula[i + 1]);
				} else if(formula[i].equals("*")){
					ans *= Double.parseDouble(formula[i + 1]);
				} else if(formula[i].equals("/")){
					ans /= Double.parseDouble(formula[i + 1]);
				}
			}
		}
		
		return ans ;
	}
	
}
