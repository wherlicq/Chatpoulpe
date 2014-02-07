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
        
        if(oMsg.rqSql.startsWith("SELECT"))
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
                
                try(ResultSet rs = prepare.executeQuery())
                {
                	ResultSetMetaData metaData = rs.getMetaData();
                	rs.last();
                    this.oMsg.selectedData = new Object[rs.getRow()][metaData.getColumnCount()];
                	rs.beforeFirst();
                    int i = 0;
                    
                    while(rs.next())
                    {
                    	for(int j = 0; j < metaData.getColumnCount(); j++)
                    	{
                            this.oMsg.selectedData[i][j] = (Object)rs.getObject(j+1);
                    	}
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
