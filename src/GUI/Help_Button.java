package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Help_Button extends JButton {
  private String name;
  private Image img;
  
  public Help_Button(String str){
    super(str);
    this.name = str;
    this.setFont(new Font("arial", Font.BOLD, 12));
    
    try {
        img = ImageIO.read(new File("bin/GUI/img/bouton_help.png"));
      } catch (IOException e) {
        e.printStackTrace();
      }
  }
  public void paintComponent(Graphics g){
      Graphics2D g2d = (Graphics2D)g;
      GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
      g2d.setPaint(gp);
      g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
      g2d.setColor(Color.black);
      g2d.drawString(this.name, this.getWidth() / 4 - (this.getWidth() / 2 /4), (this.getHeight() / 2) + 5);
    }
}