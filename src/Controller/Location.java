package Controller;

import java.lang.reflect.Array;

public class Location {
	private Integer id;
	private String label;
	private String img;
	private POI[] poi;
	
	public Location(Integer id, String label, String img, POI[] POItab)
	{
		this.setId(id);
		this.setLabel(label);
		this.setImg(img);
		this.setPoi(POItab);
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public POI[] getPoi() {
		return poi;
	}

	public void setPoi(POI[] poi) {
		this.poi = poi;
	}
}
