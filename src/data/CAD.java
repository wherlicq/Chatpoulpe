/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import java.sql.*;

/**
 *
 * @author Sush
 */
public class CAD {
    private Connection conn;
    private final StcMsg oMsg;
    private String dbUrl;
    private String user;
    private String pass;
    
    public CAD() throws ClassNotFoundException
    {
        this.oMsg = new StcMsg();
        try {
           Class.forName("com.mysql.jdbc.Driver");
           
           dbUrl = "jdbc:mysql://localhost:3306/minisig";
           user = "root";
           pass = "";

           conn = (Connection)DriverManager.getConnection(dbUrl,user,pass);
        } 
        catch (SQLException e) {
            throw new RuntimeException("Erreur dans l'obtention de la connexion");
        }
    }
    
    public StcMsg execQuery(StcMsg oMsg) throws SQLException
    {
        
        if(oMsg.rqSql.regionMatches(0, "SELECT", 6, 0))
        {
            try (PreparedStatement prepare = conn.prepareStatement(oMsg.rqSql))
            {   
                for(int i = 0; i < oMsg.data.length; i++)
                {
                    if(oMsg.data[i] instanceof String)
                    {
                        prepare.setString(i+1, (String)oMsg.data[i]);
                    }
                    else if(oMsg.data[i] instanceof Integer)
                    {
                        prepare.setInt(i+1, (Integer)oMsg.data[i]);
                    }
                    else if(oMsg.data[i] instanceof Boolean)
                    {
                        prepare.setBoolean(i+1, (Boolean)oMsg.data[i]);
                    }
                }
                
                try(ResultSet rs = prepare.executeQuery(oMsg.rqSql))
                {
                    int i = 0;
                    while(rs.next())
                    {
                        this.oMsg.data[i] = (Object)rs;
                        i++;
                    }
                }
            }
        }
        else
        {
            try (PreparedStatement prepare = conn.prepareStatement(oMsg.rqSql)) 
            {   
                for(int i = 0; i < oMsg.data.length; i++)
                {
                    if(oMsg.data[i] instanceof String)
                    {
                        prepare.setString(i+1, (String)oMsg.data[i]);
                    }
                    else if(oMsg.data[i] instanceof Integer)
                    {
                        prepare.setInt(i+1, (Integer)oMsg.data[i]);
                    }
                    else if(oMsg.data[i] instanceof Boolean)
                    {
                        prepare.setBoolean(i+1, (Boolean)oMsg.data[i]);
                    }
                }
                
                prepare.executeUpdate();
            }
        }
        
        try 
        { 
            conn.close(); 
        } 
        catch (Exception e) 
        { 
        /* ignored */ 
        }
        
        return this.oMsg;
    }
}
