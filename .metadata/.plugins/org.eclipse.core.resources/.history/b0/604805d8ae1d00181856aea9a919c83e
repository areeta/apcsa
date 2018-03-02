package textExcel;

public class ValueCell extends RealCell {

	private String num;
	private Location loc;
	
	public ValueCell(String text, Location loc) {
		super(text, loc);
		this.num = text;
		this.loc = loc;
	}
		
	@Override
	public String abbreviatedCellText() {
		return String.format("%-10.10s", getDoubleValue());
	}

	@Override
	public String fullCellText() {
		return String.format("%s", num);
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(num);
	}

}
