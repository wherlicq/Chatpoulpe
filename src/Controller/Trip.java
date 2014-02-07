package Controller;

public class Trip {
	private Integer id;
	private String label;
	private String[] link;
	private Location loc;
	private POI[] poi;
	
	public Trip(Integer id, String label,Location loc, POI[] poi)
	{
		this.id = id;
		this.label = label;
		this.poi = poi;
		this.loc = loc;
	}
}
