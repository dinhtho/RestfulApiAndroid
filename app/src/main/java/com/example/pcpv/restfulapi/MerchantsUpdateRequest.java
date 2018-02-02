package com.example.pcpv.restfulapi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by trong on 9/14/2017.
 */

public class MerchantsUpdateRequest  {
    @SerializedName("business_name")
    private String businessName;
    @SerializedName("category_id")
    private String categoryId;
    @SerializedName("description")
    private String description;
    @SerializedName("redemption_code")
    private String redemptionCode;
    @SerializedName("country_id")
    private String countryId;
    @SerializedName("phone_number")
    private String phone;
    @SerializedName("bank_name")
    private String bankName;
    @SerializedName("account_bank_no")
    private String accountBankNo;
    @SerializedName("image_id")
    private String imageId;
    @SerializedName("status")
    private int status;

    @SerializedName("business_address")
    private String businessAddress;
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRedemptionCode() {
        return redemptionCode;
    }

    public void setRedemptionCode(String redemptionCode) {
        this.redemptionCode = redemptionCode;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountBankNo() {
        return accountBankNo;
    }

    public void setAccountBankNo(String accountBankNo) {
        this.accountBankNo = accountBankNo;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

}

