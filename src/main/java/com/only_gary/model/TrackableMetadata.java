package com.only_gary.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TrackableMetadata {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private int userId;

    private String tableName;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="trackableMetadata")
    private List<TrackableObject> trackableObjectList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<TrackableObject> getTrackableObjectList() {
        return trackableObjectList;
    }

    public void setTrackableObjectList(List<TrackableObject> trackableObjectList) {
        this.trackableObjectList = trackableObjectList;
    }
}