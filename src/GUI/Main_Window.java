package GUI;
import Controller.POI;
import Controller.Prcs_View;
import Controller.Trip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class Main_Window extends JFrame{
	private boolean edition = false;
        Prcs_View oPv;
	
	public Main_Window(Prcs_View oPv) {
            
            this.oPv = oPv;
            this.initialize();
	}
	
	public void initialize()
	{
		this.setSize(1300, 700);
		this.setTitle("Carte");
		
		Dimension minSize = new Dimension(5, 30);
		Dimension prefSize = new Dimension(5, 30);
		Dimension maxSize = new Dimension(Short.MAX_VALUE, 30);
		
		JPanel main_panel = new JPanel();
		JPanel upper_panel = new JPanel();
		JPanel search_panel = new JPanel();
		JPanel navigate = new JPanel();
		JPanel mode_switch_panel = new JPanel();
		
		final POI[] poiTab = this.oPv.getProcessus().getPoi();
		final Trip[] tripTab = this.oPv.getProcessus().getTrip();
		/*final POI[] poiTab = new POI[6];
		POI poi1 = new POI(1, "a", "b", 25d, 25d, "c");			
		POI poi2 = new POI(1, "a", "b", 45d, 12d, "c");			
		POI poi3 = new POI(1, "a", "b", 600d, 389d, "c");		
		POI poi4 = new POI(1, "a", "b", 12d, 98d, "c");			
		POI poi5 = new POI(1, "a", "b", 85d, 85d, "c");			
		POI poi6 = new POI(1, "a", "b", 1d, 1d, "c");			
		poiTab[0] = poi1;										
		poiTab[1] = poi2;										
		poiTab[2] = poi3;									
		poiTab[3] = poi4;										
		poiTab[4] = poi5;										
		poiTab[5] = poi6;*/
		
		JLabel map = new JLabel();
		JPanel left = new JPanel();
		JPanel mid = new JPanel();
		JPanel right = new JPanel();
		JPanel left_content = new JPanel();
		JPanel mid_content = new JPanel();
		
		
		JPanel mid_points = new JPanel() {
			public void paintComponent(Graphics g){
				for(int i=0; i<poiTab.length; i++){
					System.out.println("X : " + (int)Math.round(poiTab[i].getX()) + " | Y : " + (int)Math.round(poiTab[i].getY()) + "\n");
					g.drawOval((int)Math.round(poiTab[i].getX()-2), (int)Math.round(poiTab[i].getY()-2), 4, 4); // Dessin des POI
				}
				for (int i = 0; i < tripTab.length; i++)
				{
					for (int j = 0; j < tripTab[i].getPoi().length; j++)
					{
						POI[] tmp = tripTab[i].getPoi();
						if(i>0) {
							g.drawLine((int)Math.round(tmp[i-1].getX()), (int)Math.round(tmp[i-1].getY()), (int)Math.round(tmp[i].getX()), (int)Math.round(tmp[i].getY()));
						}
					}
				}
			}
		};
		
		mid_points.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	System.out.println("Clic");
		    	for(int i=0; i<poiTab.length; i++){ // Pour chaque POI
		    		if((poiTab[i].getX()-4 < e.getX()) && (e.getX() < poiTab[i].getX()+4) && (poiTab[i].getY()-4 < e.getY()) && (e.getY() < poiTab[i].getY()+4)){ // On vérifie que le clic se situe dans le POI
		    			System.out.println("Vous avez cliqué sur le poi " + i + " !");
		    			System.out.println(poiTab[i].getLabel());
		    		}
		    	}
		    }
		});
		
		mid_content.add(map);
		ImageIcon MapImage = new ImageIcon("map.jpg");
		map.setIcon(MapImage);
		mid_points.setSize(new Dimension(599, 388));
		map.add(mid_points);
		JPanel right_content = new JPanel();
		JPanel left_buttons = new JPanel();
		JPanel mid_buttons = new JPanel();
		JPanel right_buttons = new JPanel();
		JPanel content = new JPanel();
		JPanel boutons_bas = new JPanel();
		
		
		JTextArea details = new JTextArea();
			details.setRows(30);
			details.setColumns(25);
		JComboBox choice = new JComboBox<String>();
		choice.setPreferredSize(new Dimension(100, 25));
	    choice.addItem("Nom exact");
	    choice.addItem("Partie de nom");
	    choice.addItem("Mot de la description");
		TextField search_input = new TextField();
		search_input.setPreferredSize(new Dimension(100, 25));
		JButton search = new JButton("Rechercher");
		final JButton mode_switch = new JButton("Edition");
		
		
		final JButton modify_details = new JButton("Modifier details");
		final JButton delete_point = new JButton("Supprimer point");
		final JButton create_point = new JButton("Créer point");
		final JButton move_point = new JButton("Déplacer point");
		final JButton add_trip_point = new JButton("Ajouter point");
		final JButton remove_trip_point = new JButton("Retirer point");
		final JButton create_trip = new JButton("Ajouter parcours");
		final JButton modify_trip = new JButton("Modifier parcours");
		final JButton delete_trip = new JButton("Supprimer parcours");
		final JButton create_location = new JButton("Ajouter lieu");
		final JButton modify_location = new JButton("Modifier lieu");
		final JButton delete_location = new JButton("Supprimer lieu");
		
		delete_point.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {

            }
        }); 

		create_point.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            	POI_Window addPoi = new POI_Window();
            	addPoi.setVisible(true);
            }
        }); 
		create_trip.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            	Trip_Window addPoi = new Trip_Window();
            	addPoi.setVisible(true);
            }
        }); 
		modify_trip.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            	Trip_Window addPoi = new Trip_Window();
            	addPoi.setVisible(true);
            }
        }); 
		delete_trip.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            	
            }
        }); 

		create_location.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            	Location_Window addPoi = new Location_Window();
            	addPoi.setVisible(true);
            }
        }); 
		modify_location.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            	Location_Window addPoi = new Location_Window();
            	addPoi.setVisible(true);
            }
        });
		delete_location.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            	
            }
        }); 
		
		
		JButton previous = new JButton("Précédent");
		JButton next = new JButton("Suivant");
		
                create_point.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }
            @Override
            public void mousePressed(MouseEvent e) {
               
            }
            @Override
            public void mouseReleased(MouseEvent e) {
               
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
                
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		this.getContentPane().add(main_panel);
		main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
		main_panel.add(upper_panel);
		main_panel.add(content);
		main_panel.add(boutons_bas);
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
		
		
		upper_panel.setLayout(new BorderLayout());
		upper_panel.add(navigate, BorderLayout.WEST);
		upper_panel.add(search_panel, BorderLayout.CENTER);
		upper_panel.add(mode_switch_panel, BorderLayout.EAST);
		navigate.add(previous);
		navigate.add(next);
		search_panel.add(choice);
		search_panel.add(search_input);
		search_panel.add(search);
		mode_switch_panel.add(mode_switch);
		
		left_content.add(details);
		left_buttons.add(modify_details);
		left_buttons.add(delete_point);
		
		mid_buttons.add(create_point);
		mid_buttons.add(move_point);
		
		right_buttons.add(add_trip_point);
		right_buttons.add(remove_trip_point);
		
		boutons_bas.setLayout(new BoxLayout(boutons_bas, BoxLayout.X_AXIS));
		boutons_bas.add(create_trip);
		boutons_bas.add(modify_trip);
		boutons_bas.add(delete_trip);
		boutons_bas.add(create_location);
		boutons_bas.add(modify_location);
		boutons_bas.add(delete_location);
		
		modify_details.setEnabled(false);
		delete_point.setEnabled(false);
		create_point.setEnabled(false);
		move_point.setEnabled(false);
		add_trip_point.setEnabled(false);
		remove_trip_point.setEnabled(false);
		create_trip.setEnabled(false);
		modify_trip.setEnabled(false);
		delete_trip.setEnabled(false);
		create_location.setEnabled(false);
		modify_location.setEnabled(false);
		delete_location.setEnabled(false);
		
		mode_switch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(edition == false){
					modify_details.setEnabled(true);
					delete_point.setEnabled(true);
					create_point.setEnabled(true);
					move_point.setEnabled(true);
					add_trip_point.setEnabled(true);
					remove_trip_point.setEnabled(true);
					create_trip.setEnabled(true);
					modify_trip.setEnabled(true);
					delete_trip.setEnabled(true);
					create_location.setEnabled(true);
					modify_location.setEnabled(true);
					delete_location.setEnabled(true);
					
					edition = true;
				} else {
					modify_details.setEnabled(false);
					delete_point.setEnabled(false);
					create_point.setEnabled(false);
					move_point.setEnabled(false);
					add_trip_point.setEnabled(false);
					remove_trip_point.setEnabled(false);
					create_trip.setEnabled(false);
					modify_trip.setEnabled(false);
					delete_trip.setEnabled(false);
					create_location.setEnabled(false);
					modify_location.setEnabled(false);
					delete_location.setEnabled(false);
					
					edition = false;
				}
				
			}
		});
	}
}