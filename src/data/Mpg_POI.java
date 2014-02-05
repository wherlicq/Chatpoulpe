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
public class Mpg_POI implements Mpg {

    private StcMsg oMsg;
    
    @Override
    public StcMsg getAll(StcMsg oMsg) {
        
        this.oMsg = new StcMsg();
        
        this.oMsg.rqSql = "SELECT * FROM `poi`";
        
        return this.oMsg;
    }

    @Override
    public StcMsg getById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "SELECT * FROM `poi` WHERE `IDPoi` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
       
        return this.oMsg;
    }

    @Override
    public StcMsg add(StcMsg oMsg) {
        
        String label;
        String text;
        Double x;
        Double y;
        
        this.oMsg = new StcMsg();
        
        label = (String)oMsg.data[0];
        text = (String)oMsg.data[1];  
        x = (Double)oMsg.data[2];
        y = (Double)oMsg.data[3];

        this.oMsg.rqSql = "INSERT INTO `poi`(`LabelPoi`, `TextPoi`, `CoordinateX`, `CoordinateY`) VALUES (?,?,?,?)";
        this.oMsg.data = new Object[4];
        this.oMsg.data[0] = label;
        this.oMsg.data[1] = text;
        this.oMsg.data[2] = x;
        this.oMsg.data[3] = y;

        return this.oMsg;
    }

    @Override
    public StcMsg update(StcMsg oMsg) {
        
        Integer id;
        String label;
        String text;
        Double x;
        Double y;
        
        this.oMsg = new StcMsg();
        
        label = (String)oMsg.data[0];
        text = (String)oMsg.data[1];  
        x = (Double)oMsg.data[2];
        y = (Double)oMsg.data[3]; 
        id = (Integer)oMsg.data[4];

        this.oMsg.rqSql = "UPDATE `poi` SET `LabelPoi`= ?, `TextPoi`= ?, `CoordinateX`, `CoordinateY` WHERE `IDPoi` = ?";
        this.oMsg.data = new Object[5];
        this.oMsg.data[0] = label;
        this.oMsg.data[1] = text;
        this.oMsg.data[2] = x;
        this.oMsg.data[3] = y;
        this.oMsg.data[4] = id;
        
        return this.oMsg;
    }

    @Override
    public StcMsg deleteById(StcMsg oMsg) {
        
        Integer id;
        
        this.oMsg = new StcMsg();
        
        id = (Integer)oMsg.data[0];
        
        this.oMsg.rqSql = "DELETE FROM `poi` WHERE `IDPoi` = ?";
        this.oMsg.data = new Object[1];
        this.oMsg.data[0] = id;
        
        return this.oMsg;
    }
    
}
