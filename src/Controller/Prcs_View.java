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
        
        public StcMsg initializeLocation(StcMsg oMsg) throws ClassNotFoundException, SQLException
        {
            StcMsg oMsga = new StcMsg();
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.loadLocation(oMsg);
            
            return this.oMsg;
        }
        
        public void addLocation(StcMsg oMsg) throws ClassNotFoundException, SQLException
        {
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.addLocation(oMsg);
        }
        
        public void updateLocation(StcMsg oMsg) throws ClassNotFoundException, SQLException
        {
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.updateLocation(oMsg);
        }
        
        public void deleteLocation(StcMsg oMsg) throws ClassNotFoundException, SQLException
        {
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.deleteLocation(oMsg);
        }
        
        public void addPoi(StcMsg oMsg) throws ClassNotFoundException, SQLException
        {
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.addPOI(oMsg);
        }
        
        public void updatePoi(StcMsg oMsg) throws ClassNotFoundException, SQLException
        {
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.updatePOI(oMsg);
        }
        
        public void deletePoi(StcMsg oMsg) throws ClassNotFoundException, SQLException
        {
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.deletePOI(oMsg);
        }
        
        public void addTrip(StcMsg oMsg) throws ClassNotFoundException, SQLException
        {
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.addTrip(oMsg);
        }
        
        public void updateTrip(StcMsg oMsg) throws ClassNotFoundException, SQLException
        {
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.updateTrip(oMsg);
        }
        
        public void deleteTrip(StcMsg oMsg) throws ClassNotFoundException, SQLException
        {
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.deleteTrip(oMsg);
        }
}
