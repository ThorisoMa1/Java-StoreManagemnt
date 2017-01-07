/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Presentation.Admin_Dept;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author TeezyT
 */
@Entity
@Table(name = "tbl_items", catalog = "store_management_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblItems.findAll", query = "SELECT t FROM TblItems t"),
    @NamedQuery(name = "TblItems.findByItemID", query = "SELECT t FROM TblItems t WHERE t.itemID = :itemID"),
    @NamedQuery(name = "TblItems.findByItemName", query = "SELECT t FROM TblItems t WHERE t.itemName = :itemName"),
    @NamedQuery(name = "TblItems.findByItemDate", query = "SELECT t FROM TblItems t WHERE t.itemDate = :itemDate"),
    @NamedQuery(name = "TblItems.findByItemQuantity", query = "SELECT t FROM TblItems t WHERE t.itemQuantity = :itemQuantity"),
    @NamedQuery(name = "TblItems.findByItemPrice", query = "SELECT t FROM TblItems t WHERE t.itemPrice = :itemPrice"),
    @NamedQuery(name = "TblItems.findByItemType", query = "SELECT t FROM TblItems t WHERE t.itemType = :itemType"),
    @NamedQuery(name = "TblItems.findByItemDescription", query = "SELECT t FROM TblItems t WHERE t.itemDescription = :itemDescription")})
public class TblItems implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Item_ID")
    private String itemID;
    @Basic(optional = false)
    @Column(name = "Item_Name")
    private String itemName;
    @Basic(optional = false)
    @Column(name = "Item_Date")
    @Temporal(TemporalType.DATE)
    private Date itemDate;
    @Basic(optional = false)
    @Column(name = "Item_Quantity")
    private int itemQuantity;
    @Basic(optional = false)
    @Column(name = "Item_Price")
    private double itemPrice;
    @Basic(optional = false)
    @Column(name = "Item_Type")
    private int itemType;
    @Column(name = "Item_Description")
    private String itemDescription;

    public TblItems() {
    }

    public TblItems(String itemID) {
        this.itemID = itemID;
    }

    public TblItems(String itemID, String itemName, Date itemDate, int itemQuantity, double itemPrice, int itemType) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemDate = itemDate;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        String oldItemID = this.itemID;
        this.itemID = itemID;
        changeSupport.firePropertyChange("itemID", oldItemID, itemID);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        String oldItemName = this.itemName;
        this.itemName = itemName;
        changeSupport.firePropertyChange("itemName", oldItemName, itemName);
    }

    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        Date oldItemDate = this.itemDate;
        this.itemDate = itemDate;
        changeSupport.firePropertyChange("itemDate", oldItemDate, itemDate);
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        int oldItemQuantity = this.itemQuantity;
        this.itemQuantity = itemQuantity;
        changeSupport.firePropertyChange("itemQuantity", oldItemQuantity, itemQuantity);
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        double oldItemPrice = this.itemPrice;
        this.itemPrice = itemPrice;
        changeSupport.firePropertyChange("itemPrice", oldItemPrice, itemPrice);
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        int oldItemType = this.itemType;
        this.itemType = itemType;
        changeSupport.firePropertyChange("itemType", oldItemType, itemType);
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        String oldItemDescription = this.itemDescription;
        this.itemDescription = itemDescription;
        changeSupport.firePropertyChange("itemDescription", oldItemDescription, itemDescription);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemID != null ? itemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblItems)) {
            return false;
        }
        TblItems other = (TblItems) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "project_1.Presentation.Admin_Dept.TblItems[ itemID=" + itemID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
