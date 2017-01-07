/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.KemptinBranch.Presentation.Business_Logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author TeezyT
 */
public class Lists implements Serializable {

    public static ArrayList<ItemClass> items;

    public static ArrayList<String> uniformTypes;
    public static ArrayList<String> ItemCatogories;
    public static ArrayList<String> authers;
    public static ArrayList<String> genres;
    public static ArrayList<String> sizes;

    public static Book bk;
    public static Uniforms uf;
    public static ItemClass item;
    public static project_1.Business_Layer.Basket orders;

}
