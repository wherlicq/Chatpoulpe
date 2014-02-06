package miniSIG;

import java.sql.SQLException;

import Controller.*;
import Data.*;

public class Sig {
	private static Processus oP = new Processus();
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StcMsg oMsg = new StcMsg();
		oMsg.data = new Object[1];
		oMsg.data[0] = 0;
		oP.loadLocation(oMsg);


	}

}
