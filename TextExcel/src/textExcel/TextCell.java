package textExcel;

public class TextCell implements Cell, Comparable<TextCell> {

	private String text;
	private Location loc;
	
	public TextCell(String text, Location loc) {
		this.text = text;
		this.loc = loc;
	}
	
	@Override
	public String abbreviatedCellText() {
		return String.format("%-10.10s",text.substring(1,text.length()-1));
	}

	@Override
	public String fullCellText() {
		return String.format("%s", text);
	}

	// TextCell should rely on the String class’s compareTo() method to sort alphabetically based on the String returned by fullCellText().  

	public int compareTo(TextCell a) {
		
		if (this.fullCellText().compareTo(a.fullCellText()) > 0) {
			return 1;
		} else if (this.fullCellText().compareTo(a.fullCellText()) < 0) {
			return -1;
		}
		
		return 0;
	}

}
