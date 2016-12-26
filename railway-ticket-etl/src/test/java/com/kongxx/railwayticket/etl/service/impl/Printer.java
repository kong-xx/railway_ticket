package com.kongxx.railwayticket.etl.service.impl;

import java.util.List;

/**
 * Created by davy on 2016/12/27.
 */
public interface Printer {
    default void print(List list){
        list.forEach(System.out::println);
    }
}
