package com.kongxx.railwayticket.etl.service.impl;

import com.kongxx.railwayticket.etl.beans.RoadMap;
import com.kongxx.railwayticket.etl.service.RoadMapLoader;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.singletonList;

/**
 * Created by davy on 2016/12/27.
 */

@Service("roadMapLoader")
public class RoadMapCrawlerLoader implements RoadMapLoader {


    @Override
    public List<RoadMap> findByStations(String startStations, String endStations) {
        RoadMap roadMap = new RoadMap();
        roadMap.setDistance(100);
        roadMap.setTrainNumber("k273");
        return singletonList(roadMap);
    }
}
