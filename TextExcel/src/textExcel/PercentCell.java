package textExcel;

public class PercentCell extends RealCell{
	
	public PercentCell(String text, Location loc) {
		super(text, loc);
	}
		
	@Override
	public String abbreviatedCellText() {
		int answer = (int) (getDoubleValue());
		return String.format("%-10.10s", answer + "%");
	}

	@Override
	public String fullCellText() {
		return String.format("%s", ((getDoubleValue() / 100)));
	}
	
	public double getDoubleValue() {
		String ans = super.fullCellText().substring(0, super.fullCellText().length()-1);
		return Double.parseDouble(ans);
	}
	
}
