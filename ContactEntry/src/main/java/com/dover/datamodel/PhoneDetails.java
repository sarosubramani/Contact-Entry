package com.dover.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class PhoneDetails{

    @JsonProperty("name")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Name name;

    @JsonProperty("phone")
    private String phone;

    public PhoneDetails(){}

    public PhoneDetails(Name name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PhoneDetails{" +
                "name=" + name +
                ", phone='" + phone + '\'' +
                '}';
    }
}
