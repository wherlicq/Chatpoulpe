package Controller;

import java.sql.SQLException;

import Data.*;

/*
 *
 *@author Will 
 */

public class Processus {
	private CAD oCAD;
	private Location loc;
	private Trip[] trip;
	private POI[]poi;
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
		StcMsg TripPOI = new StcMsg();
		StcMsg Trip = new StcMsg();
		StcMsg Img = new StcMsg();
		//StcMsg POILink = new StcMsg();
		//StcMsg TripLink = new StcMsg();
				
		POI[] POItab;
		Trip[] Triptab;
		int nbPOI;
		int nbTrip;
		

		this.oCAD = new CAD();
		Loc = this.mpgLocation.getById(Loc);
		Loc = this.oCAD.execQuery(Loc);
		
		this.oCAD = new CAD();
		LocPOI = this.mpgLocationPOI.getById(LocPOI);
		LocPOI = this.oCAD.execQuery(LocPOI);

		
		nbPOI = (Integer)LocPOI.selectedData.length;
		POItab = new POI[nbPOI];
		POI.data = new Object[nbPOI];
		for(int i = 0; i < nbPOI; i++)
		{
			POI.data[0] = LocPOI.selectedData[i][1];
			this.oCAD = new CAD();
			POI = this.mpgPOI.getById(POI);
			POI = this.oCAD.execQuery(POI);
			Img = new StcMsg();
			Img.data = new Object[1];
			Img.data[0] = POI.selectedData[i][0];
			Img = this.mpgImage.getById(Img);
			this.oCAD = new CAD();
			Img = this.oCAD.execQuery(Img);
			/*
			POILink.data = new Object[1];
			POILink.data[0] = POI.selectedData[i][0];
			POILink = this.mpgPOILink.getById(POILink);
			POILink = this.oCAD.execQuery(POILink);*/
			POItab[i] = new POI((Integer)POI.selectedData[0][0], (String)POI.selectedData[0][1], (String)POI.selectedData[0][2], (Double)POI.selectedData[0][3], (Double)POI.selectedData[0][4], (String)Img.selectedData[0][1]);
		}
		
		this.loc = new Location((Integer)Loc.selectedData[0][0], (String)Loc.selectedData[0][1], (String)Loc.selectedData[0][2], POItab);
		this.poi = POItab;

		
		Trip.data = new Object[1];
		Trip.data[0] = Loc.selectedData[0][0];
		this.oCAD = new CAD();
		Trip = this.mpgTrip.getById(Trip);
		Trip = this.oCAD.execQuery(Trip);
		nbTrip = Trip.selectedData.length;
		POI[] tmpPOI = null;

		Triptab = new Trip[nbTrip];
		for (int i = 0; i < nbTrip; i++)
		{
			this.oCAD = new CAD();
			TripPOI.data = new Object[1];
			TripPOI.data[0] = Trip.selectedData[i][0];
			TripPOI = this.mpgTripPOI.getById(TripPOI);
			TripPOI = this.oCAD.execQuery(TripPOI);
			tmpPOI = new POI[TripPOI.selectedData.length];
			int k;
			int indexPOI = 0;
			for (int j = 0; j < tmpPOI.length; i++)
			{
				k = 0;
				do
				{
					if (this.poi[k].getId() == (Integer)TripPOI.selectedData[j][1])
					{
						tmpPOI[indexPOI] = (POI)this.poi[k];
						indexPOI++;
					}
					k++;
				}while(this.poi[k].getId() != (Integer)TripPOI.selectedData[j][1] || k >= TripPOI.selectedData.length);
				Triptab[i] = new Trip((Integer)Trip.selectedData[0][0], (String)Trip.selectedData[0][1], this.loc, tmpPOI);
			}
		}
		this.setTrip(Triptab);
				
		return oMsg;
	}
	
	public StcMsg loadNews(StcMsg oMsg) throws SQLException, ClassNotFoundException
	{
		StcMsg News = oMsg; 
		News = this.mpgNews.getByNew(News);
		this.oCAD = new CAD();
		News = this.oCAD.execQuery(News);
		return News;
	}

	public Trip[] getTrip() {
		return trip;
	}

	public void setTrip(Trip[] trip) {
		this.trip = trip;
	}

	public Location getLoc() {
		return loc;
	}

	public void setPoi(POI[] poi) {
		this.poi = poi;
	}
	public POI[] getPoi() {
		return this.poi;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public News[] getNews() {
		return news;
	}

	public void setNews(News[] news) {
		this.news = news;
	}

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}
}
