package only_gary.controller;

import only_gary.model.BodyWeight;
import only_gary.repository.BodyWeightRepository;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping(path="/bodyWeight")
public class BodyWeightController {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BodyWeightRepository bodyWeightRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewBodyWeight (@RequestParam Integer userId
            , @RequestParam Timestamp timestamp
            , @RequestParam Double bodyWeight) {

        BodyWeight bodyWeightEntry = new BodyWeight();
        bodyWeightEntry.setUserId(userId);
        bodyWeightEntry.setTimestamp(timestamp);
        bodyWeightEntry.setBodyWeight(bodyWeight);

        bodyWeightRepository.save(bodyWeightEntry);
        return "Saved bodyWeight";
    }

    //get from date to date
    @Transactional
    @GetMapping(path="/get")
    public @ResponseBody List<BodyWeight> getBodyWeightList (@RequestParam Integer userId
            , @RequestParam Timestamp begDate
            , @RequestParam Timestamp endDate){

        Criteria bodyWeightCriteria = sessionFactory.getCurrentSession().createCriteria(BodyWeight.class);
        bodyWeightCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        bodyWeightCriteria.add(Restrictions.le("timestamp", endDate));
        bodyWeightCriteria.add(Restrictions.ge("timestamp", begDate));

        return bodyWeightCriteria.list();
    }

}