package only_gary.controller;

import only_gary.Service.BodyWeightDaoImpl;
import only_gary.model.BodyWeight;
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
    private BodyWeightDaoImpl bodyWeightDaoImpl;

    @GetMapping(path="/add")
    public @ResponseBody BodyWeight addNewBodyWeight (@RequestParam Integer userId
            , @RequestParam Timestamp timestamp
            , @RequestParam Double bodyWeight) {

        return bodyWeightDaoImpl.addNewBodyWeight(userId, timestamp, bodyWeight);
    }

    //get from date to date
    @Transactional
    @GetMapping(path="/get")
    public @ResponseBody List<BodyWeight> getBodyWeightList (@RequestParam Integer userId
            , @RequestParam Timestamp begDate
            , @RequestParam Timestamp endDate){

        return bodyWeightDaoImpl.getBodyWeightList(userId, begDate, endDate);
    }

}