/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Business_Layer;

import java.sql.ResultSet;

/**
 *
 * @author TeezyT
 */
public interface IDataFunctions {
    
    
    public boolean InsertItem();
    public boolean Update();
    public boolean Delete();
    public boolean GetItem();
   // public void GetAllitems();
    public String GenerateID();
    public boolean CreateItem(ResultSet rs);
    
}
