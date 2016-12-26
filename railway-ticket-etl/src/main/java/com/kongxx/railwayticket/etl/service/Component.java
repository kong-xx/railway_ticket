package com.kongxx.railwayticket.etl.service;

import java.util.Map;

/**
 * Created by davy on 2016/12/27.
 */
public interface Component {

    boolean init(Map<String, Object> params);

    boolean shutDown();

}
