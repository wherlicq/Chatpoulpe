package Controller;

public class Location {
	private Integer id;
	private String img;
	private POI[] poi;
	
	public Location(Data.StcMsg oMsg)
	{
		this.id = (Integer)oMsg.data[0];
	}
}
