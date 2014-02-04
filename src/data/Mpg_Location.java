/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minisig.data;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sush
 */
public class Mpg_Location implements Mpg {

    private StcMsg oMsg;
    private ResultSet rs;

    @Override
    public StcMsg getAll(StcMsg oMsg) {
        
        this.oMsg = new StcMsg();
        
        return this.oMsg;
    }

    @Override
    public StcMsg getById(StcMsg oMsg) {
       this.oMsg = new StcMsg();
        
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
       this.oMsg = new StcMsg();
        
        return this.oMsg;
    }

    @Override
    public StcMsg deleteById(StcMsg oMsg) {
        this.oMsg = new StcMsg();
        
        return this.oMsg;
    }
    
}
