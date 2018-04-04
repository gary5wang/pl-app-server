package com.only_gary.controller;

import com.only_gary.DaoImpl.BodyWeightDaoImpl;
import com.only_gary.DaoImpl.TrackableMetadataDaoImpl;
import com.only_gary.model.BodyWeight;
import com.only_gary.model.TrackableMetadata;
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
@RequestMapping(path="/trackableMetadata")
public class TrackableMetadataController {

    @Autowired
    private TrackableMetadataDaoImpl trackableMetadataDaoImpl;

    @GetMapping(path="/add")
    public @ResponseBody
    TrackableMetadata addTrackableMetadata (@RequestParam Integer userId
            , @RequestParam String tableName) {

        return trackableMetadataDaoImpl.addTrackableMetadata(userId, tableName);
    }

    //get from date to date
    @Transactional
    @GetMapping(path="/getAll")
    public @ResponseBody List<TrackableMetadata> getBodyWeightList (@RequestParam Integer userId){

        return trackableMetadataDaoImpl.getTrackableMetadataList(userId);
    }

}