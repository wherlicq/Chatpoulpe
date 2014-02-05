package Controller;
import GUI.Main_Window;
import GUI.Home_Window;
import Data.Mpg_TripPOI;
import Data.Mpg_LocationPOI;
import Data.StcMsg;
import Data.Mpg_POILink;
import Data.Mpg_News;
import Data.Mpg_Trip;
import Data.Mpg_LinkHyperText;
import Data.Mpg_NewsImage;
import Data.Mpg_Location;
import Data.CAD;
import Data.Mpg_POI;
import Data.Mpg_Image;
import java.sql.SQLException;


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
		try {
			this.oCAD = new CAD();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	public StcMsg addPOI(StcMsg oMsg)
	{
		return oMsg;
	}
	public StcMsg updatePOI(StcMsg oMsg)
	{
		return oMsg;
	}
	public StcMsg deletePOI(StcMsg oMsg)
	{
		return oMsg;
	}
	public StcMsg adTrip(StcMsg oMsg)
	{
		return oMsg;
	}
	public StcMsg updateTrip(StcMsg oMsg)
	{
		return oMsg;
	}
	public StcMsg deleteTrip(StcMsg oMsg)
	{
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
		this.oMsg = this.loadLocation(oMsg);
		return oMsg;
	}
	// ----------------------------------------------------------------------------------------------------------------------------
	
	public StcMsg loadLocation(StcMsg oMsg)
	{
		return oMsg;
	}
	public StcMsg loadNews(StcMsg oMsg)
	{
		return oMsg;
	}
}
