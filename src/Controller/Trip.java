package Controller;

public class Trip {
	private Integer id;
	private String label;
	private String[] link;
	private Location loc;
	private POI[] poi;
	
	public Trip(Integer id, String label,Location loc, POI[] poi)
	{
		this.setId(id);
		this.setLabel(label);
		this.setPoi(poi);
		this.setLoc(loc);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public POI[] getPoi() {
		return poi;
	}

	public void setPoi(POI[] poi) {
		this.poi = poi;
	}
}
