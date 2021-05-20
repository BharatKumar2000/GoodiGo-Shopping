package com.example.myapplication.main;

public class Address {
    private String rname;
    private String addOne;
    private String addTwo;
    private String countryname;
    private String statename;
    private String cityname;
    private String pincode;


    public Address()
    {

    }

    public Address( String rname,String addOne, String addTwo,String countryname,String statename, String cityname, String pincode) {
        this.rname=rname;
        this.addOne = addOne;
        this.addTwo = addTwo;
        this.countryname=countryname;
        this.statename = statename;
        this.cityname = cityname;
        this.pincode = pincode;
    }


    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getAddOne() {
        return addOne;
    }

    public void setAddOne(String addOne) {
        this.addOne = addOne;
    }

    public String getAddTwo() {
        return addTwo;
    }

    public void setAddTwo(String addTwo) {
        this.addTwo = addTwo;
    }



    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
