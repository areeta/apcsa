package textExcel;

public class PercentCell extends RealCell{

	private String num;
	private Location loc;
	
	public PercentCell(String text, Location loc) {
		super(text, loc);
		this.num = text;
		this.loc = loc;
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
		String ans = num.substring(0, num.length()-1);
		return Double.parseDouble(ans);
	}
	
}