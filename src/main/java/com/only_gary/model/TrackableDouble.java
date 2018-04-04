package com.only_gary.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class TrackableDouble {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "trackableMetadata_id")
    private TrackableMetadata trackableMetadata;

    private Timestamp timestamp;

    private double entry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrackableMetadata getTrackableMetadata() {
        return trackableMetadata;
    }

    public void setTrackableMetadata(TrackableMetadata trackableMetadata) {
        this.trackableMetadata = trackableMetadata;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Double getEntry() {
        return entry;
    }

    public void setEntry(Double entry) {
        this.entry = entry;
    }
}