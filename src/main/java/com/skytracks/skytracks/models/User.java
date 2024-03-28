package com.skytracks.skytracks.models;

public class User {

    private String id;

    private String email;

    private String address;


    private String name;

    private String cardNo;

    private String passportNo;


    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getPassportNo(){
         return passportNo;
    }
    public void setPassportNo(String passportNo){
        this.passportNo = passportNo;
    }
    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getCardNo()
    {
        return cardNo;
    }

    public void setCardNo (String cardNo)
    {
        this.cardNo = cardNo;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }


    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", name= "+name+", email = "+email+", address = "+address+", card = "+cardNo+", passport = "+passportNo+"]";
    }
}