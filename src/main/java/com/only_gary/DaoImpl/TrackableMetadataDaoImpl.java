package com.only_gary.DaoImpl;

import com.only_gary.Dao.TrackableMetadataDao;
import com.only_gary.model.TrackableDouble;
import com.only_gary.model.TrackableMetadata;
import com.only_gary.model.TrackableObject;
import com.only_gary.repository.TrackableMetadataRepository;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackableMetadataDaoImpl implements TrackableMetadataDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private TrackableMetadataRepository trackableMetadataRepository;

    public TrackableMetadata addTrackableMetadata (Integer userId
            , String tableName) {

        TrackableMetadata trackableMetadata = new TrackableMetadata();
        trackableMetadata.setUserId(userId);
        trackableMetadata.setTableName(tableName);

        trackableMetadataRepository.save(trackableMetadata);
        return trackableMetadata;
    }

    @Transactional
    public List<TrackableMetadata> getTrackableMetadataList (Integer userId){

        return  (List) trackableMetadataRepository.findByUserId(userId);
    }

    @Transactional
    public List<TrackableObject> getTrackableObjectList (Integer metadataId){

        TrackableMetadata trackableMetadata = trackableMetadataRepository.findById(metadataId);

        if (trackableMetadata == null){
            //TODO need to log here?
            return new ArrayList<>();
        }

        else {
            return trackableMetadata.getTrackableObjectList();
        }
    }

}