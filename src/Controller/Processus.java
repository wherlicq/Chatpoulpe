package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import GUI.*;
import Data.*;

/*
 *
 *@author Will 
 */

public class Processus {
	private Home_Window home;
	private Main_Window main;
	private CAD oCAD;
	private Location loc;
	private Trip[] trip;
	private News[] news;
	private History history;
	private StcMsg oMsg;
	private Mpg_POI mpgPOI;
	private Mpg_Trip mpgTrip;
	private Mpg_LinkHyperText mpgLink;
	private Mpg_LocationPOI mpgLocationPOI;
	private Mpg_Image mpgImage;
	private Mpg_News mpgNews;
	private Mpg_NewsImage mpgNewsImage;
	private Mpg_TripPOI mpgTripPOI;
	private Mpg_POILink mpgPOILink;
	private Mpg_Location mpgLocation;
	
	public Processus() 
	{
		this.home = new Home_Window();
		this.main = new Main_Window();
		
		this.oMsg = new StcMsg();
		
		this.mpgPOI = new Mpg_POI();
		this.mpgTrip = new Mpg_Trip();
		this.mpgLink = new Mpg_LinkHyperText();
		this.mpgLocationPOI = new Mpg_LocationPOI();
		this.mpgImage = new Mpg_Image();
		this.mpgNews = new Mpg_News();
		this.mpgNewsImage = new Mpg_NewsImage();
		this.mpgTripPOI = new Mpg_TripPOI();
		this.mpgPOILink = new Mpg_POILink();
		this.mpgLocation = new Mpg_Location();
		
	}
	
	// POI ----------------------------------------------------------------------------------------------------------------------------
	public StcMsg addPOI(StcMsg oMsg) throws ClassNotFoundException, SQLException
	{
		this.oMsg = this.mpgPOI.add(oMsg);
		this.oCAD = new CAD();
		this.oMsg = this.oCAD.execQuery(this.oMsg);
		this.oMsg = this.loadLocation(oMsg);
		return oMsg;
	}
	public StcMsg updatePOI(StcMsg oMsg) throws ClassNotFoundException, SQLException
	{
		this.oMsg = this.mpgPOI.update(oMsg);
		this.oCAD = new CAD();
		this.oMsg = this.oCAD.execQuery(this.oMsg);
		this.oMsg = this.loadLocation(oMsg);
		return this.oMsg;
	}
	
	public StcMsg deletePOI(StcMsg oMsg) throws ClassNotFoundException, SQLException
	{
		this.oMsg = this.mpgPOI.deleteById(oMsg);
		this.oCAD = new CAD();
		this.oMsg = this.oCAD.execQuery(this.oMsg);
		
		this.mpgTripPOI.deleteById(oMsg);
		this.oCAD = new CAD();
		this.oMsg = this.oCAD.execQuery(this.oMsg);
		
		this.oMsg = this.loadLocation(oMsg);
		return oMsg;
	}
	
	// Trip --------------------------------------------------------------------------------------------------------------------------
	public StcMsg addTrip(StcMsg oMsg) throws ClassNotFoundException, SQLException
	{
		this.oMsg = this.mpgTrip.add(oMsg);
		this.oCAD = new CAD();
		this.oMsg = this.oCAD.execQuery(this.oMsg);
		this.oMsg = this.loadLocation(oMsg);
		return oMsg;
	}
	public StcMsg updateTrip(StcMsg oMsg) throws ClassNotFoundException, SQLException
	{
		this.oMsg = this.mpgTrip.update(oMsg);
		this.oCAD = new CAD();
		this.oMsg = this.oCAD.execQuery(this.oMsg);
		this.oMsg = this.loadLocation(oMsg);
		return oMsg;
	}
	public StcMsg deleteTrip(StcMsg oMsg) throws ClassNotFoundException, SQLException
	{
		this.oMsg = this.mpgTrip.deleteById(oMsg);
		this.oCAD = new CAD();
		this.oMsg = this.oCAD.execQuery(this.oMsg);
		
		this.oMsg = this.loadLocation(oMsg);

		return oMsg;
	}
	
	// Location -------------------------------------------------------------------------------------------------------------------
	public StcMsg addLocation(StcMsg oMsg) throws ClassNotFoundException, SQLException
	{
		this.oMsg = this.mpgLocation.add(oMsg);
		try {
			this.oCAD = new CAD();
			this.oMsg = this.oCAD.execQuery(this.oMsg);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.oMsg = this.loadLocation(oMsg);
		return oMsg;
	}
	public StcMsg updateLocation(StcMsg oMsg) throws ClassNotFoundException, SQLException
	{
		this.oMsg = this.mpgLocation.update(oMsg);
		try {
			this.oCAD = new CAD();
			this.oMsg = this.oCAD.execQuery(this.oMsg);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.oMsg = this.loadLocation(oMsg);
		return oMsg;
	}
	public StcMsg deleteLocation(StcMsg oMsg) throws ClassNotFoundException, SQLException
	{
		this.oMsg = this.mpgLocation.deleteById(oMsg);
		try {
			this.oCAD = new CAD();
			this.oMsg = this.oCAD.execQuery(this.oMsg);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.oMsg = this.mpgLocationPOI.getByIdLocation(oMsg);
		for (int i = 0; i < this.oMsg.data.length; i++)
		{
			this.deletePOI(this.oMsg);
		}
		
		return oMsg;
	}
	// ----------------------------------------------------------------------------------------------------------------------------
	
	public StcMsg loadLocation(StcMsg oMsg) throws ClassNotFoundException, SQLException
	{
		StcMsg Loc = oMsg;
		StcMsg LocPOI = oMsg;
		StcMsg POI = new StcMsg();
		
		this.oCAD = new CAD();
		
		//Integer[] POItab;
		
		ResultSet tmp;
		
		
		Loc = this.mpgLocation.getById(Loc);
		Loc = this.oCAD.execQuery(Loc);
		tmp = (ResultSet)LocPOI.data[0];
		
		
		
		/*
		LocPOI = this.mpgLocationPOI.getByIdLocation(LocPOI);
		LocPOI = this.oCAD.execQuery(LocPOI);
		tmp = (ResultSet)LocPOI.data[0];
			*/	
		/*
		POItab = new Integer[tmp.length];
		
				int i = 0;
				while(tmp.next()){
					POItab[i] = tmp.getInt("idPOI");
				}
			*/	
				
				
				
		
		return oMsg;
	}
	public StcMsg loadNews(StcMsg oMsg)
	{
		return oMsg;
	}
}
