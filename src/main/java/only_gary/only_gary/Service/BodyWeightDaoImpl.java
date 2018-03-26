package only_gary.Service;

import only_gary.Dao.BodyWeightDao;
import only_gary.model.BodyWeight;
import only_gary.repository.BodyWeightRepository;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BodyWeightDaoImpl implements BodyWeightDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BodyWeightRepository bodyWeightRepository;

    public BodyWeight addNewBodyWeight (Integer userId
            , Timestamp timestamp
            , Double bodyWeight) {

        BodyWeight bodyWeightEntry = new BodyWeight();
        bodyWeightEntry.setUserId(userId);
        bodyWeightEntry.setTimestamp(timestamp);
        bodyWeightEntry.setBodyWeight(bodyWeight);

        bodyWeightRepository.save(bodyWeightEntry);
        return bodyWeightEntry;
    }

    //get from date to date
    @Transactional
    public List<BodyWeight> getBodyWeightList (Integer userId
            , Timestamp begDate
            , Timestamp endDate){

        Criteria bodyWeightCriteria = sessionFactory.getCurrentSession().createCriteria(BodyWeight.class);
        bodyWeightCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        bodyWeightCriteria.add(Restrictions.le("timestamp", endDate));
        bodyWeightCriteria.add(Restrictions.ge("timestamp", begDate));

        return bodyWeightCriteria.list();
    }

}