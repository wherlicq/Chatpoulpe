package miniSIG;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

import Controller.*;
import Data.*;
import GUI.Main;
import GUI.Main_Window;
import GUI.TextAreaExample;

public class Sig {
	private static Prcs_View oVP;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		oVP = new Prcs_View();
		oVP.initialize();
		/*GUI.Main main = new Main();
		main.main();*/
	}

}
