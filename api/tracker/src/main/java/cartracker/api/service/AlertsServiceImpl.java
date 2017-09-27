package cartracker.api.service;

import cartracker.api.entity.Alerts;
import cartracker.api.entity.Readings;
import cartracker.api.entity.Tires;
import cartracker.api.entity.Vehicle;
import cartracker.api.exceptions.ResourceNotFoundException;
import cartracker.api.repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlertsServiceImpl implements AlertsService {

    @Autowired
    AlertsRepository repository;

    @Transactional(readOnly = true)
    public List<Alerts> getAlerts() {
        return repository.getAlerts();
    }

    @Transactional(readOnly = true)
    public List<Alerts> getAlertsByVin(String vin) {
        List<Alerts> exist = repository.getAlertsByVin(vin);
        if(exist == null){
            throw new ResourceNotFoundException("Reading with vin: "+vin+" does not exist");
        }

        return exist;
    }

    @Transactional
    public Alerts alertsCreate(Alerts alert) {
        return repository.alertsCreate(alert);
    }

    public Alerts checkAlerts(Readings readings, Vehicle vehicle) {
        Alerts alerts = new Alerts();
        String rpmAlert = checkRpmAlert(readings.getEngineRpm(),vehicle.getRedlineRpm());
        String fuelAlert = checkFuelAlert(readings.getFuelVolume(),vehicle.getMaxFuelVolume());
        String tireAlert = checkTireAlert(readings.getTires());
        String engineAAlert = checkEngineAlert(readings.isCheckEngineLightOn(), readings.isEngineCoolantLow());

        alerts.setRpmAlert(rpmAlert);
        alerts.setFuelAlert(fuelAlert);
        alerts.setTireAlert(tireAlert);
        alerts.setEngineAlert(engineAAlert);
        alerts.setVin(vehicle.getVin());
        return alerts;
    }

    private String checkEngineAlert(boolean checkEngineLightOn, boolean engineCoolantLow) {
        if(checkEngineLightOn || engineCoolantLow){
            return "LOW";
        }
        return "No Alert";
    }

    private String checkTireAlert(Tires tires) {
        if((tires.getFrontLeft()<32)||(tires.getFrontLeft()>36))
            return "LOW";
        else if((tires.getFrontRight()<32)||(tires.getFrontRight()>36))
            return "LOW";
        else if((tires.getRearLeft()<32)||(tires.getRearRight()>36))
            return "LOW";
        else if((tires.getRearRight()<32)||(tires.getRearRight()>36))
            return "LOW";
        else
            return "No Alert";
    }

    private String checkFuelAlert(double fuelVolume, double maxFuelVolume) {
        if(fuelVolume < ((0.1)*maxFuelVolume))
            return "MEDIUM";
        return "No Alert";
    }

    private String checkRpmAlert(int engineRpm, int redlineRpm) {
        if(engineRpm > redlineRpm)
            return "HIGH";
        return "No Alert";
    }
}
