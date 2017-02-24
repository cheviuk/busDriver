package ua.od.driver.dispatcher;

import java.math.BigInteger;

/**
 * Created by cheviuk on 2/21/2017.
 * driver
 * PACKAGE_NAME
 */
public class Driver {
    private String name = "";
    private Position busPosition;
    private BigInteger id;
    private int routeNumber;

    public Driver(String name, Position busPosition, BigInteger id, int routeNumber){
        this.name = name;
        this.busPosition = busPosition;
        this.id = id;
        this.routeNumber = routeNumber;
    }

    public BigInteger getId(){
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Position getBusPosition() {
        return busPosition;
    }

    public void setBusPosition(Position busPosition) {
        this.busPosition = busPosition;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
