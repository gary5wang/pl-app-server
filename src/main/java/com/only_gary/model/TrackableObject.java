package com.only_gary.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class TrackableObject {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "trackable_metadata_id")
    private TrackableMetadata trackableMetadata;

    private Timestamp timestamp;

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
}