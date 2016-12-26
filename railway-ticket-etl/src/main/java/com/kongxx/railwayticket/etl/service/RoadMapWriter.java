package com.kongxx.railwayticket.etl.service;

import com.kongxx.railwayticket.etl.beans.RoadMap;

/**
 * Created by davy on 2016/12/27.
 */
public interface RoadMapWriter extends Component {

    boolean write(RoadMap roadMap);

}
