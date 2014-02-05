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
public class Mpg_LinkHyperText implements Mpg {
    
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
        
        this.oMsg.rqSql = "SELECT * FROM `linkhypertext` WHERE `IDLinkHyperText` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
       
        return this.oMsg;
    }

    @Override
    public StcMsg add(StcMsg oMsg) {
        
        String link;
        
        this.oMsg = new StcMsg();
        
        link = (String)oMsg.data[0];

        this.oMsg.rqSql = "INSERT INTO `linkhypertext`(`LinkHyperText`) VALUES (?)";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = link;

        return this.oMsg;
    }

    @Override
    public StcMsg update(StcMsg oMsg) {
        
        Integer id;
        String link;
        
        this.oMsg = new StcMsg();
        
        link = (String)oMsg.data[0];
        id = (Integer)oMsg.data[1];

        this.oMsg.rqSql = "UPDATE `linkhypertext` SET `LinkHyperText`= ? WHERE `IDLinkHyperText` = ?";
        this.oMsg.data = new Object[2];
        this.oMsg.data[0] = link;
        this.oMsg.data[1] = id;
        
        return this.oMsg;
    }

    @Override
    public StcMsg deleteById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "DELETE FROM `linkhypertext` WHERE `IDLinkHyperText` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
        
        return this.oMsg;
    }
}
