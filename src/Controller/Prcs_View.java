package Controller;

import java.sql.SQLException;

import Data.StcMsg;
import GUI.Home_Window;
import GUI.Main_Window;

public class Prcs_View {
	private Processus oP;
	private Home_Window home;
	private Main_Window main;
        private StcMsg oMsg;
	
	public void initialize() throws ClassNotFoundException, SQLException
	{
                home = new Home_Window(this);
                home.setVisible(true);
	}
        
        public StcMsg initializeNews() throws SQLException, ClassNotFoundException
        {
            StcMsg oMsga = new StcMsg();
            this.oMsg = new StcMsg();
            oMsga.data = new Object[1];
            oMsga.data[0] = true;
            this.oP = new Processus();
            this.oMsg = this.oP.loadNews(oMsga);
            
            return this.oMsg;
        }
}
