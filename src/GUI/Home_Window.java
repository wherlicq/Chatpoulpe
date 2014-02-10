package GUI;

/*
*
*@author Poulp
*/

import Controller.Prcs_View;
import Data.StcMsg;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class Home_Window extends JFrame{
    
    Prcs_View oPv;
    StcMsg oMsg;
    
	public Home_Window(final Prcs_View oPv) throws SQLException, ClassNotFoundException{
		
               this.oPv = oPv;
		JPanel main_panel = new JPanel();
		JPanel lower_panel = new JPanel();
		JPanel upper_panel = new JPanel();
		JPanel button_panel = new JPanel();
		JLabel news = new JLabel("Chatpoulpe");
		final JTextArea textarea = new JTextArea();
	    final JTextField tfield = new JTextField(30);
        JScrollPane scroll = new JScrollPane(textarea);
                
        //****************************************** Remplissage News **************************************
                this.oMsg = this.oPv.initializeNews();
                final StcMsg tmpMsg = this.oMsg;
                final Prcs_View tmpPv = this.oPv;
                final String[] tabNews = new String[this.oMsg.selectedData.length];
                final Integer[] tabIdItem = new Integer[tabNews.length];
                final String[] tabTypeItem = new String[tabNews.length];
                for(int i = 0; i < this.oMsg.selectedData.length; i++)
                {
                	tabNews[i] = "Nouveauté " + (i+1) + ":\n";
                    textarea.append(tabNews[i]);
                    textarea.append((String)this.oMsg.selectedData[i][1] + "\n");
                    textarea.append((String)this.oMsg.selectedData[i][2] + "\n");
                    tabIdItem[i] = (Integer)this.oMsg.selectedData[i][4];
                    tabTypeItem[i] = (String)this.oMsg.selectedData[i][5];
                    textarea.append("\n");
                }    

                tfield.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    	textarea.append(tfield.getText() + "\n");
                    }
                });  
                
                textarea.addMouseListener(new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent me)
                    {
                        int x = me.getX();
                        int y = me.getY();
                        System.out.println("X : " + x);
                        System.out.println("Y : " + y);
                        int startOffset = textarea.viewToModel(new Point(x, y));
                        System.out.println("Start Offset : " + startOffset);
                        String text = textarea.getText();
                        for (int i = 0; i < tabNews.length; i++)
                        {
                        	int searchLocation = text.indexOf(tabNews[i], startOffset);
                        	System.out.println("Search Location : " + searchLocation);
                        	if (searchLocation == startOffset) {
                        		Prcs_View oPv = new Prcs_View();
                        		try {
									oPv.newsClick(tabIdItem[i], tabTypeItem[i]);
								} catch (ClassNotFoundException | SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
                        		
                        		//tmpPv.newsClick((Integer)tmpMsg.selectedData[i][5], (String)tmpMsg.selectedData[i][6]);
                        		//JOptionPane.showMessageDialog(Home_Window.this, tabNews[i]);
                        	}
                        }
                    }
                });
                getContentPane().add(scroll, BorderLayout.CENTER);
                
//************************************************************************************************************
                
                
		JButton display_button = new JButton("Carte");
		display_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					oPv.initializeLocation(1);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				oPv.DisplayLoc();
			}
		});
//		JButton help_button = new JButton("Aide");
//		help_button.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				Help_Window help = new Help_Window();
//				
//			}
//		});
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
                textarea.setEditable(false);
		display_button.setMinimumSize(new Dimension(300, 300));
		display_button.setMaximumSize(new Dimension(300, 300));
//		help_button.setMinimumSize(new Dimension(200, 200));
//		help_button.setMaximumSize(new Dimension(300, 300));
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
//		button_panel.add(help_button);
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
