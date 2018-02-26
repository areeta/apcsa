package textExcel;

public class TextCell implements Cell{

	private String text;
	private Location loc;
	
	public TextCell(String text, Location loc) {
		this.text = text;
		this.loc = loc;
	}
	
	@Override
	public String abbreviatedCellText() {
		return String.format("%.10s", text);
	}

	@Override
	public String fullCellText() {
		return String.format("%s", text);
	}

}
