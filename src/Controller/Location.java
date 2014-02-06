package Controller;

import java.lang.reflect.Array;

public class Location {
	private Integer id;
	private String label;
	private String img;
	private POI[] poi;
	
	public Location(Integer id, String label, String img, POI[] POItab)
	{
		this.id = id;
		this.label = label;
		this.img = img;
		this.poi = POItab;
	}
}
