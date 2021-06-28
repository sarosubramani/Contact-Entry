package com.dover.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Name {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @JsonProperty("first")
    private String first;

    @JsonProperty("middle")
    private String middle;

    @JsonProperty("last")
    private String last;

    public Name(){}

    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Name{" +
                "first='" + first + '\'' +
                ", middle='" + middle + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

}
