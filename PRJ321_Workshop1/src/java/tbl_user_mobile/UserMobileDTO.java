/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_user_mobile;

/**
 *
 * @author son
 */
public class UserMobileDTO {
    private String userId, mobileId;

    public UserMobileDTO(String userId, String mobileId) {
        this.userId = userId;
        this.mobileId = mobileId;
    }

    public UserMobileDTO() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }
    
    
}
