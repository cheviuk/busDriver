package ua.od.driver.dispatcher;

import java.util.LinkedList;

/**
 * Created by cheviuk on 2/21/2017.
 * driver
 * PACKAGE_NAME
 */
public class Route {
    private LinkedList<Position> routePath;
    private int routeNumber;

    public Route(LinkedList<Position> routePath, int routeNumber){
        this.routePath = routePath;
        this.routeNumber = routeNumber;
    }
}
