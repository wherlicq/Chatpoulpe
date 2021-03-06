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
public class Mpg_News implements Mpg {

    private StcMsg oMsg;
    
    @Override
    public StcMsg getAll(StcMsg oMsg) {
        
        this.oMsg = new StcMsg();
        
        this.oMsg.rqSql = "SELECT * FROM `news`";
        
        return this.oMsg;
    }

    @Override
    public StcMsg getById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "SELECT * FROM `news` WHERE `IDNews` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
       
        return this.oMsg;
    }
    
    public StcMsg getByNew(StcMsg oMsg) {
        
        Boolean news;
        
        this.oMsg = new StcMsg();
        
        news = (Boolean)oMsg.data[0];
        
        this.oMsg.rqSql = "SELECT * FROM `news` WHERE `NewNews` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = news;
       
        return this.oMsg;
    }

    @Override
    public StcMsg add(StcMsg oMsg) {
        
        String label;
        String text;
        Integer idItem;
        String TypeItem;
        
        this.oMsg = new StcMsg();
        
        label = (String)oMsg.data[0];
        text = (String)oMsg.data[1];
        idItem = (Integer)oMsg.data[2];
        TypeItem = (String)oMsg.data[3];
        
        
        this.oMsg.rqSql = "INSERT INTO `news`(`LabelNews`, `TextNews`, `IDItemAdded`, `TypeItemAdded`) VALUES (?,?,?,?)";
        this.oMsg.data = new Object[2];
        this.oMsg.data[0] = label;
        this.oMsg.data[1] = text;
        this.oMsg.data[2] = idItem;
        this.oMsg.data[3] = TypeItem;

        return this.oMsg;
    }

    @Override
    public StcMsg update(StcMsg oMsg) {
        
        Integer id;
        String label;
        String text;
        Boolean news;
        
        this.oMsg = new StcMsg();
        
        label = (String)oMsg.data[0];
        text = (String)oMsg.data[1];  
        news = (Boolean)oMsg.data[2];
        id = (Integer)oMsg.data[3];

        this.oMsg.rqSql = "UPDATE `news` SET `LabelNews`= ?,`TextNews`= ?,`NewNews`= ? WHERE `IDNews` = ?";
        this.oMsg.data = new Object[3]; 
        this.oMsg.data[0] = label;
        this.oMsg.data[1] = text;
        this.oMsg.data[2] = news;
        this.oMsg.data[3] = id;
        
        return this.oMsg;
    }

    @Override
    public StcMsg deleteById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "DELETE FROM `news` WHERE `IDNews` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
        
        return this.oMsg;
    }
    
}
