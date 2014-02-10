package Controller;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

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
            this.oP = new Processus();
            home.setVisible(true);
            //addLocation();
//            updateLocation();
//            deleteLocation();
           //initializeLocation();
           //Location loc = this.oP.getLoc();
            
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
        
        public void newsClick(Integer idItem, String typeItem) throws ClassNotFoundException, SQLException
        {
            System.out.println("Selected News :\nid : " + idItem + " | type : " + typeItem);
            
            switch(typeItem) {
            case "Location":
            	this.oP = new Processus();
            	this.oMsg = new StcMsg();
            	this.oMsg.data = new Object[1];
            	this.oMsg.data[0] = (Object)idItem;
            	this.oP.loadLocation(this.oMsg);
            	// add the map generator method
            	break;
            	
            case "POI" :
            	this.oP = new Processus();
            	this.oMsg = new StcMsg();
            	this.oMsg.data = new Object[1];
            	this.oMsg.data[0] = (Object)this.oP.getPOIsLocation(idItem);
            	this.oP.loadLocation(this.oMsg);
            	initializeLocation((Integer)this.oMsg.data[0]);
				DisplayLoc();
            	break;
            	
            case "Trip":
            	this.oP = new Processus();
            	this.oMsg = new StcMsg();
            	this.oMsg.data = new Object[1];
            	this.oMsg.data[0] = (Object)this.oP.getTripsLocation(idItem);
            	this.oP.loadLocation(this.oMsg);
            	// add the map generator method
            	break;
            }
        }
        
        public StcMsg initializeLocation(Integer idLocation) throws ClassNotFoundException, SQLException
        {
            StcMsg oMsga = new StcMsg();
            oMsga.data = new Object[1];
            oMsga.data[0] = idLocation;
            this.oMsg = new StcMsg();
            this.oP = new Processus();
            this.oMsg = this.oP.loadLocation(oMsga);
            
            return this.oMsg;
        }
        
        public void DisplayLoc()
        {
        	if (this.main != null)
        	{
        		this.main.initialize();
        	}
        	else 
        	{
        		this.main = new Main_Window(this);
        	}
        	
        	this.main.setVisible(true);
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

    	public Processus getProcessus() {
    		return oP;
    	}
    	public void setProcessus(Processus oP) {
    		this.oP = oP;
    	}
}
