package com.kongxx.railwayticket.etl.service.impl;

import com.kongxx.railwayticket.etl.beans.RoadMap;
import com.kongxx.railwayticket.etl.service.RoadMapWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by davy on 2016/12/27.
 */

@Service("roadMapWriter")
public class RoadMapConsoleWriter implements RoadMapWriter {
    private static final Logger logger = LoggerFactory.getLogger(RoadMapConsoleWriter.class);


    @Override
    public boolean write(RoadMap roadMap) {
        System.out.println("线路:" + roadMap);
        return true;
    }

    @Override
    public boolean init(Map<String, Object> params) {
        logger.info("RoadMapConsoleWriter init");
        return true;
    }

    @Override
    public boolean shutDown() {
        logger.info("RoadMapConsoleWriter shutDown");
        return true;
    }
}
