package com.alignsolution.siamsmilemobileapplication.Biz;

/**
 * Created by aligndev on 06-May-17.
 */

public class ProductPromotion {

    private String RowId;
    private String ProductNo;
    private String ProductName;
    private String Description;
    private String ProductType;
    private String Benefit;
    private String CreatedOn;
    private String ModifiedOn;
    private String SyncDate;
    private String SyncStatus;


    public String getRowId() {
        return RowId;
    }
    public String getProductNo() {
        return ProductNo;
    }
    public String getProductName() {
        return ProductName;
    }
    public String getProductType() {
        return ProductType;
    }
    public String getDescription() {
        return Description;
    }
    public String getBenefit() {
        return Benefit;
    }
    public String getCreatedOn() {
        return CreatedOn;
    }
    public String getModifiedOn() {
        return ModifiedOn;
    }
    public String getSyncDate() {
        return SyncDate;
    }
    public String getSyncStatus() {
        return SyncStatus;
    }


    public void setRowId(String rowId) {
        this.RowId = rowId;
    }
    public void setProductNo(String productNo) {
        this.ProductNo = productNo;
    }
    public void setProductName(String productName) {
        this.ProductName = productName;
    }
    public void setProductType(String productType) {
        this.ProductType = productType;
    }
    public void setDescription(String description) {
        this.Description = description;
    }
    public void setBenefit(String benefit) {
        this.Benefit = benefit;
    }
    public void setCreatedOn(String createdOn) {
        this.CreatedOn = createdOn;
    }
    public void setModifiedOn(String modifiedOn) {
        this.ModifiedOn = modifiedOn;
    }
    public void setSyncDate(String syncDate) {
        this.SyncDate = syncDate;
    }
    public void setSyncStatus(String syncStatus) {
        this.SyncStatus = syncStatus;
    }
}
