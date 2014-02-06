package GUI;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Result_Window extends JFrame{
	
	public Result_Window() {
		this.setSize(300, 200);
		this.setTitle("Recherche");
		
		JTextArea result_pool = new JTextArea(8, 20);
		result_pool.setText("Texte à remplacer par le résultat de la recherche");
		
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().setBackground(Color.white);
		this.add(result_pool);
		
	}
}
