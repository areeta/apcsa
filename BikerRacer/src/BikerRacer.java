public class BikeRacer
{	
						
//fields
	private String name;
	private int riderNumber;
	private double milesCompleted;
	private int time;
	
//constructors
	public BikeRacer ()
	{
		this.milesCompleted = 0;
		this.time = 0;
	}
	public BikeRacer (String boi, int bois)
	{
	this.name = boi;
	this.riderNumber = bois;
	}
	
	//getters	
	public String getName()
	{
		return name;
	}
	public double getMiles()
	{
		return milesCompleted;
	}
	
	//setters 
	public void setRiders (int r)
	{
		riders = r;
	}
	public void setMiles (double m)
	{
		miles = m;
	}
	
	//new methods
	public double avgSpeed  (bikeRacer time, bikeRacer miles)
	{
	double v = miles/time;
	return v;
	}
	public double milesFrom ( BikeRacer other)
	{
		double distance = this.miles - other.miles;
		return distance;
	}
}	
	//end class bikeRacer

	public class raceClient
	{
		public static void main (String[] args)
		{
		bikeRacer[] racers = {new BikeRacer("John", 5), new BikeRacer("Mary", 7), new BikeRacer("Bob", 3), new BikeRacer("Patrick", 69)};
		}
}
