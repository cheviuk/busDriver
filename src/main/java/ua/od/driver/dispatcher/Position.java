package ua.od.driver.dispatcher;

/**
 * Created by cheviuk on 2/21/2017.
 * driver
 * PACKAGE_NAME
 */
public class Position {
    private Double x;
    private Double y;

    Position(Double x, Double y){
        this.x = x;
        this.y = y;
    }

    public void setX(Double x){
        this.x = x;
    }

    public Double getX(){
        return this.x;
    }

    public void setY(Double x){
        this.x = x;
    }

    public Double getY(){
        return this.y;
    }

}
