/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

/**
 *
 * @author Sush
 */
public class Mpg_TripPOI implements Mpg {
    
    private StcMsg oMsg;

    @Override
    public StcMsg getAll(StcMsg oMsg) {
        
        this.oMsg = new StcMsg();
        
        this.oMsg.rqSql = "SELECT * FROM `trippoi`";
        
        return this.oMsg;
    }

    @Override
    public StcMsg getById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "SELECT * FROM `trippoi` WHERE `IDTrip` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
       
        return this.oMsg;
    }

    @Override
    public StcMsg add(StcMsg oMsg) {
       
        Integer idtrip;
        Integer idpoi;
        
        this.oMsg = new StcMsg();
        
        idtrip = (Integer)oMsg.data[0];
        idpoi = (Integer)oMsg.data[1];  

        this.oMsg.rqSql = "INSERT INTO `trippoi`(`IDTrip`, `IDPoi`) VALUES (?,?)";
        this.oMsg.data = new Object[2];
        this.oMsg.data[0] = idtrip;
        this.oMsg.data[1] = idpoi;

        return this.oMsg;
    }

    @Override
    public StcMsg update(StcMsg oMsg) {
        
        Integer idtrip;
        Integer idpoi;
        
        this.oMsg = new StcMsg();
        
        idpoi = (Integer)oMsg.data[0];
        idtrip = (Integer)oMsg.data[1]; 

        this.oMsg.rqSql = "UPDATE `trippoi` SET `IDPoi`= ? WHERE `IDTrip` = ?";
        this.oMsg.data = new Object[2];
        this.oMsg.data[0] = idtrip;
        this.oMsg.data[1] = idpoi;
        
        return this.oMsg;
    }

    @Override
    public StcMsg deleteById(StcMsg oMsg) {
       
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "DELETE FROM `trippoi` WHERE `IDTrip` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
        
        return this.oMsg;
    }
}
