package miniSIG;

import java.sql.SQLException;

import Controller.*;
import Data.*;
import GUI.Main_Window;

public class Sig {
	private static Prcs_View oVP;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		oVP = new Prcs_View();
		oVP.initialize();
	}

}
