package textExcel;

public abstract class RealCell implements Cell, Comparable<RealCell> {

	private String num;
	private Location loc;
	
	public RealCell(String text, Location loc) {
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
	
	public abstract double getDoubleValue();
	
	public int compareTo(RealCell a) {
		
		if (this.getDoubleValue() > a.getDoubleValue()) {
			return 1;
		} else if (this.getDoubleValue() < a.getDoubleValue()) {
			return -1;
		}
		
		return 0;
	}

}
