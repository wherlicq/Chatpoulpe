package Controller;

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
	}
	
	public StcMsg deletePOI(StcMsg oMsg)
	{
		this.oMsg = this.mpgPOI.deleteById(oMsg);
		this.oCAD = new CAD();
		this.oMsg = this.oCAD.execQuery(this.oMsg);
		
		this.mpgTripPOI.deleteByIdPOI(oMsg);
		this.oCAD = new CAD();
		this.oMsg = this.oCAD.execQuery(this.oMsg);
		
		this.oMsg = this.loadLocation(oMsg);
		return oMsg;
	}
	
	// Trip --------------------------------------------------------------------------------------------------------------------------
	public StcMsg addTrip(StcMsg oMsg)
	{
		this.oMsg = this.mpgTrip.add(oMsg);
		this.oCAD = new CAD();
		this.oMsg = this.oCAD.execQuery(this.oMsg);
		this.oMsg = this.loadLocation(oMsg);
		return oMsg;
	}
	public StcMsg updateTrip(StcMsg oMsg)
	{
		this.oMsg = this.mpgTrip.update(oMsg);
		this.oCAD = new CAD();
		this.oMsg = this.oCAD.execQuery(this.oMsg);
		this.oMsg = this.loadLocation(oMsg);
		return oMsg;
	}
	public StcMsg deleteTrip(StcMsg oMsg)
	{
		this.oMsg = this.mpgTrip.deleteById(oMsg);
		this.oCAD = new CAD();
		this.oMsg = this.oCAD.execQuery(this.oMsg);
		
		this.oMsg = this.loadLocation(oMsg);

		return oMsg;
	}
	
	// Location -------------------------------------------------------------------------------------------------------------------
	public StcMsg addLocation(StcMsg oMsg)
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
	public StcMsg updateLocation(StcMsg oMsg)
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
	public StcMsg deleteLocation(StcMsg oMsg)
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
		this.oCAD = new CAD();
		this.oMsg = this.mpgLocation.getById(oMsg);
		this.oCAD.execQuery(this.oMsg);
		this.loc = new Location(oMsg);
		
		this.oMsg = this.mpgLocationPOI.getByIdLocation(oMsg);
		this.oCAD.execQuery(this.oMsg);
		
		return oMsg;
	}
	public StcMsg loadNews(StcMsg oMsg)
	{
		return oMsg;
	}
}
