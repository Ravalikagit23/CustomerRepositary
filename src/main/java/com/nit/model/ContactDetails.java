package com.nit.model;

public class ContactDetails {
    private String email;
    private String  phoneNumber;

    public ContactDetails(String email, String  phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
}
