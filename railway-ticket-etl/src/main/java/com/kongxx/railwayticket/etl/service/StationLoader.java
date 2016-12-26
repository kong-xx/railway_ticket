package com.kongxx.railwayticket.etl.service;

import java.util.List;
import java.util.Map;

/**
 * Created by davy on 2016/12/26.
 */

public interface StationLoader {

    List<Map.Entry<String, String>> load();

}
