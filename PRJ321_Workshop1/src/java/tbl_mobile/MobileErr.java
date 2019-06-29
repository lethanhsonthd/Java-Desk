/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_mobile;

/**
 *
 * @author son
 */
public class MobileErr {
    private String descriptionLengthErr;
    private String priceErr;
    private String mobileNameLengthErr;
    private String yearOfProductionValidErr;
    private String quantityValidErr;

    public MobileErr() {
    }

    public MobileErr(String descriptionLengthErr, String priceErr, String mobileNameLengthErr, String yearOfProductionValidErr, String quantityValidErr) {
        this.descriptionLengthErr = descriptionLengthErr;
        this.priceErr = priceErr;
        this.mobileNameLengthErr = mobileNameLengthErr;
        this.yearOfProductionValidErr = yearOfProductionValidErr;
        this.quantityValidErr = quantityValidErr;
    }

    public String getDescriptionLengthErr() {
        return descriptionLengthErr;
    }

    public void setDescriptionLengthErr(String descriptionLengthErr) {
        this.descriptionLengthErr = descriptionLengthErr;
    }

    public String getPriceErr() {
        return priceErr;
    }

    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }

    public String getMobileNameLengthErr() {
        return mobileNameLengthErr;
    }

    public void setMobileNameLengthErr(String mobileNameLengthErr) {
        this.mobileNameLengthErr = mobileNameLengthErr;
    }

    public String getYearOfProductionValidErr() {
        return yearOfProductionValidErr;
    }

    public void setYearOfProductionValidErr(String yearOfProductionValidErr) {
        this.yearOfProductionValidErr = yearOfProductionValidErr;
    }

    public String getQuantityValidErr() {
        return quantityValidErr;
    }

    public void setQuantityValidErr(String quantityValidErr) {
        this.quantityValidErr = quantityValidErr;
    }
    
}
