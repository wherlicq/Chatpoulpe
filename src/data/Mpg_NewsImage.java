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
public class Mpg_NewsImage implements Mpg {

    private StcMsg oMsg;
    
    @Override
    public StcMsg getAll(StcMsg oMsg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StcMsg getById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "SELECT * FROM `newsimage` WHERE `IDNews` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
       
        return this.oMsg;
    }

    @Override
    public StcMsg add(StcMsg oMsg) {
        
        Integer idnews;
        Integer idimage;
        
        this.oMsg = new StcMsg();
        
        idnews = (Integer)oMsg.data[0];
        idimage = (Integer)oMsg.data[1];  

        this.oMsg.rqSql = "INSERT INTO `newsimage`(`IDNews`, `IDImage`) VALUES (?,?)";
        this.oMsg.data = new Object[2];
        this.oMsg.data[0] = idnews;
        this.oMsg.data[1] = idimage;

        return this.oMsg;
    }

    @Override
    public StcMsg update(StcMsg oMsg) {
        
        Integer idnews;
        Integer idimage;
        
        this.oMsg = new StcMsg();
        
        idimage = (Integer)oMsg.data[0];
        idnews = (Integer)oMsg.data[1];   

        this.oMsg.rqSql = "UPDATE `newsimage` SET `IDImage`= ? WHERE `IDNews` = ?";
        this.oMsg.data = new Object[2];
        this.oMsg.data[0] = idimage;
        this.oMsg.data[1] = idnews;
        
        return this.oMsg;
    }

    @Override
    public StcMsg deleteById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "DELETE FROM `newsimage` WHERE `IDNews` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
        
        return this.oMsg;
    }
    
}
