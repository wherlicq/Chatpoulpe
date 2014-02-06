package Controller;

import java.lang.reflect.Array;

public class Location {
	private Integer id;
	private String img;
	private POI[] poi;
	
	public Location(Integer id, String img, Data.StcMsg POI)
	{
		this.id = (Integer)id;
		this.img = (String)img;
		this.poi = new POI[POI.data.length];
		for (int i = 0; i < POI.data.length; i++)
		{
			this.poi[i] = new POI((Data.StcMsg)POI.data[i]);
		}
	}
}
