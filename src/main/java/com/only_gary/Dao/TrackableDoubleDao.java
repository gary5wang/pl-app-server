package com.only_gary.Dao;

import com.only_gary.model.TrackableDouble;
import com.only_gary.model.TrackableMetadata;

import java.sql.Timestamp;
import java.util.List;

public interface TrackableDoubleDao {

    TrackableDouble addTrackableDouble(TrackableMetadata trackableMetadata, Timestamp timestamp, Double entry);
}
