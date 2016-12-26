package com.kongxx.railwayticket.etl.beans;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by davy on 2016/12/27.
 */
public enum SeatType {
    HEAD_SEAT("硬座"), SOFT_SEAT("软座"), HEAD_SLEEPER_UP("硬卧上"), SOFT_SLEEPER_UP("软卧上"), HEAD_SLEEPER_MID("硬卧中"), HEAD_SLEEPER_DOW("硬卧下"), SOFT_SLEEPER_DOW("软卧下");
    protected String name;

    SeatType(String name) {
        this.name = name;
    }

    public static Optional<SeatType> of(String name) {
        return Arrays.stream(SeatType.values()).filter(s -> s.name.equals(name)).findAny();
    }
}
