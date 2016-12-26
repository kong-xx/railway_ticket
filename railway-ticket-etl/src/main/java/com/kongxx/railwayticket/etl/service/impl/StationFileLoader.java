package com.kongxx.railwayticket.etl.service.impl;

import com.google.common.collect.Lists;
import com.kongxx.railwayticket.etl.service.StationLoader;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.substring;
import static org.apache.commons.lang3.StringUtils.substringBetween;
import static org.apache.commons.lang3.tuple.MutablePair.of;

/**
 * Created by davy on 2016/12/26.
 */

@Service
public class StationFileLoader implements StationLoader {
    public static final Logger logger = LoggerFactory.getLogger(StationFileLoader.class);

    @Override
    public List<Map.Entry<String, String>> load() {
        List<String> allStations = getAllStations();
        return allStations.parallelStream().map(station -> of(station, allStations))
                .flatMap(stationAndAll -> stationAndAll.right.stream().map(station -> of(stationAndAll.left, station)))
                .filter(stationAAndB -> !stationAAndB.left.equals(stationAAndB.right))
                .filter(stationAAndB -> !substring(stationAAndB.left, 0, 2).equals(substring(stationAAndB.right, 0, 2)))
                .collect(Collectors.toList());
    }


    public List<String> getAllStations() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(StationFileLoader.class.getClassLoader().getResourceAsStream("station_name.js")))) {
            String line = reader.lines().findFirst().orElseThrow(() -> new RuntimeException("站点文件中没有数据"));
            return Arrays.stream(substringBetween(line, "='", "';").split("@")).filter(StringUtils::isNotBlank).map(stationsValue -> stationsValue.split("\\|")[1].replaceAll(" ", "")).collect(Collectors.toList());
        } catch (IOException | RuntimeException e) {
            logger.error("站点解析时出错", e);
            return Lists.newArrayList();
        }
    }
}
