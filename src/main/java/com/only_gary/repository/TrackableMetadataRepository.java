package com.only_gary.repository;

import com.only_gary.model.TrackableMetadata;
import org.springframework.data.repository.CrudRepository;

public interface TrackableMetadataRepository extends CrudRepository<TrackableMetadata, Long> {

    TrackableMetadata findById(int id);
    TrackableMetadata findByUserId(int id);
}

