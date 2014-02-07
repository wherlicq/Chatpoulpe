package Controller;

public class POI {
	private Integer id;
	private String label;
	private String text;
	private Double x;
	private Double y;
	private String[] link;
	private String img;

	public POI(Integer id, String label, String text, Double x, Double y, String img)
	{
		this.setId(id);
		this.setLabel(label);
		this.setText(text);
		this.setX(x);
		this.setY(y);
		this.setImg(img);
	}
	
	public POI(Data.StcMsg oMsg)
	{
		this.setId((Integer)oMsg.data[0]);
		this.setLabel((String)oMsg.data[1]);
		this.setText((String)oMsg.data[2]);
		this.setX((Double)oMsg.data[3]);
		this.setY((Double)oMsg.data[4]);
		this.setImg((String)oMsg.data[5]);
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
