package Controller;

public class POI {
	private Integer id;
	private String label;
	private String text;
	private Double x;
	private Double y;
	private String[] link;
	private String img;
	private Trip[] trip;

	public POI(Integer id, String label, String text, Double x, Double y, String img)
	{
		this.id = id;
		this.label = label;
		this.text = text;
		this.x = x;
		this.y = y;
		this.img = img;
	}
	
	public POI(Data.StcMsg oMsg)
	{
		this.id = (Integer)oMsg.data[0];
		this.label = (String)oMsg.data[1];
		this.text = (String)oMsg.data[2];
		this.x = (Double)oMsg.data[3];
		this.y = (Double)oMsg.data[4];
		this.img = (String)oMsg.data[5];
	}
}
