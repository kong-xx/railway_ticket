package com.kongxx.railwayticket.etl.service;

import com.kongxx.railwayticket.etl.beans.RoadMap;

import java.util.List;

/**
 * Created by davy on 2016/12/26.
 */


public interface RoadMapLoader {


    List<RoadMap> findByStations(String startStations, String endStations);

}
