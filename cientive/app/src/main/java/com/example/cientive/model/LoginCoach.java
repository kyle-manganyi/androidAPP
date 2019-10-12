package com.example.cientive.model;


public class LoginCoach {

    private int id;
    private String name;
    private String email;
    private String password;
    private String price_range;
    private String coach_area;
    private String qualification;
    private String association;
    private String address;
    private String cellphone;


    public int getCoachId() {
        return id;
    }

    public void setCoachId(int id) {
        this.id = id;
    }

    public String getCoachName() {
        return name;
    }

    public void setCoachName(String name) {
        this.name = name;
    }

    public String getCoachEmail() {
        return email;
    }

    public void setCoachEmail(String email) {
        this.email = email;
    }

    public String getCoachPassword() {
        return password;
    }

    public void setCoachPassword(String password) {
        this.password = password;
    }

    public  String  getCoachPrice_range() {return price_range;}

    public void setCoachPrice_range(String price_range) {this.price_range = price_range;}

    public  String  getCoach_area() {return coach_area;}

    public void setCoach_area(String coach_area) {this.coach_area = coach_area;}

    public  String getCoachQualification() {return qualification;}

    public void setCoachQualification(String qualification) {this.qualification = qualification;}

    public  String getCoachCellphone() {return cellphone;}

    public void setCoachCellphone(String cellphone) {this.cellphone = cellphone;}

    public  String getCoachAddress() {return address;}

    public void setCoachAddress(String address) {this.address = address;}

    public  String getCoachAssociation() {return association;}

    public void setCoachAssociation(String association) {this.association = association;}






}
