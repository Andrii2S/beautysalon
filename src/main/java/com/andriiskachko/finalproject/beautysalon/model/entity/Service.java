package com.andriiskachko.finalproject.beautysalon.model.entity;


public class Service {

    private long id;
    private String nameEn;
    private String nameUk;
    private String descriptionEn;
    private String descriptionUk;
    private long timeslots;
    private boolean availability;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNameEn() {

        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }


    public String getNameUk() {
        return nameUk;
    }

    public void setNameUk(String nameUk) {
        this.nameUk = nameUk;
    }


    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }


    public String getDescriptionUk() {
        return descriptionUk;
    }

    public void setDescriptionUk(String descriptionUk) {
        this.descriptionUk = descriptionUk;
    }


    public long getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(long timeslots) {
        this.timeslots = timeslots;
    }


    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

}
