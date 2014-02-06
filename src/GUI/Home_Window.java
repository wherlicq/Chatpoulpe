package GUI;

/*
*
*@author Poulp
*/

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;



public class Home_Window extends JFrame{
	public Home_Window(){
		
		JPanel main_panel = new JPanel();
		JPanel lower_panel = new JPanel();
		JPanel upper_panel = new JPanel();
		JPanel button_panel = new JPanel();
		JLabel news = new JLabel("Chatpoulpe");
		final JTextArea textarea = new JTextArea();
		JButton display_button = new JButton("Carte");
		display_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clic Carte");
				
			}
		});
		JButton help_button = new JButton("Aide");
		help_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Help_Window help = new Help_Window();
				
			}
		});
		JButton exit_button = new JButton("Quitter");
		exit_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		
		
		
		this.setSize(450, 300);
		this.setTitle("Proto1");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setColumns(30);
		textarea.setRows(15);
		display_button.setMinimumSize(new Dimension(300, 300));
		display_button.setMaximumSize(new Dimension(300, 300));
		help_button.setMinimumSize(new Dimension(200, 200));
		help_button.setMaximumSize(new Dimension(300, 300));
		exit_button.setMinimumSize(new Dimension(200, 200));
		exit_button.setMaximumSize(new Dimension(300, 300));
		
		Dimension minSize = new Dimension(5, 30);
		Dimension prefSize = new Dimension(5, 30);
		Dimension maxSize = new Dimension(Short.MAX_VALUE, 30);
		
		//main_panel.setBackground(Color.white);
		//button_panel.setBackground(Color.white);
		
		main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
		main_panel.add(upper_panel);
		main_panel.add(lower_panel);
		upper_panel.add(news);
		button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.Y_AXIS));
		button_panel.add(display_button);
		button_panel.add(new Box.Filler(minSize, prefSize, maxSize));
		button_panel.add(help_button);
		button_panel.add(new Box.Filler(minSize, prefSize, maxSize));
		button_panel.add(exit_button);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		lower_panel.add(textarea);
		lower_panel.add(new Box.Filler(minSize, prefSize, maxSize));
		lower_panel.add(button_panel);
		
		this.getContentPane().add(main_panel);
		display_button.setHorizontalTextPosition(SwingConstants.LEFT);
	}
}
