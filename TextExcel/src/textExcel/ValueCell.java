package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell(String text, Location loc) {
		super(text, loc);
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(super.fullCellText());
	}

}
