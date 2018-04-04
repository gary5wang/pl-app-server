package com.only_gary.Dao;

import com.only_gary.model.TrackableMetadata;

import java.util.List;

public interface TrackableMetadataDao {

    TrackableMetadata addTrackableMetadata(Integer userId, String tableName);
    List<TrackableMetadata> getTrackableMetadataList(Integer userId);
}
