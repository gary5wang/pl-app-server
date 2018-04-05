package com.only_gary.repository;

import com.only_gary.model.TrackableObject;
import org.springframework.data.repository.CrudRepository;

public interface TrackableObjectRepository extends CrudRepository<TrackableObject, Long> {

}

