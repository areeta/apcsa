package textExcel;

public class FormulaCell extends RealCell {

	private String num;
	private Location loc;
	
	public FormulaCell(String text, Location loc) {
		super(text, loc);
		this.num = text;
		this.loc = loc;
	}
		
	@Override
	public String abbreviatedCellText() {
		return String.format("%-10.10s", num);
	}

	@Override
	public String fullCellText() {
		return String.format("%s", num);
	}
	
	public double getDoubleValue() {
		return 0.0 ;
	}


}