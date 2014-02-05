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
public class Mpg_POILink implements Mpg {

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
        
        this.oMsg.rqSql = "SELECT * FROM `poilink` WHERE `IDPoi` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
       
        return this.oMsg;
    }

    @Override
    public StcMsg add(StcMsg oMsg) {
        
        Integer idnews;
        Integer idlink;
        
        this.oMsg = new StcMsg();
        
        idnews = (Integer)oMsg.data[0];
        idlink = (Integer)oMsg.data[1];  

        this.oMsg.rqSql = "INSERT INTO `poilink`(`IDPoi`, `IDLinkHyperText`) VALUES (?,?)";
        this.oMsg.data = new Object[2];
        this.oMsg.data[0] = idnews;
        this.oMsg.data[1] = idlink;

        return this.oMsg;
    }

    @Override
    public StcMsg update(StcMsg oMsg) {
        
        Integer idnews;
        Integer idlink;
        
        this.oMsg = new StcMsg();
        
        idlink = (Integer)oMsg.data[0];
        idnews = (Integer)oMsg.data[1];   

        this.oMsg.rqSql = "UPDATE `poilink` SET `IDLinkHyperText`= ? WHERE `IDPoi` = ?";
        this.oMsg.data = new Object[2];
        this.oMsg.data[0] = idlink;
        this.oMsg.data[1] = idnews;
        
        return this.oMsg;
    }

    @Override
    public StcMsg deleteById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "DELETE FROM `poilink` WHERE `IDPoi` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
        
        return this.oMsg;
    }
    
}
