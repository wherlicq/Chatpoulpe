package Controller;

import java.sql.SQLException;

import Data.StcMsg;
import GUI.Home_Window;
import GUI.Main_Window;

public class Prcs_View {
	private Processus oP;
	private Home_Window home;
	private Main_Window main;
	
	public void initialize() throws ClassNotFoundException, SQLException
	{
		StcMsg oMsg = new StcMsg();
		oMsg.data = new Object[1];
		oMsg.data[0] = 1;
		oP = new Processus();
		oP.loadLocation(oMsg);
	}
}
