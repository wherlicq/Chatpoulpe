package GUI;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class Trip_Window extends JFrame{
		public Trip_Window() {
			this.setSize(300, 230);
			this.setTitle("Gestion d'un parcours");
			
			JPanel main_panel = new JPanel();
			this.getContentPane().add(main_panel);
			JPanel label_panel = new JPanel();
			main_panel.add(label_panel);
			JPanel text_panel = new JPanel();
			main_panel.add(text_panel);
			JPanel image_panel = new JPanel();
			main_panel.add(image_panel);
			JButton save = new JButton("Enregistrer les modifications");
			main_panel.add(save);
			
			JTextArea title = new JTextArea("Nom");
			title.setRows(1);
			title.setColumns(25);
			JTextArea text = new JTextArea("Descriptif");
			text.setRows(5);
			text.setColumns(25);
			JTextArea image_path = new JTextArea("Lien de l'image");
			image_path.setRows(1);
			image_path.setColumns(25);
			
			label_panel.add(title);
			text_panel.add(text);
			image_panel.add(image_path);
		}
}