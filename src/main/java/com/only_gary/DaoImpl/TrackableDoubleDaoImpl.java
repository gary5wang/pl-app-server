package com.only_gary.DaoImpl;

import com.only_gary.Dao.TrackableDoubleDao;
import com.only_gary.model.TrackableDouble;
import com.only_gary.model.TrackableMetadata;
import com.only_gary.repository.TrackableDoubleRepository;
import com.only_gary.repository.TrackableMetadataRepository;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrackableDoubleDaoImpl implements TrackableDoubleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private TrackableDoubleRepository trackableDoubleRepository;

    @Autowired
    private TrackableMetadataRepository trackableMetadataRepository;

    public TrackableDouble addTrackableDouble (TrackableMetadata trackableMetadata
            , Timestamp timestamp
            , Double entry) {

        TrackableDouble trackableDouble = new TrackableDouble();
        trackableDouble.setTrackableMetadata(trackableMetadata);
        trackableDouble.setTimestamp(timestamp);
        trackableDouble.setEntry(entry);

        trackableDoubleRepository.save(trackableDouble);
        return trackableDouble;
    }

    @Transactional
    public List<TrackableDouble> getTrackableDoubleListFromTrackableMetadataId (Integer metadataId){

        TrackableMetadata trackableMetadata = trackableMetadataRepository.findById(metadataId);

        if (trackableMetadata == null){
            //TODO need to log here?
            return new ArrayList<>();
        }

        else {
            return sessionFactory.getCurrentSession().createCriteria(TrackableDouble.class)
                    .add(Restrictions.eq("trackableMetadata_id", metadataId)).list();

        }
    }

}