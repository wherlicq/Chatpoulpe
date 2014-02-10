package GUI;
import java.awt.Color;
import java.awt.Graphics;
public class DrawCoords {
	
	public void draw(Graphics g, int x, int y){
		g.setColor(Color.RED);
		g.fillOval(x, y, 8, 8);
	}
}