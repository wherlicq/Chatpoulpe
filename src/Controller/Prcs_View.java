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
//                home = new Home_Window(this);
//                home.setVisible(true);
            this.oP = new Processus();
            //addLocation();
//            updateLocation();
            deleteLocation();
//            initializeLocation();
            
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
        
        public StcMsg initializeLocation() throws ClassNotFoundException, SQLException
        {
            StcMsg oMsga = new StcMsg();
            oMsga.data = new Object[1];
            oMsga.data[0] = 1;
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.loadLocation(oMsg);
            
            return this.oMsg;
        }
        
        public void addLocation() throws ClassNotFoundException, SQLException
        {
            StcMsg oMsga = new StcMsg();
            oMsga.data = new Object[2];
            oMsga.data[0] = "testlabel";
            oMsga.data[1] = "testimage";
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.addLocation(oMsga);
        }
        
        public void updateLocation() throws ClassNotFoundException, SQLException
        {
            StcMsg oMsga = new StcMsg();
            oMsga.data = new Object[3];
            oMsga.data[0] = "test2label";
            oMsga.data[1] = "test2image";
            oMsga.data[2] = 3;
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.updateLocation(oMsg);
        }
        
        public void deleteLocation() throws ClassNotFoundException, SQLException
        {
            StcMsg oMsga = new StcMsg();
            oMsga.data = new Object[1];
            oMsga.data[0] = 2;
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
