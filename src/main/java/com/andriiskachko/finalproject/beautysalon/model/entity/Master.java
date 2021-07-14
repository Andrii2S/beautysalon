package com.andriiskachko.finalproject.beautysalon.model.entity;

public class Master {

    private long id;
    private String login;
    private String password;
    private String nameEn;
    private String nameUa;
    private double rating;
    private String informationEn;
    private String informationUa;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }


    public String getNameUa() {
        return nameUa;
    }

    public void setNameUa(String nameUa) {
        this.nameUa = nameUa;
    }


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    public String getInformationEn() {
        return informationEn;
    }

    public void setInformationEn(String informationEn) {
        this.informationEn = informationEn;
    }


    public String getInformationUa() {
        return informationUa;
    }

    public void setInformationUa(String informationUa) {
        this.informationUa = informationUa;
    }
}
