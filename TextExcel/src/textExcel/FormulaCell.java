package textExcel;

public class FormulaCell extends RealCell {
	
	public FormulaCell(String text, Location loc) {
		super(text, loc);
	}
		
	@Override
	public String abbreviatedCellText() {
		return String.format("%-10.10s", getDoubleValue());
	}

	@Override
	public String fullCellText() {
		return String.format("%s", super.fullCellText());
	}
	
	public double getDoubleValue() {

		
		// When you parse formulas entered by the user, note that formulas always start
		// with a left parenthesis followed by a space, and that all operators and operands
		// are separated from each other with a space, and that the formula ends with a space
		// and then a right parenthesis. Although the formula is surrounded by parentheses, we
		// will not allow parentheses inside the formula, and they will not be tested.
		
		String[] formula = super.fullCellText().split(" ");
		int forLen = formula.length;
		double ans = Double.parseDouble(formula[1]);
		
		for(int i = 2; i < forLen-3; i = i+2) {
			if(formula[i].equals("+")){
				ans += (Double.parseDouble(formula[i]) + (Double.parseDouble(formula[i+2])));
			} else if(formula[i].equals("-")){
				ans += (Double.parseDouble(formula[i]) - (Double.parseDouble(formula[i+2])));
			} else if(formula[i].equals("*")){
				ans += (Double.parseDouble(formula[i]) * (Double.parseDouble(formula[i+2])));
			} else if(formula[i].equals("/")){
				ans += (Double.parseDouble(formula[i]) / (Double.parseDouble(formula[i+2])));
			}
		}
		return ans ;
	}
}
