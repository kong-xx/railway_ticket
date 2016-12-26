package com.kongxx.railwayticket.etl.service.impl;

import com.kongxx.railwayticket.etl.beans.RoadMap;
import com.kongxx.railwayticket.etl.service.RoadMapWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static com.kongxx.railwayticket.etl.beans.Keys.OUTPUT_PATH;

/**
 * Created by davy on 2016/12/27.
 */


public class RoadMapFileWriter implements RoadMapWriter {
    private static final Logger logger = LoggerFactory.getLogger(RoadMapFileWriter.class);
    protected FileWriter writer;

    @Override
    public boolean init(Map<String, Object> params) {
        String outputPath = (String) params.get(OUTPUT_PATH);
        try {
            writer = new FileWriter(outputPath);
            return true;
        } catch (IOException e) {
            logger.error("RoadMapFileWriter初始化错误", e);
            return false;
        }
    }

    @Override
    public boolean shutDown() {
        try {
            writer.close();
            return true;
        } catch (IOException e) {
            logger.error("RoadMapFileWriter 关闭错误", e);
            return false;
        }
    }

    @Override
    public boolean write(RoadMap roadMap) {
        try {
            writer.write("线路:" + roadMap);
            return true;
        } catch (IOException e) {
            logger.error("写出RoadMap数据出现错误,数据是:" + roadMap, e);
            return false;
        }
    }
}
