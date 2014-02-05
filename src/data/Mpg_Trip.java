/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minisig.Data;

/**
 *
 * @author Sush
 */
public class Mpg_Trip implements Mpg {

    private StcMsg oMsg;
    
    @Override
    public StcMsg getAll(StcMsg oMsg) {
        
        this.oMsg = new StcMsg();
        
        this.oMsg.rqSql = "SELECT * FROM `trip`";
        
        return this.oMsg;
    }

    @Override
    public StcMsg getById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "SELECT * FROM `trip` WHERE `IDTrip` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
       
        return this.oMsg;
    }

    @Override
    public StcMsg add(StcMsg oMsg) {
        
        String label;
        String text;
        
        this.oMsg = new StcMsg();
        
        label = (String)oMsg.data[0];
        text = (String)oMsg.data[1];
        
        
        this.oMsg.rqSql = "INSERT INTO `trip`(`LabelTrip`, `TextTrip`) VALUES (?,?)";
        this.oMsg.data = new Object[2];
        this.oMsg.data[0] = label;
        this.oMsg.data[1] = text;

        return this.oMsg;
    }

    @Override
    public StcMsg update(StcMsg oMsg) {
        
        Integer id;
        String label;
        String text;
        
        this.oMsg = new StcMsg();
        
        label = (String)oMsg.data[0];
        text = (String)oMsg.data[1];
        id = (Integer)oMsg.data[2];

        this.oMsg.rqSql = "UPDATE `trip` SET `LabelTrip`= ?,`TextTrip`= ? WHERE `IDTrip` = ?";
        this.oMsg.data = new Object[3];
        this.oMsg.data[0] = label;
        this.oMsg.data[1] = text;
        this.oMsg.data[2] = id;
        
        return this.oMsg;
    }

    @Override
    public StcMsg deleteById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "DELETE FROM `trip` WHERE `IDTrip` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
        
        return this.oMsg;
    }
    
}
