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
public class Mpg_Location implements Mpg {

    private StcMsg oMsg;

    @Override
    public StcMsg getAll(StcMsg oMsg) {
        
        this.oMsg = new StcMsg();
        
        this.oMsg.rqSql = "SELECT * FROM `location`";
        
        return this.oMsg;
    }

    @Override
    public StcMsg getById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "SELECT * FROM `location` WHERE `IDLocation` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
       
        return this.oMsg;
    }

    @Override
    public StcMsg add(StcMsg oMsg) {
        
        String label;
        String image;
        
        this.oMsg = new StcMsg();
        
        label = (String)oMsg.data[0];
        image = (String)oMsg.data[1];
        
        
        this.oMsg.rqSql = "INSERT INTO `location`(`LabelLocation`, `ImageLocation`) VALUES (?,?)";
        this.oMsg.data = new Object[2];
        this.oMsg.data[0] = label;
        this.oMsg.data[1] = image;

        return this.oMsg;
    }

    @Override
    public StcMsg update(StcMsg oMsg) {
        
        Integer id;
        String label;
        String image;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        label = (String)oMsg.data[1];
        image = (String)oMsg.data[2];  

        this.oMsg.rqSql = "UPDATE `location` SET `LabelLocation`= ?,`ImageLocation`= ? WHERE `IDLocation` = ?";
        this.oMsg.data = new Object[3];
        this.oMsg.data[0] = id;
        this.oMsg.data[1] = label;
        this.oMsg.data[2] = image;
        
        return this.oMsg;
    }

    @Override
    public StcMsg deleteById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "DELETE FROM `location` WHERE `IDLocation` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
        
        return this.oMsg;
    }
    
}
