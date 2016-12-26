package com.kongxx.railwayticket.etl.service.impl;

import com.kongxx.railwayticket.etl.service.RoadMapLoader;
import com.kongxx.railwayticket.etl.service.RoadMapWriter;
import com.kongxx.railwayticket.etl.service.StationLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kongxx.railwayticket.etl.beans.Keys.OUTPUT_PATH;

/**
 * Created by davy on 2016/12/26.
 */

@Service
public class RoadMapService {

    @Autowired
    protected StationLoader stationLoader;

    @Autowired
    protected RoadMapLoader roadMapLoader;

    @Autowired
    protected RoadMapWriter roadMapWriter;

//    @PostConstruct
    public void main() {
        List<Map.Entry<String, String>> stations = stationLoader.load();
        Map<String, Object> params = new HashMap<>();
        params.put(OUTPUT_PATH, "/tmp/roadmap/roadmap.txt");
        roadMapWriter.init(params);
        stations.stream().flatMap(startEndStation -> roadMapLoader.findByStations(startEndStation.getKey(), startEndStation.getValue()).stream())
                .forEach(roadMapWriter::write);
        roadMapWriter.shutDown();

    }

}
