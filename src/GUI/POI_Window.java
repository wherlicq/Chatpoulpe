package GUI;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class POI_Window extends JFrame{
	
	public POI_Window(){
		this.setSize(300, 400);
		this.setTitle("Gestion d'un point");
		
		JPanel main_panel = new JPanel();
		this.getContentPane().add(main_panel);
		main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
		JPanel label_panel = new JPanel();
		main_panel.add(label_panel);
		JPanel text_panel = new JPanel();
		main_panel.add(text_panel);
		JPanel coords_x_panel = new JPanel();
		main_panel.add(coords_x_panel);
		JPanel coords_y_panel = new JPanel();
		main_panel.add(coords_y_panel);
		JPanel image_panel = new JPanel();
		main_panel.add(image_panel);
		JPanel location_panel = new JPanel();
		main_panel.add(location_panel);
		JButton save = new JButton("Enregistrer les modifications");
		main_panel.add(save);
		
		JTextArea title = new JTextArea("Nom");
		title.setRows(1);
		title.setColumns(25);
		JTextArea text = new JTextArea("Descriptif");
		text.setRows(5);
		text.setColumns(25);
		JTextArea coords_x = new JTextArea("X");
		coords_x.setRows(1);
		coords_x.setColumns(5);
		JTextArea coords_y = new JTextArea("Y");
		coords_y.setRows(1);
		coords_y.setColumns(5);
		JTextArea image_path = new JTextArea("Lien de l'image");
		image_path.setRows(1);
		image_path.setColumns(25);
		JTextArea location = new JTextArea("Lieu");
		location.setRows(1);
		location.setColumns(25);
		
		label_panel.add(title);
		text_panel.add(text);
		coords_x_panel.add(coords_x);
		coords_y_panel.add(coords_y);
		image_panel.add(image_path);
		location_panel.add(location);
	}
}