package com.dover.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("type")
    private String type;

    public Phone(){}

    public Phone(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
