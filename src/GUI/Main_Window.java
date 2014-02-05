package GUI;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Main_Window extends JFrame{
	public Main_Window() {
		this.setSize(900, 700);
		this.setTitle("Carte");
		
		Dimension minSize = new Dimension(5, 30);
		Dimension prefSize = new Dimension(5, 30);
		Dimension maxSize = new Dimension(Short.MAX_VALUE, 30);
		
		JPanel main_panel = new JPanel();
		JPanel search_panel = new JPanel();
		JPanel content = new JPanel();
		JPanel left = new JPanel();
		JPanel mid = new JPanel();
		JPanel right = new JPanel();
		JPanel left_content = new JPanel();
		JPanel mid_content = new JPanel();
		JPanel right_content = new JPanel();
		JPanel left_buttons = new JPanel();
		JPanel mid_buttons = new JPanel();
		JPanel right_buttons = new JPanel();
		
		JTextArea details = new JTextArea();
			details.setRows(30);
			details.setColumns(25);
		JComboBox choice = new JComboBox();
		//Ajouter les choix
		TextField search_input = new TextField();
		JButton search = new JButton("Rechercher");
		JButton mode_switch = new JButton("Edition");
		
		JButton modify_details = new JButton("Modifier details");
		JButton delete_point = new JButton("Supprimer point");
		JButton create_point = new JButton("Créer point");
		JButton move_point = new JButton("Déplacer point");
		JButton add_trip_point = new JButton("Ajouter point");
		JButton remove_trip_point = new JButton("Retirer point");
		
		JButton previous = new JButton("Précédent");
		JButton next = new JButton("Suivant");
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		this.getContentPane().add(main_panel);
		main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
		main_panel.add(search_panel);
		main_panel.add(content);
		content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
		content.add(left);
		content.add(mid);
		content.add(right);
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		mid.setLayout(new BoxLayout(mid, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		left.add(left_content);
		left.add(left_buttons);
		left.add(new Box.Filler(minSize, prefSize, maxSize));
		mid.add(mid_content);
		mid.add(mid_content);
		mid.add(mid_buttons);
		mid.add(new Box.Filler(minSize, prefSize, maxSize));
		right.add(right_content);
		right.add(right_buttons);
		right.add(new Box.Filler(minSize, prefSize, maxSize));
		left_buttons.setLayout(new BoxLayout(left_buttons, BoxLayout.X_AXIS));
		mid_buttons.setLayout(new BoxLayout(mid_buttons, BoxLayout.X_AXIS));
		right_buttons.setLayout(new BoxLayout(right_buttons, BoxLayout.X_AXIS));
		
		
		search_panel.add(previous);
		search_panel.add(next);
		search_panel.add(choice);
		search_panel.add(search_input);
		search_panel.add(search);
		search_panel.add(mode_switch);
		
		left_content.add(details);
		left_buttons.add(modify_details);
		left_buttons.add(delete_point);
		
		mid_buttons.add(create_point);
		mid_buttons.add(move_point);
		
		right_buttons.add(add_trip_point);
		right_buttons.add(remove_trip_point);
		
		
		
		this.setVisible(true);
	}
}