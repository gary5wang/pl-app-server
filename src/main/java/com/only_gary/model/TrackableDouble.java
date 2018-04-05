package com.only_gary.model;

import javax.persistence.*;

@Entity
public class TrackableDouble extends TrackableObject{

    private double entry;

    public Double getEntry() {
        return entry;
    }

    public void setEntry(Double entry) {
        this.entry = entry;
    }
}