package com.andriiskachko.finalproject.beautysalon.model.dto;

public class ServiceDTO {
    private long id;
    private String name;
    private String description;
    private long time;

    public ServiceDTO()
    {
    }

    public ServiceDTO(long id, String name, String description, long timeslots)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.time= timeslots * 30;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long timeslots) {
        this.time = timeslots * 30;
    }
}
