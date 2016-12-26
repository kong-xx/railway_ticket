package com.kongxx.railwayticket.etl.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by davy on 2016/12/26.
 */
public class RoadMap {
    protected String trainNumber;
    protected String startStation;
    protected Date startTime;
    protected String endStation;
    protected Date endTime;
    protected Map.Entry<TimeUnit, TimeUnit> useTime;
    protected int distance;
    protected List<Map.Entry<SeatType, Double>> seatTypeAndPrice;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoadMap roadMap = (RoadMap) o;

        return trainNumber != null ? trainNumber.equals(roadMap.trainNumber) : roadMap.trainNumber == null;

    }

    @Override
    public int hashCode() {
        return trainNumber != null ? trainNumber.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RoadMap{" +
                "trainNumber='" + trainNumber + '\'' +
                ", startStation='" + startStation + '\'' +
                ", startTime=" + startTime +
                ", endStation='" + endStation + '\'' +
                ", endTime=" + endTime +
                ", useTime=" + useTime +
                ", distance=" + distance +
                ", seatTypeAndPrice=" + seatTypeAndPrice +
                '}';
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Map.Entry<TimeUnit, TimeUnit> getUseTime() {
        return useTime;
    }

    public void setUseTime(Map.Entry<TimeUnit, TimeUnit> useTime) {
        this.useTime = useTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<Map.Entry<SeatType, Double>> getSeatTypeAndPrice() {
        return seatTypeAndPrice;
    }

    public void setSeatTypeAndPrice(List<Map.Entry<SeatType, Double>> seatTypeAndPrice) {
        this.seatTypeAndPrice = seatTypeAndPrice;
    }
}
