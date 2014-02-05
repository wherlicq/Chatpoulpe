package miniSIG;

import Data.StcMsg;

public class Sig {
private static Controller.Processus oP = new Controller.Processus();
private static StcMsg oMsg = new StcMsg();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            
            Sig.oMsg.data = new Object[2];
            Sig.oMsg.data[0] = "test1";
            Sig.oMsg.data[1] = "test2";
            Sig.oMsg = oP.addLocation(oMsg);
	}

}
