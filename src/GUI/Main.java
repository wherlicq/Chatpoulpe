package GUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Controller.POI;

public class Main{
	/**
	 * @param args
	 */
	public  void main() {
		JFrame test = new JFrame();
		test.setSize(400, 400);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Instanciation de deux POI de test avec les coordonnées et le libellé		
		
		POI poi1 = new POI(0, "label1", "text1", (double)4, (double)7, "img1");
		POI poi2 = new POI(1, "label2", "text2", (double)25, (double)40, "img2");
		
		final POI[] poiTab = new POI[2];
		poiTab[0] = poi1;
		poiTab[1] = poi2;
		
		JPanel panneau = new JPanel() {
			public void paintComponent(Graphics g){
				for(int i=0; i<poiTab.length; i++){
					g.drawOval((int)Math.round(poiTab[i].getX()-2), (int)Math.round(poiTab[i].getY()-2), 4, 4); // Dessin des POI
				}
			}
		};
		
		panneau.addMouseListener(new MouseAdapter() {
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
		
		test.getContentPane().add(panneau);
		
		test.setVisible(true);
	}
}