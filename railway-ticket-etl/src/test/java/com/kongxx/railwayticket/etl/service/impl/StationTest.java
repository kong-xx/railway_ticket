package com.kongxx.railwayticket.etl.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by davy on 2016/12/27.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StationTest implements Printer {
    @Autowired
    protected StationFileLoader stationLoader;

    @Test
    public void testGetAllStations() {
        List<String> allStations = stationLoader.getAllStations();
        System.out.println("-----" + allStations.size());
    }

    @Test
    public void testStationFileLoad() {
        List<Map.Entry<String, String>> stations = stationLoader.load();
        System.out.println("-----" + stations.size());
    }


}
