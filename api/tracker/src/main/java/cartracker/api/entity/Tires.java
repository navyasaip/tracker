package cartracker.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class Tires implements Serializable {

    @JsonProperty("frontLeft")
    private int frontLeft;
    //    @NotNull
    @JsonProperty("frontRight")
    private int frontRight;
//    @NotNull
    @JsonProperty("rearLeft")
    private int rearLeft;
//    @NotNull
    @JsonProperty("rearRight")
    private int rearRight;

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }
}
