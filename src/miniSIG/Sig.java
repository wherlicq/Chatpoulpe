package miniSIG;

import java.sql.SQLException;

import Controller.*;
import Data.*;

public class Sig {
	private static Processus oP = new Processus();
	private static StcMsg oMsg = new StcMsg();
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
            
            Sig.oMsg.data = new Object[2];
            Sig.oMsg.data[0] = "test1";
            Sig.oMsg.data[1] = "test2";
            Sig.oMsg = oP.addLocation(oMsg);
	}

}
