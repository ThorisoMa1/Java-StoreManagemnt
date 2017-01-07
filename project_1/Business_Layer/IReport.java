/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Business_Layer;
import java.util.ArrayList;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author TeezyT
 */
public interface IReport {
    
    public void Createreport(ArrayList<ItemClass>items);
    public void ExportInfo(JXTable info,JXTable info2);
    //public void Createreport();
    
    
    
}
