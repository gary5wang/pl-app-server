package com.only_gary.Dao;

import com.only_gary.model.BodyWeight;
import java.sql.Timestamp;
import java.util.List;

public interface BodyWeightDao {

    BodyWeight addNewBodyWeight(Integer userId, Timestamp timestamp, Double bodyWeight);
    List<BodyWeight> getBodyWeightList (Integer userId, Timestamp begDate, Timestamp endDate);
}
