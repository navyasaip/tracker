package cartracker.api.service;

import cartracker.api.entity.Alerts;
import cartracker.api.entity.Readings;
import cartracker.api.entity.Vehicle;

import java.util.List;

public interface AlertsService {
    List<Alerts> getAlerts();
    List<Alerts> getAlertsByVin(String vin);
    Alerts alertsCreate(Alerts alert);
    Alerts checkAlerts(Readings readings, Vehicle vehicle);
}
