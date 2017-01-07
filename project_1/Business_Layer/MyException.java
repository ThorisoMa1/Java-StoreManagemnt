/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Business_Layer;

/**
 *
 * @author TeezyT
 */
public class MyException extends  Exception{
    
    
    String message;

    public MyException(String message) {
        super(message);
        this.message = message;
    }
    
    
}
