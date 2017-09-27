package cartracker.api.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Alerts.findAll",
                query = "SELECT a FROM Alerts a ORDER BY a.id DESC"),
        @NamedQuery(name = "Alerts.findByVIN",
                query = "SELECT a FROM Alerts a WHERE a.vin=:paramVin")
})
public class Alerts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(columnDefinition = "VARCHAR(17)")
    private String vin;

    private String rpmAlert;
    private String fuelAlert;
    private String tireAlert;
    private String engineAlert;

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    public Alerts(){
        this.timeStamp = new Date();
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRpmAlert() {
        return rpmAlert;
    }

    public void setRpmAlert(String rpmAlert) {
        this.rpmAlert = rpmAlert;
    }

    public String getFuelAlert() {
        return fuelAlert;
    }

    public void setFuelAlert(String fuelAlert) {
        this.fuelAlert = fuelAlert;
    }

    public String getTireAlert() {
        return tireAlert;
    }

    public void setTireAlert(String tireAlert) {
        this.tireAlert = tireAlert;
    }

    public String getEngineAlert() {
        return engineAlert;
    }

    public void setEngineAlert(String engineAlert) {
        this.engineAlert = engineAlert;
    }
}
