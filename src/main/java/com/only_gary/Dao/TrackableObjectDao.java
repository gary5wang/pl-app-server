package com.only_gary.Dao;

import com.only_gary.model.TrackableObject;
import com.only_gary.model.TrackableMetadata;

import java.sql.Timestamp;
import java.util.List;

public interface TrackableObjectDao {

    TrackableObject addTrackableObject(TrackableMetadata trackableMetadata, Timestamp timestamp, Object entry);
}
