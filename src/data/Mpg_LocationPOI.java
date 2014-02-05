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
public class Mpg_LocationPOI implements Mpg {
    
    private StcMsg oMsg;

    @Override
    public StcMsg getAll(StcMsg oMsg) {
        
        this.oMsg = new StcMsg();
        
        this.oMsg.rqSql = "SELECT * FROM `locationpoi`";
        
        return this.oMsg;
    }

    @Override
    public StcMsg getById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "SELECT * FROM `locationpoi` WHERE `IDLocation` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
       
        return this.oMsg;
    }
    
    public StcMsg getByIdLocation(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "SELECT * FROM `locationpoi` WHERE `IDLocation` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
       
        return this.oMsg;
    }
    
    public StcMsg getByIdPoi(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "SELECT * FROM `locationpoi` WHERE `IDPoi` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
       
        return this.oMsg;
    }

    @Override
    public StcMsg add(StcMsg oMsg) {
        
        Integer idlocation;
        Integer idpoi;
        
        this.oMsg = new StcMsg();
        
        idlocation = (Integer)oMsg.data[0];
        idpoi = (Integer)oMsg.data[1];  

        this.oMsg.rqSql = "INSERT INTO `locationpoi`(`IDLocation`, `IDPoi`) VALUES (?,?)";
        this.oMsg.data = new Object[2];
        this.oMsg.data[0] = idlocation;
        this.oMsg.data[1] = idpoi;

        return this.oMsg;
    }

    @Override
    public StcMsg update(StcMsg oMsg) {
        
        Integer idlocationnew;
        Integer idpoi;
        Integer idlocation;
        
        this.oMsg = new StcMsg();
        
        idlocationnew = (Integer)oMsg.data[0];
        idlocation = (Integer)oMsg.data[1];
        idpoi = (Integer)oMsg.data[2]; 

        this.oMsg.rqSql = "UPDATE `locationpoi` SET `IDLocation`= ?` WHERE `IDPoi` = ? AND `IDLocation` = ?";
        this.oMsg.data = new Object[3];
        this.oMsg.data[0] = idlocationnew;
        this.oMsg.data[1] = idpoi;
        this.oMsg.data[2] = idlocation;
        
        return this.oMsg;
    }

    @Override
    public StcMsg deleteById(StcMsg oMsg) {
 
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "DELETE FROM `locationpoi` WHERE `IDPoi` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
        
        return this.oMsg;
    }
}
