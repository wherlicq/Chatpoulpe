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
public class Mpg_Image implements Mpg{
    
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
        
        this.oMsg.rqSql = "SELECT * FROM `image` WHERE `IDPoi` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
       
        return this.oMsg;
    }

    @Override
    public StcMsg add(StcMsg oMsg) {
        
        String image;
        
        this.oMsg = new StcMsg();
        
        image = (String)oMsg.data[0];

        this.oMsg.rqSql = "INSERT INTO `image`(`Image`) VALUES (?)";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = image;

        return this.oMsg;
    }
    
    public StcMsg addImagePoi(StcMsg oMsg) {
        
        String image;
        Integer idpoi;
        
        this.oMsg = new StcMsg();
        
        image = (String)oMsg.data[0];
        idpoi = (Integer)oMsg.data[1];
        
        this.oMsg.rqSql = "INSERT INTO `image`(`Image`, `IDPoi`) VALUES (?,?)";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = image;
        this.oMsg.data[1] = idpoi;
        
        return this.oMsg;
    }

    @Override
    public StcMsg update(StcMsg oMsg) {
        
        Integer id;
        String image;
        
        this.oMsg = new StcMsg();
        
        image = (String)oMsg.data[0];
        id = (Integer)oMsg.data[1];

        this.oMsg.rqSql = "UPDATE `image` SET `Image`= ? WHERE `IDImage` = ?";
        this.oMsg.data = new Object[2];
        this.oMsg.data[0] = image;
        this.oMsg.data[1] = id;
        
        return this.oMsg;
    }

    @Override
    public StcMsg deleteById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "DELETE FROM `image` WHERE `IDImage` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
        
        return this.oMsg;
    }
}
