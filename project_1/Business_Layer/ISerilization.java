/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Business_Layer;

import java.util.ArrayList;

/**
 *
 * @author TeezyT
 */
public interface ISerilization {
    
     public  void Serilizefile() ;
      


    public  ArrayList<ItemClass> DserilizeSerilizefile(String Path);
       
      
    

    
}
