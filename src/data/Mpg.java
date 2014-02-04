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
public interface Mpg {
    
    public StcMsg getAll(StcMsg oMsg);
    public StcMsg getById(StcMsg oMsg);
    public StcMsg add(StcMsg oMsg);
    public StcMsg update(StcMsg oMsg);
    public StcMsg deleteById(StcMsg oMsg);
    
}
